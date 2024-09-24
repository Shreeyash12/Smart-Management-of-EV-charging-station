-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.30-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema evchargestation
--

CREATE DATABASE IF NOT EXISTS evchargestation;
USE evchargestation;

--
-- Definition of table `ev_bunk`
--

DROP TABLE IF EXISTS `ev_bunk`;
CREATE TABLE `ev_bunk` (
  `bunkid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bunklocation` varchar(45) NOT NULL,
  `bunkarea` varchar(45) NOT NULL,
  `slot` varchar(45) NOT NULL,
  `capacity` varchar(45) NOT NULL,
  `chargetime` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`bunkid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ev_bunk`
--

/*!40000 ALTER TABLE `ev_bunk` DISABLE KEYS */;
INSERT INTO `ev_bunk` (`bunkid`,`bunklocation`,`bunkarea`,`slot`,`capacity`,`chargetime`,`status`) VALUES 
 (1,'PUNE','WARJE','4','240V','2 HOUR','Active'),
 (2,'Pune','hadapser','2','360w','1hours','Active'),
 (3,'warje','warje','10','200','2','Active');
/*!40000 ALTER TABLE `ev_bunk` ENABLE KEYS */;


--
-- Definition of table `ownerreg`
--

DROP TABLE IF EXISTS `ownerreg`;
CREATE TABLE `ownerreg` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `phoneno` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ownerreg`
--

/*!40000 ALTER TABLE `ownerreg` DISABLE KEYS */;
INSERT INTO `ownerreg` (`id`,`name`,`phoneno`,`email`,`address`,`pass`,`status`) VALUES 
 (1,'kedar shinde','7756412841','kedar@gmail.com','sector1,near kids wear shop,hadapser,pune','Kedar1','Active'),
 (2,'Aarti','9856321456','aarti@gmail.com','abc','Aarti1','Active');
/*!40000 ALTER TABLE `ownerreg` ENABLE KEYS */;


--
-- Definition of table `search`
--

DROP TABLE IF EXISTS `search`;
CREATE TABLE `search` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bunklocation` varchar(45) NOT NULL,
  `bunkarea` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `search`
--

/*!40000 ALTER TABLE `search` DISABLE KEYS */;
INSERT INTO `search` (`id`,`bunklocation`,`bunkarea`,`status`) VALUES 
 (1,'PUNE','WARJE','Active'),
 (2,'PUNE','WARJE','Active'),
 (3,'katraj','katraj','Active');
/*!40000 ALTER TABLE `search` ENABLE KEYS */;


--
-- Definition of table `userreg`
--

DROP TABLE IF EXISTS `userreg`;
CREATE TABLE `userreg` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `phoneno` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `area` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userreg`
--

/*!40000 ALTER TABLE `userreg` DISABLE KEYS */;
INSERT INTO `userreg` (`id`,`name`,`phoneno`,`email`,`location`,`area`,`pass`,`status`) VALUES 
 (1,'Aarti','9865231456','aarti@gmail.com','Pune','warje','Arti12','Active');
/*!40000 ALTER TABLE `userreg` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
