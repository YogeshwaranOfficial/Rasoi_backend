package com.cheflancer.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_activity")
@Data
public class UserActivity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    private Long foodId;
    
    @Enumerated(EnumType.STRING)
    private ActionType action; // VIEW, SEARCH, ORDER
    
    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public enum ActionType { VIEW, SEARCH, ORDER }
}