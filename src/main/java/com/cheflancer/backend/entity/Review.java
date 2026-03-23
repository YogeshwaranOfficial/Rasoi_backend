package com.cheflancer.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;        // The Customer
    private Long foodId;        // The Dish
    private String dishName;    
    private Long providerId;    // The Chef
    private Long orderId;       
    private String customerName;
    
    private Integer rating;     // 1 to 5
    
    @Column(columnDefinition = "TEXT")
    private String comment;     
    
    private LocalDateTime createdAt = LocalDateTime.now();
}