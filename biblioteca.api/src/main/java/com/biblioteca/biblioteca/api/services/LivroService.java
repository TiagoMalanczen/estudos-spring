package com.biblioteca.biblioteca.api.services;

import com.biblioteca.biblioteca.api.DTOs.LivroDTO;
import com.biblioteca.biblioteca.api.database.model.LivroEntity;
import com.biblioteca.biblioteca.api.database.repository.LivroRespository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRespository livroRespository;

    public List<LivroDTO> buscarLivros(){
        return livroRespository.findAll()
                .stream()
                .map(livro -> LivroDTO.builder()
                        .isbm(livro.getIsbm())
                        .titulo(livro.getTitulo())
                        .quantidadeDisponivel(livro.getQuantidadeDisponivel())
                        .build())
                .toList();
    }

    public void cadastrarLivro(LivroDTO livroDTO){

        LivroEntity livro = livroRespository.findByIsbm(livroDTO.getIsbm())
                .orElse(null);

        if(livro != null){
             throw new RuntimeException("Livro ja cadastrado com esse Isbm");
        }

        livroRespository.save(LivroEntity.builder()
                .isbm(livroDTO.getIsbm())
                .titulo(livroDTO.getTitulo())
                .quantidadeDisponivel(livroDTO.getQuantidadeDisponivel())
                .build());
    }
}
