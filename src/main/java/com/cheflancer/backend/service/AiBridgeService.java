package com.cheflancer.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

@Service
public class AiBridgeService {
    private final String AI_URL = "http://localhost:5000/ai/recommend";
    
    // Use a single instance for better performance
    private final RestTemplate restTemplate = new RestTemplate();

    public boolean getAiDecision(Double rating, Integer orders, Double sentiment) {
        
        // Step 1: Fix Map Null Type Safety
        // Using HashMap and explicit null checks satisfies the @NonNull Map requirement
        Map<String, Object> data = new HashMap<>();
        data.put("rating", Objects.requireNonNullElse(rating, 0.0));
        data.put("orderCount", Objects.requireNonNullElse(orders, 0));
        data.put("sentimentScore", Objects.requireNonNullElse(sentiment, 0.0));
        
        final Map<String, Object> requestBody = Objects.requireNonNull(data);
        
        // Step 2: Fix HttpEntity Null Type Safety
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody);

        // Step 3: Fix HttpMethod Null Type Safety
        // Using a final variable for the Method satisfies Java(16778128)
        final HttpMethod method = Objects.requireNonNull(HttpMethod.POST);

        try {
            ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                AI_URL,
                method,
                entity,
                new ParameterizedTypeReference<Map<String, Object>>() {}
            );

            Map<String, Object> body = response.getBody();
            
            // Step 4: Safe extraction of boolean result
            if (body != null && body.containsKey("is_recommended")) {
                Object result = body.get("is_recommended");
                return result instanceof Boolean && (Boolean) result;
            }
        } catch (Exception e) {
            // If Python AI server is down, return false safely
            System.err.println("AI Service Error: " + e.getMessage());
        }

        return false;
    }
}