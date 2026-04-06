package com.cheflancer.backend.controller;

import com.cheflancer.backend.entity.Review;
import com.cheflancer.backend.repository.ReviewRepository;
import com.cheflancer.backend.repository.FoodRepository; // ADDED IMPORT
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects; // ADDED FOR NULL SAFETY

@RestController
@RequestMapping("/api/reviews")

public class ReviewController {

    @Autowired 
    private ReviewRepository reviewRepo;

    @Autowired 
    private FoodRepository foodRepository; // FIXED: Added missing repository

    @GetMapping("/food/{foodId}")
    public List<Review> getReviewsByFood(@PathVariable Long foodId) {
        return reviewRepo.findByFoodId(foodId);
    }

    @GetMapping("/provider/{providerId}")
    public List<Review> getReviewsByChef(@PathVariable Long providerId) {
        return reviewRepo.findByProviderIdOrderByCreatedAtDesc(providerId);
    }

    @PostMapping("/submit")
    public ResponseEntity<Review> submitReview(@RequestBody Review review) {
        // 1. Save the new review with null safety
        final Review safeReview = Objects.requireNonNull(review, "Review data cannot be null");
        Review savedReview = reviewRepo.save(safeReview);
        
        // 2. Logic: Update the Food's Average Rating and Popularity
        final Long safeFoodId = Objects.requireNonNull(safeReview.getFoodId(), "Food ID is required");

        foodRepository.findById(safeFoodId).ifPresent(food -> {
            List<Review> allReviews = reviewRepo.findByFoodId(food.getId());
            
            // Calculate new average rating
            double newAvg = allReviews.stream()
                    .mapToInt(Review::getRating)
                    .average()
                    .orElse(0.0);
            
            food.setAvgRating(newAvg);
            
            // Increment popularity (total orders) for the AI algorithm
            Integer currentOrders = food.getTotalOrders() != null ? food.getTotalOrders() : 0;
            food.setTotalOrders(currentOrders + 1); 
            
            foodRepository.save(food);
        });
        
        return ResponseEntity.ok(savedReview);
    }
}