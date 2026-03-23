package com.cheflancer.backend.repository;

import com.cheflancer.backend.entity.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Long> {
    // Custom query to find a Chef by their User ID
    Optional<Chef> findByUserId(Long userId);
}