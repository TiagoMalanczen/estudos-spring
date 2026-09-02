package com.biblioteca.biblioteca.api.database.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nomeUsuario;

    @Column(nullable = false)
    private String matricula;

    @Column(nullable = false, unique = true)
    private String email;

}
