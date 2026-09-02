package com.biblioteca.biblioteca.api.DTOs;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private String matricula;
    @NotBlank
    private String email;

}
