package br.com.souza.spring_boot_essentials.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class TokenProvideT {

    @Value("${jwt.expirations}")
    private Long expirations;

    @Value("${jwt.key}")
    private String key;

    public String gerarToken(Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return buildToken(userDetails.getUsername());
    }

    private String buildToken(String username){

    }
}
