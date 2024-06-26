CREATE DATABASE  IF NOT EXISTS `telephonedirectory` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `telephonedirectory`;
-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: localhost    Database: telephonedirectory
-- ------------------------------------------------------
-- Server version	8.0.36-0ubuntu0.22.04.1

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
-- Table structure for table `city_master`
--

DROP TABLE IF EXISTS `city_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city_master` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city_short_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `city_full_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `city_wise_index`
--

DROP TABLE IF EXISTS `city_wise_index`;
/*!50001 DROP VIEW IF EXISTS `city_wise_index`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `city_wise_index` AS SELECT 
 1 AS `lab_id`,
 1 AS `lab_short_name`,
 1 AS `lab_full_name`,
 1 AS `city_full_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `director_mail`
--

DROP TABLE IF EXISTS `director_mail`;
/*!50001 DROP VIEW IF EXISTS `director_mail`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `director_mail` AS SELECT 
 1 AS `email`,
 1 AS `emp_id`,
 1 AS `mail_category`,
 1 AS `lab_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `emp_cadre`
--

DROP TABLE IF EXISTS `emp_cadre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_cadre` (
  `cadre_id` int NOT NULL AUTO_INCREMENT,
  `cadre_short_name` varchar(45) DEFAULT NULL,
  `cadre_full_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`cadre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `emp_designation`
--

DROP TABLE IF EXISTS `emp_designation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_designation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `design_short_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `design_full_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `cadre_id` int NOT NULL,
  `order_no` int NOT NULL DEFAULT '-1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `design_full_name_UNIQUE` (`design_full_name`),
  KEY `fk_cadre_id_idx` (`cadre_id`),
  CONSTRAINT `fk_cadre_id_idx` FOREIGN KEY (`cadre_id`) REFERENCES `emp_cadre` (`cadre_id`) ON DELETE CASCADE ON UPDATE CASCADE 
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `emp_mail_drona`;
/*!50001 DROP VIEW IF EXISTS `emp_mail_drona`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `emp_mail_drona` AS SELECT 
 1 AS `emp_id`,
 1 AS `email`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `emp_mail_internet`
--

DROP TABLE IF EXISTS `emp_mail_internet`;
/*!50001 DROP VIEW IF EXISTS `emp_mail_internet`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `emp_mail_internet` AS SELECT 
 1 AS `emp_id`,
 1 AS `email`*/;
SET character_set_client = @saved_cs_client;


--
-- Table structure for table `emp_role`
--

DROP TABLE IF EXISTS `emp_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_short_name` varchar(45) DEFAULT NULL,
  `role_full_name` varchar(200) DEFAULT NULL,
  `last_updated` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `event_log`
--

