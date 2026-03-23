package com.cheflancer.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String password;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(columnDefinition = "TEXT")
    private String bio; 
    
    // FIXED: Made nullable temporarily because existing DB data has NULL locations
    @Column(nullable = true) 
    private String location; 

    // COORDINATES FOR AI & MAPS
    private Double latitude;
    private Double longitude;
    
    private boolean isOnline = true; 

    // --- CLOUDINARY FIELDS ---
    @Column(name = "profile_pic_url")
    private String profilePicUrl;

    @Column(name = "profile_pic_public_id")
    private String profilePicPublicId;

    // --- DUAL VERIFICATION FIELDS ---
    @Column(name = "email_verified")
    private boolean emailVerified = false;

    @Column(name = "phone_verified")
    private boolean phoneVerified = false;
    
    @Column(name = "email_otp")
    private String emailOtp; 

    @Column(name = "phone_otp")
    private String phoneOtp;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // --- RELATIONSHIPS (Cascading for Profile Sync) ---
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Customer customerProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Chef chefProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private HomeProvider homeProfile;

    public enum Role { 
        CUSTOMER, 
        CHEF, 
        HOME_FOOD,
        ADMIN
    }
}