package com.biblioteca.biblioteca.api.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmprestimoDTO {

    @NotNull
    private Integer usuarioId;

    @NotNull
    private Integer livroId;
}
