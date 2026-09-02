package com.biblioteca.biblioteca.api.services;

import com.biblioteca.biblioteca.api.DTOs.LivroDTO;
import com.biblioteca.biblioteca.api.DTOs.UsuarioDTO;
import com.biblioteca.biblioteca.api.database.model.LivroEntity;
import com.biblioteca.biblioteca.api.database.model.UsuarioEntity;
import com.biblioteca.biblioteca.api.database.repository.UsuarioRespository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UsuarioService {

    private final UsuarioRespository usuarioRespository;

    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRespository.findAll()
                .stream()
                .map(usuario -> UsuarioDTO.builder()
                        .nome(usuario.getNomeUsuario())
                        .email(usuario.getEmail())
                        .matricula(usuario.getMatricula())
                        .build())
                .toList();
    }


    public void cadastrarUsuario(UsuarioDTO usuarioDTO){

        UsuarioEntity identificadorEmail = usuarioRespository
                .findByEmail(usuarioDTO.getEmail())
                .orElse(null);

        UsuarioEntity identificadorMatricula = usuarioRespository
                .findByMatricula(usuarioDTO.getMatricula())
                .orElse(null);

        if(identificadorEmail != null){
            throw new RuntimeException("Usuario com email ja cadastrado");
        }
        if(identificadorMatricula != null){
            throw new RuntimeException("Usuario com matricula ja cadastrada");
        }

        UsuarioEntity usuarioEntity = usuarioRespository
                .save(UsuarioEntity.builder()
                        .email(usuarioDTO.getEmail())
                        .nomeUsuario(usuarioDTO.getNome())
                        .matricula(usuarioDTO.getMatricula())
                        .build());

    }
}
