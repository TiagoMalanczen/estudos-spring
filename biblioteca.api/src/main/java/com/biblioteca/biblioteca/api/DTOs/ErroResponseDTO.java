package com.biblioteca.biblioteca.api.DTOs;

import java.time.LocalDate;

public record ErroResponseDTO(
        LocalDate time,
        int status,
        String erro,
        String mensagem
) {
}