DROP TABLE IF EXISTS `event_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `event` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `ip` varchar(45) DEFAULT NULL,
  `date_of_entry` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1688 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `lab_category`
--

DROP TABLE IF EXISTS `lab_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lab_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cat_short_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `cat_full_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `lab_cluster`
--

DROP TABLE IF EXISTS `lab_cluster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lab_cluster` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cluster_short_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `cluster_full_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `deleted` varchar(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '0',
  `cluster_category` varchar(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `lab_details`
--

DROP TABLE IF EXISTS `lab_details`;
/*!50001 DROP VIEW IF EXISTS `lab_details`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `lab_details` AS SELECT 
 1 AS `lab_id`,
 1 AS `lab_auth_name`,
 1 AS `lab_short_name`,
 1 AS `lab_full_name`,
 1 AS `lab_cat_id`,
 1 AS `lab_cat_short_name`,
 1 AS `lab_cat_full_name`,
 1 AS `lab_cluster_id`,
 1 AS `lab_cluster_short_name`,
 1 AS `lab_cluster_full_name`,
 1 AS `other_group`,
 1 AS `last_updated`,
 1 AS `address_id`,
 1 AS `address_line1`,
 1 AS `address_line2`,
 1 AS `address_line3`,
 1 AS `city_id`,
 1 AS `city_full_name`,
 1 AS `zip_id`,
 1 AS `zipcode`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `lab_epabx`
--

DROP TABLE IF EXISTS `lab_epabx`;
/*!50001 DROP VIEW IF EXISTS `lab_epabx`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `lab_epabx` AS SELECT 
 1 AS `epabx_id`,
 1 AS `epabx_no`,
 1 AS `did_no`,
 1 AS `lab_id`*/;
SET character_set_client = @saved_cs_client;


DROP TABLE IF EXISTS `lab_fax`;
/*!50001 DROP VIEW IF EXISTS `lab_fax`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `lab_fax` AS SELECT 
 1 AS `fax_id`,
 1 AS `fax_no`,
 1 AS `lab_id`,
 1 AS `std_code`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `lab_fax_category`
--

DROP TABLE IF EXISTS `lab_fax_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lab_fax_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fax_cat_short_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `fax_cat_full_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `mail_category`
--

DROP TABLE IF EXISTS `mail_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mail_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mail_cat_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `pdf_emp_details`
--

DROP TABLE IF EXISTS `pdf_emp_details`;
/*!50001 DROP VIEW IF EXISTS `pdf_emp_details`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `pdf_emp_details` AS SELECT 
 1 AS `emp_id`,
 1 AS `emp_title`,
 1 AS `emp_first_name`,
 1 AS `emp_middle_name`,
 1 AS `emp_last_name`,
 1 AS `viewing_order`,
 1 AS `emp_design_id`,
 1 AS `addl_design`,
 1 AS `design_full_name`,
 1 AS `design_short_name`,
 1 AS `office_room_no`,
 1 AS `city_id`,
 1 AS `zipcode_id`,
 1 AS `address_line1`,
 1 AS `address_line2`,
 1 AS `address_line3`,
 1 AS `lab_id`,
 1 AS `lab_short_name`,
 1 AS `lab_full_name`,
 1 AS `city_full_name`,
 1 AS `zipcode`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `pdf_generated_stats`
--

DROP TABLE IF EXISTS `pdf_generated_stats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pdf_generated_stats` (
  `id` int NOT NULL AUTO_INCREMENT,
  `remarks` varchar(255) DEFAULT NULL,
  `generated_by` int NOT NULL,
  `generated_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_login_id_idx` (`generated_by`),
  CONSTRAINT `fk_login_id` FOREIGN KEY (`generated_by`) REFERENCES `login` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `pdf_telephone_index`
--

DROP TABLE IF EXISTS `pdf_telephone_index`;
/*!50001 DROP VIEW IF EXISTS `pdf_telephone_index`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `pdf_telephone_index` AS SELECT 
 1 AS `lab_id`,
 1 AS `lab_short_name`,
 1 AS `lab_full_name`,
 1 AS `other_group`,
 1 AS `deleted`,
 1 AS `viewing_order`,
 1 AS `city_id`,
 1 AS `city_full_name`,
 1 AS `cluster_category`,
 1 AS `cluster_short_name`,
 1 AS `cluster_full_name`,
 1 AS `lab_cat_id`,
 1 AS `cat_short_name`,
 1 AS `cat_full_name`*/;
SET character_set_client = @saved_cs_client;


--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publisher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `publisher_short_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `publisher_full_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `address_line1` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `address_line2` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `address_line3` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `pincode` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `compiled_by` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `edited_by` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `cover_design_by` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `distribution_by` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `last_updated` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `sc_g_and_above_details`
--

DROP TABLE IF EXISTS `sc_g_and_above_details`;
/*!50001 DROP VIEW IF EXISTS `sc_g_and_above_details`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `sc_g_and_above_details` AS SELECT 
 1 AS `emp_id`,
 1 AS `emp_title`,
 1 AS `emp_first_name`,
 1 AS `emp_middle_name`,
 1 AS `emp_last_name`,
 1 AS `emp_mail`,
 1 AS `tele_cat_id`,
 1 AS `std_code`,
 1 AS `telephone_number`,
 1 AS `viewing_order`,
 1 AS `emp_design_id`,
 1 AS `addl_design`,
 1 AS `design_full_name`,
 1 AS `office_room_no`,
 1 AS `city_id`,
 1 AS `zipcode_id`,
 1 AS `address_line1`,
 1 AS `address_line2`,
 1 AS `address_line3`,
 1 AS `lab_id`,
 1 AS `lab_short_name`,
 1 AS `lab_full_name`,
 1 AS `city_full_name`,
 1 AS `zipcode`*/;
SET character_set_client = @saved_cs_client;


DROP TABLE IF EXISTS `telephone_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telephone_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tele_cat_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `telephonedirectory_index`
--

DROP TABLE IF EXISTS `telephonedirectory_index`;
/*!50001 DROP VIEW IF EXISTS `telephonedirectory_index`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `telephonedirectory_index` AS SELECT 
 1 AS `lab_id`,
 1 AS `lab_short_name`,
 1 AS `lab_full_name`,
 1 AS `other_group`,
 1 AS `deleted`,
 1 AS `city_full_name`,
 1 AS `cluster_category`,
 1 AS `cluster_short_name`,
 1 AS `cluster_full_name`,
 1 AS `lab_cat_id`,
 1 AS `cat_short_name`,
 1 AS `cat_full_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `useful_tel_category`
--

DROP TABLE IF EXISTS `useful_tel_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `useful_tel_category` (
  `cat_id` int NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `useful_tel_no_delhi`
--

DROP TABLE IF EXISTS `useful_tel_no_delhi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `useful_tel_no_delhi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tel_no_entity` varchar(200) DEFAULT NULL,
  `tel_no` varchar(200) DEFAULT NULL,
  `cat_id` int NOT NULL,
  `last_updated` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_cat_id` (`cat_id`),
  CONSTRAINT `fk_cat_id` FOREIGN KEY (`cat_id`) REFERENCES `telephone_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `useful_tele_no_delhi`
--

DROP TABLE IF EXISTS `useful_tele_no_delhi`;
/*!50001 DROP VIEW IF EXISTS `useful_tele_no_delhi`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `useful_tele_no_delhi` AS SELECT 
 1 AS `tel_id`,
 1 AS `tel_no_entity`,
 1 AS `tel_no`,
 1 AS `cat_name`,
 1 AS `cat_id`*/;
SET character_set_client = @saved_cs_client;




--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) DEFAULT NULL,
  `last_updated` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `zipcode_master`
--

DROP TABLE IF EXISTS `zipcode_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zipcode_master` (
  `id` int NOT NULL AUTO_INCREMENT,
  `zipcode` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '""',
  `city_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_city_id_idx` (`city_id`),
  CONSTRAINT `fk_city_id` FOREIGN KEY (`city_id`) REFERENCES `city_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1737 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Table structure for table `lab_master`
--

DROP TABLE IF EXISTS `lab_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lab_master` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lab_auth_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `lab_short_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `lab_full_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `lab_cat_id` int NOT NULL,
  `lab_city_id` int NOT NULL,
  `lab_cluster_id` int NOT NULL,
  `other_group` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT 'other',
  `last_updated` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` varchar(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '0',
  `viewing_order` int DEFAULT '-1',
  PRIMARY KEY (`id`),
  KEY `fk_lab_cat_id_idx` (`lab_cat_id`),
  KEY `fk_lab_cluster_id_idx` (`lab_cluster_id`),
  KEY `fk_lab_city_id_idx` (`lab_city_id`),
  CONSTRAINT `fk_lab_cat_id` FOREIGN KEY (`lab_cat_id`) REFERENCES `lab_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_lab_city_id` FOREIGN KEY (`lab_city_id`) REFERENCES `city_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_lab_cluster_id` FOREIGN KEY (`lab_cluster_id`) REFERENCES `lab_cluster` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=187 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `std_code_master`
--

DROP TABLE IF EXISTS `std_code_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `std_code_master` (
  `id` int NOT NULL AUTO_INCREMENT,
  `std_code` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `lab_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lab_lab_id_idx` (`lab_id`),
  CONSTRAINT `fk_lab_lab_id` FOREIGN KEY (`lab_id`) REFERENCES `lab_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `lab_region`
--

DROP TABLE IF EXISTS `lab_region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lab_region` (
  `id` int NOT NULL AUTO_INCREMENT,
  `region_short_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `region_full_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='Lab Region/ Zone table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lab_telephone_master`
--

DROP TABLE IF EXISTS `lab_telephone_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lab_telephone_master` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lab_id` int NOT NULL,
  `tele_cat_id` int NOT NULL,
  `std_code_id` int NOT NULL,
  `telephone_number` varchar(45) DEFAULT NULL COMMENT 'EPABX Number',
  `last_updated` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_laboratory_id_idx` (`lab_id`),
  KEY `fk_tel_cat_id_idx` (`tele_cat_id`),
  KEY `fk_stdcode_id_idx` (`std_code_id`),
  CONSTRAINT `fk_laboratory_id` FOREIGN KEY (`lab_id`) REFERENCES `lab_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_std_id` FOREIGN KEY (`std_code_id`) REFERENCES `std_code_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tel_cat_id` FOREIGN KEY (`tele_cat_id`) REFERENCES `telephone_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `lab_id` int DEFAULT NULL,
  `active` varchar(1) NOT NULL,
  `date_of_entry` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_updated` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_lab_id_login_idx` (`lab_id`),
  CONSTRAINT `fk_lab_id_login_idx` FOREIGN KEY (`lab_id`) REFERENCES `lab_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=174 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_assigned_role`
--

DROP TABLE IF EXISTS `user_assigned_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_assigned_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL DEFAULT '0',
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id` (`user_id`),
  KEY `fk_role_id` (`role_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `login` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `login_dropdown_view`
--

DROP TABLE IF EXISTS `login_dropdown_view`;
/*!50001 DROP VIEW IF EXISTS `login_dropdown_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `login_dropdown_view` AS SELECT 
 1 AS `lab_id`,
 1 AS `lab_short_name`,
 1 AS `lab_full_name`,
 1 AS `city_full_name`,
 1 AS `username`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `emp_master`
--

DROP TABLE IF EXISTS `emp_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_master` (
  `id` int NOT NULL AUTO_INCREMENT,
  `emp_title` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `emp_first_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `emp_middle_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `emp_last_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `emp_design_id` int NOT NULL,
  `office_room_no` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `lab_id` int NOT NULL,
  `emp_role_id` int DEFAULT NULL,
  `last_updated` datetime DEFAULT CURRENT_TIMESTAMP,
  `viewing_order` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '-1',
  `addl_design` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '',
  `deleted` varchar(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `emp_design_id_idx` (`emp_design_id`),
  KEY `fk_lab_id_idx` (`lab_id`),
  KEY `fk_emp_role_id` (`emp_role_id`),
  CONSTRAINT `emp_design_id` FOREIGN KEY (`emp_design_id`) REFERENCES `emp_designation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_emp_role_id` FOREIGN KEY (`emp_role_id`) REFERENCES `emp_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE, 
  CONSTRAINT `fk_lab_id` FOREIGN KEY (`lab_id`) REFERENCES `lab_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5103 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `emp_residential_address`
--

DROP TABLE IF EXISTS `emp_residential_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_residential_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `zipcode_id` int NOT NULL,
  `emp_id` int NOT NULL,
  `address_line1` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `address_line2` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `address_line3` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `city_id` int NOT NULL,
  `last_updated` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_emp_id_idx` (`emp_id`),
  KEY `fk_city_id_idx` (`city_id`),
  KEY `fk_zipcode_id_idx` (`zipcode_id`),
  CONSTRAINT `fk_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `emp_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_city_id_idx` FOREIGN KEY (`city_id`) REFERENCES `city_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE, 
  CONSTRAINT `fk_zipcode_id_idx` FOREIGN KEY (`zipcode_id`) REFERENCES `zipcode_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE 
) ENGINE=InnoDB AUTO_INCREMENT=5099 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `emp_mail_master`

DROP TABLE IF EXISTS `emp_mail_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_mail_master` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(200) DEFAULT NULL,
  `mail_cat_id` int NOT NULL,
  `emp_id` int NOT NULL,
  `last_updated` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_mail_cat_id_idx` (`mail_cat_id`),
  KEY `fk_employee_employee_idx` (`emp_id`),
  CONSTRAINT `fk_employee_employee` FOREIGN KEY (`emp_id`) REFERENCES `emp_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_mail_cat_id` FOREIGN KEY (`mail_cat_id`) REFERENCES `mail_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10170 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `emp_telephone_master`
--

DROP TABLE IF EXISTS `emp_telephone_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_telephone_master` (
  `id` int NOT NULL AUTO_INCREMENT,
  `emp_id` int NOT NULL,
  `tele_cat_id` int NOT NULL,
  `telephone_number` varchar(45) DEFAULT '',
  `last_updated` datetime DEFAULT CURRENT_TIMESTAMP,
  `epabx` varchar(45) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `fk_emp_id_idx` (`emp_id`),
  KEY `fk_tel_cat_id_idx` (`tele_cat_id`),
  CONSTRAINT `fk_employee_id` FOREIGN KEY (`emp_id`) REFERENCES `emp_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tel_cat_id_idx` FOREIGN KEY (`tele_cat_id`) REFERENCES `telephone_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12130 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `emp_telephone_office`
--

DROP TABLE IF EXISTS `emp_telephone_office`;
/*!50001 DROP VIEW IF EXISTS `emp_telephone_office`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `emp_telephone_office` AS SELECT 
 1 AS `tel_id`,
 1 AS `emp_id`,
 1 AS `telephone_number`,
 1 AS `epabx`,
 1 AS `last_updated`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `emp_telephone_residence`
--

DROP TABLE IF EXISTS `emp_telephone_residence`;
/*!50001 DROP VIEW IF EXISTS `emp_telephone_residence`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `emp_telephone_residence` AS SELECT 
 1 AS `tel_id`,
 1 AS `emp_id`,
 1 AS `telephone_number`,
 1 AS `epabx`,
 1 AS `last_updated`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `employee_basic_details`
--

DROP TABLE IF EXISTS `employee_basic_details`;
/*!50001 DROP VIEW IF EXISTS `employee_basic_details`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `employee_basic_details` AS SELECT 
 1 AS `emp_id`,
 1 AS `emp_title`,
 1 AS `emp_first_name`,
 1 AS `emp_middle_name`,
 1 AS `emp_last_name`,
 1 AS `viewing_order`,
 1 AS `emp_design_id`,
 1 AS `addl_design`,
 1 AS `design_full_name`,
 1 AS `office_room_no`,
 1 AS `city_id`,
 1 AS `zipcode_id`,
 1 AS `address_line1`,
 1 AS `address_line2`,
 1 AS `address_line3`,
 1 AS `lab_id`,
 1 AS `lab_short_name`,
 1 AS `lab_full_name`,
 1 AS `city_full_name`,
 1 AS `zipcode`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `employee_details`
--

DROP TABLE IF EXISTS `employee_details`;
/*!50001 DROP VIEW IF EXISTS `employee_details`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `employee_details` AS SELECT 
 1 AS `emp_id`,
 1 AS `emp_title`,
 1 AS `emp_first_name`,
 1 AS `emp_middle_name`,
 1 AS `emp_last_name`,
 1 AS `emp_design_id`,
 1 AS `office_room_no`,
 1 AS `address_line1`,
 1 AS `address_line2`,
 1 AS `address_line3`,
 1 AS `city_id`,
 1 AS `zipcode_id`,
 1 AS `lab_id`,
 1 AS `tele_cat_id`,
 1 AS `telephone_number`,
 1 AS `mail_cat_id`,
 1 AS `email`*/;
SET character_set_client = @saved_cs_client;


--
-- Table structure for table `first_pass_change_status`
--

DROP TABLE IF EXISTS `first_pass_change_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `first_pass_change_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login_id` int NOT NULL,
  `last_updated` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_loginId_idx` (`login_id`),
  CONSTRAINT `fk_loginId` FOREIGN KEY (`login_id`) REFERENCES `login` (`id`) ON DELETE CASCADE ON UPDATE CASCADE 
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `forget_password_link_status`
--

DROP TABLE IF EXISTS `forget_password_link_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forget_password_link_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mail_id` varchar(200) DEFAULT NULL,
  `token` varchar(45) DEFAULT NULL,
  `lab_id` int DEFAULT NULL,
  `link_status` varchar(45) DEFAULT 'ACTIVE',
  `date_of_entry` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_lab_id_lab_mastet_idx` (`lab_id`),
  CONSTRAINT `fk_lab_id_lab_mastet_idx` FOREIGN KEY (`lab_id`) REFERENCES `lab_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `forget_password_mail_master`
--

DROP TABLE IF EXISTS `forget_password_mail_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forget_password_mail_master` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mail_id` varchar(100) DEFAULT NULL,
  `lab_id` int DEFAULT NULL,
  `date_of_entry` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `lab_id_UNIQUE` (`lab_id`),
  CONSTRAINT `lab_id_UNIQUE` FOREIGN KEY (`lab_id`) REFERENCES `lab_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lab_address_master`
--

DROP TABLE IF EXISTS `lab_address_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lab_address_master` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lab_id` int NOT NULL,
  `address_line1` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `address_line2` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `address_line3` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `city_id` int NOT NULL,
  `zipcode_id` int NOT NULL,
  `last_updated` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_city_id` (`city_id`),
  KEY `fk_zipcode_id_idx` (`zipcode_id`),
  KEY `fk_lab_id` (`lab_id`),
  CONSTRAINT `fk_city_id_lam` FOREIGN KEY (`city_id`) REFERENCES `city_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_zipcode_id_lam` FOREIGN KEY (`zipcode_id`) REFERENCES `zipcode_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_lab_id_lam` FOREIGN KEY (`lab_id`) REFERENCES `lab_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE 
) ENGINE=InnoDB AUTO_INCREMENT=186 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `lab_and_default_pass`
--

DROP TABLE IF EXISTS `lab_and_default_pass`;
/*!50001 DROP VIEW IF EXISTS `lab_and_default_pass`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `lab_and_default_pass` AS SELECT 
 1 AS `lab_full_name`,
 1 AS `username`,
 1 AS `password`,
 1 AS `lab_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `lab_basic_details`
--

DROP TABLE IF EXISTS `lab_basic_details`;
/*!50001 DROP VIEW IF EXISTS `lab_basic_details`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `lab_basic_details` AS SELECT 
 1 AS `lab_id`,
 1 AS `lab_auth_name`,
 1 AS `lab_short_name`,
 1 AS `lab_full_name`,
 1 AS `lab_cat_id`,
 1 AS `lab_city_id`,
 1 AS `lab_cluster_id`,
 1 AS `std_code_id`,
 1 AS `fax_no`,
 1 AS `fax_cat_id`*/;
SET character_set_client = @saved_cs_client;


--
-- Table structure for table `lab_epabx_master`
--

DROP TABLE IF EXISTS `lab_epabx_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lab_epabx_master` (
  `id` int NOT NULL AUTO_INCREMENT,
  `epabx` varchar(45) DEFAULT NULL,
  `did_no` varchar(45) DEFAULT NULL,
  `lab_id` int NOT NULL,
  `last_updated` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_lab_idx` (`lab_id`),
  CONSTRAINT `fk_lab_idx_ep` FOREIGN KEY (`lab_id`) REFERENCES `lab_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE 
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `lab_fax_master`
--

DROP TABLE IF EXISTS `lab_fax_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lab_fax_master` (
  `id` int NOT NULL AUTO_INCREMENT,
  `std_code_id` int NOT NULL,
  `fax_no` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `lab_id` int NOT NULL,
  `fax_cat_id` int NOT NULL,
  `last_updated` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_lab_id_idx` (`lab_id`),
  KEY `fk_std_code_id_idx` (`std_code_id`),
  KEY `fk_fax_cat_id` (`fax_cat_id`),
  CONSTRAINT `fk_lab_id_idx_fx` FOREIGN KEY (`lab_id`) REFERENCES `lab_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_std_code_id_fx` FOREIGN KEY (`std_code_id`) REFERENCES `std_code_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_fax_cat_id_fx` FOREIGN KEY (`fax_cat_id`) REFERENCES `lab_fax_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=218 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `lab_header`
--

DROP TABLE IF EXISTS `lab_header`;
/*!50001 DROP VIEW IF EXISTS `lab_header`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `lab_header` AS SELECT 
 1 AS `lab_id`,
 1 AS `lab_auth_name`,
 1 AS `lab_short_name`,
 1 AS `lab_full_name`,
 1 AS `lab_epbx_id`,
 1 AS `lab_fax_id`*/;
SET character_set_client = @saved_cs_client;

