package com.cheflancer.backend.service;

import com.cheflancer.backend.entity.*;
import com.cheflancer.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.Objects;

@Service
public class UserService {

    @Autowired private UserRepository userRepository;
    @Autowired private ChefRepository chefRepository;
    @Autowired private HomeProviderRepository homeProviderRepository;
    @Autowired private CustomerRepository customerRepository;

    // Logic: Industry standard encoder for password security
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Logic: Encodes a raw password. Used by AuthController for Reset Password.
     */
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public Optional<User> findById(Long id) {
        final Long safeId = Objects.requireNonNull(id, "ID cannot be null");
        return userRepository.findById(safeId);
    }

    /**
     * Logic: Updated to use secure password matching instead of .equals()
     */
    public Optional<User> authenticate(String email, String rawPassword) {
        return userRepository.findByEmail(email)
                .filter(user -> passwordEncoder.matches(rawPassword, user.getPassword()));
    }

    @Transactional
    public User updateUserProfile(Long id, User details, Customer customerDetails, Chef chefDetails, HomeProvider homeDetails) {
        final Long safeId = Objects.requireNonNull(id, "Update ID cannot be null");
        final User safeDetails = Objects.requireNonNull(details, "Update details cannot be null");

        return userRepository.findById(safeId).map(user -> {
            // 1. Update Core Identity (Users Table)
            if (safeDetails.getName() != null) user.setName(safeDetails.getName());
            if (safeDetails.getPhone() != null) user.setPhone(safeDetails.getPhone());
            if (safeDetails.getBio() != null) user.setBio(safeDetails.getBio());
            if (safeDetails.getLocation() != null) user.setLocation(safeDetails.getLocation());
            user.setOnline(safeDetails.isOnline());

            // 2. Role-Specific Profile Updates
            if (user.getRole() == User.Role.CHEF && chefDetails != null) {
                chefRepository.findById(safeId).ifPresent(c -> {
                    final Chef chef = Objects.requireNonNull(c);
                    if (chefDetails.getCollegeName() != null) chef.setCollegeName(chefDetails.getCollegeName());
                    if (chefDetails.getSpecialization() != null) chef.setSpecialization(chefDetails.getSpecialization());
                    chefRepository.saveAndFlush(chef);
                });
            } else if (user.getRole() == User.Role.HOME_FOOD && homeDetails != null) {
                homeProviderRepository.findById(safeId).ifPresent(h -> {
                    final HomeProvider hp = Objects.requireNonNull(h);
                    if (homeDetails.getSignatureDish() != null) hp.setSignatureDish(homeDetails.getSignatureDish());
                    if (homeDetails.getExperienceYears() != null) hp.setExperienceYears(homeDetails.getExperienceYears());
                    homeProviderRepository.saveAndFlush(hp);
                });
            } else if (user.getRole() == User.Role.CUSTOMER && customerDetails != null) {
                customerRepository.findById(safeId).ifPresent(c -> {
                    final Customer cust = Objects.requireNonNull(c);
                    if (customerDetails.getDob() != null) cust.setDob(customerDetails.getDob());
                    if (customerDetails.getGender() != null) cust.setGender(customerDetails.getGender());
                    customerRepository.saveAndFlush(cust);
                });
            }

            return userRepository.saveAndFlush(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional
    public User registerUser(User user) {
        // Logic: Hash the password before saving for the first time
        if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        // 1. Save and flush to ensure the ID is generated
        User savedUser = userRepository.saveAndFlush(Objects.requireNonNull(user, "User data cannot be null"));

        // 2. Logic: Pass the managed 'savedUser' to sub-profile constructors
        if (savedUser.getRole() == User.Role.CHEF) {
            Chef newChef = new Chef();
            newChef.setUser(savedUser);
            chefRepository.save(newChef);
        } else if (savedUser.getRole() == User.Role.HOME_FOOD) {
            HomeProvider newHp = new HomeProvider();
            newHp.setUser(savedUser);
            homeProviderRepository.save(newHp);
        } else if (savedUser.getRole() == User.Role.CUSTOMER) {
            Customer newCust = new Customer();
            newCust.setUser(savedUser);
            customerRepository.save(newCust);
        }

        return savedUser;
    }

    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}