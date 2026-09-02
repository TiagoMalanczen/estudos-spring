package com.biblioteca.biblioteca.api.database.model;

import com.biblioteca.biblioteca.api.database.enums.StatusEmprestimo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "emprestimos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmprestimoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate dataEmprestimo;

    @Column(nullable = false)
    private LocalDate dataDevolucaoPrevista;

    @Column
    private LocalDate dataDevolucaoEfetiva;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEmprestimo statusEmprestimo;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuarioEntity;

    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private LivroEntity livroEntity;

}

