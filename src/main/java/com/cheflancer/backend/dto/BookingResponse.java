package com.cheflancer.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BookingResponse {
    private Long orderId;
    private String foodName;
    private String status;
    private LocalDateTime orderTime;
}