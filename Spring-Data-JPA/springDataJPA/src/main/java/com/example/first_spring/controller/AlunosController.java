package com.example.first_spring.controller;


import com.example.first_spring.database.model.AlunosEntity;
import com.example.first_spring.database.model.AvaliacoesFisicasEntity;
import com.example.first_spring.dto.AlunosDTO;
import com.example.first_spring.services.AlunosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/alunos")
@RequiredArgsConstructor
@Validated
public class AlunosController {

    private final AlunosService alunosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@Valid @RequestBody AlunosDTO alunosDTO){
        alunosService.cadastrarAluno(alunosDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlunosEntity> listarAlunos(){
        return alunosService.listarAll();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvaliacoesFisicasEntity mostrarAvaliacao(@PathVariable Integer id){
        return alunosService.getALunoAvaliacao(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAluno(@PathVariable Integer id){
        alunosService.deletarAluno(id);
    }
}
