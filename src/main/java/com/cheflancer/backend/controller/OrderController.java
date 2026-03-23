package com.cheflancer.backend.controller;

import com.cheflancer.backend.entity.Order;
import com.cheflancer.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // POST: Place a new order
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.placeOrder(order));
    }

    // GET: Get all orders for a specific Chef Dashboard
    @GetMapping("/chef/{chefId}")
    public ResponseEntity<List<Order>> getChefOrders(@PathVariable Long chefId) {
        return ResponseEntity.ok(orderService.getOrdersByChef(chefId));
    }

    // GET: Get all orders for a Customer's Profile
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderService.getOrdersByCustomer(customerId));
    }

    // // PUT: Update status (Accept, Deliver, Cancel)
    // @PutMapping("/{id}/status")
    // public ResponseEntity<Order> updateStatus(@PathVariable Long id, @RequestParam String status) {
    //     return ResponseEntity.ok(orderService.updateOrderStatus(id, status));
    // }
    
    // MUST match the axios.put call in React exactly
    @PutMapping("/{id}/status")
    public ResponseEntity<Order> updateStatus(@PathVariable Long id, @RequestParam String status) {
        Order updated = orderService.updateOrderStatus(id, status);
        return ResponseEntity.ok(updated);
    }
}