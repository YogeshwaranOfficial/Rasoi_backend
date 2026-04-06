package com.cheflancer.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import java.util.List;

@Configuration
public class SecurityConfig {

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     http.csrf(csrf -> csrf.disable()) // Required for Postman/React testing
    //         .cors(cors -> cors.configurationSource(request -> {
    //             CorsConfiguration config = new CorsConfiguration();
    //             config.setAllowedOrigins(List.of("http://localhost:5173")); // Your React Port
    //             config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
    //             config.setAllowedHeaders(List.of("*"));
    //             return config;
    //         }))
    //         .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // Allows testing without JWT first
            
    //     return http.build();
    // }
   @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable()) 
        .cors(cors -> cors.configurationSource(request -> {
            CorsConfiguration config = new CorsConfiguration();
            // This allows both local testing and your live site
            config.setAllowedOrigins(List.of(
                "http://localhost:5173", 
                "http://localhost:3000",
                "https://rasoifrontend.vercel.app"
            )); 
            config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            config.setAllowedHeaders(List.of("*")); // Allows all headers
            config.setAllowCredentials(true); 
            return config;
        }))
        .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); 
        
    return http.build();
}
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}