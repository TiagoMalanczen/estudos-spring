package com.biblioteca.biblioteca.api.DTOs;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroDTO {

    @NotBlank
    private String titulo;
    @NotBlank
    private String isbm;
    @NotNull
    private int quantidadeDisponivel;

}
