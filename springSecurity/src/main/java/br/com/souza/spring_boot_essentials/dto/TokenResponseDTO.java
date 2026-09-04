package br.com.souza.spring_boot_essentials.dto;

public record TokenResponseDTO(
            String nome,
            long expiracao
){}
