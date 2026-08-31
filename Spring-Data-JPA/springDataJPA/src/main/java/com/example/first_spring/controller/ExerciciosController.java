package com.example.first_spring.controller;

import com.example.first_spring.database.model.ExerciciosEntity;
import com.example.first_spring.dto.ExerciciosDTO;
import com.example.first_spring.services.ExerciciosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/exercicios")
@RequiredArgsConstructor
@Validated
public class ExerciciosController {

    private final ExerciciosService exerciciosService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> findAll(){
        return exerciciosService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody ExerciciosDTO exerciciosDTO){
        exerciciosService.save(exerciciosDTO);
    }

    @GetMapping("/grupo/{grupoMuscular}")
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> findByGrupoMuscular(@PathVariable String grupoMuscular){
        return exerciciosService.findAllGrupoMuscular(grupoMuscular);
    }
}
