package com.cheflancer.backend.repository;

import com.cheflancer.backend.entity.HomeBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HomeBannerRepository extends JpaRepository<HomeBanner, Long> {
    
    /**
     * Logic: Returns all banners sorted by the 'displayOrder' column.
     * This allows the Python AI to control the exact sequence (1st, 2nd, 3rd) 
     * by simply changing the integer in the database.
     */
    List<HomeBanner> findAllByOrderByDisplayOrderAsc();
}