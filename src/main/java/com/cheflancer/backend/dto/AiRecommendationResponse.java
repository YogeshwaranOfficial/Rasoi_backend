package com.cheflancer.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AiRecommendationResponse {
    // Changed from List<Food> to List<FoodDTO>
    private List<FoodDTO> foods;
    
    // This is the "Health Intelligence" text from Gemini
    private String reasoning;
}