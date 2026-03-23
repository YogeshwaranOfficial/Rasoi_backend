package com.cheflancer.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    // CRITICAL: Prevents Infinite Recursion in JSON
    @JsonBackReference
    private User user;

    private String address;
    private String city = "Madurai"; // Logic: Updated to Madurai for consistency

    // --- NEW PROFILE FIELDS ---
    private LocalDate dob; // Stores Date of Birth
    
    @Enumerated(EnumType.STRING)
    private Gender gender; // Enum for MALE, FEMALE, OTHER
    
    private String favoriteCuisines; // Stores values like "South Indian, Chinese"
    
    private String profilePictureUrl;

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    // Updated constructor for modern Hibernate mapping
    public Customer(User user) {
        this.user = user;
        if (user != null) {
            this.userId = user.getId();
        }
    }
}