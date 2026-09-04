package br.com.souza.spring_boot_essentials.controller;

import br.com.souza.spring_boot_essentials.dto.LoginRequestDTo;
import br.com.souza.spring_boot_essentials.dto.RegisterRequestDTO;
import br.com.souza.spring_boot_essentials.dto.TokenResponseDTO;
import br.com.souza.spring_boot_essentials.exception.BadRequestException;
import br.com.souza.spring_boot_essentials.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public void regiter(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) throws BadRequestException {
        authenticationService.register(registerRequestDTO);
    }

    @PostMapping("/login")
    public TokenResponseDTO login(@RequestBody @Valid LoginRequestDTo loginRequestDTo) throws Exception {
        return authenticationService.login(loginRequestDTo);
    }
}
