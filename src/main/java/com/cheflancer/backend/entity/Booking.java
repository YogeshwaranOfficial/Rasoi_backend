package com.cheflancer.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Long providerId;
    private String foodName;
    private Double totalPrice;
    
    // Status represents the lifecycle of the order
    private String status = "PENDING"; // PENDING, PREPARING, COMPLETED, DELIVERED

    // Capture the time of order for the Dashboard Graphs
    @Column(name = "order_time")
    private LocalDateTime orderTime = LocalDateTime.now();
}