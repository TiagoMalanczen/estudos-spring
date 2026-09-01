package com.example.first_spring.services;

import com.example.first_spring.database.model.AlunosEntity;
import com.example.first_spring.database.model.AvaliacoesFisicasEntity;
import com.example.first_spring.database.model.ExerciciosEntity;
import com.example.first_spring.database.repository.AlunoRepository;
import com.example.first_spring.database.repository.AvaliacoesFisicasRepository;
import com.example.first_spring.database.repository.ExerciciosRepository;
import com.example.first_spring.dto.AvaliacaoFisicaDTO;
import com.example.first_spring.dto.ExerciciosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final AlunoRepository alunoRepository;
    private final AvaliacoesFisicasRepository avaliacoesFisicasRepository;

    public void criarAvaliacaoFisica(AvaliacaoFisicaDTO avaliacaoFisicaDTO){
       AlunosEntity aluno =  alunoRepository.findById(avaliacaoFisicaDTO.getId())
                .orElseThrow(() -> new RuntimeException("Aluno nao encontrado"));
        AvaliacoesFisicasEntity avf = aluno.getAvaliacaoFisica();

        if(avf != null){
            throw new RuntimeException("Este aluno ja possui uma avaliacao");
        }

        avf = AvaliacoesFisicasEntity.builder()
                .peso(avaliacaoFisicaDTO.getPeso())
                .altura(avaliacaoFisicaDTO.getAltura())
                .porcentagemGordura(avaliacaoFisicaDTO.getPercentualGordura())
                .build();

        aluno.setAvaliacaoFisica(avf);
        alunoRepository.save(aluno);
    }
}
