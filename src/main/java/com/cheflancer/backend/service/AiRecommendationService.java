package com.cheflancer.backend.service;

import com.cheflancer.backend.entity.Food;
import com.cheflancer.backend.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AiRecommendationService {

    @Autowired 
    private FoodRepository foodRepo;
    
    private final String GEMINI_API_KEY = "AIzaSyDhB-8Ig2cmbldVqdyXS2gajpBGSirC9Q8";
    private final String GEMINI_URL = "https://generativelanguage.googleapis.com/v1/models/gemini-1.5-flash-latest:generateContent?key=" + GEMINI_API_KEY;

    public List<Food> getFilteredFoods(int age, String gender, String emotion) {
        // Internal Logic for WHO Categories
        String ageGroup;
        if (age <= 10) ageGroup = "KIDS";
        else if (age <= 20) ageGroup = "TEENS";
        else if (age <= 30) ageGroup = "ADULT_YOUNG";
        else if (age <= 40) ageGroup = "ADULT_MID";
        else if (age <= 50) ageGroup = "ADULT_MATURE";
        else ageGroup = "ELDERLY"; // 50+ matches this
                
        // Fetching 10 for Mood/Gender
        List<Food> moodMatches = foodRepo.findByMoodBoosterAndAvailableTrue(emotion.toUpperCase()).stream()
                .filter(f -> f.getTargetGender().equalsIgnoreCase(gender) || f.getTargetGender().equalsIgnoreCase("ALL"))
                .limit(10)
                .collect(Collectors.toList());

        // Fetching 10 for Age/Nutrition (WHO Standards)
        List<Food> ageMatches = foodRepo.findByBiometrics(ageGroup, "ALL").stream()
                .limit(10)
                .collect(Collectors.toList());

        List<Food> final20 = new ArrayList<>();
        final20.addAll(moodMatches);
        final20.addAll(ageMatches);

        return final20;
    }

    public String generateAiReasoning(int age, String gender, String emotion, List<Food> recommendedFoods) {
        if (recommendedFoods == null || recommendedFoods.isEmpty()) return "";

        String foodNames = recommendedFoods.stream()
                .map(Food::getName)
                .distinct()
                .limit(5)
                .collect(Collectors.joining(", "));
        
        String prompt = String.format(
            "User: %d year old %s, feeling %s. Items: %s. " +
            "Provide a professional 2-line nutritional tip about why these suit their stage of life. " +
            "No bullets. No bold."+ "Act as a clinical nutritionist. The user is a [Age Range] [Gender] feeling [Emotion]. They chose [Food Name]. Explain the bio-compatibility of this choice based on WHO age-stage guidelines in 5 lines.",
            age, gender, emotion, foodNames
        );

        try {
            RestTemplate restTemplate = new RestTemplate();
            
            // Fix for Null Type Safety: Building the Map manually
            Map<String, Object> part = new HashMap<>();
            part.put("text", prompt);

            Map<String, Object> content = new HashMap<>();
            content.put("parts", Collections.singletonList(part));

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("contents", Collections.singletonList(content));

            ParameterizedTypeReference<Map<String, Object>> typeRef = new ParameterizedTypeReference<>() {};

            // Wrapping every critical parameter in Objects.requireNonNull
            ResponseEntity<Map<String, Object>> responseEntity = restTemplate.exchange(
                Objects.requireNonNull(GEMINI_URL), 
                Objects.requireNonNull(HttpMethod.POST), 
                new HttpEntity<>(Objects.requireNonNull(requestBody)), 
                typeRef
            );

            Map<String, Object> response = responseEntity.getBody();
            return extractText(response);
        } catch (Exception e) {
            return "These selections provide an optimal balance of energy and nutrients tailored to your specific profile.";
        }
    }

    private String extractText(Map<String, Object> response) {
        try {
            if (response == null) return "Profile analysis complete.";
            List<?> candidates = (List<?>) response.get("candidates");
            Map<?, ?> content = (Map<?, ?>) ((Map<?, ?>) candidates.get(0)).get("content");
            List<?> parts = (List<?>) content.get("parts");
            return (String) ((Map<?, ?>) parts.get(0)).get("text");
        } catch (Exception e) {
            return "Enjoy your personalized healthy meal selection.";
        }
    }
}