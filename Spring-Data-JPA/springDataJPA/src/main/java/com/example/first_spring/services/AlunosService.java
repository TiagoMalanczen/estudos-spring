package com.example.first_spring.services;

import com.example.first_spring.database.model.AlunosEntity;
import com.example.first_spring.database.model.AvaliacoesFisicasEntity;
import com.example.first_spring.database.repository.AlunoRepository;
import com.example.first_spring.dto.AlunosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunosService {

    private final AlunoRepository alunoRepository;

    public List<AlunosEntity> listarAll(){
        return alunoRepository.findAll();
    }
    public void cadastrarAluno(AlunosDTO alunosDTO){
        AlunosEntity aluno = alunoRepository.findByEmail(alunosDTO.getEmail())
                .orElse(null);

        if(aluno != null){
            throw new RuntimeException("Aluno ja cadastrado com este email");
        }

        alunoRepository.save(AlunosEntity.builder()
                    .nome(alunosDTO.getNome())
                    .email(alunosDTO.getEmail())
                .build());
    }

    public AvaliacoesFisicasEntity getALunoAvaliacao(Integer alunoId){
        AlunosEntity aluno = alunoRepository.findByIdFEtch(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno nao encontrado"));

        AvaliacoesFisicasEntity avaliacao = aluno.getAvaliacaoFisica();

        if(avaliacao == null){
            throw new RuntimeException("Avaliacao fisica nao encontrada");
        }

        return avaliacao;
    }
}
