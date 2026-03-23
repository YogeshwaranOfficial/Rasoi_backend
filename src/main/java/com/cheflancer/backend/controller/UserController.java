package com.cheflancer.backend.controller;

import com.cheflancer.backend.entity.User;
import com.cheflancer.backend.service.UserService;
import com.cheflancer.backend.service.CloudinaryService;
import com.cheflancer.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired private UserService userService;
    @Autowired private CloudinaryService cloudinaryService;
    @Autowired private UserRepository userRepo;

    // 1. DYNAMIC LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        return userService.authenticate(email, password)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    // 2. REGISTRATION
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        if(userService.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(userService.registerUser(user));
    }

    // 3. UNIFIED PROFILE UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<User> updateProfile(@PathVariable Long id, @RequestBody User userDetails) {
        // FIX: Ensuring 'id' is converted to a non-null type to satisfy Java warnings
        final Long safeId = Objects.requireNonNull(id, "User ID cannot be null");
        try {
            User updatedUser = userService.updateUserProfile(
                safeId, 
                userDetails, 
                userDetails.getCustomerProfile(), 
                null, 
                null
            ); 
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 4. CLOUDINARY IMAGE UPLOAD
     * FIX: Added Objects.requireNonNull to resolve 'Long' to '@NonNull Long' warning
     */
    @PostMapping("/{id}/upload-profile-pic")
    public ResponseEntity<?> updateProfilePicture(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        // This line converts the nullable Long into a guaranteed non-null value
        final Long safeId = Objects.requireNonNull(id, "ID is required for upload");

        return userRepo.findById(safeId).map(user -> {
            try {
                // Delete existing pic if it exists
                if (user.getProfilePicPublicId() != null) {
                    cloudinaryService.deleteImage(user.getProfilePicPublicId());
                }

                // Upload to Cloudinary
                // Inside the upload endpoint
                Map<String, Object> result = cloudinaryService.uploadImage(file, "profiles/customers");
                
                // Update DB
                user.setProfilePicUrl(result.get("secure_url").toString());
                user.setProfilePicPublicId(result.get("public_id").toString());
                userRepo.save(user);

                return ResponseEntity.ok(Map.of("url", user.getProfilePicUrl()));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                     .body("Cloudinary Error: " + e.getMessage());
            }
        }).orElse(ResponseEntity.notFound().build());
    }

    // 5. PUBLIC PROFILE DATA
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        final Long safeId = Objects.requireNonNull(id, "ID is required");
        return userService.findById(safeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}