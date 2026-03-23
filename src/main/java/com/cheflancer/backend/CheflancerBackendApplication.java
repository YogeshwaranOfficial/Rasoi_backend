package com.cheflancer.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.cheflancer.backend.config.JwtProperties; // Import your new config class

@SpringBootApplication
@EnableAsync // Required for async email sending and AI processing
@EnableScheduling // Required for your Midnight Reset / AI Metric updates
@EnableConfigurationProperties(JwtProperties.class) // FIX: Clears 'unknown property' warnings in properties file
public class CheflancerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheflancerBackendApplication.class, args);
        
        // Pro-Tip: Final Year Project Branding
        System.out.println("----------------------------------------------------------");
        System.out.println(">>> RasoiElite AI-Based Recommendation Framework: ACTIVE");
        System.out.println(">>> Running on Port: 8080 | Status: Zero Warnings");
        System.out.println("----------------------------------------------------------");
    }
}