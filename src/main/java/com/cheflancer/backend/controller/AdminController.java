package com.cheflancer.backend.controller;

import com.cheflancer.backend.entity.*;
import com.cheflancer.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

    @Autowired private UserRepository userRepo;
    @Autowired private FoodRepository foodRepo;

    // 1. Get All Users (Admin Dashboard View)
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // 2. Delete User Safely (Fixes Null Type Safety Warning)
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        // Logic: Explicitly check for null to satisfy @NonNull requirement
        Long safeId = Objects.requireNonNull(id, "User ID cannot be null");
        
        if (userRepo.existsById(safeId)) {
            userRepo.deleteById(safeId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * 3. Verify Chef Profile
     * FIXED: Changed setVerified(true) to handle both Email and Phone verification.
     */
    @PutMapping("/verify-chef/{id}")
    public ResponseEntity<User> verifyChef(@PathVariable Long id) {
        Long safeId = Objects.requireNonNull(id, "Chef ID cannot be null");

        return userRepo.findById(safeId).map(user -> {
            // Logic: Admin verification bypasses both OTP requirements
            user.setEmailVerified(true);
            user.setPhoneVerified(true);
            user.setEmailOtp(null); // Clear any pending OTPs
            user.setPhoneOtp(null);
            
            return ResponseEntity.ok(userRepo.save(user));
        }).orElse(ResponseEntity.notFound().build());
    }

    // 4. Global Food Management
    @DeleteMapping("/foods/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        Long safeId = Objects.requireNonNull(id, "Food ID cannot be null");

        if (foodRepo.existsById(safeId)) {
            foodRepo.deleteById(safeId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}