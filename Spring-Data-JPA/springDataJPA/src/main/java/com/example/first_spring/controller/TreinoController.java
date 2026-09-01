package com.example.first_spring.controller;

import com.example.first_spring.database.repository.TreinosRepository;
import com.example.first_spring.dto.TreinoDTO;
import com.example.first_spring.services.TreinoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/treino")
@RequiredArgsConstructor
@Validated
public class TreinoController {

    private final TreinoService treinoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTreino(@Valid @RequestBody TreinoDTO treinoDTO){
        treinoService.criarTreino(treinoDTO);
    }

}
