CREATE DATABASE  IF NOT EXISTS `booking` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `booking`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: booking
-- ------------------------------------------------------
-- Server version   5.7.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `addressid` int(11) NOT NULL AUTO_INCREMENT,
  `street1` varchar(45) NOT NULL,
  `street2` varchar(45) DEFAULT NULL,
  `city` varchar(45) NOT NULL,
  `zipcode` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  PRIMARY KEY (`addressid`),
  UNIQUE KEY `addressid_UNIQUE` (`addressid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'1000 N 4th st',NULL,'Fairfield','52557','IA'),(2,'1302 S Main st',NULL,'Fairfield','52556','IA'),(3,'1500 4th st',NULL,'Fairfield','52557','IA');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `cellphone` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `addressid` int(11) DEFAULT NULL,
  `paymentid` int(11) DEFAULT NULL,
  PRIMARY KEY (`customerid`),
  UNIQUE KEY `customerid_UNIQUE` (`customerid`),
  KEY `fk_customer_address_idx` (`addressid`),
  KEY `fk_customer_payment_idx` (`paymentid`),
  CONSTRAINT `fk_customer_address` FOREIGN KEY (`addressid`) REFERENCES `address` (`addressid`),
  CONSTRAINT `fk_customer_payment` FOREIGN KEY (`paymentid`) REFERENCES `payment` (`paymentid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'LUAT','NGUYEN','8484669338','LUATNGUYEN@GMAIL.COM',1,1),(2,'KIMTEY','CHAV','1234567890','KIMTEYCHAV@GMAIL.COM',2,2),(3,'ENKH','ENKH','0987654321','ENKH@GMAIL.COM',3,3);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passenger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) DEFAULT NULL,
  `type` varchar(10) NOT NULL,
  `tripid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (1,'Adult','Adult',NULL),(2,'Passenger with Disability (PWD)','Adult',NULL),(3,'Companion (Book with PWD)','Adult',NULL),(4,'Kimtey Chav','Adult',NULL),(5,'Luat Nguyen','Adult',NULL),(6,'Enkh Enkh','Adult',NULL),(7,'Tam Nguyen','Adult',NULL),(8,'Dat Doan','Senior',NULL),(9,'Vu Le','Senior',NULL),(10,'Dan Cao','Senior',NULL),(11,'Tam Huynh','Military',NULL),(12,'Nam Ngo','Military',NULL),(13,'Vu Ngo','Senior',NULL),(14,'Tin Nguyen','Senior',NULL),(15,'Trung Nguyen','Child',NULL),(16,'Dung Dinh','Child',NULL),(17,'Han Nguyen','Infant',NULL),(18,'Mi Tran','Child',NULL),(19,'Quoc Nguyen','Infant',NULL);
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `paymentid` int(11) NOT NULL AUTO_INCREMENT,
  `cardtype` varchar(45) DEFAULT NULL,
  `holdername` varchar(45) DEFAULT NULL,
  `cardnumber` varchar(45) DEFAULT NULL,
  `expiredmonth` varchar(45) DEFAULT NULL,
  `expiredyear` varchar(45) DEFAULT NULL,
  `ccv` varchar(45) DEFAULT NULL,
  `addressid` int(11) DEFAULT NULL,
  PRIMARY KEY (`paymentid`),
  UNIQUE KEY `paymentid_UNIQUE` (`paymentid`),
  KEY `fk_payment_address_idx` (`addressid`),
  CONSTRAINT `fk_payment_address` FOREIGN KEY (`addressid`) REFERENCES `address` (`addressid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'VISA','LUAT V NGUYEN','1111222233334444','12','2020','311',1),(2,'DISCOVER','KIMTEY CHAV','2222333344445555','01','2030','002',2),(3,'MASTERCARD','ENKH','1234567887654321','06','2021','123',3);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `port`
--

DROP TABLE IF EXISTS `port`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `port` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `port_name_index` (`name`),
  KEY `fk_port_address` (`address_id`),
  CONSTRAINT `fk_port_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`addressid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `port`
--

