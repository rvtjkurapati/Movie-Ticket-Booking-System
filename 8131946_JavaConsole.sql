-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sample
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `adminId` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`adminId`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (5,'ravi','root'),(7,'rteja','Aptech@007'),(9,'harsha','Aptech'),(10,'rvtj','Aptech@007');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `availability`
--

DROP TABLE IF EXISTS `availability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `availability` (
  `movieId` int DEFAULT NULL,
  `showdate` date DEFAULT NULL,
  `morning` varchar(10) DEFAULT NULL,
  `matinee` varchar(10) DEFAULT NULL,
  `secondshow` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `availability`
--

LOCK TABLES `availability` WRITE;
/*!40000 ALTER TABLE `availability` DISABLE KEYS */;
INSERT INTO `availability` VALUES (1003,'2022-12-20','115','114','117'),(1003,'2022-12-21','120','120','120'),(1003,'2022-12-22','117','120','120'),(1003,'2022-12-23','120','120','120'),(1003,'2022-12-24','120','120','120'),(1003,'2022-12-25','120','120','120'),(1006,'2022-09-05','120','120','120'),(1006,'2022-09-06','120','120','120'),(1006,'2022-09-07','120','120','120'),(1006,'2022-09-08','120','120','120'),(1006,'2022-09-09','120','120','120'),(1006,'2022-09-10','120','120','120'),(1007,'2022-09-05','120','114','120'),(1007,'2022-09-06','120','120','120');
/*!40000 ALTER TABLE `availability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `bid` int NOT NULL AUTO_INCREMENT,
  `custId` int DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `movieId` int DEFAULT NULL,
  `showdate` date DEFAULT NULL,
  `showtime` varchar(10) DEFAULT NULL,
  `seats` int DEFAULT NULL,
  PRIMARY KEY (`bid`),
  KEY `movie_id` (`movieId`),
  CONSTRAINT `movie_id` FOREIGN KEY (`movieId`) REFERENCES `movie` (`movieId`)
) ENGINE=InnoDB AUTO_INCREMENT=20235 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (20227,109,'pankaj_2001','9493018954',1003,'2022-12-20','secondshow',3),(20228,110,'rvtj_kurapati','9493018954',1003,'2022-12-22','morning',3),(20231,5,'ravi','9493018954',1003,'2022-12-20','matinee',6),(20233,5,'ravi','9493018954',1007,'2022-09-05','matinee',6),(20234,114,'rvtjkurapati','9493018954',1003,'2022-12-20','morning',5);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `custId` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`custId`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (105,'bdfb','fgn','dnbdgn','sgnn'),(106,'harsha','Aptech@159','9493018954','a@gmail.com'),(107,'root','Aptech@159','9493018954','a@gmail.com'),(109,'pankaj_2001','A123456!z','6989698969','pankaj@gmail.com'),(110,'rvtj_kurapati','A123456!z','9493018954','rvtj@gmail.com'),(111,'rvtj_123','Aptech@159','9493018954','rvtj@gmail.com'),(112,'harsha.777','H@rsha007','9493018954','harshakarumuri@gmail.com'),(114,'rvtjkurapati','Aptech@007','9493018954','rvtj@gmail.com'),(115,'rvtj','Aptech@007','9493018954','rvtj@gmail.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `movieId` int NOT NULL AUTO_INCREMENT,
  `moviename` varchar(20) DEFAULT NULL,
  `lang` varchar(10) DEFAULT NULL,
  `morning` varchar(10) DEFAULT NULL,
  `matinee` varchar(10) DEFAULT NULL,
  `secondshow` varchar(10) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`movieId`)
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1003,'Beast','Tamil','10:30AM','02:30PM','06:30PM','2022-12-20','2022-12-25'),(1006,'Karthikeya-2','Telugu','10:30AM','02:30PM','09:30PM','2022-09-05','2022-09-10'),(1007,'Don','Tamil','08:30AM','01:30PM','07:30PM','2022-09-05','2022-09-06');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-22 19:07:10
