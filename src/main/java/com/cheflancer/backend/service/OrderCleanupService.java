package com.cheflancer.backend.service;

import com.cheflancer.backend.entity.Order;
import com.cheflancer.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderCleanupService {

    @Autowired
    private OrderRepository orderRepository;

    // Runs at 00:00:00 (Midnight) every day
    // Cron format: "second minute hour day month day-of-week"
    @Scheduled(cron = "0 0 0 * * *")
    public void archiveDailyOrders() {
        System.out.println("Midnight Reset: Starting order archiving process...");

        // 1. Fetch all finished orders
        List<Order> activeOrders = orderRepository.findAll();
        
        int archivedCount = 0;
        for (Order order : activeOrders) {
            if ("COMPLETED".equalsIgnoreCase(order.getStatus()) || 
                "CANCELLED".equalsIgnoreCase(order.getStatus())) {
                
                order.setStatus("ARCHIVED"); // Move to history
                orderRepository.save(order);
                archivedCount++;
            }
        }

        System.out.println("Midnight Reset Complete. Archived " + archivedCount + " orders.");
    }
}