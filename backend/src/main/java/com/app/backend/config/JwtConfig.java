package com.app.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

@Configuration
public class JwtConfig {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expirationInMs}")
    private long expirationInMs;

    @Bean
    public Key jwtSecretKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String getSecret() {
        return secret;
    }

    public long getExpirationInMs() {
        return expirationInMs;
    }

    public SignatureAlgorithm getAlgorithm() {
        return SignatureAlgorithm.HS256;
    }
}
