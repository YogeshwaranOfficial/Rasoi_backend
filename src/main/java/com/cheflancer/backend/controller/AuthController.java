// package com.cheflancer.backend.controller;

// import com.cheflancer.backend.dto.RegisterRequest;
// import com.cheflancer.backend.entity.User;
// import com.cheflancer.backend.service.UserService;
// import com.cheflancer.backend.service.EmailService;
// import com.cheflancer.backend.repository.UserRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.transaction.annotation.Transactional;

// import java.util.Map; // FIXED: Missing import
// import java.util.Optional;
// import java.util.Random;

// // --- DTOs for Request Payloads ---
// class VerifyRequest {
//     public String email;
//     public String otp;
// }

// class LoginRequest {
//     public String email;
//     public String password;
// }

// @RestController
// @RequestMapping("/api/auth")
// @CrossOrigin(origins = "http://localhost:5173") // Vite Port
// public class AuthController {

//     @Autowired private UserRepository userRepo;
//     @Autowired private UserService userService;
//     @Autowired private EmailService emailService;

//     /**
//      * 1. REGISTRATION LOGIC
//      */
//     @PostMapping("/register")
//     @Transactional 
//     public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
//         if (req == null || req.getEmail() == null) {
//             return new ResponseEntity<>("Invalid request data", HttpStatus.BAD_REQUEST);
//         }

//         String email = req.getEmail().trim().toLowerCase();

//         Optional<User> existingUser = userRepo.findByEmail(email);
//         if (existingUser.isPresent()) {
//             User oldUser = existingUser.get();
//             if (oldUser.isEmailVerified()) {
//                 return new ResponseEntity<>("Error: Email already verified.", HttpStatus.CONFLICT);
//             } else {
//                 // Delete unverified attempt to allow fresh registration
//                 userRepo.delete(oldUser);
//                 userRepo.flush(); 
//             }
//         }

//         User user = new User();
//         user.setName(req.getName());
//         user.setEmail(email);
//         user.setPassword(req.getPassword()); // Note: UserService should handle BCrypt encoding
//         user.setPhone(req.getPhone());
//         user.setLocation(req.getLocation()); 
//         user.setLatitude(req.getLatitude());  
//         user.setLongitude(req.getLongitude()); 
//         user.setEmailVerified(false);
      
//         try {
//             if (req.getRole() != null) {
//                 user.setRole(User.Role.valueOf(req.getRole().toUpperCase()));
//             }
//         } catch (IllegalArgumentException e) {
//             return new ResponseEntity<>("Invalid Role selection.", HttpStatus.BAD_REQUEST);
//         }

//         String generatedOtp = String.format("%04d", new Random().nextInt(10000));
//         user.setEmailOtp(generatedOtp);

//         try {
//             User registeredUser = userService.registerUser(user);
//             emailService.sendOtpEmail(registeredUser.getEmail(), generatedOtp);
//             return new ResponseEntity<>("OTP sent to " + registeredUser.getEmail(), HttpStatus.OK);
//         } catch (Exception e) {
//             return new ResponseEntity<>("Registration Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//         }
//     }

//     /**
//      * 2. OTP VERIFICATION
//      */
//     @PostMapping("/verify-otp")
//     public ResponseEntity<?> verify(@RequestBody VerifyRequest req) {
//         if (req == null || req.email == null || req.otp == null) {
//             return new ResponseEntity<>("Missing email or OTP", HttpStatus.BAD_REQUEST);
//         }

//         String safeEmail = req.email.trim().toLowerCase(); 
//         String safeOtp = req.otp.trim();

//         return userRepo.findByEmail(safeEmail).map(user -> {
//             if (safeOtp.equals(user.getEmailOtp())) {
//                 user.setEmailVerified(true);
//                 user.setEmailOtp(null); // Clear OTP after success
//                 userRepo.save(user);
//                 return new ResponseEntity<>("Verification successful!", HttpStatus.OK);
//             }
//             return new ResponseEntity<>("Invalid OTP code.", HttpStatus.BAD_REQUEST);
//         }).orElse(new ResponseEntity<>("User record not found.", HttpStatus.NOT_FOUND));
//     }

//     /**
//      * 3. LOGIN LOGIC
//      */
//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestBody LoginRequest req) {
//         if (req == null || req.email == null || req.password == null) {
//             return new ResponseEntity<>("Email and password are required.", HttpStatus.BAD_REQUEST);
//         }

//         String email = req.email.trim().toLowerCase();

//         return userService.authenticate(email, req.password).map(user -> {
//             if (!user.isEmailVerified()) {
//                 return new ResponseEntity<>("Please verify your email before logging in.", HttpStatus.FORBIDDEN);
//             }
//             return new ResponseEntity<>(user, HttpStatus.OK);
//         }).orElse(new ResponseEntity<>("Invalid email or password.", HttpStatus.UNAUTHORIZED));
//     }

//     /**
//      * 4. FORGOT PASSWORD (Generate OTP)
//      */
//     @PostMapping("/forgot-password")
//     public ResponseEntity<?> forgotPassword(@RequestBody Map<String, String> request) {
//         String email = request.get("email").trim().toLowerCase();
        
//         return userRepo.findByEmail(email).map(user -> {
//             String otp = String.format("%04d", new Random().nextInt(10000));
//             user.setEmailOtp(otp); // Reuse the emailOtp field for reset
//             userRepo.save(user);
            
//             try {
//                 emailService.sendOtpEmail(email, otp);
//                 return ResponseEntity.ok("OTP sent to your email!");
//             } catch (Exception e) {
//                 return new ResponseEntity<>("Failed to send email.", HttpStatus.INTERNAL_SERVER_ERROR);
//             }
//         }).orElse(new ResponseEntity<>("User not found with this email.", HttpStatus.NOT_FOUND));
//     }

