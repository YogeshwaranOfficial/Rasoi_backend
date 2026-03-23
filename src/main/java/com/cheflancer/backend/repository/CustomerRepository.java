package com.cheflancer.backend.repository;

import com.cheflancer.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    // Finds the customer profile for delivery address lookups
    Optional<Customer> findByUserId(Long userId);
}