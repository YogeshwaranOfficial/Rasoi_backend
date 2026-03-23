package com.cheflancer.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "foods")
@Data
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    private String ingredients; 

    @Column(columnDefinition = "TEXT") 
    private String image; 

    private Long providerId;
    private String providerName; 
    
    private Double latitude;
    private Double longitude;
    
    private boolean available = true; 
    private boolean isAiRecommended = false;
    private Double avgRating = 4.5; 
    private Integer totalOrders = 0;

    // --- NEW BIOMETRIC MAPPING COLUMNS ---
    
    @Column(name = "target_age_group")
    private String targetAgeGroup; // e.g., "KIDS", "TEENS", "ADULT", "ELDERLY"

    @Column(name = "target_gender")
    private String targetGender; // e.g., "MALE", "FEMALE", "ALL"

    @Column(name = "mood_booster")
    private String moodBooster; // e.g., "HAPPY", "STRESSED", "TIRED", "NEUTRAL"

    @Column(name = "spice_level")
    private Integer spiceLevel; // 1 (Low) to 5 (High)

    // --- EXISTING ENUMS ---

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private CookType cookType;

    public enum CookType {
        CHEF, HOME_FOOD
    }

    public enum Category {
        VEG, 
        NON_VEG, 
        CHINESE, 
        SOUTH_INDIAN, 
        NORTH_INDIAN, 
        DESSERTS, 
        CONTINENTAL, 
        BIRYANI      
    }
}