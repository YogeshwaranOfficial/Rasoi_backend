package com.cheflancer.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private String customerName; // Added: For the Chef to see who ordered
    
    private Long providerId;     // The Chef
    private String providerName; // Added: For the Customer to see which kitchen they ordered from
    
    private String foodName;
    private Double totalPrice;
    
    /**
     * Startup Logic Statuses: 
     * PENDING (Customer placed it)
     * ACCEPTED (Chef is cooking)
     * DELIVERED (Order reached student)
     * CANCELLED (By either party)
     */
    private String status = "PENDING"; 

    private LocalDateTime orderTime = LocalDateTime.now();
    
    // NEW: Payment tracking for real-world reliability
    private String paymentStatus = "UNPAID"; // UNPAID, PAID
}