package com.cheflancer.backend.repository;

import com.cheflancer.backend.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    
    // --- 1. BIOMETRIC FILTERING (NEW) ---
    
    /**
     * Finds foods matching the specific demographic and emotional profile.
     * We use 'ALL' for gender as a fallback so items like 'Curd Rice' show for everyone.
     */
    @Query("SELECT f FROM Food f WHERE f.targetAgeGroup = :ageGroup " +
           "AND (f.targetGender = :gender OR f.targetGender = 'ALL') " +
           "AND f.available = true")
    List<Food> findByBiometrics(@Param("ageGroup") String ageGroup, 
                                @Param("gender") String gender);

    /**
     * Finds foods specifically tagged to boost a certain mood.
     */
    List<Food> findByMoodBoosterAndAvailableTrue(String moodBooster);

    /**
     * Finds foods that are safe for a specific spice tolerance.
     */
    List<Food> findBySpiceLevelLessThanEqualAndAvailableTrue(Integer spiceLevel);


    // --- 2. EXISTING CORE LOGIC ---
    
    List<Food> findByCategory(Food.Category category);

    List<Food> findByIsAiRecommendedTrue();
    
    List<Food> findByProviderId(Long providerId);

    List<Food> findByNameContainingIgnoreCaseOrCategory(String name, Food.Category category);

    List<Food> findByAvgRatingGreaterThanEqual(Double rating);
}