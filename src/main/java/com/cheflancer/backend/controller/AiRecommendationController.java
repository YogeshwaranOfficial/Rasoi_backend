package com.cheflancer.backend.controller;

import com.cheflancer.backend.dto.AiRecommendationResponse;
import com.cheflancer.backend.dto.FoodDTO;
import com.cheflancer.backend.service.AiRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/foods")
@CrossOrigin(origins = "http://localhost:3000") 
public class AiRecommendationController {

    @Autowired 
    private AiRecommendationService aiService;

    @GetMapping("/recommend")
    public AiRecommendationResponse getAiRecommendations(
            @RequestParam int age, 
            @RequestParam String gender, 
            @RequestParam String emotion) {
        
        // 1. Get the filtered entities from the service
        // (We will update the Service next to match this logic)
        var foodEntities = aiService.getFilteredFoods(age, gender, emotion);
        
        // 2. Convert Entities to DTOs for the response
        List<FoodDTO> foodDtos = foodEntities.stream()
                .map(FoodDTO::new)
                .collect(Collectors.toList());

        // 3. Generate the AI "Reasoning" text (Gemini call)
        String reasoning = aiService.generateAiReasoning(age, gender, emotion, foodEntities);
        
        // 4. Return the new DTO-based response
        return new AiRecommendationResponse(foodDtos, reasoning);
    }
}