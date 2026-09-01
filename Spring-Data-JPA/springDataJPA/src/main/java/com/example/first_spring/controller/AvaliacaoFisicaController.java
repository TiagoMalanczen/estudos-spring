package com.example.first_spring.controller;

import com.example.first_spring.dto.AvaliacaoFisicaDTO;
import com.example.first_spring.services.AvaliacaoFisicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/avaliacao_fisica")
@RequiredArgsConstructor
@Validated
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDTO avaliacaoFisicaDTO){
        avaliacaoFisicaService.criarAvaliacaoFisica(avaliacaoFisicaDTO);
    }
}
