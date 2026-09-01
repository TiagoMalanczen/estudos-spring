package com.example.first_spring.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlunosDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private String email;
}
