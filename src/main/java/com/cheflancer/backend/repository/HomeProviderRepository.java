package com.cheflancer.backend.repository;

import com.cheflancer.backend.entity.HomeProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface HomeProviderRepository extends JpaRepository<HomeProvider, Long> {
    // Custom query to find a Home Provider by their User ID
    Optional<HomeProvider> findByUserId(Long userId);
}