//     /**
//      * 5. RESET PASSWORD (Verify & Update)
//      */
//     @PostMapping("/reset-password")
//     public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> request) {
//         String email = request.get("email").trim().toLowerCase();
//         String otp = request.get("otp").trim();
//         String newPassword = request.get("newPassword");

//         return userRepo.findByEmail(email).map(user -> {
//             if (otp.equals(user.getEmailOtp())) {
//                 // Logic: Encode the new password before saving
//                 user.setPassword(userService.encodePassword(newPassword)); 
//                 user.setEmailOtp(null); // Clear reset OTP
//                 userRepo.save(user);
//                 return ResponseEntity.ok("Password updated successfully!");
//             }
//             return new ResponseEntity<>("Invalid OTP.", HttpStatus.BAD_REQUEST);
//         }).orElse(new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND));
//     }
// }









package com.cheflancer.backend.controller;

import com.cheflancer.backend.dto.RegisterRequest;
import com.cheflancer.backend.entity.User;
import com.cheflancer.backend.service.UserService;
import com.cheflancer.backend.service.EmailService;
import com.cheflancer.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;
import java.util.Random;

class VerifyRequest {
    public String email;
    public String otp;
}

class LoginRequest {
    public String email;
    public String password;
}

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired private UserRepository userRepo;
    @Autowired private UserService userService;
    @Autowired private EmailService emailService;

    @PostMapping("/register")
    @Transactional 
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        if (req == null || req.getEmail() == null) {
            return new ResponseEntity<>("Invalid request data", HttpStatus.BAD_REQUEST);
        }

        String email = req.getEmail().trim().toLowerCase();
        Optional<User> existingUser = userRepo.findByEmail(email);
        
        if (existingUser.isPresent()) {
            User oldUser = existingUser.get();
            if (oldUser.isEmailVerified()) {
                return new ResponseEntity<>("Error: Email already verified.", HttpStatus.CONFLICT);
            } else {
                userRepo.delete(oldUser);
                userRepo.flush(); 
            }
        }

        User user = new User();
        user.setName(req.getName());
        user.setEmail(email);
        user.setPassword(req.getPassword()); 
        user.setPhone(req.getPhone());
        user.setLocation(req.getLocation()); 
        user.setLatitude(req.getLatitude());  
        user.setLongitude(req.getLongitude()); 
        user.setEmailVerified(false);
      
        try {
            if (req.getRole() != null) {
                user.setRole(User.Role.valueOf(req.getRole().toUpperCase()));
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Invalid Role selection.", HttpStatus.BAD_REQUEST);
        }

        String generatedOtp = String.format("%04d", new Random().nextInt(10000));
        user.setEmailOtp(generatedOtp);

        try {
            User registeredUser = userService.registerUser(user);
            // Action "REG" for Registration
            emailService.sendOtpEmail(registeredUser.getEmail(), generatedOtp, "REG");
            return new ResponseEntity<>("OTP sent to " + registeredUser.getEmail(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Registration Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verify(@RequestBody VerifyRequest req) {
        if (req == null || req.email == null || req.otp == null) {
            return new ResponseEntity<>("Missing email or OTP", HttpStatus.BAD_REQUEST);
        }
        return userRepo.findByEmail(req.email.trim().toLowerCase()).map(user -> {
            if (req.otp.trim().equals(user.getEmailOtp())) {
                user.setEmailVerified(true);
                user.setEmailOtp(null);
                userRepo.save(user);
                return new ResponseEntity<>("Verification successful!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Invalid OTP code.", HttpStatus.BAD_REQUEST);
        }).orElse(new ResponseEntity<>("User record not found.", HttpStatus.NOT_FOUND));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        if (req == null || req.email == null || req.password == null) {
            return new ResponseEntity<>("Email and password are required.", HttpStatus.BAD_REQUEST);
        }
        return userService.authenticate(req.email.trim().toLowerCase(), req.password).map(user -> {
            if (!user.isEmailVerified()) {
                return new ResponseEntity<>("Please verify your email before logging in.", HttpStatus.FORBIDDEN);
            }
            return new ResponseEntity<>(user, HttpStatus.OK);
        }).orElse(new ResponseEntity<>("Invalid email or password.", HttpStatus.UNAUTHORIZED));
    }

   @PostMapping("/forgot-password")
public ResponseEntity<?> forgotPassword(@RequestBody Map<String, String> request) {
    String email = request.get("email").trim().toLowerCase();
    
    return userRepo.findByEmail(email).map(user -> {
        String otp = String.format("%04d", new Random().nextInt(10000));
        user.setEmailOtp(otp);
        userRepo.save(user);
        
        try {
            // CRITICAL: Ensure "RESET" is the 3rd argument here!
            emailService.sendOtpEmail(email, otp, "RESET"); 
            return ResponseEntity.ok("OTP sent to your email!");
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to send email.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }).orElse(new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND));
}
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> request) {
        String email = request.get("email").trim().toLowerCase();
        String otp = request.get("otp").trim();
        String newPassword = request.get("newPassword");

        return userRepo.findByEmail(email).map(user -> {
            if (otp.equals(user.getEmailOtp())) {
                user.setPassword(userService.encodePassword(newPassword)); 
                user.setEmailOtp(null);
                userRepo.save(user);
                return ResponseEntity.ok("Password updated successfully!");
            }
            return new ResponseEntity<>("Invalid OTP.", HttpStatus.BAD_REQUEST);
        }).orElse(new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND));
    }
}