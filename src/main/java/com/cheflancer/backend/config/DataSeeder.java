// package com.cheflancer.backend.config;

// import com.cheflancer.backend.entity.*;
// import com.cheflancer.backend.repository.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Component;
// import org.springframework.transaction.annotation.Transactional;
// import java.util.Random;

// @Component
// public class DataSeeder implements CommandLineRunner {

//     @Autowired private UserRepository userRepo;
//     @Autowired private ChefRepository chefRepo;
//     @Autowired private FoodRepository foodRepo;
//     @Autowired private HomeProviderRepository homeProviderRepo;
//     @Autowired private PasswordEncoder passwordEncoder;

//     private final String CLOUD_NAME = "dnejefctn";
//     private final String CLOUDINARY_BASE = "https://res.cloudinary.com/" + CLOUD_NAME + "/image/upload/";

//     @Override
//     @Transactional
//     public void run(String... args) {
//         if (userRepo.count() > 0) return;

//         createDemoCustomer();
//         seedChefBatches();
//         seedHomeCookBatches();

//         System.out.println(">>> DATA SEEDED SUCCESSFULLY WITH AI BIOMETRIC TAGS");
//     }

//     private void createDemoCustomer() {
//         User u = new User();
//         u.setName("Showcase User");
//         u.setEmail("user@rasoi.com");
//         u.setPassword(passwordEncoder.encode("password123"));
//         u.setRole(User.Role.CUSTOMER);
//         u.setEmailVerified(true);
//         u.setLatitude(9.9252);
//         u.setLongitude(78.1197);
//         u.setPhone("9988776655");
//         userRepo.save(u);
//     }

//     private void seedChefBatches() {
//         // Categories remain same as your original logic
//         String[][] south = {
//             {"Chef Vignesh","vignesh@rasoi.com","Bun_Parotta"}, {"Chef Jeyaram","jeyaram@rasoi.com","Kari_Dosa"},
//             {"Chef Nirmal","nirmal@rasoi.com","Chettinad_Chicken"}, {"Chef Seshathri","seshu@rasoi.com","Madurai_Idly"},
//             {"Chef Ananth","ananth@rasoi.com","Pongal_Vadai"}, {"Chef Aakash","aakash@rasoi.com","Appam_Stew"},
//             {"Chef Santhosh","santhosh@rasoi.com","Mutton_Biryani"}, {"Chef Damu","damu@rasoi.com","Fish_Fry"},
//             {"Chef Bhat","bhat@rasoi.com","Rava_Dosa"}, {"Chef Ranga","ranga@rasoi.com","Curd_Rice"}
//         };
//         seedBatch(south, "SOUTH_INDIAN", Food.CookType.CHEF);

//         String[][] north = {
//             {"Chef Preeti","preeti@rasoi.com","Chole_Bhature"}, {"Chef Singh","singh@rasoi.com","Paneer_Kulcha"},
//             {"Chef Khanna","khanna@rasoi.com","Dal_Makhani"}, {"Chef Kapoor","kapoor@rasoi.com","Butter_Chicken"},
//             {"Chef Malhotra","mal@rasoi.com","Kadai_Paneer"}, {"Chef Verma","verma@rasoi.com","Galouti_Kebab"},
//             {"Chef Gupta","gupta@rasoi.com","Gatte_Ki_Sabzi"}, {"Chef Mehra","mehra@rasoi.com","Himachali_Dham"},
//             {"Chef Kohli","kohli@rasoi.com","Aloo_Gutke"}, {"Chef Oberoi","oberoi@rasoi.com","Lassi_Platter"}
//         };
//         seedBatch(north, "NORTH_INDIAN", Food.CookType.CHEF);

