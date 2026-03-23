package com.cheflancer.backend.controller;

import com.cheflancer.backend.entity.HomeBanner; // 1. IMPORT YOUR ENTITY
import com.cheflancer.backend.repository.HomeBannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; // 2. IMPORT JAVA UTIL LIST

@RestController
@RequestMapping("/api/home")
@CrossOrigin(origins = "http://localhost:5173")
public class HomeBannerController {

    @Autowired 
    private HomeBannerRepository bannerRepo;

    /**
     * Logic: Returns the list of AI-curated banners.
     * Fix: Changed return type from HomeBannerController to HomeBanner.
     */
    @GetMapping("/banners")
    public List<HomeBanner> getActiveBanners() {
        // Using the sorted method we defined in the Repository
        return bannerRepo.findAllByOrderByDisplayOrderAsc(); 
    }
}