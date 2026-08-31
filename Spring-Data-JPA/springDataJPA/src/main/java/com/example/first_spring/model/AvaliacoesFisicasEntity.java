package com.example.first_spring.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "avaliacoes_fisicas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class AvaliacoesFisicasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private BigDecimal peso;
    @Column(nullable = true)
    private BigDecimal altura;
    @Column(name = "Porcentagem_gordura_corporal", nullable = true)
    private BigDecimal porcentagemGordura;


}
