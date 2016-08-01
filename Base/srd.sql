-- MySQL dump 10.13  Distrib 5.6.27, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: concurso
-- ------------------------------------------------------
-- Server version	5.6.27-0ubuntu1

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
-- Table structure for table `CIUDAD`
--

DROP TABLE IF EXISTS `CIUDAD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CIUDAD` (
  `ciudad_id` int(11) NOT NULL AUTO_INCREMENT,
  `ciudad_nombre` varchar(45) NOT NULL,
  `provincia_id` int(11) NOT NULL,
  PRIMARY KEY (`ciudad_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CIUDAD`
--

LOCK TABLES `CIUDAD` WRITE;
/*!40000 ALTER TABLE `CIUDAD` DISABLE KEYS */;
/*!40000 ALTER TABLE `CIUDAD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROVINCIA`
--

DROP TABLE IF EXISTS `PROVINCIA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROVINCIA` (
  `provincia_id` int(11) NOT NULL AUTO_INCREMENT,
  `provincia_nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`provincia_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROVINCIA`
--

LOCK TABLES `PROVINCIA` WRITE;
/*!40000 ALTER TABLE `PROVINCIA` DISABLE KEYS */;
/*!40000 ALTER TABLE `PROVINCIA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SOLICITUD`
--

DROP TABLE IF EXISTS `SOLICITUD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SOLICITUD` (
  `SOL_CI` varchar(10) NOT NULL,
  `SOL_APELLIDOS` varchar(50) NOT NULL,
  `SOL_NOMBRES` varchar(50) NOT NULL,
  `SOL_CODPROV` int(11) NOT NULL,
  `SOL_CODCIU` int(11) NOT NULL,
  `SOL_SEXO` varchar(1) NOT NULL,
  `SOL_FECHANAC` date NOT NULL,
  `SOL_NUMMIEM` int(11) NOT NULL,
  `SOL_TELEFONO` varchar(15) NOT NULL,
  `SOL_DISC` tinyint(4) NOT NULL,
  `SOL_FECHA` date DEFAULT NULL,
  `SOL_ESTADO` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SOL_CI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SOLICITUD`
--

LOCK TABLES `SOLICITUD` WRITE;
/*!40000 ALTER TABLE `SOLICITUD` DISABLE KEYS */;
INSERT INTO `SOLICITUD` VALUES ('1727371773','Samaniego Freire','Ángel Andrés',0,14,'H','2016-06-07',6,'0987947495',0,'2016-07-11','A');
/*!40000 ALTER TABLE `SOLICITUD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `usr_ci` varchar(10) NOT NULL,
  `usr_clave` varchar(32) NOT NULL,
  `usr_nombre` varchar(70) NOT NULL,
  `usr_fechaNac` varchar(50) NOT NULL,
  `usr_direccion` varchar(100) NOT NULL,
  PRIMARY KEY (`usr_ci`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES ('1727299420','1727299420','','',''),('1727371773','andres','','','');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-28  4:24:47
