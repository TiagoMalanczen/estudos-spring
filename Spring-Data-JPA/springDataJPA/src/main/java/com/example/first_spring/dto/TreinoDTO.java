package com.example.first_spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class TreinoDTO {

    @NotNull
    private Integer idAluno;
    @NotBlank
    private String nome;
    @NotEmpty
    private List<Integer> exerciciosId;
}
