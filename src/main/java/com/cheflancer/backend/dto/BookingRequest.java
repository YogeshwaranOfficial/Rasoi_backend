package com.cheflancer.backend.dto;

import lombok.Data;

@Data
public class BookingRequest {
    private Long customerId;
    private Long providerId;
    private String foodName;
    private Double totalPrice;
}