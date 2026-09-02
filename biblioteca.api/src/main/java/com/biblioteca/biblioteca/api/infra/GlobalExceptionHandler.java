package com.biblioteca.biblioteca.api.infra;

import com.biblioteca.biblioteca.api.DTOs.ErroResponseDTO;
import com.biblioteca.biblioteca.api.exceptions.RecursoNaoencontradoException;
import com.biblioteca.biblioteca.api.exceptions.RegrasNegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoencontradoException.class)
    public ResponseEntity<ErroResponseDTO> handlerNaoEncontrado(RecursoNaoencontradoException e){
        ErroResponseDTO erro = new ErroResponseDTO (
                LocalDate.now(),
                HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado",
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(RegrasNegocioException.class)
    public ResponseEntity<ErroResponseDTO> handlerRegrasNegocio(RegrasNegocioException e){
        ErroResponseDTO erro = new ErroResponseDTO (
                LocalDate.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Violacao de regra de negocio",
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
