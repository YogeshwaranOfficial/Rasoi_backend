package com.cheflancer.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "home_banners")
@Data
public class HomeBanner {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long foodId; 
    private String bannerName;
    
    @Column(columnDefinition = "TEXT")
    private String bannerBio;
    
    private String bannerImageUrl;
    private String bannerTag;
    private String themeColor;

    // --- ADD THIS FIELD TO FIX THE ERROR ---
    @Column(name = "display_order")
    private Integer displayOrder; 
}