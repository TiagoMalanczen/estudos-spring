package br.com.souza.spring_boot_essentials.service;

import br.com.souza.spring_boot_essentials.config.TokenProvide;
import br.com.souza.spring_boot_essentials.database.model.AlunosEntity;
import br.com.souza.spring_boot_essentials.database.model.RolesEntity;
import br.com.souza.spring_boot_essentials.database.repository.IAlunosRepository;
import br.com.souza.spring_boot_essentials.database.repository.RolesRepository;
import br.com.souza.spring_boot_essentials.dto.LoginRequestDTo;
import br.com.souza.spring_boot_essentials.dto.RegisterRequestDTO;
import br.com.souza.spring_boot_essentials.dto.TokenResponseDTO;
import br.com.souza.spring_boot_essentials.enums.RoleTypeEnum;
import br.com.souza.spring_boot_essentials.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor

public class AuthenticationService {

    private final IAlunosRepository alunosRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenProvide tokenProvide;
    @Value("${jwt.expiration}")
    private Long expirationtime;

    public void register(RegisterRequestDTO dto) throws BadRequestException {
        AlunosEntity aluno = alunosRepository.findByEmail(dto.getEmail())
                .orElse(null);

        if (aluno != null) {
            throw new BadRequestException("Aluno já cadastrado com este email");
        }

        RolesEntity role = rolesRepository.findByNome(RoleTypeEnum.ROlE_ALUNO.name())
                        .orElseGet(() -> rolesRepository.save(RolesEntity.builder()
                                        .nome(RoleTypeEnum.ROlE_ALUNO.name())
                                .build()));

        alunosRepository.save(AlunosEntity.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .roles(Set.of(role))
                .senha(passwordEncoder.encode(dto.getSenha()))
                .build());
    }

    public TokenResponseDTO login(LoginRequestDTo loginRequestDTo) throws Exception {
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTo.getEmail(), loginRequestDTo.getSenha()));
            String token = tokenProvide.gerarToken(authenticate);

            return new TokenResponseDTO(token, expirationtime);
        }
        catch (BadCredentialsException e){
            throw new BadRequestException("Credenciais Invalidas");
        }
        catch (Exception e){
            throw e;
        }
    }
}
