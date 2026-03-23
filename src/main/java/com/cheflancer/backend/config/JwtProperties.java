package com.cheflancer.backend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "rasoi.jwt")
@Data // This generates getters/setters so Spring can inject the values
public class JwtProperties {
    private String secret;
    private Long expiration;
}