//         String[][] vegGems = {
//             {"Chef Goel","goel@rasoi.com","Gujarati_Thali"}, {"Chef Rahul","rahul@rasoi.com","Misal_Pav"},
//             {"Chef Shah","shah@rasoi.com","Undhiyu"}, {"Chef Patel","patel@rasoi.com","Dhokla_Platter"},
//             {"Chef Joshi","joshi@rasoi.com","Puran_Poli"}, {"Chef Kulkarni","kul@rasoi.com","Vada_Pav"},
//             {"Chef Deshpande","desh@rasoi.com","Zunka_Bhakar"}, {"Chef Trivedi","tri@rasoi.com","Ker_Sangri"},
//             {"Chef Agrawal","agra@rasoi.com","Poha_Jalebi"}, {"Chef Sharma","sharma.v@rasoi.com","Bhopali_Paan"}
//         };
//         seedBatch(vegGems, "VEG", Food.CookType.CHEF);

//         String[][] chinese = {
//             {"Chef Lin","lin@rasoi.com","Veg_Momos"}, {"Chef Chang","chang@rasoi.com","Hakka_Noodles"},
//             {"Chef Zhou","zhou@rasoi.com","Manchow_Soup"}, {"Chef Wong","wong@rasoi.com","Dragon_Chicken"},
//             {"Chef Lee","lee@rasoi.com","Spring_Rolls"}, {"Chef Kim","kim@rasoi.com","Fried_Rice"},
//             {"Chef Tan","tan@rasoi.com","Chilli_Paneer"}, {"Chef Ho","ho@rasoi.com","Dim_Sums"},
//             {"Chef Wu","wu@rasoi.com","Noodle_Soup"}, {"Chef Cho","cho@rasoi.com","Schezwan_Chicken"}
//         };
//         seedBatch(chinese, "CHINESE", Food.CookType.CHEF);

//         String[][] chefDesserts = {
//             {"Chef Tiwari","tiwari@rasoi.com","Gulab_Jamun"}, {"Chef Iyer","iyer@rasoi.com","Mysore_Pak"},
//             {"Chef Halder","halder@rasoi.com","Mishti_Doi"}, {"Chef Agarwal","agar@rasoi.com","Mathura_Peda"},
//             {"Chef Joshi.D","joshi.d@rasoi.com","Mango_Shrikhand"}, {"Chef Sharma.D","sharma.d@rasoi.com","Bikaneri_Ghevar"},
//             {"Chef Reddy.D","reddy.d@rasoi.com","Double_Ka_Meetha"}, {"Chef Das.D","das.d@rasoi.com","Chhena_Poda"},
//             {"Chef Murthy","murthy@rasoi.com","Dharwad_Pedha"}, {"Chef Bengali","bengali@rasoi.com","Sandesh_Platter"}
//         };
//         seedBatch(chefDesserts, "DESSERTS", Food.CookType.CHEF);
//     }

//     private void seedHomeCookBatches() {
//         String[][] hVeg = {
//             {"Saraswathi Amma","saras@gmail.com","Sambhar_Idli"}, {"Lakshmi Mami","lakshmi@gmail.com","Puliyodharai"},
//             {"Grace Mary","grace@gmail.com","Lemon_Rice"}, {"Mrs. Kapoor","kapoor.h@gmail.com","Rajma_Chawal"},
//             {"Revathi Kitchen","revathi@gmail.com","Aloo_Paratha"}, {"Kavitha Foods","kavitha@gmail.com","Tiffin_Combo"}
//         };
//         seedBatch(hVeg, "VEG", Food.CookType.HOME_FOOD);

//         String[][] hNonVeg = {
//             {"Meena Aunty","meena@gmail.com","Home_Fish_Curry"}, {"Fatima Bi","fatima@gmail.com","Home_Mutton_Biryani"}
//         };
//         seedBatch(hNonVeg, "NON_VEG", Food.CookType.HOME_FOOD);

//         String[][] hDesserts = {
//             {"Deepa Home","deepa@gmail.com","Medu_Vada"}, {"Mani Grandmom","mani@gmail.com","Tirunelveli_Halwa"}
//         };
//         seedBatch(hDesserts, "DESSERTS", Food.CookType.HOME_FOOD);
//     }

