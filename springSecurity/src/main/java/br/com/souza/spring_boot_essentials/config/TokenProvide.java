package br.com.souza.spring_boot_essentials.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class TokenProvide {

    @Value("${jwt.expiration}")
    private Long expirationtime;

    @Value("${jwt.key}")
    private String key;

    //Gerar um token
    public String gerarToken(Authentication authentication){
        UserDetails user = (UserDetails) authentication.getPrincipal();
        return buildToken(user.getUsername());
    }

    private String buildToken(String username){
        Date now = new Date();
        Date expiration = new Date(now.getTime() + expirationtime);
        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(expiration)
                .signWith(getSigningKey())
                .compact();
    }

    private SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(key.getBytes());
    }

    //Validar um token
    public boolean validarToken(String token){
        try {
            getClaims(token);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    private Claims getClaims(String token){
        //validar assinatura
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    //Extrair informacoes do token
    public String getUsername(String token){
        return getClaims(token).getSubject();
    }
}
