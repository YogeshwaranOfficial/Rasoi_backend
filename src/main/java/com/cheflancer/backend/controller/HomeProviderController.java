package com.cheflancer.backend.controller;

import com.cheflancer.backend.entity.HomeProvider;
import com.cheflancer.backend.repository.HomeProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/home-providers")
@CrossOrigin(origins = "http://localhost:5173")
public class HomeProviderController {

    @Autowired private HomeProviderRepository homeRepo;

    // 1. GET HOME KITCHEN PROFILE
    @GetMapping("/{userId}")
    public ResponseEntity<HomeProvider> getHomeProfile(@PathVariable Long userId) {
        // FIX: Handle null safety for the ID path variable
        final Long safeId = Objects.requireNonNull(userId, "User ID cannot be null");
        
        return homeRepo.findById(safeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 2. UPDATE HOME DATA (Signature Dish, Experience, etc.)
    @PutMapping("/{userId}")
    public ResponseEntity<HomeProvider> updateHomeProvider(@PathVariable Long userId, @RequestBody HomeProvider details) {
        // FIX: Handle null safety for both the ID and the Request Body
        final Long safeId = Objects.requireNonNull(userId, "Update ID cannot be null");
        final HomeProvider safeDetails = Objects.requireNonNull(details, "Provider details cannot be null");

        return homeRepo.findById(safeId).map(existingHp -> {
            // FIX: Ensure the retrieved entity is treated as NonNull for the compiler
            final HomeProvider hp = Objects.requireNonNull(existingHp);
            
            if (safeDetails.getKitchenName() != null) hp.setKitchenName(safeDetails.getKitchenName());
            if (safeDetails.getSignatureDish() != null) hp.setSignatureDish(safeDetails.getSignatureDish());
            if (safeDetails.getSpecialistCuisine() != null) hp.setSpecialistCuisine(safeDetails.getSpecialistCuisine());
            if (safeDetails.getExperienceYears() != null) hp.setExperienceYears(safeDetails.getExperienceYears());
            
            return ResponseEntity.ok(homeRepo.save(hp));
        }).orElse(ResponseEntity.notFound().build());
    }
}