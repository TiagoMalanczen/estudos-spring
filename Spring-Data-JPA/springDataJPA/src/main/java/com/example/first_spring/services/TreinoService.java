package com.example.first_spring.services;

import com.example.first_spring.database.model.AlunosEntity;
import com.example.first_spring.database.model.ExerciciosEntity;
import com.example.first_spring.database.model.TreinoEntity;
import com.example.first_spring.database.repository.AlunoRepository;
import com.example.first_spring.database.repository.ExerciciosRepository;
import com.example.first_spring.database.repository.TreinosRepository;
import com.example.first_spring.dto.TreinoDTO;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final TreinosRepository treinosRepository;
    private final ExerciciosRepository exerciciosRepository;
    private final AlunoRepository alunoRepository;

    public void criarTreino(TreinoDTO treinoDTO){
        Set<ExerciciosEntity> exercicios = new HashSet<>();

        AlunosEntity aluno = alunoRepository.findById(treinoDTO.getIdAluno())
                .orElseThrow(() -> new RuntimeException("Aluno nao encontrado"));

        boolean treinoExiste = treinosRepository.findByNomeAndAlunosEntityId(treinoDTO.getNome(), treinoDTO.getIdAluno())
                .isPresent();
        if (treinoExiste) {
            throw new RuntimeException("Já existe um treino com este nome para este aluno");
        }

        for(Integer exerciciosId : treinoDTO.getExerciciosId()){
            ExerciciosEntity exerciciosEntity = exerciciosRepository.findById(exerciciosId)
                    .orElseThrow(() -> new RuntimeException("Exercicio nao encontrado"));

            exercicios.add(exerciciosEntity);
        }

        TreinoEntity treino = TreinoEntity.builder()
                .nome(treinoDTO.getNome())
                .alunosEntity(aluno)
                .exercicios(exercicios) 
                .build();

        treinosRepository.save(treino);
    }
}
