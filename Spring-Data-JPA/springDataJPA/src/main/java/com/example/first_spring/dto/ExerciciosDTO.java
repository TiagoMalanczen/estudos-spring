package com.example.first_spring.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ExerciciosDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private String grupoMuscular;
}
