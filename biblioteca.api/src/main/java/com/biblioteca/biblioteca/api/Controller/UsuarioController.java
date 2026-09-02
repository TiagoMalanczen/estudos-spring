package com.biblioteca.biblioteca.api.Controller;

import com.biblioteca.biblioteca.api.DTOs.UsuarioDTO;
import com.biblioteca.biblioteca.api.database.model.UsuarioEntity;
import com.biblioteca.biblioteca.api.services.UsuarioService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/v1/usuario")
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDTO> listarUsuario(){
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarUsuario(@RequestBody  UsuarioDTO usuarioDTO){
        usuarioService.cadastrarUsuario(usuarioDTO);
        System.out.println("Usuario cadastrado");
    }

}