LOCK TABLES `port` WRITE;
/*!40000 ALTER TABLE `port` DISABLE KEYS */;
INSERT INTO `port` VALUES (1,'Burlington, IA - BRL',1),(2,'Creston, IA - CRN',2),(3,'Davenport, IA - DVP',3),(4,'Fort Madison, IA - FMD',1),(5,'Mt. Pleasant, IA - MTP',2),(6,'Mt. Pleasant, IA - MTP',3),(7,'Ottumwa, IA - OTM',1),(8,'Alton, IL - ALN',2),(9,'Carbondale, IL - CDL',3),(10,'Carlinville, IL - CRV',1),(11,'Centralia, IL - CEN',2),(12,'Champaign, IL - CHM',3),(13,'Chicago, IL - CHI',1),(14,'Union Station',2),(15,'Danville, IL - DVI',3),(16,'Du Quoin, IL - DQN',1),(17,'Dwight, IL - DWT',2),(18,'Effingham, IL - EFG',3),(19,'Galesburg, IL - GBB',1),(20,'Gilman, IL - GLM',2),(21,'Glenview, IL - GLN',3),(22,'Homewood, IL - HMW',1),(23,'Albany, NY - ABA',2),(24,'Amsterdam, NY - AMS',3),(25,'Buffalo, NY - BFX',1),(26,'Croton-on-Hudson, NY - CRT',1),(27,'Depew, NY - BUF',1),(28,'Dunkirk, NY - DUK',1),(29,'Fort Edward, NY - FED',1),(30,'Fredonia, NY - FDN',1),(31,'Hudson, NY - HUD',1),(32,'Jamestown, NY - JMN',1),(33,'Lake Placid, NY - LPD',1),(34,'New Rochelle, NY - NRO',1),(35,'New York, NY - NYP',1),(36,'Niagara Falls, NY - NFL',1),(37,'Plattsburgh, NY - PLB',1),(38,'Port Henry, NY - POH',1),(39,'Port Kent, NY - PRK',1),(40,'Poughkeepsie, NY - POU',1),(41,'Rensselaer, NY - ALB',1),(42,'Rhinecliff, NY - RHI',1),(43,'Rochester, NY - ROC',1),(44,'Rome, NY - ROM',1),(45,'Rouses Point, NY - RSP',1),(46,'Saratoga Springs, NY - SAR',1),(47,'Schenectady, NY - SDY',1),(48,'Syracuse, NY - SYR',1),(49,'Syracuse, NY - NYF',1),(50,'Ticonderoga, NY - FTC',1),(51,'Utica, NY - UCA',1),(52,'Westport, NY - WSP',1),(53,'Whitehall, NY - WHL',1),(54,'Yonkers, NY - YNY',1),(55,'Cincinnati, OH - CIN',1),(56,'Cleveland, OH - CLE',1),(57,'Columbus, OH - COL',1),(58,'Elyria, OH - ELY',1);
/*!40000 ALTER TABLE `port` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `startdate` datetime NOT NULL,
  `enddate` datetime NOT NULL,
  `promotioncode` varchar(20) NOT NULL,
  `percent` decimal(5,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
INSERT INTO `promotion` VALUES (1,'2018-01-01 00:00:00','2018-05-31 00:00:00','ABCDE',0.10),(2,'2018-02-14 00:00:00','2018-02-16 00:00:00','SPRING20',0.20),(3,'2018-03-01 00:00:00','2018-03-15 00:00:00','SPRING30',30.00);
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sourceport_id` int(11) NOT NULL,
  `destinationport_id` int(11) NOT NULL,
  `duration` decimal(10,2) NOT NULL,
  `distance` decimal(10,2) NOT NULL,
  `pricesingleway` decimal(15,2) NOT NULL,
  `priceroundway` decimal(15,2) NOT NULL,
  `departuredate` datetime NOT NULL,
  `arrivaldate` datetime NOT NULL,
  `trainid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_route_sourceport` (`sourceport_id`),
  KEY `fk_route_destinationport_id` (`destinationport_id`),
  KEY `fk_route_train_idx` (`trainid`),
  CONSTRAINT `fk_route_destinationport_id` FOREIGN KEY (`destinationport_id`) REFERENCES `port` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_route_sourceport` FOREIGN KEY (`sourceport_id`) REFERENCES `port` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_route_train` FOREIGN KEY (`trainid`) REFERENCES `train` (`trainid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,1,2,10.00,10.00,31.00,62.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',4),(2,2,3,15.00,20.00,32.00,64.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',5),(3,3,4,20.00,30.00,33.00,66.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',6),(4,4,5,22.00,40.00,34.00,68.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',7),(5,5,6,11.00,50.00,35.00,70.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',8),(6,6,7,12.00,60.00,36.00,72.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',9),(7,7,8,13.00,70.00,37.00,74.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',10),(8,8,9,14.00,80.00,38.00,76.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(9,9,10,15.00,90.00,39.00,78.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(10,10,11,16.00,100.00,40.00,80.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(11,11,12,17.00,110.00,41.00,82.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(12,12,13,18.00,120.00,42.00,84.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(13,13,14,19.00,130.00,43.00,86.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(14,14,15,20.00,140.00,44.00,88.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(15,15,16,21.00,150.00,45.00,90.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(16,16,17,22.00,160.00,46.00,92.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(17,17,18,23.00,170.00,47.00,94.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(18,18,19,24.00,180.00,48.00,96.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(19,19,20,25.00,190.00,49.00,98.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(20,20,21,26.00,200.00,50.00,100.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(21,21,22,27.00,210.00,51.00,102.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(22,22,23,28.00,220.00,52.00,104.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(23,23,24,29.00,230.00,53.00,106.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(24,24,25,30.00,240.00,54.00,108.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(25,25,26,31.00,250.00,55.00,110.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(26,26,27,32.00,260.00,56.00,112.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(27,27,28,33.00,270.00,57.00,114.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(28,28,29,34.00,280.00,58.00,116.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(29,29,30,35.00,290.00,59.00,118.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(30,30,31,36.00,300.00,60.00,120.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(31,31,32,37.00,310.00,61.00,122.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(32,32,33,38.00,320.00,62.00,124.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(33,33,34,39.00,330.00,63.00,126.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(34,34,35,40.00,340.00,64.00,128.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(35,35,36,41.00,350.00,65.00,130.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(36,36,37,42.00,360.00,66.00,132.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(37,37,38,42.00,370.00,67.00,134.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(38,38,39,43.00,380.00,68.00,136.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(39,39,40,44.00,390.00,69.00,138.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(40,40,41,45.00,400.00,70.00,140.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(41,41,42,46.00,410.00,71.00,142.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(42,42,43,46.00,420.00,72.00,144.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(43,43,44,43.00,430.00,73.00,146.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(44,44,45,43.00,440.00,74.00,148.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(45,45,46,23.00,450.00,75.00,150.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(46,46,47,43.00,460.00,76.00,152.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(47,47,48,32.00,470.00,77.00,154.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(48,48,49,32.00,480.00,78.00,156.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(49,49,50,21.00,490.00,79.00,158.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(50,50,51,32.00,500.00,80.00,160.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL),(51,51,1,43.00,510.00,81.00,162.00,'2018-02-03 12:00:00','2018-02-03 18:30:00',NULL);
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train`
--

DROP TABLE IF EXISTS `train`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train` (
  `trainid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `model` varchar(50) NOT NULL,
  `madeby` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `capacity` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`trainid`),
  UNIQUE KEY `trainid_UNIQUE` (`trainid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train`
--

LOCK TABLES `train` WRITE;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;
INSERT INTO `train` VALUES (4,'Train 01','1960','USA','ECONOMY',500,'Good'),(5,'Train 02','1960','USA','ECONOMY',500,'Good'),(6,'Train 03','1960','USA','ECONOMY',500,'Good'),(7,'Train 04','2000','JAPAN','REGULAR',200,'Very Good'),(8,'Train 05','2000','JAPAN','REGULAR',200,'Very Good'),(9,'Train 06','2000','JAPAN','REGULAR',200,'Very Good'),(10,'Train 07','2018','GERMANY','ROYAL',300,'Exellent'),(11,'Train 08','2018','GERMANY','ROYAL',300,'Exellent');
/*!40000 ALTER TABLE `train` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trip` (
  `id` int(11) NOT NULL,
  `tripway` varchar(20) NOT NULL,
  `bookDate` datetime NOT NULL,
  `route_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `confimationnumber` varchar(45) DEFAULT NULL,
  `totalprice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `trip_id_uindex` (`id`),
  KEY `fk_route_route` (`route_id`),
  KEY `fk_trip_customer` (`customer_id`),
  CONSTRAINT `fk_route_route` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_trip_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customerid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `customerid` int(11) DEFAULT NULL,
  UNIQUE KEY `id_UNIQUE` (`userid`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fd_user_customer_idx` (`customerid`),
  CONSTRAINT `fd_user_customer` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'kimtey','123',2),(3,'enkh','123',3),(4,'tam','123',NULL),(5,'luatnguyen','123',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-01 11:44:14
