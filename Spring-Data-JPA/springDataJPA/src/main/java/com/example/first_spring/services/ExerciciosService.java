package com.example.first_spring.services;

import com.example.first_spring.database.model.ExerciciosEntity;
import com.example.first_spring.database.repository.ExerciciosRepository;
import com.example.first_spring.dto.ExerciciosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciciosService {

    private final ExerciciosRepository exerciciosRepository;

    public List<ExerciciosEntity> findAll(){
        return exerciciosRepository.findAll();
    }
    public void save(ExerciciosDTO exerciciosDTO){
        exerciciosRepository.save(ExerciciosEntity.builder()
                        .nome(exerciciosDTO.getNome())
                        .grupoMuscular(exerciciosDTO.getGrupoMuscular())
                .build());
    }
    public List<ExerciciosEntity> findAllGrupoMuscular(String grupoMuscular){
        return exerciciosRepository.findAllByGrupoMuscular(grupoMuscular);
    }
}
