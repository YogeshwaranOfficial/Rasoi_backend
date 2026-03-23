package com.cheflancer.backend.repository;

import com.cheflancer.backend.entity.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {
    // This allows the AI to see everything a specific customer has viewed or ordered
    List<UserActivity> findByUserId(Long userId);
}