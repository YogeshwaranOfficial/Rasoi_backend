package com.cheflancer.backend.controller;

import com.cheflancer.backend.dto.FoodDTO;
import com.cheflancer.backend.entity.Food;
import com.cheflancer.backend.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/foods")
// FIXED: Use 5173 consistently (Standard for Vite/React)
 
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping
    public List<FoodDTO> getAllFoods() {
        return foodRepository.findAll().stream()
                .map(FoodDTO::new) // This now automatically includes biometric fields
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDTO> getFoodById(@PathVariable Long id) {
        Long safeId = Objects.requireNonNull(id, "Food ID cannot be null");
        return foodRepository.findById(safeId)
                .map(food -> ResponseEntity.ok(new FoodDTO(food)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<FoodDTO>> getFoodsByCategory(@PathVariable String category) {
        try {
            Food.Category catEnum = Food.Category.valueOf(category.toUpperCase());
            List<FoodDTO> foods = foodRepository.findByCategory(catEnum).stream()
                    .map(FoodDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(foods);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<FoodDTO> createFood(@RequestBody Food food) {
        return saveFoodLogic(food);
    }

    private ResponseEntity<FoodDTO> saveFoodLogic(Food food) {
        if (food.getLatitude() == null || food.getLongitude() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // --- NEW: BIOMETRIC DEFAULTS ---
        // If no biometric data is provided, we set safe defaults
        if (food.getTargetAgeGroup() == null) food.setTargetAgeGroup("ADULT");
        if (food.getTargetGender() == null) food.setTargetGender("ALL");
        if (food.getMoodBooster() == null) food.setMoodBooster("NEUTRAL");
        if (food.getSpiceLevel() == null) food.setSpiceLevel(3);

        food.setAiRecommended(false); 
        if (food.getAvgRating() == null) food.setAvgRating(4.5);
        if (food.getTotalOrders() == null) food.setTotalOrders(0);

        Food savedFood = foodRepository.save(food);
        return new ResponseEntity<>(new FoodDTO(savedFood), HttpStatus.OK);
    }

    @GetMapping("/provider/{providerId}")
    public List<FoodDTO> getProviderMenu(@PathVariable Long providerId) {
        return foodRepository.findByProviderId(providerId).stream()
                .map(FoodDTO::new)
                .collect(Collectors.toList());
    }

    /**
     * General Recommendations (Static)
     * This uses a weighted score based on popularity and rating.
     */
    @GetMapping("/recommended")
    public List<FoodDTO> getRecommendedFoods() {
        return foodRepository.findAll().stream()
                .filter(Food::isAvailable)
                .sorted((f1, f2) -> {
                    // Formula: (Rating * 70%) + (Popularity * 30%)
                    double score1 = (f1.getAvgRating() * 0.7) + (f1.getTotalOrders() * 0.3);
                    double score2 = (f2.getAvgRating() * 0.7) + (f2.getTotalOrders() * 0.3);
                    
                    if (f1.isAiRecommended()) score1 += 1.0;
                    if (f2.isAiRecommended()) score2 += 1.0;
                    
                    return Double.compare(score2, score1); 
                })
                .limit(6) 
                .map(FoodDTO::new)
                .collect(Collectors.toList());
    }
}