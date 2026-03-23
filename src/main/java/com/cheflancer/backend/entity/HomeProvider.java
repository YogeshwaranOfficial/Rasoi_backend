package com.cheflancer.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "home_providers")
@Data
public class HomeProvider {
    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column(name = "kitchen_name")
    private String kitchenName; // Matches your DB 'kitchen_name'

    @Column(name = "specialist_cuisine")
    private String specialistCuisine; // Matches your DB 'specialist_cuisine'

    @Column(name = "experience_years")
    private Integer experienceYears;

    @Column(name = "signature_dish")
    private String signatureDish;

    @Column(name = "avg_rating")
    private Double avgRating = 4.5;

    @Column(name = "total_reviews")
    private Integer totalReviews = 0;
}