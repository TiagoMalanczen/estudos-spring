package com.biblioteca.biblioteca.api.services;


import com.biblioteca.biblioteca.api.DTOs.EmprestimoDTO;
import com.biblioteca.biblioteca.api.DTOs.LivroDTO;
import com.biblioteca.biblioteca.api.database.enums.StatusEmprestimo;
import com.biblioteca.biblioteca.api.database.model.EmprestimoEntity;
import com.biblioteca.biblioteca.api.database.model.LivroEntity;
import com.biblioteca.biblioteca.api.database.model.UsuarioEntity;
import com.biblioteca.biblioteca.api.database.repository.EmprestimoRepository;
import com.biblioteca.biblioteca.api.database.repository.LivroRespository;
import com.biblioteca.biblioteca.api.database.repository.UsuarioRespository;
import com.biblioteca.biblioteca.api.exceptions.RecursoNaoencontradoException;
import com.biblioteca.biblioteca.api.exceptions.RegrasNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class EmprestimoService {

    private final UsuarioRespository usuarioRespository;
    private final LivroRespository livroRespository;
    private final EmprestimoRepository emprestimoRepository;

    @Transactional
    public void realizarEmprestimo(EmprestimoDTO emprestimoDTO){

        UsuarioEntity usuarioEntity = usuarioRespository.findById(emprestimoDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
        LivroEntity livroEntity = livroRespository.findById(emprestimoDTO.getLivroId())
                .orElseThrow(() -> new RuntimeException("Estoque esgotado"));

        if (livroEntity.getQuantidadeDisponivel() == 0){
            throw new RuntimeException("Estoque esgotado");
        }

        livroEntity.setQuantidadeDisponivel(livroEntity.getQuantidadeDisponivel()-1);

        EmprestimoEntity emprestimoEntity = EmprestimoEntity.builder()
                .dataEmprestimo(LocalDate.now())
                .dataDevolucaoPrevista(LocalDate.now().plusDays(7))
                .dataDevolucaoEfetiva(null)
                .statusEmprestimo(StatusEmprestimo.ATIVO)
                .usuarioEntity(usuarioEntity)
                .livroEntity(livroEntity)
                .build();

        emprestimoRepository.save(emprestimoEntity);
    }


    @Transactional
    public void devolverLivro(Integer emprestimoId){
        EmprestimoEntity emprestimoEntity = emprestimoRepository.findById(emprestimoId)
                .orElseThrow(() -> new RecursoNaoencontradoException("Emprestimo nao encontrado"));

        if(emprestimoEntity.getStatusEmprestimo() != StatusEmprestimo.ATIVO){
            throw new RegrasNegocioException("Emprestimo ja encerrado");
        }

        emprestimoEntity.setDataDevolucaoEfetiva(LocalDate.now());
        if(emprestimoEntity.getDataDevolucaoEfetiva().isAfter(emprestimoEntity.getDataDevolucaoPrevista())){
            emprestimoEntity.setStatusEmprestimo(StatusEmprestimo.ATRASADO);
        }
        else{
            emprestimoEntity.setStatusEmprestimo(StatusEmprestimo.DEVOLVIDO);
        }
        LivroEntity livro = emprestimoEntity.getLivroEntity();
        livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel()+1);
    }
}
