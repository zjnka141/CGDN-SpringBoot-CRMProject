-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: codegym_crm
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `accounts` (
  `id` varchar(40) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(45) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13  8:36:05
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: codegym_crm
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `campaigns`
--

DROP TABLE IF EXISTS `campaigns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `campaigns` (
  `id` varchar(36) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` longtext,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `deleted` bit(1) NOT NULL,
  `start_day` date NOT NULL,
  `end_day` date NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campaigns`
--

LOCK TABLES `campaigns` WRITE;
/*!40000 ALTER TABLE `campaigns` DISABLE KEYS */;
INSERT INTO `campaigns` VALUES ('01f68877-a8b5-4570-8872-c462a377bda5','Da Nang','Da Nang dep qua',NULL,'2019-04-27 20:53:20','2019-05-02 09:49:13',NULL,2,_binary '','2019-04-03','2019-04-18','01695650107'),('03206ad7-3472-433e-873e-7199e9d5f6f4','Chien dich Thang loi','ok',NULL,'2019-05-03 08:38:11','2019-05-07 16:41:46',NULL,2,_binary '','2019-05-23','2019-05-23','0905345562'),('086adb05-16b5-4e40-bfd9-1583fa13f020','Chien dịch','mô tả',NULL,'2019-05-09 15:19:30','2019-05-09 16:30:43',NULL,2,_binary '','2019-05-04','2019-05-16','0121692553'),('092a4724-a329-49c9-85e9-e67334bd499b','book','sdfafa',NULL,'2019-05-03 19:29:26','2019-05-08 08:26:13',NULL,2,_binary '','2019-05-14','2019-05-09','0121629577'),('0ecb913c-c691-4c64-a82f-a48519f36ec2','sda','adasd',NULL,'2019-05-02 11:45:47','2019-05-08 15:24:26',NULL,2,_binary '','2019-05-08','2019-05-15','adad'),('0f696945-7e35-43a2-90c7-50075c351d30','ada','áda',NULL,'2019-05-02 11:48:14','2019-05-03 19:33:25',NULL,2,_binary '','2019-05-08','2019-05-15','áda'),('12f0b424-026f-4b03-b4f5-04c76ebb8979','d','d',NULL,'2019-05-02 09:44:51','2019-05-08 13:35:08',NULL,2,_binary '','2019-05-01','2019-05-17',''),('167f6a30-8a6a-4c59-9207-da50122ecb88','nbfgbdf','dhfbd',NULL,'2019-05-02 10:43:30','2019-05-08 15:18:07',NULL,2,_binary '','2019-05-07','2019-05-15','dgdfg'),('1bc1eed1-7cc2-4e93-87db-3bb5bb6b11a8','dgdfgh','ghfgb',NULL,'2019-05-02 10:43:47','2019-05-08 13:36:11',NULL,2,_binary '','2019-05-14','2019-05-15','xcvs'),('1d94658b-436b-4a64-84e8-57f8ae3cd983','dfsdgdsff','fsfsfsfs',NULL,'2019-05-02 10:42:59','2019-05-08 13:35:14',NULL,2,_binary '','2019-05-08','2019-05-17','fs'),('26bf50fa-b08a-4fb8-8cf8-7a51360ae511','c','abc',NULL,'2019-05-02 09:43:03','2019-05-02 17:26:31',NULL,3,_binary '','2019-05-08','2019-05-25','01695650107'),('2b5a4f3f-5897-4fa2-b577-f526ec31ddc7','chua co','chưa cần thêm chiến dịch',NULL,'2019-04-26 08:53:45','2019-05-02 09:48:43',NULL,2,_binary '','2019-04-03','2019-04-10','01695650107'),('2eb649ac-3787-4efa-83ee-bab65dffa25f','Chien dich 234','',NULL,'2019-05-17 09:32:46','2019-05-17 09:32:46',NULL,1,_binary '\0','2019-05-09','2019-05-24','0123456789'),('3350aaed-fcf1-4734-abc1-57cf1de129d1','gdfgđgdf','dgd',NULL,'2019-05-02 10:43:15','2019-05-08 15:18:03',NULL,2,_binary '','2019-05-01','2019-05-16','bdfbd'),('359b83f5-2a02-4c6f-9540-8ff3e4b9c302','Chien dich Thang loi','',NULL,'2019-05-10 09:16:32','2019-05-10 09:16:55',NULL,2,_binary '','2019-05-08','2019-05-07','0121629577'),('40a3672c-fe2a-4db1-ac4e-e619e0a3c3a6','a','câc',NULL,'2019-05-02 11:38:37','2019-05-03 19:29:40',NULL,2,_binary '','2019-05-08','2019-05-15','ádasd'),('4f2c7c50-1dd3-4dee-bf3a-672137dd4dd9','Da nag','Dep qua hihi',NULL,'2019-04-27 17:18:18','2019-04-27 17:25:13',NULL,2,_binary '','2019-04-09','2019-04-05','01695650107'),('54a308d4-8cff-4e1b-be88-271ba54eaaba','Quang Nam','Quang nam que huong toi',NULL,'2019-04-27 20:38:58','2019-04-27 20:59:22',NULL,2,_binary '','2019-04-03','2019-04-18','01695650107'),('620d38ed-5783-45ef-95e0-2271462281ff','sdvsdv','dfvdfv',NULL,'2019-05-02 10:44:09','2019-05-08 16:38:38',NULL,2,_binary '','2019-05-15','2019-05-22','sfsdf'),('64504244-5090-4188-8a15-4eec76026568','book','abc',NULL,'2019-05-03 08:56:38','2019-05-08 13:35:04',NULL,2,_binary '','2019-05-16','2019-05-22','0121629577'),('6df23555-575a-4df3-b665-0fe7ae375e83','Truong Tan Hai','Sinh vien',NULL,'2019-05-08 16:10:48','2019-05-08 17:08:37',NULL,2,_binary '','2019-05-16','2019-05-16','0123456789'),('76629a2c-d88c-4a59-a8d3-340c66ecbce9','Da Nang','Dan Nag xinh dep',NULL,'2019-04-27 20:43:28','2019-04-27 20:52:53',NULL,2,_binary '','2019-04-10','2019-04-18','01695650107'),('837dfd9a-1add-44bc-b178-3ed8e1b1910e','Quang Nam','',NULL,'2019-05-10 09:16:49','2019-05-14 11:10:18',NULL,2,_binary '','2019-05-16','2019-05-08','0905345562'),('8c191d09-7d5c-4bb8-b514-743bc51254c0','finish','Hoan thành campaign',NULL,'2019-05-07 14:19:49','2019-05-07 15:29:22',NULL,2,_binary '','2000-02-02','2000-03-20','0169565010'),('8f3d4755-14a3-4fcd-a056-dca652f78ba8','ada','adas',NULL,'2019-05-02 11:41:25','2019-05-07 14:58:36',NULL,2,_binary '','2019-05-08','2019-05-15','ádasd'),('9df71f50-55a2-4501-9bdc-15c6b72b0bdf','book','',NULL,'2019-05-09 16:05:10','2019-05-09 16:22:46',NULL,2,_binary '','2019-05-23','2019-05-23','0121629577'),('a2530184-b4cb-4e1e-809d-6eac6f6aa848','e','f',NULL,'2019-05-02 09:51:09','2019-05-08 13:36:22',NULL,2,_binary '','2019-05-08','2019-05-15','adad'),('af546da6-dafc-4192-913e-de895fdf20bb','e','abc',NULL,'2019-05-02 09:50:28','2019-05-08 15:18:00',NULL,2,_binary '','2019-05-08','2019-05-16','adad'),('b760b450-843d-4ef0-a53b-4d737b9c13d4','Chiến Dịch 1','abc',NULL,'2019-05-14 11:11:23','2019-05-17 09:28:42',NULL,2,_binary '','2019-05-02','2019-05-09','0121629577'),('bb107908-2b25-4b49-9a85-8fdfd54a2d29','Chien dich toan cau abc','Pho bien qua anh em oi. hihi.',NULL,'2019-04-24 15:50:38','2019-04-24 16:44:50',NULL,4,_binary '','2019-04-03','2019-04-20','01695650107123'),('c3023e12-1872-4108-8417-4b1ab2eff3e9','dsfas','dsc',NULL,'2019-05-02 17:26:06','2019-05-08 13:36:15',NULL,2,_binary '','2019-04-30','2019-05-08','0121629577'),('c5c3e0b1-ccdc-443a-8a96-090b72f1e249','null','campaign null',NULL,'2019-05-02 09:47:12','2019-05-08 15:18:17',NULL,2,_binary '','2019-05-08','2019-05-16','01695650107'),('c7e83730-3afe-4063-9c27-3d82d1eb8647','Da nag','Dep qua hihi',NULL,'2019-04-27 17:18:28','2019-04-27 17:38:35',NULL,2,_binary '','2019-04-09','2019-04-05','01695650107'),('ce69078a-b7de-44e0-8424-cc0b5748cadd','Quang Nam','Quang Nam que toi qua dep\r\n',NULL,'2019-04-27 20:29:45','2019-04-27 20:30:45',NULL,4,_binary '','2019-04-11','2019-04-12','01695650107'),('cf784544-23ab-442f-aa0f-ddcd868e1942','a','abc',NULL,'2019-05-02 09:50:48','2019-05-03 10:03:03',NULL,4,_binary '','2019-05-08','2019-05-16','0905345562'),('d1019be5-e45e-4339-b891-695584d26e9c','book','đá',NULL,'2019-05-02 11:58:01','2019-05-08 13:34:47',NULL,3,_binary '','2019-05-08','2019-05-16','01216295776'),('d328a632-51f0-44ac-9c51-42f5e7239cdc','Quang Nam','Thanh pho than thuong',NULL,'2019-04-24 16:49:43','2019-04-27 17:38:53',NULL,2,_binary '','2019-04-10','2019-04-05','076567899'),('d32d76f2-f507-4032-8402-7744a3469467','book','',NULL,'2019-05-09 16:38:44','2019-05-09 17:01:28',NULL,2,_binary '','2019-05-18','2019-05-15','0121629577'),('daef3f35-bf52-4ca4-a8e3-8cd1eb4ed5c1','bc','bc',NULL,'2019-05-02 09:43:57','2019-05-07 16:41:30',NULL,2,_binary '','2019-05-08','2019-05-16','adada'),('e1ed49fc-0306-4ea1-8ebc-5e6078623d95','abcjkg','abc',NULL,'2019-05-02 10:57:51','2019-05-03 19:33:01',NULL,3,_binary '','2019-05-09','2019-05-08','0123245678'),('e727c7e4-96b1-471d-b117-c94ccab6af0c','Truong Tan Hai','',NULL,'2019-05-08 17:09:02','2019-05-10 09:15:48',NULL,3,_binary '','2019-05-10','2019-05-20','0121629577'),('f7692fdd-997b-4fbd-a943-449da4e30766','a','abcsndaslfhkasjdf.hasd;fsadjgsa/fADF;DSIAGYHSDIAJF/F\r\nasfjsadklfasj.fbas.djfdferfeasfa\r\nFNSADFNSDAJKF',NULL,'2019-05-02 09:50:48','2019-05-03 19:29:36',NULL,7,_binary '','2019-05-08','2019-05-16','0905345563');
/*!40000 ALTER TABLE `campaigns` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13  8:36:04
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: codegym_crm
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `classes` (
  `id` varchar(40) NOT NULL,
  `name` varchar(45) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `start_day` datetime DEFAULT NULL,
  `end_day` datetime DEFAULT NULL,
  `learning_status` varchar(45) DEFAULT NULL,
  `total_student` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_classes_courses1_idx` (`product_id`),
  CONSTRAINT `fk_classes_courses1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES ('15c9dcf1-45cc-4a39-88db-221ce0c2e2a2','C2019H11',NULL,NULL,NULL,NULL,6,'1',_binary '','2019-06-14 00:00:00','2019-06-15 00:00:00','Learning',NULL),('15fd40b1-0417-4990-904a-4630a6fe6fe2','C2019H1',NULL,NULL,NULL,NULL,6,'1',_binary '','2019-06-06 00:00:00','2019-06-14 00:00:00','Learning',NULL),('20de5131-7260-4cc5-b519-eff4c8e856b8','C2019H11',NULL,NULL,NULL,NULL,2,'2',_binary '','2019-06-21 00:00:00','2019-06-20 00:00:00','Learning',NULL),('88509304-9567-4b70-a530-1d4c39933724','C2019H11',NULL,NULL,NULL,NULL,3,'3',_binary '','2019-06-12 00:00:00','2019-06-14 00:00:00','Graduated',NULL),('b23f119d-eed6-4360-9062-a70300f67373','C2019H11abc',NULL,NULL,NULL,NULL,11,'2',_binary '\0','2019-06-14 00:00:00','2019-06-19 00:00:00','Learning',NULL);
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13  8:36:04
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: codegym_crm
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `leads`
--

DROP TABLE IF EXISTS `leads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `leads` (
  `id` varchar(36) NOT NULL,
  `product` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `source` varchar(45) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `admission_date` datetime DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `deleted` bit(1) NOT NULL,
  `campaigns_id` varchar(36) DEFAULT NULL,
  `last_update_status_date` datetime DEFAULT NULL,
  `job` varchar(45) DEFAULT NULL,
  `gender` varchar(45) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_leads_campaigns1_idx` (`campaigns_id`),
  CONSTRAINT `fk_leads_campaigns1` FOREIGN KEY (`campaigns_id`) REFERENCES `campaigns` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leads`
--

LOCK TABLES `leads` WRITE;
/*!40000 ALTER TABLE `leads` DISABLE KEYS */;
INSERT INTO `leads` VALUES ('0b873a45-1c4d-4aaa-9231-702d05ab18d4','Bootcamp Java Fulltime','Quang Nam','0121629577','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-16 14:46:45','2019-05-17 09:15:05',NULL,'2019-05-08 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-07 00:00:00','Sinh vien','Male','G0'),('11137888-665d-4f6b-b454-c4bc90421b74','Bootcamp Java Fulltime','Truong Tan Hai','0905345562','zitxiem1998@gmail.com','Cong nghe thong tin',NULL,'2019-05-07 17:07:37','2019-05-07 17:35:42',NULL,'2019-05-17 00:00:00',3,_binary '','092a4724-a329-49c9-85e9-e67334bd499b','2019-05-10 00:00:00','Sinh vien','Male','G1'),('28e3557b-21a1-43e4-b390-2f1f9fde6b3a','Bootcamp Java Fulltime','Dang Thi Nga','0123456789','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-15 17:21:49','2019-05-16 17:32:08',NULL,'2019-05-10 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-03 00:00:00','Sinh vien','Male','G0'),('2a4d327f-dd28-42e9-9465-7f1862f51bf2','abc','longoccho','121629577abc','zitxiem1998@gmail.com','Công nghẹ thông tin',NULL,'2019-05-17 16:40:40','2019-05-17 16:40:40',NULL,'2019-05-12 00:00:00',1,_binary '\0','2eb649ac-3787-4efa-83ee-bab65dffa25f','2019-02-05 00:00:00','Sinh vien ngheo','male','G0'),('46a940d3-782b-4292-b646-8fcdd247b8d1','Bootcamp Java Fulltime','Truong Tan Hai','0123456789','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-15 17:40:24','2019-05-17 09:15:24',NULL,'2019-05-17 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-16 00:00:00','Sinh vien','Male','G0'),('49cecfb1-a32a-4bcf-af65-0dd7c6610474','BootcampJavaFulltime','bookabc','0123456789','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-15 17:40:51','2019-05-16 17:32:04',NULL,'2019-05-17 00:00:00',3,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-10 00:00:00','Sinh vien','Male','G0'),('59329443-5853-4a0c-96af-a38a8453db6f','Bootcamp Java Fulltime','Truong Tan Hai','0121629577','vunv@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-13 16:56:45','2019-05-13 17:00:30',NULL,'2019-05-07 00:00:00',2,_binary '',NULL,'2019-05-08 00:00:00','Sinh vien','Male','G1'),('5b9beca7-ad5f-4d77-bff8-6ed9d9ba9963','BootcampJavaFulltime','name','0121629577','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-16 14:45:52','2019-05-17 09:15:02',NULL,'2019-05-22 00:00:00',7,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-06 00:00:00','Sinh vien','Male','G0'),('5e5d0147-c3a6-482b-b12e-890fbc9a393f','Bootcamp Java Fulltime','Truong Tan Hai','0123456789','zitxiem1998@gmail.com','fsadf',NULL,'2019-05-15 16:53:46','2019-05-17 09:15:27',NULL,'2019-05-16 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-16 00:00:00','Sinh vien','Male','G0'),('65c6f423-cd5b-4129-b1a1-ef923cf89d2c','Bootcamp Java Fulltime','Quang Nam','0123456789','zitxiem1998@gmail.com','fsadf',NULL,'2019-05-16 14:47:22','2019-05-17 09:15:09',NULL,'2019-05-21 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-06 00:00:00','Sinh vien','Male','G0'),('770c24f1-571f-498b-9114-bcaba2443e9d','Bootcamp Java Fulltime','Quang Nam','0121629577','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-17 15:57:55','2019-05-17 15:57:55',NULL,'2019-05-21 00:00:00',1,_binary '\0','2eb649ac-3787-4efa-83ee-bab65dffa25f','2019-05-07 00:00:00','Sinh vien','Male','G0'),('820ab426-f777-4c1c-b246-a74f3ce2db32','BootcampJavaFulltime','Truong Tan Hai','0905345562','zitxiem1998@gmail.com','Cong nghe thong tin',NULL,'2019-05-10 16:36:29','2019-05-13 16:48:21',NULL,'2019-05-09 00:00:00',4,_binary '',NULL,'2019-05-08 00:00:00','Sinh vien','Male','G2'),('82977de5-fb57-4e26-880f-71808c38779b','AcceleratorPHP','avccccsvsdfsdadasd','0905345562','vunv@gmail.comabca','CONG NGHE THONG TIN',NULL,'2019-05-17 09:55:59','2019-05-17 11:16:25',NULL,'2019-05-15 00:00:00',3,_binary '','2eb649ac-3787-4efa-83ee-bab65dffa25f','2019-05-21 00:00:00','Sinh vien','Male','G0'),('84e72532-9d4b-4123-b821-57498c85120e','BootcampJavaFulltime','Truong Tan Hai','0123456789','abc@codgym.vnhgv','CONG NGHE THONG TIN',NULL,'2019-05-14 11:16:07','2019-05-14 11:20:47',NULL,'2019-05-09 00:00:00',3,_binary '',NULL,'2019-05-24 00:00:00','Sinh vien','Male','G1'),('87a9915a-b4e1-4ba4-ae33-b80e5c2fee63','abc','Haiabc','121629577abc','zitxiem1998@gmail.com','Công nghẹ thông tin',NULL,'2019-05-17 16:28:48','2019-05-17 16:28:48',NULL,'2019-05-12 00:00:00',1,_binary '\0','2eb649ac-3787-4efa-83ee-bab65dffa25f','2019-02-05 00:00:00','Sinh vien ngheo','male','G0'),('8b814fef-cebf-41ee-87f6-f8fc2480de7f','Bootcamp Java Fulltime','book','0121629577','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-16 14:46:20','2019-05-16 17:31:57',NULL,'2019-05-15 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-13 00:00:00','Sinh vien','Male','G0'),('8d401372-6fa1-4096-994b-d66004c915b9','Bootcamp Java Fulltime','abcccccc','0121629577','abc@codgym.vn','CONG NGHE THONG TIN',NULL,'2019-05-17 09:16:00','2019-05-17 09:28:42',NULL,'2019-05-14 00:00:00',2,_binary '\0',NULL,'2019-05-07 00:00:00','Sinh vien','Male','G0'),('a59ae6ab-a2af-40b9-9e3e-3f23f2da428c','BootcampJavaFulltime','Truong Tan Haiádasd','0905345562','vunv@fpt.gmail.com','Cong nghe thong tin',NULL,'2019-05-07 17:06:01','2019-05-07 17:06:16',NULL,'2019-05-09 00:00:00',3,_binary '',NULL,'2019-05-03 00:00:00','Sinh vien','Male','G1'),('acfb29a4-8cea-4206-9909-64234f30f306','Bootcamp Java Fulltime','book','0123456789','zitxiem1998@gmail.com','fsadfádasd',NULL,'2019-05-07 17:21:42','2019-05-07 17:34:47',NULL,'2019-05-16 00:00:00',2,_binary '',NULL,'2019-05-08 00:00:00','Sinh vien','Male','G1'),('baa6a720-4791-40e8-9d73-77b58af15817','abc','Thangabc','121629577abc','zitxiem1998@gmail.com','Công nghẹ thông tin',NULL,'2019-05-17 17:02:25','2019-05-17 17:02:25',NULL,'2019-05-12 00:00:00',1,_binary '\0','2eb649ac-3787-4efa-83ee-bab65dffa25f','2019-02-05 00:00:00','Sinh vien ngheo','male','G0'),('bddf7d90-6a17-4cd2-a9fa-1d6e19cf263f','Bootcamp Java Fulltime','Dang Thi Nga','0123456789','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-15 17:31:48','2019-05-16 17:32:12',NULL,'2019-05-10 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-03 00:00:00','Sinh vien','Male','G0'),('be8f6b75-885d-4207-8f3b-ee299c41e460','Bootcamp Java Fulltime','Truong Tan Hoa','0123456789','zitxiem1998@gmail.com','Y bac si',NULL,'2019-05-15 16:48:32','2019-05-15 16:59:06',NULL,'2019-05-08 00:00:00',2,_binary '',NULL,'2019-05-09 00:00:00','Sinh vien','Male','G0'),('bf9af195-0ed7-4f67-b8cb-a53e49e84478','Bootcamp Java Fulltime','abcderr','0905345562','vunv@fpt.gmail.com','Y bac si',NULL,'2019-05-17 09:37:39','2019-05-17 09:38:03',NULL,'2019-05-23 00:00:00',2,_binary '','2eb649ac-3787-4efa-83ee-bab65dffa25f','2019-05-07 00:00:00','Sinh vien','Male','G0'),('d55aea3e-a5e6-4b6e-aca6-d6bbbc3b7ef7','Bootcamp Java Fulltime','dsfsd','0123456789','sdfsdfsdf@gmail.com','fsadf',NULL,'2019-05-14 11:29:38','2019-05-14 11:29:38',NULL,'2019-05-25 00:00:00',1,_binary '\0',NULL,'2019-05-14 00:00:00','Sinh vien','Male','G1'),('d5e98282-b626-4066-b171-755749561170','Bootcamp Java Fulltime','Truong Tan Em','0123456789','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-15 16:58:22','2019-05-17 09:15:13',NULL,'2019-05-15 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-03 00:00:00','Sinh vien','Male','G0'),('d655b35d-900e-4401-85ae-e6f3ffb219cf','abc','longoccho','121629577abc','zitxiem1998@gmail.com','Công nghẹ thông tin',NULL,'2019-05-17 16:39:27','2019-05-17 16:39:27',NULL,'2019-05-12 00:00:00',1,_binary '\0','2eb649ac-3787-4efa-83ee-bab65dffa25f','2019-02-05 00:00:00','Sinh vien ngheo','male','G0'),('d74329de-78a0-47d2-a1b3-4fa02706fd9f','Bootcamp Java Fulltime','Truong Tan Hai','0123456789','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-15 17:39:44','2019-05-17 09:15:30',NULL,'2019-05-17 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-16 00:00:00','Sinh vien','Male','G0'),('d7dcb2fc-3c20-4ac1-886a-6ec72f8e570a','Bootcamp Java Fulltime','Truong Tan Hai','0905345562','zitxiem1998@gmail.com','Cong nghe thong tin',NULL,'2019-05-08 10:12:13','2019-05-09 16:11:04',NULL,'2019-05-10 00:00:00',7,_binary '','e727c7e4-96b1-471d-b117-c94ccab6af0c','2019-05-03 00:00:00','Sinh vien','Male','G1'),('e6f6fbb8-8383-406e-88b7-7dd2b7860b71','Bootcamp Java Fulltime','Truong Tan Hai','0123456789','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-15 16:47:15','2019-05-15 16:59:13',NULL,'2019-05-09 00:00:00',2,_binary '',NULL,'2019-05-09 00:00:00','Sinh vien','Male','G0'),('ec72f75a-0edd-43fc-8412-d08d203cdf94','abc','Haiabc','121629577abc','zitxiem1998@gmail.com','Công nghẹ thông tin',NULL,'2019-05-17 16:07:14','2019-05-17 16:07:14',NULL,'2019-05-12 00:00:00',1,_binary '\0','2eb649ac-3787-4efa-83ee-bab65dffa25f','2019-02-05 00:00:00','Sinh vien ngheo','male','G0'),('ee94c424-0d0b-4409-809b-3627f18fe832','Bootcamp Java Fulltime','Truong Tan Hai','0121629577','zitxiem1998@gmail.com','Chien dich 234',NULL,'2019-05-17 11:17:11','2019-05-17 11:27:33',NULL,'2019-05-23 00:00:00',2,_binary '\0',NULL,'2019-05-17 00:00:00','Sinh vien','Male','G1'),('f93cb766-815d-45a9-a57c-c7de96764d30','Bootcamp Java Fulltime','accccccccccccccccccccccccccc','0905345562','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-17 09:27:55','2019-05-17 09:28:42',NULL,'2019-05-14 00:00:00',2,_binary '\0',NULL,'2019-05-14 00:00:00','Sinh vien','Male','G0'),('fa100394-9121-45c1-9a6a-529d70dd4af6','Bootcamp Java Fulltime','Truong Tan Em','0121629577','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-17 09:00:53','2019-05-17 09:15:18',NULL,'2019-05-21 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-06 00:00:00','Sinh vien','Male','G0'),('fe172c80-9585-4463-a76f-ddc375d68b26','Accelerator PHP','Truong Tan Hai','0905345562','zitxiem1998@gmail.com','Cong nghe thong tin',NULL,'2019-05-08 08:17:13','2019-05-10 16:30:04',NULL,'2019-05-10 00:00:00',8,_binary '',NULL,'2019-05-10 00:00:00','Sinh vien','Female','G3');
/*!40000 ALTER TABLE `leads` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13  8:36:04
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: codegym_crm
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `lead_detail`
--

DROP TABLE IF EXISTS `lead_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lead_detail` (
  `id` varchar(45) NOT NULL,
  `leads_id` varchar(45) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `last_update_lead_detail_date` datetime DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `last_updated_by` varchar(45) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `version` bigint(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lead_detail_leads1_idx` (`leads_id`),
  CONSTRAINT `fk_lead_detail_leads1` FOREIGN KEY (`leads_id`) REFERENCES `leads` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lead_detail`
--

LOCK TABLES `lead_detail` WRITE;
/*!40000 ALTER TABLE `lead_detail` DISABLE KEYS */;
INSERT INTO `lead_detail` VALUES ('2fdd2816-c44a-47d1-aa7f-a695c27f9610','59329443-5853-4a0c-96af-a38a8453db6f','G1','2019-05-07 00:00:00','abc','anbc',NULL,'2019-05-13 16:57:04','2019-05-13 16:57:04',1),('b653af50-78d3-4e41-9af2-0abeba24bb11','84e72532-9d4b-4123-b821-57498c85120e','G2','2019-05-10 00:00:00','abc','van',NULL,'2019-05-14 11:17:08','2019-05-14 11:17:08',1),('b655c581-9d8c-4798-9dd9-e2af1036496d','84e72532-9d4b-4123-b821-57498c85120e','G2','2019-05-10 00:00:00','abc','van',NULL,'2019-05-14 11:17:08','2019-05-14 11:17:08',1),('c75df59b-aaf1-4da7-9f28-b11fd0e489d8','84e72532-9d4b-4123-b821-57498c85120e','G2','2019-05-10 00:00:00','abc','van',NULL,'2019-05-14 11:17:09','2019-05-14 11:17:09',1);
/*!40000 ALTER TABLE `lead_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13  8:36:05
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: codegym_crm
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `products` (
  `id` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `deleted` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('076da022-2e69-422d-a613-5817fc084c6b',NULL,'2019-05-07 15:25:28','2019-05-13 15:58:16',NULL,2,_binary '','Quang Nam','2019-05-08 00:00:00'),('1',NULL,'2019-04-23 15:41:41','2019-05-07 15:25:41',NULL,4,_binary '','Course 55','2019-01-21 00:00:00'),('2',NULL,'2019-04-23 15:43:02','2019-05-13 15:58:09',NULL,3,_binary '\0','Course 5','2019-01-21 00:00:00'),('3',NULL,'2019-04-23 15:54:52','2019-04-23 15:54:52',NULL,1,_binary '\0','Course 7','2019-01-21 00:00:00'),('58197b3a-8eae-435b-8586-d86591e089e3',NULL,'2019-05-03 19:30:40','2019-05-13 15:58:23',NULL,2,_binary '','Da Nang','2019-01-21 00:00:00'),('a8b452f1-ee8e-4837-b4f2-13a4bf8a4de4',NULL,'2019-05-02 17:20:40','2019-05-03 19:30:44',NULL,2,_binary '','book','2019-01-21 00:00:00'),('c19b631b-3fcb-421d-9b58-c1201c51aa1e',NULL,'2019-05-03 16:46:40','2019-05-03 16:46:51',NULL,3,_binary '','Quang Namsadasd','0000-00-00 00:00:00'),('c353f667-5a60-4ad8-bcf9-659c3f58d488',NULL,'2019-05-14 11:08:15','2019-05-14 11:08:27',NULL,3,_binary '','codeGym_BootCamp2','2019-05-03 00:00:00'),('f44abf55-e004-4a15-abba-2a78ec2b807e',NULL,'2019-04-24 14:57:24','2019-05-02 17:19:01',NULL,2,_binary '','book','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13  8:36:05
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: codegym_crm
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `students` (
  `id` varchar(36) NOT NULL,
  `name` varchar(50) NOT NULL,
  `birthday` date DEFAULT NULL,
  `gender` varchar(10) NOT NULL,
  `classes_id` varchar(40) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `deleted` bit(1) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) NOT NULL,
  `student_status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_students_classes1_idx` (`classes_id`),
  CONSTRAINT `fk_students_classes1` FOREIGN KEY (`classes_id`) REFERENCES `classes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13  8:36:05
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: codegym_crm
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `accounts` (
  `id` varchar(40) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(45) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13  8:36:05
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: codegym_crm
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `campaigns`
--

DROP TABLE IF EXISTS `campaigns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `campaigns` (
  `id` varchar(36) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` longtext,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `deleted` bit(1) NOT NULL,
  `start_day` date NOT NULL,
  `end_day` date NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campaigns`
--

LOCK TABLES `campaigns` WRITE;
/*!40000 ALTER TABLE `campaigns` DISABLE KEYS */;
INSERT INTO `campaigns` VALUES ('01f68877-a8b5-4570-8872-c462a377bda5','Da Nang','Da Nang dep qua',NULL,'2019-04-27 20:53:20','2019-05-02 09:49:13',NULL,2,_binary '','2019-04-03','2019-04-18','01695650107'),('03206ad7-3472-433e-873e-7199e9d5f6f4','Chien dich Thang loi','ok',NULL,'2019-05-03 08:38:11','2019-05-07 16:41:46',NULL,2,_binary '','2019-05-23','2019-05-23','0905345562'),('086adb05-16b5-4e40-bfd9-1583fa13f020','Chien dịch','mô tả',NULL,'2019-05-09 15:19:30','2019-05-09 16:30:43',NULL,2,_binary '','2019-05-04','2019-05-16','0121692553'),('092a4724-a329-49c9-85e9-e67334bd499b','book','sdfafa',NULL,'2019-05-03 19:29:26','2019-05-08 08:26:13',NULL,2,_binary '','2019-05-14','2019-05-09','0121629577'),('0ecb913c-c691-4c64-a82f-a48519f36ec2','sda','adasd',NULL,'2019-05-02 11:45:47','2019-05-08 15:24:26',NULL,2,_binary '','2019-05-08','2019-05-15','adad'),('0f696945-7e35-43a2-90c7-50075c351d30','ada','áda',NULL,'2019-05-02 11:48:14','2019-05-03 19:33:25',NULL,2,_binary '','2019-05-08','2019-05-15','áda'),('12f0b424-026f-4b03-b4f5-04c76ebb8979','d','d',NULL,'2019-05-02 09:44:51','2019-05-08 13:35:08',NULL,2,_binary '','2019-05-01','2019-05-17',''),('167f6a30-8a6a-4c59-9207-da50122ecb88','nbfgbdf','dhfbd',NULL,'2019-05-02 10:43:30','2019-05-08 15:18:07',NULL,2,_binary '','2019-05-07','2019-05-15','dgdfg'),('1bc1eed1-7cc2-4e93-87db-3bb5bb6b11a8','dgdfgh','ghfgb',NULL,'2019-05-02 10:43:47','2019-05-08 13:36:11',NULL,2,_binary '','2019-05-14','2019-05-15','xcvs'),('1d94658b-436b-4a64-84e8-57f8ae3cd983','dfsdgdsff','fsfsfsfs',NULL,'2019-05-02 10:42:59','2019-05-08 13:35:14',NULL,2,_binary '','2019-05-08','2019-05-17','fs'),('26bf50fa-b08a-4fb8-8cf8-7a51360ae511','c','abc',NULL,'2019-05-02 09:43:03','2019-05-02 17:26:31',NULL,3,_binary '','2019-05-08','2019-05-25','01695650107'),('2b5a4f3f-5897-4fa2-b577-f526ec31ddc7','chua co','chưa cần thêm chiến dịch',NULL,'2019-04-26 08:53:45','2019-05-02 09:48:43',NULL,2,_binary '','2019-04-03','2019-04-10','01695650107'),('2eb649ac-3787-4efa-83ee-bab65dffa25f','Chien dich 234','',NULL,'2019-05-17 09:32:46','2019-05-17 09:32:46',NULL,1,_binary '\0','2019-05-09','2019-05-24','0123456789'),('3350aaed-fcf1-4734-abc1-57cf1de129d1','gdfgđgdf','dgd',NULL,'2019-05-02 10:43:15','2019-05-08 15:18:03',NULL,2,_binary '','2019-05-01','2019-05-16','bdfbd'),('359b83f5-2a02-4c6f-9540-8ff3e4b9c302','Chien dich Thang loi','',NULL,'2019-05-10 09:16:32','2019-05-10 09:16:55',NULL,2,_binary '','2019-05-08','2019-05-07','0121629577'),('40a3672c-fe2a-4db1-ac4e-e619e0a3c3a6','a','câc',NULL,'2019-05-02 11:38:37','2019-05-03 19:29:40',NULL,2,_binary '','2019-05-08','2019-05-15','ádasd'),('4f2c7c50-1dd3-4dee-bf3a-672137dd4dd9','Da nag','Dep qua hihi',NULL,'2019-04-27 17:18:18','2019-04-27 17:25:13',NULL,2,_binary '','2019-04-09','2019-04-05','01695650107'),('54a308d4-8cff-4e1b-be88-271ba54eaaba','Quang Nam','Quang nam que huong toi',NULL,'2019-04-27 20:38:58','2019-04-27 20:59:22',NULL,2,_binary '','2019-04-03','2019-04-18','01695650107'),('620d38ed-5783-45ef-95e0-2271462281ff','sdvsdv','dfvdfv',NULL,'2019-05-02 10:44:09','2019-05-08 16:38:38',NULL,2,_binary '','2019-05-15','2019-05-22','sfsdf'),('64504244-5090-4188-8a15-4eec76026568','book','abc',NULL,'2019-05-03 08:56:38','2019-05-08 13:35:04',NULL,2,_binary '','2019-05-16','2019-05-22','0121629577'),('6df23555-575a-4df3-b665-0fe7ae375e83','Truong Tan Hai','Sinh vien',NULL,'2019-05-08 16:10:48','2019-05-08 17:08:37',NULL,2,_binary '','2019-05-16','2019-05-16','0123456789'),('76629a2c-d88c-4a59-a8d3-340c66ecbce9','Da Nang','Dan Nag xinh dep',NULL,'2019-04-27 20:43:28','2019-04-27 20:52:53',NULL,2,_binary '','2019-04-10','2019-04-18','01695650107'),('837dfd9a-1add-44bc-b178-3ed8e1b1910e','Quang Nam','',NULL,'2019-05-10 09:16:49','2019-05-14 11:10:18',NULL,2,_binary '','2019-05-16','2019-05-08','0905345562'),('8c191d09-7d5c-4bb8-b514-743bc51254c0','finish','Hoan thành campaign',NULL,'2019-05-07 14:19:49','2019-05-07 15:29:22',NULL,2,_binary '','2000-02-02','2000-03-20','0169565010'),('8f3d4755-14a3-4fcd-a056-dca652f78ba8','ada','adas',NULL,'2019-05-02 11:41:25','2019-05-07 14:58:36',NULL,2,_binary '','2019-05-08','2019-05-15','ádasd'),('9df71f50-55a2-4501-9bdc-15c6b72b0bdf','book','',NULL,'2019-05-09 16:05:10','2019-05-09 16:22:46',NULL,2,_binary '','2019-05-23','2019-05-23','0121629577'),('a2530184-b4cb-4e1e-809d-6eac6f6aa848','e','f',NULL,'2019-05-02 09:51:09','2019-05-08 13:36:22',NULL,2,_binary '','2019-05-08','2019-05-15','adad'),('af546da6-dafc-4192-913e-de895fdf20bb','e','abc',NULL,'2019-05-02 09:50:28','2019-05-08 15:18:00',NULL,2,_binary '','2019-05-08','2019-05-16','adad'),('b760b450-843d-4ef0-a53b-4d737b9c13d4','Chiến Dịch 1','abc',NULL,'2019-05-14 11:11:23','2019-05-17 09:28:42',NULL,2,_binary '','2019-05-02','2019-05-09','0121629577'),('bb107908-2b25-4b49-9a85-8fdfd54a2d29','Chien dich toan cau abc','Pho bien qua anh em oi. hihi.',NULL,'2019-04-24 15:50:38','2019-04-24 16:44:50',NULL,4,_binary '','2019-04-03','2019-04-20','01695650107123'),('c3023e12-1872-4108-8417-4b1ab2eff3e9','dsfas','dsc',NULL,'2019-05-02 17:26:06','2019-05-08 13:36:15',NULL,2,_binary '','2019-04-30','2019-05-08','0121629577'),('c5c3e0b1-ccdc-443a-8a96-090b72f1e249','null','campaign null',NULL,'2019-05-02 09:47:12','2019-05-08 15:18:17',NULL,2,_binary '','2019-05-08','2019-05-16','01695650107'),('c7e83730-3afe-4063-9c27-3d82d1eb8647','Da nag','Dep qua hihi',NULL,'2019-04-27 17:18:28','2019-04-27 17:38:35',NULL,2,_binary '','2019-04-09','2019-04-05','01695650107'),('ce69078a-b7de-44e0-8424-cc0b5748cadd','Quang Nam','Quang Nam que toi qua dep\r\n',NULL,'2019-04-27 20:29:45','2019-04-27 20:30:45',NULL,4,_binary '','2019-04-11','2019-04-12','01695650107'),('cf784544-23ab-442f-aa0f-ddcd868e1942','a','abc',NULL,'2019-05-02 09:50:48','2019-05-03 10:03:03',NULL,4,_binary '','2019-05-08','2019-05-16','0905345562'),('d1019be5-e45e-4339-b891-695584d26e9c','book','đá',NULL,'2019-05-02 11:58:01','2019-05-08 13:34:47',NULL,3,_binary '','2019-05-08','2019-05-16','01216295776'),('d328a632-51f0-44ac-9c51-42f5e7239cdc','Quang Nam','Thanh pho than thuong',NULL,'2019-04-24 16:49:43','2019-04-27 17:38:53',NULL,2,_binary '','2019-04-10','2019-04-05','076567899'),('d32d76f2-f507-4032-8402-7744a3469467','book','',NULL,'2019-05-09 16:38:44','2019-05-09 17:01:28',NULL,2,_binary '','2019-05-18','2019-05-15','0121629577'),('daef3f35-bf52-4ca4-a8e3-8cd1eb4ed5c1','bc','bc',NULL,'2019-05-02 09:43:57','2019-05-07 16:41:30',NULL,2,_binary '','2019-05-08','2019-05-16','adada'),('e1ed49fc-0306-4ea1-8ebc-5e6078623d95','abcjkg','abc',NULL,'2019-05-02 10:57:51','2019-05-03 19:33:01',NULL,3,_binary '','2019-05-09','2019-05-08','0123245678'),('e727c7e4-96b1-471d-b117-c94ccab6af0c','Truong Tan Hai','',NULL,'2019-05-08 17:09:02','2019-05-10 09:15:48',NULL,3,_binary '','2019-05-10','2019-05-20','0121629577'),('f7692fdd-997b-4fbd-a943-449da4e30766','a','abcsndaslfhkasjdf.hasd;fsadjgsa/fADF;DSIAGYHSDIAJF/F\r\nasfjsadklfasj.fbas.djfdferfeasfa\r\nFNSADFNSDAJKF',NULL,'2019-05-02 09:50:48','2019-05-03 19:29:36',NULL,7,_binary '','2019-05-08','2019-05-16','0905345563');
/*!40000 ALTER TABLE `campaigns` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13  8:36:04
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: codegym_crm
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `classes` (
  `id` varchar(40) NOT NULL,
  `name` varchar(45) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `start_day` datetime DEFAULT NULL,
  `end_day` datetime DEFAULT NULL,
  `learning_status` varchar(45) DEFAULT NULL,
  `total_student` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_classes_courses1_idx` (`product_id`),
  CONSTRAINT `fk_classes_courses1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES ('15c9dcf1-45cc-4a39-88db-221ce0c2e2a2','C2019H11',NULL,NULL,NULL,NULL,6,'1',_binary '','2019-06-14 00:00:00','2019-06-15 00:00:00','Learning',NULL),('15fd40b1-0417-4990-904a-4630a6fe6fe2','C2019H1',NULL,NULL,NULL,NULL,6,'1',_binary '','2019-06-06 00:00:00','2019-06-14 00:00:00','Learning',NULL),('20de5131-7260-4cc5-b519-eff4c8e856b8','C2019H11',NULL,NULL,NULL,NULL,2,'2',_binary '','2019-06-21 00:00:00','2019-06-20 00:00:00','Learning',NULL),('88509304-9567-4b70-a530-1d4c39933724','C2019H11',NULL,NULL,NULL,NULL,3,'3',_binary '','2019-06-12 00:00:00','2019-06-14 00:00:00','Graduated',NULL),('b23f119d-eed6-4360-9062-a70300f67373','C2019H11abc',NULL,NULL,NULL,NULL,11,'2',_binary '\0','2019-06-14 00:00:00','2019-06-19 00:00:00','Learning',NULL);
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13  8:36:04
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: codegym_crm
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `leads`
--

DROP TABLE IF EXISTS `leads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `leads` (
  `id` varchar(36) NOT NULL,
  `product` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `source` varchar(45) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `admission_date` datetime DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `deleted` bit(1) NOT NULL,
  `campaigns_id` varchar(36) DEFAULT NULL,
  `last_update_status_date` datetime DEFAULT NULL,
  `job` varchar(45) DEFAULT NULL,
  `gender` varchar(45) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_leads_campaigns1_idx` (`campaigns_id`),
  CONSTRAINT `fk_leads_campaigns1` FOREIGN KEY (`campaigns_id`) REFERENCES `campaigns` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leads`
--

LOCK TABLES `leads` WRITE;
/*!40000 ALTER TABLE `leads` DISABLE KEYS */;
INSERT INTO `leads` VALUES ('0b873a45-1c4d-4aaa-9231-702d05ab18d4','Bootcamp Java Fulltime','Quang Nam','0121629577','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-16 14:46:45','2019-05-17 09:15:05',NULL,'2019-05-08 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-07 00:00:00','Sinh vien','Male','G0'),('11137888-665d-4f6b-b454-c4bc90421b74','Bootcamp Java Fulltime','Truong Tan Hai','0905345562','zitxiem1998@gmail.com','Cong nghe thong tin',NULL,'2019-05-07 17:07:37','2019-05-07 17:35:42',NULL,'2019-05-17 00:00:00',3,_binary '','092a4724-a329-49c9-85e9-e67334bd499b','2019-05-10 00:00:00','Sinh vien','Male','G1'),('28e3557b-21a1-43e4-b390-2f1f9fde6b3a','Bootcamp Java Fulltime','Dang Thi Nga','0123456789','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-15 17:21:49','2019-05-16 17:32:08',NULL,'2019-05-10 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-03 00:00:00','Sinh vien','Male','G0'),('2a4d327f-dd28-42e9-9465-7f1862f51bf2','abc','longoccho','121629577abc','zitxiem1998@gmail.com','Công nghẹ thông tin',NULL,'2019-05-17 16:40:40','2019-05-17 16:40:40',NULL,'2019-05-12 00:00:00',1,_binary '\0','2eb649ac-3787-4efa-83ee-bab65dffa25f','2019-02-05 00:00:00','Sinh vien ngheo','male','G0'),('46a940d3-782b-4292-b646-8fcdd247b8d1','Bootcamp Java Fulltime','Truong Tan Hai','0123456789','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-15 17:40:24','2019-05-17 09:15:24',NULL,'2019-05-17 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-16 00:00:00','Sinh vien','Male','G0'),('49cecfb1-a32a-4bcf-af65-0dd7c6610474','BootcampJavaFulltime','bookabc','0123456789','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-15 17:40:51','2019-05-16 17:32:04',NULL,'2019-05-17 00:00:00',3,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-10 00:00:00','Sinh vien','Male','G0'),('59329443-5853-4a0c-96af-a38a8453db6f','Bootcamp Java Fulltime','Truong Tan Hai','0121629577','vunv@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-13 16:56:45','2019-05-13 17:00:30',NULL,'2019-05-07 00:00:00',2,_binary '',NULL,'2019-05-08 00:00:00','Sinh vien','Male','G1'),('5b9beca7-ad5f-4d77-bff8-6ed9d9ba9963','BootcampJavaFulltime','name','0121629577','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-16 14:45:52','2019-05-17 09:15:02',NULL,'2019-05-22 00:00:00',7,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-06 00:00:00','Sinh vien','Male','G0'),('5e5d0147-c3a6-482b-b12e-890fbc9a393f','Bootcamp Java Fulltime','Truong Tan Hai','0123456789','zitxiem1998@gmail.com','fsadf',NULL,'2019-05-15 16:53:46','2019-05-17 09:15:27',NULL,'2019-05-16 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-16 00:00:00','Sinh vien','Male','G0'),('65c6f423-cd5b-4129-b1a1-ef923cf89d2c','Bootcamp Java Fulltime','Quang Nam','0123456789','zitxiem1998@gmail.com','fsadf',NULL,'2019-05-16 14:47:22','2019-05-17 09:15:09',NULL,'2019-05-21 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-06 00:00:00','Sinh vien','Male','G0'),('770c24f1-571f-498b-9114-bcaba2443e9d','Bootcamp Java Fulltime','Quang Nam','0121629577','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-17 15:57:55','2019-05-17 15:57:55',NULL,'2019-05-21 00:00:00',1,_binary '\0','2eb649ac-3787-4efa-83ee-bab65dffa25f','2019-05-07 00:00:00','Sinh vien','Male','G0'),('820ab426-f777-4c1c-b246-a74f3ce2db32','BootcampJavaFulltime','Truong Tan Hai','0905345562','zitxiem1998@gmail.com','Cong nghe thong tin',NULL,'2019-05-10 16:36:29','2019-05-13 16:48:21',NULL,'2019-05-09 00:00:00',4,_binary '',NULL,'2019-05-08 00:00:00','Sinh vien','Male','G2'),('82977de5-fb57-4e26-880f-71808c38779b','AcceleratorPHP','avccccsvsdfsdadasd','0905345562','vunv@gmail.comabca','CONG NGHE THONG TIN',NULL,'2019-05-17 09:55:59','2019-05-17 11:16:25',NULL,'2019-05-15 00:00:00',3,_binary '','2eb649ac-3787-4efa-83ee-bab65dffa25f','2019-05-21 00:00:00','Sinh vien','Male','G0'),('84e72532-9d4b-4123-b821-57498c85120e','BootcampJavaFulltime','Truong Tan Hai','0123456789','abc@codgym.vnhgv','CONG NGHE THONG TIN',NULL,'2019-05-14 11:16:07','2019-05-14 11:20:47',NULL,'2019-05-09 00:00:00',3,_binary '',NULL,'2019-05-24 00:00:00','Sinh vien','Male','G1'),('87a9915a-b4e1-4ba4-ae33-b80e5c2fee63','abc','Haiabc','121629577abc','zitxiem1998@gmail.com','Công nghẹ thông tin',NULL,'2019-05-17 16:28:48','2019-05-17 16:28:48',NULL,'2019-05-12 00:00:00',1,_binary '\0','2eb649ac-3787-4efa-83ee-bab65dffa25f','2019-02-05 00:00:00','Sinh vien ngheo','male','G0'),('8b814fef-cebf-41ee-87f6-f8fc2480de7f','Bootcamp Java Fulltime','book','0121629577','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-16 14:46:20','2019-05-16 17:31:57',NULL,'2019-05-15 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-13 00:00:00','Sinh vien','Male','G0'),('8d401372-6fa1-4096-994b-d66004c915b9','Bootcamp Java Fulltime','abcccccc','0121629577','abc@codgym.vn','CONG NGHE THONG TIN',NULL,'2019-05-17 09:16:00','2019-05-17 09:28:42',NULL,'2019-05-14 00:00:00',2,_binary '\0',NULL,'2019-05-07 00:00:00','Sinh vien','Male','G0'),('a59ae6ab-a2af-40b9-9e3e-3f23f2da428c','BootcampJavaFulltime','Truong Tan Haiádasd','0905345562','vunv@fpt.gmail.com','Cong nghe thong tin',NULL,'2019-05-07 17:06:01','2019-05-07 17:06:16',NULL,'2019-05-09 00:00:00',3,_binary '',NULL,'2019-05-03 00:00:00','Sinh vien','Male','G1'),('acfb29a4-8cea-4206-9909-64234f30f306','Bootcamp Java Fulltime','book','0123456789','zitxiem1998@gmail.com','fsadfádasd',NULL,'2019-05-07 17:21:42','2019-05-07 17:34:47',NULL,'2019-05-16 00:00:00',2,_binary '',NULL,'2019-05-08 00:00:00','Sinh vien','Male','G1'),('baa6a720-4791-40e8-9d73-77b58af15817','abc','Thangabc','121629577abc','zitxiem1998@gmail.com','Công nghẹ thông tin',NULL,'2019-05-17 17:02:25','2019-05-17 17:02:25',NULL,'2019-05-12 00:00:00',1,_binary '\0','2eb649ac-3787-4efa-83ee-bab65dffa25f','2019-02-05 00:00:00','Sinh vien ngheo','male','G0'),('bddf7d90-6a17-4cd2-a9fa-1d6e19cf263f','Bootcamp Java Fulltime','Dang Thi Nga','0123456789','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-15 17:31:48','2019-05-16 17:32:12',NULL,'2019-05-10 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-03 00:00:00','Sinh vien','Male','G0'),('be8f6b75-885d-4207-8f3b-ee299c41e460','Bootcamp Java Fulltime','Truong Tan Hoa','0123456789','zitxiem1998@gmail.com','Y bac si',NULL,'2019-05-15 16:48:32','2019-05-15 16:59:06',NULL,'2019-05-08 00:00:00',2,_binary '',NULL,'2019-05-09 00:00:00','Sinh vien','Male','G0'),('bf9af195-0ed7-4f67-b8cb-a53e49e84478','Bootcamp Java Fulltime','abcderr','0905345562','vunv@fpt.gmail.com','Y bac si',NULL,'2019-05-17 09:37:39','2019-05-17 09:38:03',NULL,'2019-05-23 00:00:00',2,_binary '','2eb649ac-3787-4efa-83ee-bab65dffa25f','2019-05-07 00:00:00','Sinh vien','Male','G0'),('d55aea3e-a5e6-4b6e-aca6-d6bbbc3b7ef7','Bootcamp Java Fulltime','dsfsd','0123456789','sdfsdfsdf@gmail.com','fsadf',NULL,'2019-05-14 11:29:38','2019-05-14 11:29:38',NULL,'2019-05-25 00:00:00',1,_binary '\0',NULL,'2019-05-14 00:00:00','Sinh vien','Male','G1'),('d5e98282-b626-4066-b171-755749561170','Bootcamp Java Fulltime','Truong Tan Em','0123456789','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-15 16:58:22','2019-05-17 09:15:13',NULL,'2019-05-15 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-03 00:00:00','Sinh vien','Male','G0'),('d655b35d-900e-4401-85ae-e6f3ffb219cf','abc','longoccho','121629577abc','zitxiem1998@gmail.com','Công nghẹ thông tin',NULL,'2019-05-17 16:39:27','2019-05-17 16:39:27',NULL,'2019-05-12 00:00:00',1,_binary '\0','2eb649ac-3787-4efa-83ee-bab65dffa25f','2019-02-05 00:00:00','Sinh vien ngheo','male','G0'),('d74329de-78a0-47d2-a1b3-4fa02706fd9f','Bootcamp Java Fulltime','Truong Tan Hai','0123456789','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-15 17:39:44','2019-05-17 09:15:30',NULL,'2019-05-17 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-16 00:00:00','Sinh vien','Male','G0'),('d7dcb2fc-3c20-4ac1-886a-6ec72f8e570a','Bootcamp Java Fulltime','Truong Tan Hai','0905345562','zitxiem1998@gmail.com','Cong nghe thong tin',NULL,'2019-05-08 10:12:13','2019-05-09 16:11:04',NULL,'2019-05-10 00:00:00',7,_binary '','e727c7e4-96b1-471d-b117-c94ccab6af0c','2019-05-03 00:00:00','Sinh vien','Male','G1'),('e6f6fbb8-8383-406e-88b7-7dd2b7860b71','Bootcamp Java Fulltime','Truong Tan Hai','0123456789','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-15 16:47:15','2019-05-15 16:59:13',NULL,'2019-05-09 00:00:00',2,_binary '',NULL,'2019-05-09 00:00:00','Sinh vien','Male','G0'),('ec72f75a-0edd-43fc-8412-d08d203cdf94','abc','Haiabc','121629577abc','zitxiem1998@gmail.com','Công nghẹ thông tin',NULL,'2019-05-17 16:07:14','2019-05-17 16:07:14',NULL,'2019-05-12 00:00:00',1,_binary '\0','2eb649ac-3787-4efa-83ee-bab65dffa25f','2019-02-05 00:00:00','Sinh vien ngheo','male','G0'),('ee94c424-0d0b-4409-809b-3627f18fe832','Bootcamp Java Fulltime','Truong Tan Hai','0121629577','zitxiem1998@gmail.com','Chien dich 234',NULL,'2019-05-17 11:17:11','2019-05-17 11:27:33',NULL,'2019-05-23 00:00:00',2,_binary '\0',NULL,'2019-05-17 00:00:00','Sinh vien','Male','G1'),('f93cb766-815d-45a9-a57c-c7de96764d30','Bootcamp Java Fulltime','accccccccccccccccccccccccccc','0905345562','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-17 09:27:55','2019-05-17 09:28:42',NULL,'2019-05-14 00:00:00',2,_binary '\0',NULL,'2019-05-14 00:00:00','Sinh vien','Male','G0'),('fa100394-9121-45c1-9a6a-529d70dd4af6','Bootcamp Java Fulltime','Truong Tan Em','0121629577','zitxiem1998@gmail.com','CONG NGHE THONG TIN',NULL,'2019-05-17 09:00:53','2019-05-17 09:15:18',NULL,'2019-05-21 00:00:00',2,_binary '','b760b450-843d-4ef0-a53b-4d737b9c13d4','2019-05-06 00:00:00','Sinh vien','Male','G0'),('fe172c80-9585-4463-a76f-ddc375d68b26','Accelerator PHP','Truong Tan Hai','0905345562','zitxiem1998@gmail.com','Cong nghe thong tin',NULL,'2019-05-08 08:17:13','2019-05-10 16:30:04',NULL,'2019-05-10 00:00:00',8,_binary '',NULL,'2019-05-10 00:00:00','Sinh vien','Female','G3');
/*!40000 ALTER TABLE `leads` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13  8:36:04
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: codegym_crm
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `lead_detail`
--

DROP TABLE IF EXISTS `lead_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lead_detail` (
  `id` varchar(45) NOT NULL,
  `leads_id` varchar(45) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `last_update_lead_detail_date` datetime DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `last_updated_by` varchar(45) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `version` bigint(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lead_detail_leads1_idx` (`leads_id`),
  CONSTRAINT `fk_lead_detail_leads1` FOREIGN KEY (`leads_id`) REFERENCES `leads` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lead_detail`
--

LOCK TABLES `lead_detail` WRITE;
/*!40000 ALTER TABLE `lead_detail` DISABLE KEYS */;
INSERT INTO `lead_detail` VALUES ('2fdd2816-c44a-47d1-aa7f-a695c27f9610','59329443-5853-4a0c-96af-a38a8453db6f','G1','2019-05-07 00:00:00','abc','anbc',NULL,'2019-05-13 16:57:04','2019-05-13 16:57:04',1),('b653af50-78d3-4e41-9af2-0abeba24bb11','84e72532-9d4b-4123-b821-57498c85120e','G2','2019-05-10 00:00:00','abc','van',NULL,'2019-05-14 11:17:08','2019-05-14 11:17:08',1),('b655c581-9d8c-4798-9dd9-e2af1036496d','84e72532-9d4b-4123-b821-57498c85120e','G2','2019-05-10 00:00:00','abc','van',NULL,'2019-05-14 11:17:08','2019-05-14 11:17:08',1),('c75df59b-aaf1-4da7-9f28-b11fd0e489d8','84e72532-9d4b-4123-b821-57498c85120e','G2','2019-05-10 00:00:00','abc','van',NULL,'2019-05-14 11:17:09','2019-05-14 11:17:09',1);
/*!40000 ALTER TABLE `lead_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13  8:36:05
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: codegym_crm
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `products` (
  `id` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `deleted` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('076da022-2e69-422d-a613-5817fc084c6b',NULL,'2019-05-07 15:25:28','2019-05-13 15:58:16',NULL,2,_binary '','Quang Nam','2019-05-08 00:00:00'),('1',NULL,'2019-04-23 15:41:41','2019-05-07 15:25:41',NULL,4,_binary '','Course 55','2019-01-21 00:00:00'),('2',NULL,'2019-04-23 15:43:02','2019-05-13 15:58:09',NULL,3,_binary '\0','Course 5','2019-01-21 00:00:00'),('3',NULL,'2019-04-23 15:54:52','2019-04-23 15:54:52',NULL,1,_binary '\0','Course 7','2019-01-21 00:00:00'),('58197b3a-8eae-435b-8586-d86591e089e3',NULL,'2019-05-03 19:30:40','2019-05-13 15:58:23',NULL,2,_binary '','Da Nang','2019-01-21 00:00:00'),('a8b452f1-ee8e-4837-b4f2-13a4bf8a4de4',NULL,'2019-05-02 17:20:40','2019-05-03 19:30:44',NULL,2,_binary '','book','2019-01-21 00:00:00'),('c19b631b-3fcb-421d-9b58-c1201c51aa1e',NULL,'2019-05-03 16:46:40','2019-05-03 16:46:51',NULL,3,_binary '','Quang Namsadasd','0000-00-00 00:00:00'),('c353f667-5a60-4ad8-bcf9-659c3f58d488',NULL,'2019-05-14 11:08:15','2019-05-14 11:08:27',NULL,3,_binary '','codeGym_BootCamp2','2019-05-03 00:00:00'),('f44abf55-e004-4a15-abba-2a78ec2b807e',NULL,'2019-04-24 14:57:24','2019-05-02 17:19:01',NULL,2,_binary '','book','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13  8:36:05
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: codegym_crm
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `students` (
  `id` varchar(36) NOT NULL,
  `name` varchar(50) NOT NULL,
  `birthday` date DEFAULT NULL,
  `gender` varchar(10) NOT NULL,
  `classes_id` varchar(40) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `deleted` bit(1) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) NOT NULL,
  `student_status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_students_classes1_idx` (`classes_id`),
  CONSTRAINT `fk_students_classes1` FOREIGN KEY (`classes_id`) REFERENCES `classes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13  8:36:05
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: codegym_crm
-- ------------------------------------------------------
-- Server version	