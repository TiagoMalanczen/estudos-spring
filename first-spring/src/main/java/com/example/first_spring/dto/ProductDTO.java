package com.example.first_spring.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductDTO {

    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}
