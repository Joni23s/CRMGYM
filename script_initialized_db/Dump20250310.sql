CREATE DATABASE  IF NOT EXISTS `crmgym_test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `crmgym_test`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: crmgym_test
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `documentId` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phoneNumber` bigint(15) DEFAULT NULL,
  `isActive` tinyint(1) NOT NULL,
  PRIMARY KEY (`documentId`),
  UNIQUE KEY `documentId_UNIQUE` (`documentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (24567891,'Juan','Pérez','juan.perez@example.com',1123456789,1),(25634892,'Juan','Palo','sdda@sdsad.com',2634870125,1),(27891234,'María','González','maria.gonzalez@example.com',1134567890,1),(30234567,'Carlos','Fernández','carlos.fernandez@example.com',1145678901,1),(31567890,'Ana','López','ana.lopez@example.com',1156789012,1),(32456789,'Benja','Atino','benja.atino@example.com',2634890845,1),(32456841,'Firu','Lai','elriu@fa.com',321456875,1),(32456987,'Juan','Palo','juan@gmail.com',254587522,1),(32654789,'Juan','Palo','juanpa.example@mail.com',235468791,1),(32901234,'Pedro','Martínez','pedro.martinez@example.com',1167890123,1),(34234567,'Laura','Gómez','laura.gomez@example.com',1178901234,1),(35678901,'Diego','Díaz','diego.diaz@example.com',1189012345,1),(36901234,'Sofía','Torres','sofia.torres@example.com',1190123456,1),(38234567,'Martín','Ramírez','martin.ramirez@example.com',1201234567,1),(39567890,'Valentina','Flores','valentina.flores@example.com',1212345678,1),(40901234,'Lucas','Benítez','lucas.benitez@example.com',1223456789,1),(42234567,'Camila','Acosta','camila.acosta@example.com',1234567890,1),(43567890,'Mateo','Herrera','mateo.herrera@example.com',1245678901,1),(44901234,'Julieta','Medina','julieta.medina@example.com',1256789012,1),(46234567,'Andrés','Molina','andres.molina@example.com',1267890123,1),(47567890,'Natalia','Ríos','natalia.rios@example.com',1278901234,1),(48901234,'Santiago','Silva','santiago.silva@example.com',1289012345,1),(50234567,'Florencia','Castro','florencia.castro@example.com',1290123456,1),(51567890,'Gabriel','Ortega','gabriel.ortega@example.com',1301234567,1),(52901234,'Luciana','Vargas','luciana.vargas@example.com',1312345678,1);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-10 12:46:57
