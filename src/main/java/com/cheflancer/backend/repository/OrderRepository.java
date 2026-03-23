package com.cheflancer.backend.repository;

import com.cheflancer.backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
    // 1. FOR THE CHEF DASHBOARD: Get all orders to calculate total revenue/stats
    List<Order> findByProviderId(Long providerId);

    // 2. FOR THE CUSTOMER PROFILE: Get all orders so students can see their past meals
    List<Order> findByCustomerId(Long customerId);

    // 3. PRESERVED LOGIC: Finds specific active orders (NEW or PENDING)
    List<Order> findByProviderIdAndStatus(Long providerId, String status);

    // 4. PRESERVED LOGIC: Finds archived orders for the Business Dashboard stats
    List<Order> findByStatus(String status);
    
    // 5. FOR THE AI MODEL: Get completed orders with specific food items to find trends
    List<Order> findByStatusAndFoodName(String status, String foodName);
}