-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: ag
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address_line_one` text,
  `address_line_two` text,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `pincode` tinytext,
  `user_name` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'House no. 12 Sarabha Nagar','Hoshiarpur road, near Bliss public school','Jalandhar','Punjab','144004','himanshu4319'),(2,'House no. 12 Sarabha Nagar','Jalandhar','Jalandhar','Punjab','144004','Yash4215l'),(3,'vinay nagar','Lamba pind','Jalandhar','Punjab','144001','vivekGPT'),(4,'Gauri Collection , b-9','New Santokhpura','Jalandhar','Punjab','144004','AK107'),(5,'PG near DAV University','kishangarh','Jalandhar','Punjab','144001','Y2J'),(6,'adampur','jalandhar','Abohar','Punjab','144102','lovekaur'),(7,'Airman Street','Aslamabad','Jalandhar','Punjab','144004','raman26');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_user`
--

DROP TABLE IF EXISTS `admin_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `administrator` int DEFAULT NULL,
  `owner_name` varchar(50) DEFAULT NULL,
  `user_name` text,
  `firm_name` varchar(100) DEFAULT NULL,
  `pass` text,
  `login_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_user`
--

LOCK TABLES `admin_user` WRITE;
/*!40000 ALTER TABLE `admin_user` DISABLE KEYS */;
INSERT INTO `admin_user` VALUES (1,1,'Himanshu Aggarwal','himanshu4319','H.A. Garg & Company','Keepit4321@','himanshu4319'),(3,1,'Yashpal','Yash4215','rai group','Yash123','Yash4215'),(4,1,'Vivek Gupta','VivekGPT','R.N. Gupta & Company','humtum111088','VivekGPT'),(7,1,'Arun Kumar','AK107','AK garg & company','AK1234567890','AK107'),(8,0,'Anil Kumar','Anil123','AK garg & company','Anil123','AK107'),(9,0,'Ashok Kumar Goel','Ashok123','AK garg & company','Helloworlds','AK107'),(11,0,'Vikas Kapoor','Vikas123','rai group','Vikas123','Yash4215'),(12,1,'Naval Sharma','Y2J','NKS & Co.','Y@J','Y2J'),(13,1,'lovepreet kaur','lovekaur','lovepreet','lovepreet','lovekaur'),(14,1,'Raman','raman26','Dashmesh Boutique','qwerty','raman26'),(17,0,'sunil','sunil123','lovepreet','123456','lovekaur'),(18,0,'Manvi Prashar','Manvi123','H.A. Garg & Company','Manvi123','himanshu4319');
/*!40000 ALTER TABLE `admin_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills` (
  `id` int NOT NULL AUTO_INCREMENT,
  `invoiceNumber` varchar(50) DEFAULT NULL,
  `orderDate` date DEFAULT NULL,
  `firmId` varchar(50) DEFAULT NULL,
  `productId` varchar(50) DEFAULT NULL,
  `productDesc` tinytext,
  `productQty` varchar(50) DEFAULT NULL,
  `productPrice` varchar(10) DEFAULT NULL,
  `loginUser` varchar(50) DEFAULT NULL,
  `totalValue` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (68,'001','2023-05-01','Nittin Kumar & co.','A&A002','A&A002 Oral B toothbrush - set of 3','10','20','himanshu4319','22200'),(69,'001','2023-05-01','Nittin Kumar & co.','A&A002','A&A002 Oral B toothbrush - set of 3','10','200','himanshu4319','22200'),(70,'001','2023-05-01','Nittin Kumar & co.','A&A001','A&A001 Basmati Rice - 1Kg','100','200','himanshu4319','22200'),(71,'002','2023-05-01','Lovepreet kaur & company','A&A001','A&A001 Basmati Rice - 1Kg','10','20','himanshu4319','110200'),(72,'002','2023-05-01','Lovepreet kaur & company','A&A002','A&A002 Oral B toothbrush - set of 3','100','200','himanshu4319','110200'),(73,'002','2023-05-01','Lovepreet kaur & company','A&A001','A&A001 Basmati Rice - 1Kg','1000','90','himanshu4319','110200'),(74,'003','2023-05-01','Dashmesh Boutique','A&A003','A&A003 Fortune chana dal 1 KG','10','130','himanshu4319','32300'),(75,'003','2023-05-01','Dashmesh Boutique','A&A002','A&A002 Oral B toothbrush - set of 3','100','130','himanshu4319','32300'),(76,'003','2023-05-01','Dashmesh Boutique','A&A001','A&A001 Basmati Rice - 1Kg','120','150','himanshu4319','32300'),(77,'004','2023-05-02','Dashmesh Boutique','A&A002','A&A002 Oral B toothbrush - set of 3','10','20','himanshu4319','2400'),(78,'004','2023-05-02','Dashmesh Boutique','A&A002','A&A002 Oral B toothbrush - set of 3','10','20','himanshu4319','2400'),(79,'004','2023-05-02','Dashmesh Boutique','A&A002','A&A002 Oral B toothbrush - set of 3','10','200','himanshu4319','2400'),(80,'005','2023-05-02','Lovepreet kaur & company','A&A002','A&A002 Oral B toothbrush - set of 3','10','20','himanshu4319','40200'),(81,'005','2023-05-02','Lovepreet kaur & company','A&A001','A&A001 Basmati Rice - 1Kg','100','200','himanshu4319','40200'),(82,'005','2023-05-02','Lovepreet kaur & company','A&A003','A&A003 Fortune chana dal 1 KG','100','200','himanshu4319','40200'),(83,'005','2023-05-02','Lovepreet kaur & company','A&A002','A&A002 Oral B toothbrush - set of 3','10','20','himanshu4319','40200'),(84,'005','2023-05-02','Lovepreet kaur & company','A&A001','A&A001 Basmati Rice - 1Kg','100','200','himanshu4319','40200'),(85,'005','2023-05-02','Lovepreet kaur & company','A&A003','A&A003 Fortune chana dal 1 KG','100','200','himanshu4319','40200');
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(30) DEFAULT NULL,
  `category_code` varchar(30) DEFAULT NULL,
  `loginid` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (2,'RIce','CAT001','raman26'),(3,'Oils and Pulses','CAT002','raman26'),(4,'Oral Hygiene','CAT001','himanshu4319'),(5,'Rice and Pulses','CAT002','himanshu4319');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Jalandhar','Punjab'),(2,'Amritsar','Punjab'),(3,'Bathinda','Punjab'),(4,'Ferozpur','Punjab'),(5,'Gurdaspur','Punjab'),(6,'Jalandhar Cantt','Punjab'),(7,'Jalalabad','Punjab'),(8,'Sultanpur Lodhi','Punjab'),(9,'Kapurthala','Punjab'),(10,'Mukeria','Punjab'),(11,'Tanda','Punjab'),(12,'Dasuya','Punjab'),(13,'Ludhiana','Punjab'),(14,'Pathankot','Punjab'),(15,'Abohar','Punjab'),(16,'Ambala','Haryana'),(17,'Sonipath','Haryana'),(18,'Panipath','Haryana'),(19,'Karnal','Haryana'),(20,'Krukshetra','Haryana'),(21,'Faridabad','Haryana'),(22,'Gurugram','Haryana'),(23,'Rohtak','Haryana');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `firm`
--

DROP TABLE IF EXISTS `firm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `firm` (
  `id` int NOT NULL AUTO_INCREMENT,
  `M_S` varchar(50) DEFAULT NULL,
  `firm_nickname` varchar(50) DEFAULT NULL,
  `firm_contact` tinytext,
  `owner_name` varchar(50) DEFAULT NULL,
  `owner_contact` tinytext,
  `firm_address` text,
  `State` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `pincode` tinytext,
  `loginid` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `firm`
--

LOCK TABLES `firm` WRITE;
/*!40000 ALTER TABLE `firm` DISABLE KEYS */;
INSERT INTO `firm` VALUES (1,'H.A garg & Company','Laadi ','+918837787822','Mr. Himanshu Aggarwal','+91 9872815822','Santokhpura','Punjab','Jalandhar','144004','himanshu4319'),(2,'NextBillion Enterprises','Groww','+91999999999','Mr. XYZ','+91 8888888888','New delhi, near rly station','Punjab','Jalalabad','114456','himanshu4318'),(3,'AK Aggarwal & company','Laadi ','+918837787822','Mr. Ashish Aggarwal','+91 9999988888','Dwarka, Dwarka','Punjab','Jalandhar','11101','VivekGPT'),(4,'Nittin Kumar & co.','nittin','+91 9999999999','Mr. NKS','+91 7837042261','Dummy Address','Punjab','Gurdaspur','15659','himanshu4319'),(5,'Lovepreet kaur & company','Love','+91 9218785521','Miss Lovepreet Kaur','+91 1234567890','Adampur, Adampur','Punjab','Jalandhar','144004','himanshu4319'),(6,'Dashmesh Boutique','Raman Deep','+91 8837787822','Mr. RD','+91 1234567890','Jalandahr, Jalandhar','Punjab','Jalalabad','144622','himanshu4319');
/*!40000 ALTER TABLE `firm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Ac_number` tinytext,
  `ifsc` tinytext,
  `Bname` varchar(50) DEFAULT NULL,
  `upi` tinytext,
  `login` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'3457280485','CBIN0281542','Central Bank of India','6283561496@paytm','himanshu4319'),(2,'9876543210','BBIN0258146','Free Fund Bank','9876543210@apl','Yash4215');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_entry`
--

DROP TABLE IF EXISTS `payment_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_entry` (
  `id` int NOT NULL AUTO_INCREMENT,
  `payID` varchar(30) DEFAULT NULL,
  `payDate` date DEFAULT NULL,
  `customerId` varchar(50) DEFAULT NULL,
  `payDesc` text,
  `payAmount` varchar(10) DEFAULT NULL,
  `payType` varchar(10) DEFAULT NULL,
  `loginid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_entry`
--

LOCK TABLES `payment_entry` WRITE;
/*!40000 ALTER TABLE `payment_entry` DISABLE KEYS */;
INSERT INTO `payment_entry` VALUES (7,'INV1','2023-04-25','Nittin Kumar & co.','TRF','null','Debit','himanshu4319'),(8,'INV2','2023-04-04','Nittin Kumar & co.','TRF UPI','-15000.0','Credit','himanshu4319'),(9,'INV3','2023-04-08','Lovepreet kaur & company','TRF','-15000.0','Debit','himanshu4319'),(10,'INV4','2023-04-26','H.A garg & Company','TRF','12000','Debit','himanshu4319'),(11,'INV5','2023-04-26','Nittin Kumar & co.','TRF','550','Debit','himanshu4319'),(12,'INV6','2023-04-25','Nittin Kumar & co.','trf','12000','Debit','himanshu4319'),(13,'INV7','2023-04-29','Lovepreet kaur & company','trf','15000','Debit','himanshu4319'),(14,'INV8','2023-05-02','Dashmesh Boutique','trf','7860','Debit','himanshu4319'),(15,'INV9','2023-05-02','Dashmesh Boutique','trf','-13000.0','Credit','himanshu4319'),(16,'INV10','2023-05-03','Dashmesh Boutique','trf		','2500','Debit','himanshu4319');
/*!40000 ALTER TABLE `payment_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `proId` varchar(10) DEFAULT NULL,
  `proName` varchar(50) DEFAULT NULL,
  `proCategory` varchar(50) DEFAULT NULL,
  `proQuantity` varchar(3) DEFAULT NULL,
  `proDesc` text,
  `proPrice` varchar(10) DEFAULT NULL,
  `loginid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (3,'A&A001','Tata sampann','Oils and Pulses','0','olikgh','780','raman26'),(4,'A&A002','Oral B toothbrush - set of 3','Oral Hygiene','19','','99','himanshu4319'),(5,'A&A001','Basmati Rice - 1Kg','Rice and Pulses','20','Basmati Rice - 1kg','200','himanshu4319'),(6,'A&A003','Fortune chana dal 1 KG','Rice and Pulses','21','Rich in protiens','150','himanshu4319');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase` (
  `id` int NOT NULL AUTO_INCREMENT,
  `invoiceNumber` varchar(50) DEFAULT NULL,
  `invoiceDate` date DEFAULT NULL,
  `firmId` varchar(50) DEFAULT NULL,
  `productId` varchar(50) DEFAULT NULL,
  `productDesc` text,
  `productQty` varchar(6) DEFAULT NULL,
  `productPrice` varchar(10) DEFAULT NULL,
  `loginUser` varchar(50) DEFAULT NULL,
  `totalValue` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` VALUES (1,'105','2023-05-01','Nittin Kumar & co.','A&A001','A&A001 Basmati Rice - 1Kg','50','10','himanshu4319','19508'),(2,'105','2023-05-01','Nittin Kumar & co.','A&A002','A&A002 Oral B toothbrush - set of 3','96','99','himanshu4319','19508'),(3,'105','2023-05-01','Nittin Kumar & co.','A&A002','A&A002 Oral B toothbrush - set of 3','96','99','himanshu4319','19508');
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'Jammu & Kashmir'),(2,'Himachal Pradesh'),(3,'Punjab'),(4,'Rajasthan'),(5,'Haryana'),(6,'Delhi'),(7,'Uttar Pradesh'),(8,'Uttrakhand'),(9,'Bihar'),(10,'Jharkhand'),(11,'Orissa'),(12,'Madhya Pradesh'),(13,'Chattisgarh'),(14,'West Bengal'),(15,'Gujarat'),(16,'Maharashtra'),(17,'Kerala'),(18,'Tamil Nadu'),(19,'Karnatka'),(20,'Telangana'),(21,'Andhra Pradesh'),(22,'Assam'),(23,'Meghalaya'),(24,'Mizoram'),(25,'Nagaland'),(26,'Tripura'),(27,'Manipur'),(28,'Goa'),(29,'Arunachal Pradesh'),(30,'Chandigarh'),(31,'Lakshwadeep'),(32,'Andaman & NIcobar islands'),(33,'Dadar Nagar Haveli'),(34,'Ladakh');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-07 16:11:33
