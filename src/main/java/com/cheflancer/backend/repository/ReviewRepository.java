package com.cheflancer.backend.repository;

import com.cheflancer.backend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    
    // For Chef Profile
    List<Review> findByProviderIdOrderByCreatedAtDesc(Long providerId);

    // For Food Details & AI Logic
    List<Review> findByFoodId(Long foodId);
}