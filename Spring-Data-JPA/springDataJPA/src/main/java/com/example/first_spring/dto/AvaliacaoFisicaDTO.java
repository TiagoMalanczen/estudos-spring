package com.example.first_spring.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AvaliacaoFisicaDTO {

    @NotNull
    private Integer id;
    @NotNull
    private BigDecimal peso;
    @NotNull
    private BigDecimal altura;
    @NotNull
    private BigDecimal percentualGordura;

}
