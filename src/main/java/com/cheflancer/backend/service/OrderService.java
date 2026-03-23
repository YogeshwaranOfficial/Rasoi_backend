package com.cheflancer.backend.service;

import com.cheflancer.backend.entity.Order;
import com.cheflancer.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    /**
     * 1. PLACE ORDER
     * FIX: Null type safety for the saved object.
     */
    public Order placeOrder(Order order) {
        // Step 1: Ensure the order object is strictly non-null
        final Order safeOrder = Objects.requireNonNull(order, "Order data cannot be null");
        safeOrder.setStatus("PENDING"); 
        
        return orderRepository.save(safeOrder);
    }

    /**
     * 2. FETCH FOR CHEF
     * FIX: Null type safety for Chef ID.
     */
    public List<Order> getOrdersByChef(Long chefId) {
        final Long safeChefId = Objects.requireNonNull(chefId, "Chef ID cannot be null");
        return orderRepository.findByProviderId(safeChefId);
    }

    /**
     * 3. FETCH FOR CUSTOMER
     * FIX: Null type safety for Customer ID.
     */
    public List<Order> getOrdersByCustomer(Long customerId) {
        final Long safeCustomerId = Objects.requireNonNull(customerId, "Customer ID cannot be null");
        return orderRepository.findByCustomerId(safeCustomerId);
    }

    /**
     * 4. UPDATE STATUS: The "Accept/Reject" logic
     * FIX: Null type safety for orderId and returned order object.
     */
    public Order updateOrderStatus(Long orderId, String newStatus) {
        // Step 1: Extract to a final variable with a strict null check
        final Long safeOrderId = Objects.requireNonNull(orderId, "Order ID cannot be null");
        
        Order order = orderRepository.findById(safeOrderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + safeOrderId));
        
        order.setStatus(newStatus);
        
        // Step 2: Ensure the save method receives a verified non-null object
        final Order orderToSave = Objects.requireNonNull(order);
        return orderRepository.save(orderToSave);
    }
}