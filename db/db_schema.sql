-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: rasoi_db
-- ------------------------------------------------------
-- Server version	8.0.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `customer_id` bigint DEFAULT NULL,
  `food_name` varchar(255) DEFAULT NULL,
  `order_time` datetime(6) DEFAULT NULL,
  `provider_id` bigint DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (1,1,'Manchow Soup','2026-03-22 19:03:41.953395',34,'PENDING',180),(2,1,'Manchow Soup','2026-03-22 19:04:06.203330',34,'PENDING',180);
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chefs`
--

DROP TABLE IF EXISTS `chefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chefs` (
  `user_id` bigint NOT NULL,
  `kitchen_name` varchar(255) DEFAULT NULL,
  `college_name` varchar(255) DEFAULT NULL,
  `degree_pdf_url` varchar(255) DEFAULT NULL,
  `specialization` varchar(255) DEFAULT NULL,
  `graduation_year` int DEFAULT NULL,
  `avg_rating` double DEFAULT '4.5',
  `total_reviews` int DEFAULT '0',
  PRIMARY KEY (`user_id`),
  CONSTRAINT `fk_chef_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chefs`
--

LOCK TABLES `chefs` WRITE;
/*!40000 ALTER TABLE `chefs` DISABLE KEYS */;
INSERT INTO `chefs` VALUES (2,'CHEF VIGNESH KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(3,'CHEF JEYARAM KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(4,'CHEF NIRMAL KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(5,'CHEF SESHATHRI KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(6,'CHEF ANANTH KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(7,'CHEF AAKASH KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(8,'CHEF SANTHOSH KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(9,'CHEF DAMU KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(10,'CHEF BHAT KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(11,'CHEF RANGA KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(12,'CHEF PREETI KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(13,'CHEF SINGH KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(14,'CHEF KHANNA KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(15,'CHEF KAPOOR KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(16,'CHEF MALHOTRA KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(17,'CHEF VERMA KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(18,'CHEF GUPTA KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(19,'CHEF MEHRA KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(20,'CHEF KOHLI KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(21,'CHEF OBEROI KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(22,'CHEF GOEL KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(23,'CHEF RAHUL KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(24,'CHEF SHAH KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(25,'CHEF PATEL KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(26,'CHEF JOSHI KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(27,'CHEF KULKARNI KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(28,'CHEF DESHPANDE KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(29,'CHEF TRIVEDI KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(30,'CHEF AGRAWAL KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(31,'CHEF SHARMA KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(32,'CHEF LIN KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(33,'CHEF CHANG KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(34,'CHEF ZHOU KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(35,'CHEF WONG KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(36,'CHEF LEE KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(37,'CHEF KIM KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(38,'CHEF TAN KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(39,'CHEF HO KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(40,'CHEF WU KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(41,'CHEF CHO KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(42,'CHEF TIWARI KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(43,'CHEF IYER KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(44,'CHEF HALDER KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(45,'CHEF AGARWAL KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(46,'CHEF JOSHI.D KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(47,'CHEF SHARMA.D KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(48,'CHEF REDDY.D KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(49,'CHEF DAS.D KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(50,'CHEF MURTHY KITCHEN',NULL,NULL,NULL,NULL,4.5,0),(51,'CHEF BENGALI KITCHEN',NULL,NULL,NULL,NULL,4.5,0);
/*!40000 ALTER TABLE `chefs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  `dob` date DEFAULT NULL,
  `gender` enum('MALE','FEMALE','OTHER') DEFAULT NULL,
  `favorite_cuisines` varchar(255) DEFAULT 'Not Specified',
  `profile_picture_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKeuat1oase6eqv195jvb71a93s` (`user_id`),
  CONSTRAINT `FKrh1g1a20omjmn6kurd35o3eit` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foods`
--

DROP TABLE IF EXISTS `foods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foods` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `available` bit(1) NOT NULL,
  `avg_rating` double DEFAULT '4.5',
  `category` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_ai_recommended` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `provider_id` bigint DEFAULT NULL,
  `total_orders` int DEFAULT '0',
  `image` text,
  `provider_name` varchar(255) DEFAULT NULL,
  `cook_type` enum('CHEF','HOME_FOOD') DEFAULT 'CHEF',
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `image_public_id` varchar(255) DEFAULT NULL,
  `ingredients` varchar(255) DEFAULT NULL,
  `target_age_group` varchar(255) DEFAULT NULL,
  `target_gender` varchar(255) DEFAULT NULL,
  `mood_booster` varchar(255) DEFAULT NULL,
  `spice_level` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_provider` (`provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foods`
--

LOCK TABLES `foods` WRITE;
/*!40000 ALTER TABLE `foods` DISABLE KEYS */;
INSERT INTO `foods` VALUES (1,_binary '',4.721958134046195,'SOUTH_INDIAN',NULL,_binary '\0','Bun Parotta',328,2,0,'https://res.cloudinary.com/dnejefctn/image/upload/Bun_Parotta.jpg','CHEF VIGNESH KITCHEN','CHEF',9.936895250751823,78.11344230302429,NULL,NULL,NULL,'ADULT_YOUNG','MALE','STRESSED',5),(2,_binary '',4.797723145176709,'SOUTH_INDIAN',NULL,_binary '\0','Kari Dosa',120,3,0,'https://res.cloudinary.com/dnejefctn/image/upload/Kari_Dosa.jpg','CHEF JEYARAM KITCHEN','CHEF',9.99504286468481,78.15010192628057,NULL,NULL,NULL,'ADULT_YOUNG','MALE','STRESSED',5),(3,_binary '',4.340612553006168,'SOUTH_INDIAN',NULL,_binary '\0','Chettinad Chicken',294,4,0,'https://res.cloudinary.com/dnejefctn/image/upload/Chettinad_Chicken.jpg','CHEF NIRMAL KITCHEN','CHEF',9.939204038728612,78.17265909751545,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(4,_binary '',4.210536308906384,'SOUTH_INDIAN',NULL,_binary '\0','Madurai Idly',306,5,0,'https://res.cloudinary.com/dnejefctn/image/upload/Madurai_Idly.jpg','CHEF SESHATHRI KITCHEN','CHEF',9.9262916721354,78.17732362631759,NULL,NULL,NULL,'ELDERLY','ALL','NEUTRAL',1),(5,_binary '',4.43189029459697,'SOUTH_INDIAN',NULL,_binary '\0','Pongal Vadai',358,6,0,'https://res.cloudinary.com/dnejefctn/image/upload/Pongal_Vadai.jpg','CHEF ANANTH KITCHEN','CHEF',9.93763779483313,78.17024959327162,NULL,NULL,NULL,'ELDERLY','ALL','NEUTRAL',1),(6,_binary '',4.752914868013205,'SOUTH_INDIAN',NULL,_binary '\0','Appam Stew',192,7,0,'https://res.cloudinary.com/dnejefctn/image/upload/Appam_Stew.jpg','CHEF AAKASH KITCHEN','CHEF',9.937778978025287,78.18568458418676,NULL,NULL,NULL,'ELDERLY','ALL','NEUTRAL',1),(7,_binary '',4.405940624007464,'SOUTH_INDIAN',NULL,_binary '\0','Mutton Biryani',150,8,0,'https://res.cloudinary.com/dnejefctn/image/upload/Mutton_Biryani.jpg','CHEF SANTHOSH KITCHEN','CHEF',9.928217432940299,78.17425875651534,NULL,NULL,NULL,'ADULT_YOUNG','MALE','STRESSED',5),(8,_binary '',4.293246522781865,'SOUTH_INDIAN',NULL,_binary '\0','Fish Fry',240,9,0,'https://res.cloudinary.com/dnejefctn/image/upload/Fish_Fry.jpg','CHEF DAMU KITCHEN','CHEF',9.969734411001872,78.16321307671767,NULL,NULL,NULL,'ADULT_YOUNG','MALE','STRESSED',5),(9,_binary '',4.234779396007691,'SOUTH_INDIAN',NULL,_binary '\0','Rava Dosa',338,10,0,'https://res.cloudinary.com/dnejefctn/image/upload/Rava_Dosa.jpg','CHEF BHAT KITCHEN','CHEF',9.945660715399955,78.14731916920081,NULL,NULL,NULL,'ELDERLY','ALL','NEUTRAL',1),(10,_binary '',4.655964205431923,'SOUTH_INDIAN',NULL,_binary '\0','Curd Rice',293,11,0,'https://res.cloudinary.com/dnejefctn/image/upload/Curd_Rice.jpg','CHEF RANGA KITCHEN','CHEF',9.999837236165208,78.18869631206682,NULL,NULL,NULL,'ELDERLY','ALL','NEUTRAL',1),(11,_binary '',4.378894621961819,'NORTH_INDIAN',NULL,_binary '\0','Chole Bhature',206,12,0,'https://res.cloudinary.com/dnejefctn/image/upload/Chole_Bhature.jpg','CHEF PREETI KITCHEN','CHEF',9.993908610483471,78.13534830331405,NULL,NULL,NULL,'TEENS','ALL','STRESSED',4),(12,_binary '',4.235450349698723,'NORTH_INDIAN',NULL,_binary '\0','Paneer Kulcha',149,13,0,'https://res.cloudinary.com/dnejefctn/image/upload/Paneer_Kulcha.jpg','CHEF SINGH KITCHEN','CHEF',9.940116640100024,78.13071722333817,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(13,_binary '',4.3110299666005165,'NORTH_INDIAN',NULL,_binary '\0','Dal Makhani',200,14,0,'https://res.cloudinary.com/dnejefctn/image/upload/Dal_Makhani.jpg','CHEF KHANNA KITCHEN','CHEF',9.935716817333272,78.12762713385804,NULL,NULL,NULL,'ELDERLY','ALL','NEUTRAL',1),(14,_binary '',4.406919244347953,'NORTH_INDIAN',NULL,_binary '\0','Butter Chicken',203,15,0,'https://res.cloudinary.com/dnejefctn/image/upload/Butter_Chicken.jpg','CHEF KAPOOR KITCHEN','CHEF',9.958401157264912,78.13467034381786,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(15,_binary '',4.624799360360504,'NORTH_INDIAN',NULL,_binary '\0','Kadai Paneer',204,16,0,'https://res.cloudinary.com/dnejefctn/image/upload/Kadai_Paneer.jpg','CHEF MALHOTRA KITCHEN','CHEF',9.970602777856213,78.18767645014904,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(16,_binary '',4.75936003966443,'NORTH_INDIAN',NULL,_binary '\0','Galouti Kebab',342,17,0,'https://res.cloudinary.com/dnejefctn/image/upload/Galouti_Kebab.jpg','CHEF VERMA KITCHEN','CHEF',9.970992923692586,78.11334239556135,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(17,_binary '',4.340613612874404,'NORTH_INDIAN',NULL,_binary '\0','Gatte Ki Sabzi',356,18,0,'https://res.cloudinary.com/dnejefctn/image/upload/Gatte_Ki_Sabzi.jpg','CHEF GUPTA KITCHEN','CHEF',9.920726513471546,78.17485497974852,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(18,_binary '',4.5716654332145765,'NORTH_INDIAN',NULL,_binary '\0','Himachali Dham',166,19,0,'https://res.cloudinary.com/dnejefctn/image/upload/Himachali_Dham.jpg','CHEF MEHRA KITCHEN','CHEF',9.990228009157523,78.14544329336094,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(19,_binary '',4.735546230567178,'NORTH_INDIAN',NULL,_binary '\0','Aloo Gutke',138,20,0,'https://res.cloudinary.com/dnejefctn/image/upload/Aloo_Gutke.jpg','CHEF KOHLI KITCHEN','CHEF',9.968618327328212,78.16612161077764,NULL,NULL,NULL,'ADULT_MATURE','ALL','NEUTRAL',3),(20,_binary '',4.57931458166021,'NORTH_INDIAN',NULL,_binary '\0','Lassi Platter',310,21,0,'https://res.cloudinary.com/dnejefctn/image/upload/Lassi_Platter.jpg','CHEF OBEROI KITCHEN','CHEF',9.986453000974464,78.13786963624736,NULL,NULL,NULL,'ADULT_MID','ALL','HAPPY',3),(21,_binary '',4.665114394561182,'VEG',NULL,_binary '\0','Gujarati Thali',245,22,0,'https://res.cloudinary.com/dnejefctn/image/upload/Gujarati_Thali.jpg','CHEF GOEL KITCHEN','CHEF',9.944623926288754,78.13358180584115,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(22,_binary '',4.222839368359539,'VEG',NULL,_binary '\0','Misal Pav',332,23,0,'https://res.cloudinary.com/dnejefctn/image/upload/Misal_Pav.jpg','CHEF RAHUL KITCHEN','CHEF',9.982499354021689,78.11576934250974,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(23,_binary '',4.743187424906715,'VEG',NULL,_binary '\0','Undhiyu',205,24,0,'https://res.cloudinary.com/dnejefctn/image/upload/Undhiyu.jpg','CHEF SHAH KITCHEN','CHEF',9.955794759658882,78.18420891441468,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(24,_binary '',4.2725585218462285,'VEG',NULL,_binary '\0','Dhokla Platter',126,25,0,'https://res.cloudinary.com/dnejefctn/image/upload/Dhokla_Platter.jpg','CHEF PATEL KITCHEN','CHEF',9.98177751741806,78.15502009890696,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(25,_binary '',4.72804950282156,'VEG',NULL,_binary '\0','Puran Poli',184,26,0,'https://res.cloudinary.com/dnejefctn/image/upload/Puran_Poli.jpg','CHEF JOSHI KITCHEN','CHEF',9.995853703803908,78.13886603370504,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(26,_binary '',4.480671236874839,'VEG',NULL,_binary '\0','Vada Pav',306,27,0,'https://res.cloudinary.com/dnejefctn/image/upload/Vada_Pav.jpg','CHEF KULKARNI KITCHEN','CHEF',9.963616947243752,78.1475775081412,NULL,NULL,NULL,'TEENS','ALL','STRESSED',4),(27,_binary '',4.325910940335647,'VEG',NULL,_binary '\0','Zunka Bhakar',273,28,0,'https://res.cloudinary.com/dnejefctn/image/upload/Zunka_Bhakar.jpg','CHEF DESHPANDE KITCHEN','CHEF',9.927915410906985,78.13770204031027,NULL,NULL,NULL,'ADULT_MATURE','ALL','NEUTRAL',3),(28,_binary '',4.619885345497191,'VEG',NULL,_binary '\0','Ker Sangri',296,29,0,'https://res.cloudinary.com/dnejefctn/image/upload/Ker_Sangri.jpg','CHEF TRIVEDI KITCHEN','CHEF',9.948004204035652,78.14505350173334,NULL,NULL,NULL,'ADULT_MATURE','ALL','NEUTRAL',3),(29,_binary '',4.66245080671086,'VEG',NULL,_binary '\0','Poha Jalebi',298,30,0,'https://res.cloudinary.com/dnejefctn/image/upload/Poha_Jalebi.jpg','CHEF AGRAWAL KITCHEN','CHEF',9.987494250767917,78.18475585530534,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(30,_binary '',4.630096025241278,'VEG',NULL,_binary '\0','Bhopali Paan',295,31,0,'https://res.cloudinary.com/dnejefctn/image/upload/Bhopali_Paan.jpg','CHEF SHARMA KITCHEN','CHEF',9.947837466441772,78.12428952114922,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(31,_binary '',4.635437291675252,'CHINESE',NULL,_binary '\0','Veg Momos',227,32,0,'https://res.cloudinary.com/dnejefctn/image/upload/Veg_Momos.jpg','CHEF LIN KITCHEN','CHEF',9.975419699896772,78.13261839386988,NULL,NULL,NULL,'TEENS','ALL','STRESSED',4),(32,_binary '',4.606769563583266,'CHINESE',NULL,_binary '\0','Hakka Noodles',153,33,0,'https://res.cloudinary.com/dnejefctn/image/upload/Hakka_Noodles.jpg','CHEF CHANG KITCHEN','CHEF',9.959371231623226,78.17939485937177,NULL,NULL,NULL,'TEENS','ALL','STRESSED',4),(33,_binary '',4.552716795084063,'CHINESE',NULL,_binary '\0','Manchow Soup',129,34,0,'https://res.cloudinary.com/dnejefctn/image/upload/Manchow_Soup.jpg','CHEF ZHOU KITCHEN','CHEF',9.92184597309237,78.1394123130304,NULL,NULL,NULL,'TEENS','ALL','STRESSED',4),(34,_binary '',4.621767546449528,'CHINESE',NULL,_binary '\0','Dragon Chicken',269,35,0,'https://res.cloudinary.com/dnejefctn/image/upload/Dragon_Chicken.jpg','CHEF WONG KITCHEN','CHEF',9.960765161313507,78.18012873792787,NULL,NULL,NULL,'ADULT_YOUNG','MALE','STRESSED',5),(35,_binary '',4.357944214538162,'CHINESE',NULL,_binary '\0','Spring Rolls',288,36,0,'https://res.cloudinary.com/dnejefctn/image/upload/Spring_Rolls.jpg','CHEF LEE KITCHEN','CHEF',9.924648834493617,78.16096426235704,NULL,NULL,NULL,'TEENS','ALL','STRESSED',4),(36,_binary '',4.457455354579704,'CHINESE',NULL,_binary '\0','Fried Rice',123,37,0,'https://res.cloudinary.com/dnejefctn/image/upload/Fried_Rice.jpg','CHEF KIM KITCHEN','CHEF',9.984881622233745,78.18905098776195,NULL,NULL,NULL,'TEENS','ALL','STRESSED',4),(37,_binary '',4.727175701960957,'CHINESE',NULL,_binary '\0','Chilli Paneer',294,38,0,'https://res.cloudinary.com/dnejefctn/image/upload/Chilli_Paneer.jpg','CHEF TAN KITCHEN','CHEF',9.987830550001231,78.16821636252487,NULL,NULL,NULL,'TEENS','ALL','STRESSED',4),(38,_binary '',4.24021181774552,'CHINESE',NULL,_binary '\0','Dim Sums',141,39,0,'https://res.cloudinary.com/dnejefctn/image/upload/Dim_Sums.jpg','CHEF HO KITCHEN','CHEF',9.989778798124517,78.11242861954216,NULL,NULL,NULL,'TEENS','ALL','STRESSED',4),(39,_binary '',4.74380524968513,'CHINESE',NULL,_binary '\0','Noodle Soup',301,40,0,'https://res.cloudinary.com/dnejefctn/image/upload/Noodle_Soup.jpg','CHEF WU KITCHEN','CHEF',9.969531341318275,78.15482972655205,NULL,NULL,NULL,'TEENS','ALL','STRESSED',4),(40,_binary '',4.735151527799458,'CHINESE',NULL,_binary '\0','Schezwan Chicken',211,41,0,'https://res.cloudinary.com/dnejefctn/image/upload/Schezwan_Chicken.jpg','CHEF CHO KITCHEN','CHEF',9.997424548288762,78.17605493682875,NULL,NULL,NULL,'ADULT_YOUNG','MALE','STRESSED',5),(41,_binary '',4.501978583744634,'DESSERTS',NULL,_binary '\0','Gulab Jamun',291,42,0,'https://res.cloudinary.com/dnejefctn/image/upload/Gulab_Jamun.jpg','CHEF TIWARI KITCHEN','CHEF',9.96938213189574,78.17510136074984,NULL,NULL,NULL,'KIDS','ALL','HAPPY',1),(42,_binary '',4.527068019943125,'DESSERTS',NULL,_binary '\0','Mysore Pak',221,43,0,'https://res.cloudinary.com/dnejefctn/image/upload/Mysore_Pak.jpg','CHEF IYER KITCHEN','CHEF',9.930931815299113,78.17677118806189,NULL,NULL,NULL,'KIDS','ALL','HAPPY',1),(43,_binary '',4.624655032558868,'DESSERTS',NULL,_binary '\0','Mishti  Doi',332,44,0,'https://res.cloudinary.com/dnejefctn/image/upload/Mishti_ Doi.jpg','CHEF HALDER KITCHEN','CHEF',9.975180670717425,78.13432222394968,NULL,NULL,NULL,'KIDS','ALL','HAPPY',1),(44,_binary '',4.258634222688331,'DESSERTS',NULL,_binary '\0','Mathura Peda',242,45,0,'https://res.cloudinary.com/dnejefctn/image/upload/Mathura_Peda.jpg','CHEF AGARWAL KITCHEN','CHEF',9.951804153133219,78.1418036023036,NULL,NULL,NULL,'KIDS','ALL','HAPPY',1),(45,_binary '',4.593817007334368,'DESSERTS',NULL,_binary '\0','Mango Shrikhand',122,46,0,'https://res.cloudinary.com/dnejefctn/image/upload/Mango_Shrikhand.jpg','CHEF JOSHI.D KITCHEN','CHEF',9.991960551642071,78.1579786544637,NULL,NULL,NULL,'KIDS','ALL','HAPPY',1),(46,_binary '',4.251982937530986,'DESSERTS',NULL,_binary '\0','Bikaneri Ghevar',201,47,0,'https://res.cloudinary.com/dnejefctn/image/upload/Bikaneri_Ghevar.jpg','CHEF SHARMA.D KITCHEN','CHEF',9.988478684544251,78.12155757813058,NULL,NULL,NULL,'KIDS','ALL','HAPPY',1),(47,_binary '',4.590912812515648,'DESSERTS',NULL,_binary '\0','Double Ka Meetha',238,48,0,'https://res.cloudinary.com/dnejefctn/image/upload/Double_Ka_Meetha.jpg','CHEF REDDY.D KITCHEN','CHEF',9.994409953780986,78.14738048747746,NULL,NULL,NULL,'KIDS','ALL','HAPPY',1),(48,_binary '',4.581910123010734,'DESSERTS',NULL,_binary '\0','Chhena Poda',346,49,0,'https://res.cloudinary.com/dnejefctn/image/upload/Chhena_Poda.jpg','CHEF DAS.D KITCHEN','CHEF',9.974458862184498,78.14378767919148,NULL,NULL,NULL,'KIDS','ALL','HAPPY',1),(49,_binary '',4.6310489227018,'DESSERTS',NULL,_binary '\0','Dharwad Pedha',257,50,0,'https://res.cloudinary.com/dnejefctn/image/upload/Dharwad_Pedha.jpg','CHEF MURTHY KITCHEN','CHEF',9.952634334101452,78.15836704612674,NULL,NULL,NULL,'KIDS','ALL','HAPPY',1),(50,_binary '',4.4768972672411245,'DESSERTS',NULL,_binary '\0','Sandesh Platter',288,51,0,'https://res.cloudinary.com/dnejefctn/image/upload/Sandesh_Platter.jpg','CHEF BENGALI KITCHEN','CHEF',9.939864987413909,78.16090203485281,NULL,NULL,NULL,'KIDS','ALL','HAPPY',1),(51,_binary '',4.449744925327616,'VEG',NULL,_binary '\0','Sambhar Idli',284,52,0,'https://res.cloudinary.com/dnejefctn/image/upload/Sambhar_Idli.jpg','Saraswathi Amma','HOME_FOOD',9.944966090514011,78.15303796234086,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(52,_binary '',4.419084998680683,'VEG',NULL,_binary '\0','Puliyodharai',163,53,0,'https://res.cloudinary.com/dnejefctn/image/upload/Puliyodharai.jpg','Lakshmi Mami','HOME_FOOD',9.976029723958623,78.15197000026957,NULL,NULL,NULL,'ADULT_MATURE','ALL','NEUTRAL',3),(53,_binary '',4.502143942883764,'VEG',NULL,_binary '\0','Lemon Rice',328,54,0,'https://res.cloudinary.com/dnejefctn/image/upload/Lemon_Rice.jpg','Grace Mary','HOME_FOOD',9.988342481073346,78.1810997424712,NULL,NULL,NULL,'ADULT_MATURE','ALL','NEUTRAL',3),(54,_binary '',4.51551913806082,'VEG',NULL,_binary '\0','Rajma Chawal',363,55,0,'https://res.cloudinary.com/dnejefctn/image/upload/Rajma_Chawal.jpg','Mrs. Kapoor','HOME_FOOD',9.974472863831853,78.17702350068004,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(55,_binary '',4.279211211503601,'VEG',NULL,_binary '\0','Aloo Paratha',244,56,0,'https://res.cloudinary.com/dnejefctn/image/upload/Aloo_Paratha.jpg','Revathi Kitchen','HOME_FOOD',9.924594513252963,78.18949884147369,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(56,_binary '',4.449247783113974,'VEG',NULL,_binary '\0','Tiffin Combo',319,57,0,'https://res.cloudinary.com/dnejefctn/image/upload/Tiffin_Combo.jpg','Kavitha Foods','HOME_FOOD',9.969876847219647,78.17249705843933,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(57,_binary '',4.28619112706947,'NON_VEG',NULL,_binary '\0','Home Fish Curry',306,58,0,'https://res.cloudinary.com/dnejefctn/image/upload/Home_Fish_Curry.jpg','Meena Aunty','HOME_FOOD',9.934261593431188,78.13090120394598,NULL,NULL,NULL,'ADULT_MID','ALL','NEUTRAL',3),(58,_binary '',4.422415724112104,'NON_VEG',NULL,_binary '\0','Home Mutton Biryani',134,59,0,'https://res.cloudinary.com/dnejefctn/image/upload/Home_Mutton_Biryani.jpg','Fatima Bi','HOME_FOOD',9.956135964394148,78.12927438328744,NULL,NULL,NULL,'ADULT_YOUNG','MALE','STRESSED',5),(59,_binary '',4.74606090885865,'DESSERTS',NULL,_binary '\0','Medu Vada',286,60,0,'https://res.cloudinary.com/dnejefctn/image/upload/Medu_Vada.jpg','Deepa Home','HOME_FOOD',9.98123489809666,78.11556291376642,NULL,NULL,NULL,'KIDS','ALL','HAPPY',1),(60,_binary '',4.772953256910277,'DESSERTS',NULL,_binary '\0','Tirunelveli Halwa',361,61,0,'https://res.cloudinary.com/dnejefctn/image/upload/Tirunelveli_Halwa.jpg','Mani Grandmom','HOME_FOOD',9.954503267841305,78.12158692644164,NULL,NULL,NULL,'KIDS','ALL','HAPPY',1);
/*!40000 ALTER TABLE `foods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `home_banners`
--

