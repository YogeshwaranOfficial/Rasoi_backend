package com.cheflancer.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "chefs")
@Data
@NoArgsConstructor
public class Chef {
    @Id
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    private String kitchenName;
    private String collegeName;
    private String degreePdfUrl; // For your future PDF degree verification
    private String specialization;
    private Integer graduationYear;
    private Double avgRating = 4.5; // Shared rating logic
    private Integer totalReviews = 0;

    public Chef(User user) {
        this.user = user;
        // REMOVED: this.userId = user.getId(); <--- This was the error!
        if (user != null) {
            this.kitchenName = user.getName() + "'s Professional Kitchen";
        }
    }
}
