package com.cheflancer.backend.repository;

import com.cheflancer.backend.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    
    // 1. Fetch all orders for a specific Chef to show on their Dashboard
    List<Booking> findByProviderId(Long providerId);

    // 2. Fetch all orders for a specific Customer (Anna Univ Student) to show History
    List<Booking> findByCustomerId(Long customerId);

    // 3. Performance Analytics: Find completed orders in a date range for Graphs
    List<Booking> findByProviderIdAndStatusAndOrderTimeBetween(
        Long providerId, 
        String status, 
        LocalDateTime start, 
        LocalDateTime end
    );

    // 4. Status Filter: Find "Live" orders that need cooking
    List<Booking> findByProviderIdAndStatus(Long providerId, String status);
}