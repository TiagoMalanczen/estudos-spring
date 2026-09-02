package com.biblioteca.biblioteca.api.Controller;


import com.biblioteca.biblioteca.api.DTOs.LivroDTO;
import com.biblioteca.biblioteca.api.database.model.LivroEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.biblioteca.biblioteca.api.services.LivroService;

import java.util.List;

@RestController
@RequestMapping("/v1/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LivroDTO> mostrarLivros(){
        return livroService.buscarLivros();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarLivro(@RequestBody LivroDTO livroDTO){
        livroService.cadastrarLivro(livroDTO);
    }

}
