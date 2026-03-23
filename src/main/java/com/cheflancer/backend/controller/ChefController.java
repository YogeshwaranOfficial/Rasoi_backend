package com.cheflancer.backend.controller;

import com.cheflancer.backend.entity.Chef;
import com.cheflancer.backend.repository.ChefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/chefs")
@CrossOrigin(origins = "http://localhost:5173")
public class ChefController {

    @Autowired private ChefRepository chefRepo;

    // 1. GET PROFESSIONAL PROFILE
    @GetMapping("/{userId}")
    public ResponseEntity<Chef> getChefProfile(@PathVariable Long userId) {
        // FIX: Explicitly handle null safety for the ID
        final Long safeId = Objects.requireNonNull(userId, "User ID cannot be null");
        
        return chefRepo.findById(safeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 2. UPDATE PROFESSIONAL DATA (College, Specialization, etc.)
    @PutMapping("/{userId}")
    public ResponseEntity<Chef> updateChef(@PathVariable Long userId, @RequestBody Chef details) {
        // FIX: Explicitly handle null safety for both the ID and the Body
        final Long safeId = Objects.requireNonNull(userId, "Update ID cannot be null");
        final Chef safeDetails = Objects.requireNonNull(details, "Chef details cannot be null");

        return chefRepo.findById(safeId).map(existingChef -> {
            // FIX: Ensure the entity itself is treated as NonNull
            final Chef chef = Objects.requireNonNull(existingChef);
            
            if (safeDetails.getKitchenName() != null) chef.setKitchenName(safeDetails.getKitchenName());
            if (safeDetails.getCollegeName() != null) chef.setCollegeName(safeDetails.getCollegeName());
            if (safeDetails.getSpecialization() != null) chef.setSpecialization(safeDetails.getSpecialization());
            if (safeDetails.getGraduationYear() != null) chef.setGraduationYear(safeDetails.getGraduationYear());
            if (safeDetails.getDegreePdfUrl() != null) chef.setDegreePdfUrl(safeDetails.getDegreePdfUrl());
            
            return ResponseEntity.ok(chefRepo.save(chef));
        }).orElse(ResponseEntity.notFound().build());
    }
}