
/*TEAMS SCHEMA SPRING 2022
Create a new schema with your prefix, e.g.
	kj_teams_sp22
Modify the data in  your schema to match your theme.
Note: I've added a 'motto' column for your team motto
Run this script to populate your database
Modify your config.js in your backend with the AWS Credentials
module.exports = {
    HOST: "jenson-mysql.c8qwuofu4md8.us-east-1.rds.amazonaws.com",
    USER: "kennyjay",
    PASSWORD: "mysqluser",
    DB: "YOUR DB NAME"
  };
*/
UNLOCK TABLES;

DROP TABLE IF EXISTS `license_levels`;

CREATE TABLE `license_levels` (
  `id` int NOT NULL AUTO_INCREMENT,
  `value` varchar(32) DEFAULT NULL,
  `description` varchar(2048) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


--
-- Dumping data for table `license_levels`
--

LOCK TABLES `license_levels` WRITE;

INSERT INTO `license_levels` VALUES (1,'NA','Not Applicable'),(2,'A','A Level License'),(3,'B','B Level License'),(4,'C','C Level License'),(5,'D','D Level License');

UNLOCK TABLES;

--
-- Table structure for table `leagues`
--

DROP TABLE IF EXISTS `leagues`;

CREATE TABLE `leagues` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `description` varchar(2048) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


--
-- Dumping data for table `leagues`
--

LOCK TABLES `leagues` WRITE;

INSERT INTO `leagues` VALUES (1,'Battlefield','My favorite League'),(2,'Final Destination','A bunch of Losers');

UNLOCK TABLES;


-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: jenson-mysql.c8qwuofu4md8.us-east-1.rds.amazonaws.com    Database: myteams2
-- ------------------------------------------------------
-- Server version	8.0.20


DROP TABLE IF EXISTS `people`;

CREATE TABLE `people` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(32) DEFAULT NULL,
  `last_name` varchar(32) NOT NULL,
  `notes` varchar(2048) NOT NULL,
  `team_id` int NOT NULL,
  `email` varchar(128) NOT NULL,
  `phone` varchar(24) NOT NULL,
  `license_level_id` int NOT NULL,
  `person_type` enum('coach','player','admin') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_team` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;

INSERT INTO `people` VALUES (1,'Luigi','Mansion','notes!',1,'test@test.com','(666)666-6666',1,'coach'),
(2,'Kirby','Allstar','note',2,'test1@test.com','(123)456-7890',2,'coach'),
(3,'Pac','Man','noted',3,'test2@test.com','(555)555-5555',3,'coach'),
(4,'Lucas','Mary','notes notes',4,'test3@test.com','(232)232-2323',4,'coach'),
(5,'Lucas','Mary 2','notes notes',4,'test3@test.com','(232)232-2323',4,'coach');

UNLOCK TABLES;

-- GTID state at the beginning of the backup 
--

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;

CREATE TABLE `teams` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `coach_id` int NOT NULL,
  `league_id` int NOT NULL,
  `notes` varchar(1024) NOT NULL,
  `motto` varchar(1024) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `coach_id_2` (`coach_id`),
  KEY `league_id` (`league_id`),
  CONSTRAINT `fk_coach_person` FOREIGN KEY (`coach_id`) REFERENCES `people` (`id`),
  CONSTRAINT `fk_league_team` FOREIGN KEY (`league_id`) REFERENCES `leagues` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;

INSERT INTO `teams` VALUES 
(1,"Ghost Hunters",1,1,'This is an awesome team', 'we hunt ghosts!'),
(2,'The Pink Puffs',2,1,'This is an awesome team', 'We da Best!'),
(3,'Buffets Bane',3,1,'This is an awesome team', 'eating is great!'),
(4,'Echoes',4,1,'This is an awesome team','being in the dark is the way'),
(5,'Corrupted Visions',5,1,'Not so great team', 'We like it this way');

UNLOCK TABLES;

-- Dump completed on 2020-11-03 23:00:44
