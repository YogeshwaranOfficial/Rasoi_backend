package com.cheflancer.backend.controller;

import com.cheflancer.backend.entity.Booking;
import com.cheflancer.backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:5173")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    /**
     * 1. Customer places a new order
     * FIX: Null type safety for the saved object
     */
    @PostMapping("/place")
    public ResponseEntity<Booking> placeOrder(@RequestBody Booking booking) {
        // Step 1: Guarantee the booking object is not null
        final Booking safeBooking = Objects.requireNonNull(booking, "Booking data cannot be null");
        
        // Initial status set to PENDING for Chef review
        safeBooking.setStatus("PENDING"); 
        
        return ResponseEntity.ok(bookingRepository.save(safeBooking));
    }

    /**
     * 2. Chef accepts/updates status
     * FIX: Null type safety for ID and extracted Map values
     */
    @PutMapping("/{id}/status")
    public ResponseEntity<Booking> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> statusUpdate) {
        // Step 1: Ensure ID and Map are non-null
        final Long safeId = Objects.requireNonNull(id, "ID cannot be null");
        final Map<String, String> safeUpdate = Objects.requireNonNull(statusUpdate, "Status update map cannot be null");
        
        String newStatus = safeUpdate.get("status");

        return bookingRepository.findById(safeId).map(booking -> {
            booking.setStatus(newStatus); // e.g., PREPARING, COMPLETED
            return ResponseEntity.ok(bookingRepository.save(booking));
        }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * 3. Get all orders for a specific Chef
     * FIX: Null type safety for PathVariable
     */
    @GetMapping("/provider/{providerId}")
    public List<Booking> getProviderOrders(@PathVariable Long providerId) {
        final Long safeProviderId = Objects.requireNonNull(providerId, "Provider ID cannot be null");
        return bookingRepository.findByProviderId(safeProviderId);
    }

    /**
     * 4. Get specific order details
     * FIX: Null type safety for ID search
     */
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getOrderById(@PathVariable Long id) {
        final Long safeId = Objects.requireNonNull(id, "Order ID cannot be null");
        
        return bookingRepository.findById(safeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    /**
     * 5. Get all orders for a specific Customer (Order History)
     */
    @GetMapping("/customer/{customerId}")
    public List<Booking> getCustomerOrders(@PathVariable Long customerId) {
        final Long safeCustomerId = Objects.requireNonNull(customerId, "Customer ID cannot be null");
        return bookingRepository.findByCustomerId(safeCustomerId);
    }
}