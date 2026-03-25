package com.cheflancer.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull; // Required import for null safety
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// public class WebConfig implements WebMvcConfigurer {

//     @Override
//     public void addCorsMappings(@NonNull CorsRegistry registry) { // Add @NonNull here
//         registry.addMapping("/**")
//                 .allowedOrigins("http://localhost:5173") // Matches your React frontend port
//                 .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                 .allowedHeaders("*")
//                 .allowCredentials(true);
//     }
// }// Add this import

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) { // Add @NonNull here
        registry.addMapping("/**")
                .allowedOrigins("https://rasoifrontend.vercel.app")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}