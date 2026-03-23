package com.cheflancer.backend.dto;

import com.cheflancer.backend.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String image;
    private Long providerId;
    private String providerName;
    private Double latitude;
    private Double longitude;
    private boolean available;
    private boolean isAiRecommended;
    private Double avgRating;
    private String category;
    private String cookType;

    // --- NEW BIOMETRIC FIELDS FOR FRONTEND ---
    private String targetAgeGroup;
    private String targetGender;
    private String moodBooster;
    private Integer spiceLevel;

    // Updated Helper Constructor
    public FoodDTO(Food food) {
        this.id = food.getId();
        this.name = food.getName();
        this.price = food.getPrice();
        this.description = food.getDescription();
        this.image = food.getImage();
        this.providerId = food.getProviderId();
        this.providerName = food.getProviderName();
        this.latitude = food.getLatitude();
        this.longitude = food.getLongitude();
        this.available = food.isAvailable();
        this.isAiRecommended = food.isAiRecommended();
        this.avgRating = food.getAvgRating();
        this.category = food.getCategory() != null ? food.getCategory().name() : null;
        this.cookType = food.getCookType() != null ? food.getCookType().name() : null;
        
        // Mapping new entity fields to DTO
        this.targetAgeGroup = food.getTargetAgeGroup();
        this.targetGender = food.getTargetGender();
        this.moodBooster = food.getMoodBooster();
        this.spiceLevel = food.getSpiceLevel();
    }
}