//     private void seedBatch(String[][] batch, String category, Food.CookType cookType) {
//         Random r = new Random();
//         for (String[] d : batch) {
//             User u = new User();
//             u.setName(d[0]); u.setEmail(d[1]);
//             u.setPassword(passwordEncoder.encode("password123"));
//             u.setRole(cookType == Food.CookType.CHEF ? User.Role.CHEF : User.Role.HOME_FOOD);
//             u.setEmailVerified(true);
//             u.setLatitude(9.92 + (r.nextDouble()*0.08));
//             u.setLongitude(78.11 + (r.nextDouble()*0.08));
//             u.setPhone("91"+(1000000000L+r.nextInt(900000000)));
//             u.setProfilePicUrl("https://ui-avatars.com/api/?name="+d[0].replace(" ","+"));
//             User savedUser = userRepo.saveAndFlush(u);

//             if(cookType==Food.CookType.CHEF){
//                 Chef chef = new Chef(); chef.setUser(savedUser);
//                 chef.setKitchenName(d[0].toUpperCase()+" KITCHEN");
//                 chefRepo.save(chef);
//             } else {
//                 HomeProvider hp = new HomeProvider(); hp.setUser(savedUser);
//                 hp.setKitchenName(d[0]);
//                 homeProviderRepo.save(hp);
//             }

//             Food f = new Food();
//             f.setProviderId(savedUser.getId());
//             f.setProviderName(cookType==Food.CookType.CHEF ? d[0].toUpperCase()+" KITCHEN" : d[0]);
//             String originalName = d[2].replace("_"," ");
//             f.setName(originalName);
//             f.setCategory(Food.Category.valueOf(category));
//             f.setCookType(cookType);
//             f.setPrice(120.0 + r.nextInt(250));
//             f.setAvailable(true);
//             f.setAvgRating(4.2 + r.nextDouble()*0.6);
//             f.setLatitude(savedUser.getLatitude());
//             f.setLongitude(savedUser.getLongitude());
//             f.setImage(CLOUDINARY_BASE + d[2] + ".jpg");

//             // --- AI BIOMETRIC ASSIGNMENT LOGIC ---
//             // We assign these based on keywords to match your accuracy requirements
//             assignBiometrics(f, originalName, category);

//             foodRepo.save(f);
//         }
//     }

//     private void assignBiometrics(Food f, String name, String category) {
//         // Default Settings
//         f.setTargetAgeGroup("ADULT");
//         f.setTargetGender("ALL");
//         f.setMoodBooster("NEUTRAL");
//         f.setSpiceLevel(3);

//         // Kids & Teens Logic (Desserts, Chinese, Snacks)
//         if (category.equals("DESSERTS") || category.equals("CHINESE") || name.contains("Pav") || name.contains("Poha")) {
//             f.setTargetAgeGroup("KIDS");
//             f.setMoodBooster("HAPPY");
//             f.setSpiceLevel(1);
//         }

//         // Adult Males (Spicy, Non-Veg, Heavy North/South)
//         if (name.contains("Biryani") || name.contains("Chicken") || name.contains("Mutton") || name.contains("Fry")) {
//             f.setTargetGender("MALE");
//             f.setSpiceLevel(5);
//             f.setMoodBooster("STRESSED");
//         }

//         // Elderly (Soft textures, easy to digest)
//         if (name.contains("Idly") || name.contains("Curd Rice") || name.contains("Stew") || name.contains("Pongal") || name.contains("Dal")) {
//             f.setTargetAgeGroup("ELDERLY");
//             f.setSpiceLevel(1);
//             f.setMoodBooster("NEUTRAL");
//         }
        
//         // Emotion Override (Comfort foods for sad/stressed)
//         if (name.contains("Lassi") || name.contains("Doi") || name.contains("Halwa")) {
//             f.setMoodBooster("STRESSED");
//         }
//     }
// }






package com.cheflancer.backend.config;