DROP TABLE IF EXISTS `home_banners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `home_banners` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `food_id` bigint NOT NULL,
  `banner_name` varchar(255) NOT NULL,
  `banner_bio` varchar(255) DEFAULT NULL,
  `banner_image_url` varchar(255) NOT NULL,
  `banner_tag` varchar(255) DEFAULT NULL,
  `theme_color` varchar(255) DEFAULT NULL,
  `display_order` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `food_id` (`food_id`),
  CONSTRAINT `home_banners_ibfk_1` FOREIGN KEY (`food_id`) REFERENCES `foods` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home_banners`
--

LOCK TABLES `home_banners` WRITE;
/*!40000 ALTER TABLE `home_banners` DISABLE KEYS */;
/*!40000 ALTER TABLE `home_banners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `home_providers`
--

DROP TABLE IF EXISTS `home_providers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `home_providers` (
  `user_id` bigint NOT NULL,
  `kitchen_name` varchar(255) DEFAULT NULL,
  `specialist_cuisine` varchar(255) DEFAULT NULL,
  `experience_years` int DEFAULT NULL,
  `signature_dish` varchar(255) DEFAULT NULL,
  `avg_rating` double DEFAULT '4.5',
  `total_reviews` int DEFAULT '0',
  PRIMARY KEY (`user_id`),
  CONSTRAINT `home_providers_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home_providers`
--

LOCK TABLES `home_providers` WRITE;
/*!40000 ALTER TABLE `home_providers` DISABLE KEYS */;
INSERT INTO `home_providers` VALUES (52,'Saraswathi Amma',NULL,NULL,NULL,4.5,0),(53,'Lakshmi Mami',NULL,NULL,NULL,4.5,0),(54,'Grace Mary',NULL,NULL,NULL,4.5,0),(55,'Mrs. Kapoor',NULL,NULL,NULL,4.5,0),(56,'Revathi Kitchen',NULL,NULL,NULL,4.5,0),(57,'Kavitha Foods',NULL,NULL,NULL,4.5,0),(58,'Meena Aunty',NULL,NULL,NULL,4.5,0),(59,'Fatima Bi',NULL,NULL,NULL,4.5,0),(60,'Deepa Home',NULL,NULL,NULL,4.5,0),(61,'Mani Grandmom',NULL,NULL,NULL,4.5,0);
/*!40000 ALTER TABLE `home_providers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `customer_id` bigint NOT NULL,
  `food_id` bigint NOT NULL,
  `provider_id` bigint NOT NULL,
  `quantity` int DEFAULT '1',
  `status` varchar(255) DEFAULT NULL,
  `ordered_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `food_name` varchar(255) DEFAULT NULL,
  `order_time` datetime(6) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `provider_name` varchar(255) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `food_id` (`food_id`),
  KEY `provider_id` (`provider_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `users` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`food_id`) REFERENCES `foods` (`id`),
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`provider_id`) REFERENCES `providers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comment` text,
  `created_at` datetime(6) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `food_id` bigint DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  `provider_id` bigint DEFAULT NULL,
  `rating` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `dish_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_chef_reviews` (`provider_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_activity`
--

DROP TABLE IF EXISTS `user_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_activity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `food_id` bigint NOT NULL,
  `action` enum('VIEW','SEARCH','ORDER') NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `food_id` (`food_id`),
  CONSTRAINT `user_activity_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `user_activity_ibfk_2` FOREIGN KEY (`food_id`) REFERENCES `foods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_activity`
--

LOCK TABLES `user_activity` WRITE;
/*!40000 ALTER TABLE `user_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` enum('CHEF','CUSTOMER','HOME_FOOD','ADMIN') NOT NULL,
  `bio` text,
  `location` varchar(255) DEFAULT NULL,
  `is_online` tinyint(1) DEFAULT '1',
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `email_verified` tinyint(1) DEFAULT '0',
  `email_otp` varchar(255) DEFAULT NULL,
  `phone_otp` varchar(255) DEFAULT NULL,
  `phone_verified` tinyint(1) DEFAULT '0',
  `profile_pic_url` varchar(255) DEFAULT NULL,
  `profile_pic_public_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2026-03-22 13:20:23.674026','user@rasoi.com','Showcase User','$2a$10$FmLlSvKOTxUNwkF43yMQw.gHq5fyA6NxADENS62VwiKA4i3Om4uJ6','9988776655','CUSTOMER',NULL,NULL,1,9.9252,78.1197,1,NULL,NULL,0,NULL,NULL),(2,'2026-03-22 13:20:23.770800','vignesh@rasoi.com','Chef Vignesh','$2a$10$D.Wpw//KbaRMVDtpbmxjF.r0Oj/3Bj02djgU/SgxZP3sFZwnyanxu','911605277314','CHEF',NULL,NULL,1,9.936895250751823,78.11344230302429,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Vignesh',NULL),(3,'2026-03-22 13:20:23.877223','jeyaram@rasoi.com','Chef Jeyaram','$2a$10$jjq3IF.yfosGzlRnZaMoueHqtm3bCodF55zM74/8FVoN249V6WAKi','911837285579','CHEF',NULL,NULL,1,9.99504286468481,78.15010192628057,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Jeyaram',NULL),(4,'2026-03-22 13:20:23.950456','nirmal@rasoi.com','Chef Nirmal','$2a$10$yD1xJrjmaMEhRq6xDgoi1eu5temGwGxmvlGJ5zsw2RWlFWvGIfQcK','911372151069','CHEF',NULL,NULL,1,9.939204038728612,78.17265909751545,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Nirmal',NULL),(5,'2026-03-22 13:20:24.034062','seshu@rasoi.com','Chef Seshathri','$2a$10$E7iBypr.V6i6ALx12REt3ehDSeOV0nyqfZPjRwIbeyKo.CaDMcw0W','911466249527','CHEF',NULL,NULL,1,9.9262916721354,78.17732362631759,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Seshathri',NULL),(6,'2026-03-22 13:20:24.102094','ananth@rasoi.com','Chef Ananth','$2a$10$LqLbEMIFtT9IO1tRraBBuudDIrJo9ScqXQWrf/c3a04Jif6LuPQh.','911504163866','CHEF',NULL,NULL,1,9.93763779483313,78.17024959327162,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Ananth',NULL),(7,'2026-03-22 13:20:24.185200','aakash@rasoi.com','Chef Aakash','$2a$10$9UcmromalwHsPcJwVkj7vu98RsscsBhmU1.d.btQqDTNomMIG57Sm','911376379975','CHEF',NULL,NULL,1,9.937778978025287,78.18568458418676,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Aakash',NULL),(8,'2026-03-22 13:20:24.273705','santhosh@rasoi.com','Chef Santhosh','$2a$10$dJvLJPwPbAa6pesGPL9dnu2uBS4oy6zzacRftqMofXI/NJFB72BEK','911086787076','CHEF',NULL,NULL,1,9.928217432940299,78.17425875651534,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Santhosh',NULL),(9,'2026-03-22 13:20:24.352260','damu@rasoi.com','Chef Damu','$2a$10$hzGepanDKrmvGAwSP6SEtel.6FYXiRKTmmqIC0sMUtkaxV.TTVwU6','911755516311','CHEF',NULL,NULL,1,9.969734411001872,78.16321307671767,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Damu',NULL),(10,'2026-03-22 13:20:24.434010','bhat@rasoi.com','Chef Bhat','$2a$10$RvIGZLj2no5w3N8oULsZ3uiwuMntgDn/MYwuupCefVlXQsJ4gZsFi','911052910216','CHEF',NULL,NULL,1,9.945660715399955,78.14731916920081,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Bhat',NULL),(11,'2026-03-22 13:20:24.501895','ranga@rasoi.com','Chef Ranga','$2a$10$uZQ7Dqd.hS6Yj16r.QDkseGW5El8BTWVvFEXjqC5acbTKrvSVw0Du','911526609979','CHEF',NULL,NULL,1,9.999837236165208,78.18869631206682,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Ranga',NULL),(12,'2026-03-22 13:20:24.589887','preeti@rasoi.com','Chef Preeti','$2a$10$fRUFhntDza9mTDvPN2kHYulAjfRQiLOxSjg392EFAKk4WlBFZYM0a','911863185236','CHEF',NULL,NULL,1,9.993908610483471,78.13534830331405,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Preeti',NULL),(13,'2026-03-22 13:20:24.667002','singh@rasoi.com','Chef Singh','$2a$10$grXiBTik0V09i4m6N.5VYu0AEp/rrEZPUXxGqsTNBrNRdMHARttkm','911520302412','CHEF',NULL,NULL,1,9.940116640100024,78.13071722333817,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Singh',NULL),(14,'2026-03-22 13:20:24.750866','khanna@rasoi.com','Chef Khanna','$2a$10$OCoCEGasYyqvwv60BAhDouzIzyCjk3fhJlRJ.seD8X54g26eV5hzO','911494514255','CHEF',NULL,NULL,1,9.935716817333272,78.12762713385804,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Khanna',NULL),(15,'2026-03-22 13:20:24.835737','kapoor@rasoi.com','Chef Kapoor','$2a$10$yZuwGhiPZuv0DEb9o0gzZelDEELnnR44Ml8Q9jWfxCTGS3/m6DBD.','911462060794','CHEF',NULL,NULL,1,9.958401157264912,78.13467034381786,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Kapoor',NULL),(16,'2026-03-22 13:20:24.901804','mal@rasoi.com','Chef Malhotra','$2a$10$SQpFPMPcVXx58l4Xryko1.62EesvTiDmljx5.wywro8fyxB8up9ai','911725414472','CHEF',NULL,NULL,1,9.970602777856213,78.18767645014904,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Malhotra',NULL),(17,'2026-03-22 13:20:24.990344','verma@rasoi.com','Chef Verma','$2a$10$SxV3DF47umVy1sDKbZ.Vv.4DauJksUD2ftaFwx6T9oXhCo8/JkHtW','911213345413','CHEF',NULL,NULL,1,9.970992923692586,78.11334239556135,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Verma',NULL),(18,'2026-03-22 13:20:25.068307','gupta@rasoi.com','Chef Gupta','$2a$10$FBLgm4//vcRRJOhOF9QhHec4o1m7qOYYpTeNKTHLO0fXrW99GcVhe','911780599185','CHEF',NULL,NULL,1,9.920726513471546,78.17485497974852,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Gupta',NULL),(19,'2026-03-22 13:20:25.156686','mehra@rasoi.com','Chef Mehra','$2a$10$vpDbYWIE6UOH2Qy8JxyinuviWzAmgRCKGNCcwseS03G9DwxDMS8sq','911584796700','CHEF',NULL,NULL,1,9.990228009157523,78.14544329336094,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Mehra',NULL),(20,'2026-03-22 13:20:25.233769','kohli@rasoi.com','Chef Kohli','$2a$10$GtU8ruweg4Z8jx2lv280DOYM254dUdygvNJINyoeBuLEUTQW6DYB6','911856350953','CHEF',NULL,NULL,1,9.968618327328212,78.16612161077764,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Kohli',NULL),(21,'2026-03-22 13:20:25.324856','oberoi@rasoi.com','Chef Oberoi','$2a$10$ushCSlKnuB.fsWpJ0IoWhu7oBBH2c0vrJs8YZ1m1M6vit8oUj39Py','911595281875','CHEF',NULL,NULL,1,9.986453000974464,78.13786963624736,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Oberoi',NULL),(22,'2026-03-22 13:20:25.400989','goel@rasoi.com','Chef Goel','$2a$10$cAA0uIchrnDDn8qJQb.5tuoLId8pQKYX6qZUHSBy.s45KBXqlHnIy','911549003733','CHEF',NULL,NULL,1,9.944623926288754,78.13358180584115,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Goel',NULL),(23,'2026-03-22 13:20:25.474993','rahul@rasoi.com','Chef Rahul','$2a$10$aW4U/wsdR4SstPd158rmReZPoLspqL9fOmTyhFeiMJZyqGgfR6HUq','911058098410','CHEF',NULL,NULL,1,9.982499354021689,78.11576934250974,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Rahul',NULL),(24,'2026-03-22 13:20:25.558028','shah@rasoi.com','Chef Shah','$2a$10$oE0yPPDfwzpwrqBr/4rO6urHmm8DL.qe05qi3JAO0fp2zVsxwA1Z6','911845484003','CHEF',NULL,NULL,1,9.955794759658882,78.18420891441468,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Shah',NULL),(25,'2026-03-22 13:20:25.633807','patel@rasoi.com','Chef Patel','$2a$10$JqedDVT31t/AVMJ.Ybvm/.u0TQrWa8PIVHyt4Ew1wbE15e82QNMci','911800465754','CHEF',NULL,NULL,1,9.98177751741806,78.15502009890696,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Patel',NULL),(26,'2026-03-22 13:20:25.707985','joshi@rasoi.com','Chef Joshi','$2a$10$hZ10lyhwilV82UXPh4v9zefUhkveZ2ynN42684dHse/Z6SAyTsh9S','911187250182','CHEF',NULL,NULL,1,9.995853703803908,78.13886603370504,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Joshi',NULL),(27,'2026-03-22 13:20:25.788937','kul@rasoi.com','Chef Kulkarni','$2a$10$cmt9B8ns9ibdb9KFGgLRhOWrJ/BI8W.M9UzDF9aLEigRQ1irAEOL6','911402541340','CHEF',NULL,NULL,1,9.963616947243752,78.1475775081412,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Kulkarni',NULL),(28,'2026-03-22 13:20:25.866987','desh@rasoi.com','Chef Deshpande','$2a$10$2laArVl8O8UyQU8YroK8FuksxjnECQj6fRuQ3GZrku84/PVi/ZL6i','911611523880','CHEF',NULL,NULL,1,9.927915410906985,78.13770204031027,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Deshpande',NULL),(29,'2026-03-22 13:20:25.941464','tri@rasoi.com','Chef Trivedi','$2a$10$htu26pKaujGlUG27QHm2qOYphCdfnq4xzeZoD/W3MBT37fAWPEMeC','911892577589','CHEF',NULL,NULL,1,9.948004204035652,78.14505350173334,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Trivedi',NULL),(30,'2026-03-22 13:20:26.022946','agra@rasoi.com','Chef Agrawal','$2a$10$5Sabl9ZdXtrMJYtGo0BlJ.0y.jmt.0h7wGfOmN5uGYA8A69Ol6Dna','911591394307','CHEF',NULL,NULL,1,9.987494250767917,78.18475585530534,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Agrawal',NULL),(31,'2026-03-22 13:20:26.101117','sharma.v@rasoi.com','Chef Sharma','$2a$10$7XCIpdefY.SykLNjlJNf5esZfFqF576OyK5NR9f4ETrOLxO1vc0bO','911277301498','CHEF',NULL,NULL,1,9.947837466441772,78.12428952114922,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Sharma',NULL),(32,'2026-03-22 13:20:26.185407','lin@rasoi.com','Chef Lin','$2a$10$Yk/j8Q9J2RXoJSxE38NkM.nrKTKeba9iNNOfqJglB2wp1D9QoCB8W','911067713189','CHEF',NULL,NULL,1,9.975419699896772,78.13261839386988,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Lin',NULL),(33,'2026-03-22 13:20:26.251686','chang@rasoi.com','Chef Chang','$2a$10$LZMjjmqvh4/uqyO.Gpl6kOSLdZSItdrPA/QJd/E37f5RjQ/Ppn9P6','911139740604','CHEF',NULL,NULL,1,9.959371231623226,78.17939485937177,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Chang',NULL),(34,'2026-03-22 13:20:26.340998','zhou@rasoi.com','Chef Zhou','$2a$10$9D9dpgVOvigLSMryoyJxteMSYG/YCfjyP1YuZURsOb3xqPc4yI6Lq','911389653571','CHEF',NULL,NULL,1,9.92184597309237,78.1394123130304,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Zhou',NULL),(35,'2026-03-22 13:20:26.418856','wong@rasoi.com','Chef Wong','$2a$10$.yrHr2ruwgp7ETGVGpqkp.3wDVjWD4FD0nYRd.TMuF27Vt65Njd1m','911420931843','CHEF',NULL,NULL,1,9.960765161313507,78.18012873792787,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Wong',NULL),(36,'2026-03-22 13:20:26.499772','lee@rasoi.com','Chef Lee','$2a$10$ktIBPL9dsbZG4VlFiHLum..GNnZkICV2/qBZnbPGqCs0TuM8QirPi','911791077791','CHEF',NULL,NULL,1,9.924648834493617,78.16096426235704,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Lee',NULL),(37,'2026-03-22 13:20:26.574626','kim@rasoi.com','Chef Kim','$2a$10$ZNOUZYgCKs.e9upRyxtOOO0V25Poo6x3Lj89jE8KuBqQessPxKuZu','911440358612','CHEF',NULL,NULL,1,9.984881622233745,78.18905098776195,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Kim',NULL),(38,'2026-03-22 13:20:26.650602','tan@rasoi.com','Chef Tan','$2a$10$gjWZghEEl.Dc1FN3f6W13eR/cNrrkb5VLncsu.zRHlM134BL6Otpa','911871268795','CHEF',NULL,NULL,1,9.987830550001231,78.16821636252487,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Tan',NULL),(39,'2026-03-22 13:20:26.724948','ho@rasoi.com','Chef Ho','$2a$10$SlqBLUAEx5RO7nS1z7NtouHiQWMRLbqfrbJgU.rElWFgOOC75DikO','911795703812','CHEF',NULL,NULL,1,9.989778798124517,78.11242861954216,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Ho',NULL),(40,'2026-03-22 13:20:26.808087','wu@rasoi.com','Chef Wu','$2a$10$0nk/XAdIfh3GHaHHD1/Ok.xRUcs9kGVOJcY/OvOnHUzKlFUn7Iqny','911465421528','CHEF',NULL,NULL,1,9.969531341318275,78.15482972655205,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Wu',NULL),(41,'2026-03-22 13:20:26.892623','cho@rasoi.com','Chef Cho','$2a$10$WpOONfTa.x0poN.Uu2FTFOR41NkZO4YVjzpPSjEb7JCo0PNITEQPO','911176664170','CHEF',NULL,NULL,1,9.997424548288762,78.17605493682875,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Cho',NULL),(42,'2026-03-22 13:20:26.966925','tiwari@rasoi.com','Chef Tiwari','$2a$10$z4Z6N/jKPJBNfio3jdu9T.KTDjaI5p96iHsfifzksspJBWLmh1TR6','911137168909','CHEF',NULL,NULL,1,9.96938213189574,78.17510136074984,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Tiwari',NULL),(43,'2026-03-22 13:20:27.050542','iyer@rasoi.com','Chef Iyer','$2a$10$C1b4vKT5AgY5uZDSg1vseukv6Ck36cIXNE1RWDv7S7hWtJwP4ggR2','911889193570','CHEF',NULL,NULL,1,9.930931815299113,78.17677118806189,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Iyer',NULL),(44,'2026-03-22 13:20:27.118429','halder@rasoi.com','Chef Halder','$2a$10$iV/lV4tWHATcRQXj76BjyeY62/f0j50yuiRzAH5NS08r30ftzkOsK','911778054139','CHEF',NULL,NULL,1,9.975180670717425,78.13432222394968,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Halder',NULL),(45,'2026-03-22 13:20:27.208019','agar@rasoi.com','Chef Agarwal','$2a$10$Y6YhdbHOvD/FaC2WO6/IjO1G947gnBDCof/ze54L9nKS/QdedepeG','911872488495','CHEF',NULL,NULL,1,9.951804153133219,78.1418036023036,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Agarwal',NULL),(46,'2026-03-22 13:20:27.317642','joshi.d@rasoi.com','Chef Joshi.D','$2a$10$a116i1iK149I8y573y2ntuu0a3QOqswMTf9pJRUjG53jn.MAOdtyy','911198504085','CHEF',NULL,NULL,1,9.991960551642071,78.1579786544637,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Joshi.D',NULL),(47,'2026-03-22 13:20:27.400440','sharma.d@rasoi.com','Chef Sharma.D','$2a$10$txNbmX3LvusStNM/8hi7r.Hif7qmvAcgp0gdfGpGop8FzIKbk.sii','911177074506','CHEF',NULL,NULL,1,9.988478684544251,78.12155757813058,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Sharma.D',NULL),(48,'2026-03-22 13:20:27.474734','reddy.d@rasoi.com','Chef Reddy.D','$2a$10$inWNSef/cOqyB4snAC4XFe56ZFR4tNe5xP3PVwdIzXNiLb2KyLxzW','911374119720','CHEF',NULL,NULL,1,9.994409953780986,78.14738048747746,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Reddy.D',NULL),(49,'2026-03-22 13:20:27.550443','das.d@rasoi.com','Chef Das.D','$2a$10$3lRWys0E/g8b54J/eqfXkepiviyMaTrhN5tvlRMw0L2nbn.9oDVDu','911497478928','CHEF',NULL,NULL,1,9.974458862184498,78.14378767919148,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Das.D',NULL),(50,'2026-03-22 13:20:27.632153','murthy@rasoi.com','Chef Murthy','$2a$10$n1SVjdZgzI923f9UdtzVju/YADxLDWt8IvP1oDNkTaVRwO4Hq/Duu','911674900328','CHEF',NULL,NULL,1,9.952634334101452,78.15836704612674,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Murthy',NULL),(51,'2026-03-22 13:20:27.708057','bengali@rasoi.com','Chef Bengali','$2a$10$4BcKCcLJYW8adO7hPbf5ouK2Rem2XwRFlYzAx8E4gAY9OolcML4i.','911432228220','CHEF',NULL,NULL,1,9.939864987413909,78.16090203485281,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Chef+Bengali',NULL),(52,'2026-03-22 13:20:27.783709','saras@gmail.com','Saraswathi Amma','$2a$10$3GvF.beLdKwgCk0tm7/aquIyf/9xWJ/ZkZjYPZjLPUbYSD02MUQyC','911107248413','HOME_FOOD',NULL,NULL,1,9.944966090514011,78.15303796234086,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Saraswathi+Amma',NULL),(53,'2026-03-22 13:20:27.851949','lakshmi@gmail.com','Lakshmi Mami','$2a$10$eO5qs6nlGPjMwAERxq5I5OOmMIV0zrkP9sinngg0UZ1HuFODcbac6','911080760009','HOME_FOOD',NULL,NULL,1,9.976029723958623,78.15197000026957,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Lakshmi+Mami',NULL),(54,'2026-03-22 13:20:27.933773','grace@gmail.com','Grace Mary','$2a$10$7LpvuA.Ry64MyJhNqp.rjuoXJq2QfA7J8NgCVjaePB5921ilpB24C','911602013594','HOME_FOOD',NULL,NULL,1,9.988342481073346,78.1810997424712,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Grace+Mary',NULL),(55,'2026-03-22 13:20:28.007190','kapoor.h@gmail.com','Mrs. Kapoor','$2a$10$OVFsYdzlha4a7dQKw66U8OsZfQkdnj0c7XUy3gPwQNGlafv3rr70i','911106068098','HOME_FOOD',NULL,NULL,1,9.974472863831853,78.17702350068004,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Mrs.+Kapoor',NULL),(56,'2026-03-22 13:20:28.091369','revathi@gmail.com','Revathi Kitchen','$2a$10$/gKkT7O2LJ85J6evbwY89.9MyhWt6LfsteLTkjQex45P7ucsksLyq','911394922517','HOME_FOOD',NULL,NULL,1,9.924594513252963,78.18949884147369,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Revathi+Kitchen',NULL),(57,'2026-03-22 13:20:28.167181','kavitha@gmail.com','Kavitha Foods','$2a$10$Rxqv8tHelrGu/tQH.TsVpeMoJQaGYS5B5VfNsWPhls3C5RMXRew9e','911285790152','HOME_FOOD',NULL,NULL,1,9.969876847219647,78.17249705843933,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Kavitha+Foods',NULL),(58,'2026-03-22 13:20:28.235046','meena@gmail.com','Meena Aunty','$2a$10$FlddTZSZH5l7hEhDwgfFeePRjOQltXMIYKwd2SitS/eRkWBA79NlG','911184495309','HOME_FOOD',NULL,NULL,1,9.934261593431188,78.13090120394598,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Meena+Aunty',NULL),(59,'2026-03-22 13:20:28.325280','fatima@gmail.com','Fatima Bi','$2a$10$V7wGkzNAsYYSy6R6DYp.XeuIDeUEVf4B8WtLeIbYlLSZGMSliXDQa','911730542105','HOME_FOOD',NULL,NULL,1,9.956135964394148,78.12927438328744,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Fatima+Bi',NULL),(60,'2026-03-22 13:20:28.403545','deepa@gmail.com','Deepa Home','$2a$10$xkKKliI2Z9qZ.a0xQ8xkt.TIwMTwYOlkRRK6u7/3wNcSDGGMU0aka','911501781430','HOME_FOOD',NULL,NULL,1,9.98123489809666,78.11556291376642,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Deepa+Home',NULL),(61,'2026-03-22 13:20:28.483903','mani@gmail.com','Mani Grandmom','$2a$10$0KNrEA6rCL3PrcJPeZeWwuNSNlZh2XFCcnC5/RzQzBks.OlMWw0CK','911846108022','HOME_FOOD',NULL,NULL,1,9.954503267841305,78.12158692644164,1,NULL,NULL,0,'https://ui-avatars.com/api/?name=Mani+Grandmom',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-23 20:31:52
