package com.biblioteca.biblioteca.api.database.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "livros")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false, unique = true)
    private String isbm;
    @Column(nullable = false)
    private int quantidadeDisponivel;
}