import com.cheflancer.backend.entity.*;
import com.cheflancer.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Random;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired private UserRepository userRepo;
    @Autowired private ChefRepository chefRepo;
    @Autowired private FoodRepository foodRepo;
    @Autowired private HomeProviderRepository homeProviderRepo;
    @Autowired private PasswordEncoder passwordEncoder;

    private final String CLOUD_NAME = "dnejefctn";
    private final String CLOUDINARY_BASE = "https://res.cloudinary.com/" + CLOUD_NAME + "/image/upload/";

    @Override
    @Transactional
    public void run(String... args) {
        if (userRepo.count() > 0) return;

        createDemoCustomer();
        seedChefBatches();
        seedHomeCookBatches();

        System.out.println(">>> DATA SEEDED SUCCESSFULLY WITH PRECISION BIOMETRIC BUCKETS");
    }

    private void createDemoCustomer() {
        User u = new User();
        u.setName("Showcase User");
        u.setEmail("user@rasoi.com");
        u.setPassword(passwordEncoder.encode("password123"));
        u.setRole(User.Role.CUSTOMER);
        u.setEmailVerified(true);
        u.setLatitude(9.9252);
        u.setLongitude(78.1197);
        u.setPhone("9988776655");
        userRepo.save(u);
    }

    private void seedChefBatches() {
        String[][] south = {
            {"Chef Vignesh","vignesh@rasoi.com","Bun_Parotta"}, {"Chef Jeyaram","jeyaram@rasoi.com","Kari_Dosa"},
            {"Chef Nirmal","nirmal@rasoi.com","Chettinad_Chicken"}, {"Chef Seshathri","seshu@rasoi.com","Madurai_Idly"},
            {"Chef Ananth","ananth@rasoi.com","Pongal_Vadai"}, {"Chef Aakash","aakash@rasoi.com","Appam_Stew"},
            {"Chef Santhosh","santhosh@rasoi.com","Mutton_Biryani"}, {"Chef Damu","damu@rasoi.com","Fish_Fry"},
            {"Chef Bhat","bhat@rasoi.com","Rava_Dosa"}, {"Chef Ranga","ranga@rasoi.com","Curd_Rice"}
        };
        seedBatch(south, "SOUTH_INDIAN", Food.CookType.CHEF);

        String[][] north = {
            {"Chef Preeti","preeti@rasoi.com","Chole_Bhature"}, {"Chef Singh","singh@rasoi.com","Paneer_Kulcha"},
            {"Chef Khanna","khanna@rasoi.com","Dal_Makhani"}, {"Chef Kapoor","kapoor@rasoi.com","Butter_Chicken"},
            {"Chef Malhotra","mal@rasoi.com","Kadai_Paneer"}, {"Chef Verma","verma@rasoi.com","Galouti_Kebab"},
            {"Chef Gupta","gupta@rasoi.com","Gatte_Ki_Sabzi"}, {"Chef Mehra","mehra@rasoi.com","Himachali_Dham"},
            {"Chef Kohli","kohli@rasoi.com","Aloo_Gutke"}, {"Chef Oberoi","oberoi@rasoi.com","Lassi_Platter"}
        };
        seedBatch(north, "NORTH_INDIAN", Food.CookType.CHEF);

        String[][] vegGems = {
            {"Chef Goel","goel@rasoi.com","Gujarati_Thali"}, {"Chef Rahul","rahul@rasoi.com","Misal_Pav"},
            {"Chef Shah","shah@rasoi.com","Undhiyu"}, {"Chef Patel","patel@rasoi.com","Dhokla_Platter"},
            {"Chef Joshi","joshi@rasoi.com","Puran_Poli"}, {"Chef Kulkarni","kul@rasoi.com","Vada_Pav"},
            {"Chef Deshpande","desh@rasoi.com","Zunka_Bhakar"}, {"Chef Trivedi","tri@rasoi.com","Ker_Sangri"},
            {"Chef Agrawal","agra@rasoi.com","Poha_Jalebi"}, {"Chef Sharma","sharma.v@rasoi.com","Bhopali_Paan"}
        };
        seedBatch(vegGems, "VEG", Food.CookType.CHEF);

        String[][] chinese = {
            {"Chef Lin","lin@rasoi.com","Veg_Momos"}, {"Chef Chang","chang@rasoi.com","Hakka_Noodles"},
            {"Chef Zhou","zhou@rasoi.com","Manchow_Soup"}, {"Chef Wong","wong@rasoi.com","Dragon_Chicken"},
            {"Chef Lee","lee@rasoi.com","Spring_Rolls"}, {"Chef Kim","kim@rasoi.com","Fried_Rice"},
            {"Chef Tan","tan@rasoi.com","Chilli_Paneer"}, {"Chef Ho","ho@rasoi.com","Dim_Sums"},
            {"Chef Wu","wu@rasoi.com","Noodle_Soup"}, {"Chef Cho","cho@rasoi.com","Schezwan_Chicken"}
        };
        seedBatch(chinese, "CHINESE", Food.CookType.CHEF);

        String[][] chefDesserts = {
            {"Chef Tiwari","tiwari@rasoi.com","Gulab_Jamun"}, {"Chef Iyer","iyer@rasoi.com","Mysore_Pak"},
            {"Chef Halder","halder@rasoi.com","Mishti_ Doi"}, {"Chef Agarwal","agar@rasoi.com","Mathura_Peda"},
            {"Chef Joshi.D","joshi.d@rasoi.com","Mango_Shrikhand"}, {"Chef Sharma.D","sharma.d@rasoi.com","Bikaneri_Ghevar"},
            {"Chef Reddy.D","reddy.d@rasoi.com","Double_Ka_Meetha"}, {"Chef Das.D","das.d@rasoi.com","Chhena_Poda"},
            {"Chef Murthy","murthy@rasoi.com","Dharwad_Pedha"}, {"Chef Bengali","bengali@rasoi.com","Sandesh_Platter"}
        };
        seedBatch(chefDesserts, "DESSERTS", Food.CookType.CHEF);
    }

    private void seedHomeCookBatches() {
        String[][] hVeg = {
            {"Saraswathi Amma","saras@gmail.com","Sambhar_Idli"}, {"Lakshmi Mami","lakshmi@gmail.com","Puliyodharai"},
            {"Grace Mary","grace@gmail.com","Lemon_Rice"}, {"Mrs. Kapoor","kapoor.h@gmail.com","Rajma_Chawal"},
            {"Revathi Kitchen","revathi@gmail.com","Aloo_Paratha"}, {"Kavitha Foods","kavitha@gmail.com","Tiffin_Combo"}
        };
        seedBatch(hVeg, "VEG", Food.CookType.HOME_FOOD);

        String[][] hNonVeg = {
            {"Meena Aunty","meena@gmail.com","Home_Fish_Curry"}, {"Fatima Bi","fatima@gmail.com","Home_Mutton_Biryani"}
        };
        seedBatch(hNonVeg, "NON_VEG", Food.CookType.HOME_FOOD);

        String[][] hDesserts = {
            {"Deepa Home","deepa@gmail.com","Medu_Vada"}, {"Mani Grandmom","mani@gmail.com","Tirunelveli_Halwa"}
        };
        seedBatch(hDesserts, "DESSERTS", Food.CookType.HOME_FOOD);
    }

    private void seedBatch(String[][] batch, String category, Food.CookType cookType) {
        Random r = new Random();
        for (String[] d : batch) {
            User u = new User();
            u.setName(d[0]); u.setEmail(d[1]);
            u.setPassword(passwordEncoder.encode("password123"));
            u.setRole(cookType == Food.CookType.CHEF ? User.Role.CHEF : User.Role.HOME_FOOD);
            u.setEmailVerified(true);
            u.setLatitude(9.92 + (r.nextDouble()*0.08));
            u.setLongitude(78.11 + (r.nextDouble()*0.08));
            u.setPhone("91"+(1000000000L+r.nextInt(900000000)));
            u.setProfilePicUrl("https://ui-avatars.com/api/?name="+d[0].replace(" ","+"));
            User savedUser = userRepo.saveAndFlush(u);

            if(cookType==Food.CookType.CHEF){
                Chef chef = new Chef(); chef.setUser(savedUser);
                chef.setKitchenName(d[0].toUpperCase()+" KITCHEN");
                chefRepo.save(chef);
            } else {
                HomeProvider hp = new HomeProvider(); hp.setUser(savedUser);
                hp.setKitchenName(d[0]);
                homeProviderRepo.save(hp);
            }

            Food f = new Food();
            f.setProviderId(savedUser.getId());
            f.setProviderName(cookType==Food.CookType.CHEF ? d[0].toUpperCase()+" KITCHEN" : d[0]);
            String originalName = d[2].replace("_"," ");
            f.setName(originalName);
            f.setCategory(Food.Category.valueOf(category));
            f.setCookType(cookType);
            f.setPrice(120.0 + r.nextInt(250));
            f.setAvailable(true);
            f.setAvgRating(4.2 + r.nextDouble()*0.6);
            f.setLatitude(savedUser.getLatitude());
            f.setLongitude(savedUser.getLongitude());
            f.setImage(CLOUDINARY_BASE + d[2] + ".jpg");

            // --- REFINED AI BIOMETRIC BUCKETS ---
            assignBiometrics(f, originalName, category);

            foodRepo.save(f);
        }
    }

    private void assignBiometrics(Food f, String name, String category) {
        // Default Settings (ADULT_MID 31-40)
        f.setTargetAgeGroup("ADULT_MID");
        f.setTargetGender("ALL");
        f.setMoodBooster("NEUTRAL");
        f.setSpiceLevel(3);

        // 1. KIDS (1-10) - Focus: Soft Sweets & Non-Spicy
        if (category.equals("DESSERTS") || name.contains("Halwa") || name.contains("Mishti") || name.contains("Sandesh") || name.contains("Pedha")) {
            f.setTargetAgeGroup("KIDS");
            f.setMoodBooster("HAPPY");
            f.setSpiceLevel(1);
        }

        // 2. TEENS (11-20) - Focus: High Carb & Fast Food
        if (category.equals("CHINESE") || name.contains("Bhature") || name.contains("Noodles") || name.contains("Momos") || name.contains("Vada Pav")) {
            f.setTargetAgeGroup("TEENS");
            f.setMoodBooster("STRESSED");
            f.setSpiceLevel(4);
        }

        // 3. ADULT_YOUNG (21-30) - Focus: HEAVY / OILY / SPICY (The Bun Parotta Fix)
        if (name.contains("Bun Parotta") || name.contains("Kari Dosa") || name.contains("Biryani") || name.contains("Fry") || name.contains("Schezwan") || name.contains("Dragon")) {
            f.setTargetAgeGroup("ADULT_YOUNG");
            f.setTargetGender("MALE");
            f.setSpiceLevel(5);
            f.setMoodBooster("STRESSED");
        }

        // 4. ADULT_MATURE (41-50) - Focus: Metabolism & Regional Specialties
        if (name.contains("Lemon Rice") || name.contains("Puliyodharai") || name.contains("Gutke") || name.contains("Sangri") || name.contains("Zunka")) {
            f.setTargetAgeGroup("ADULT_MATURE");
            f.setSpiceLevel(3);
        }

        // 5. ELDERLY (50+) - Focus: High Digestion & Low Oil
        if (name.contains("Idly") || name.contains("Curd Rice") || name.contains("Stew") || name.contains("Pongal") || name.contains("Dal Makhani") || name.contains("Rava Dosa")) {
            f.setTargetAgeGroup("ELDERLY");
            f.setTargetGender("ALL");
            f.setSpiceLevel(1);
            f.setMoodBooster("NEUTRAL");
        }
        
        // Final Mood Override
        if (name.contains("Lassi") || name.contains("Shrikhand") || name.contains("Doi")) {
            f.setMoodBooster("HAPPY");
        }
    }
}