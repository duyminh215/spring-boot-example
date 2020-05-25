-- MySQL dump 10.16  Distrib 10.1.44-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: 128.199.147.248    Database: social
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `social`;

USE `social`;

--
-- Table structure for table `achievement`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `achievement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(450) DEFAULT NULL,
  `content` varchar(6000) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `created_time` bigint(20) NOT NULL,
  `updated_time` bigint(20) NOT NULL,
  `icon` varchar(245) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievement`
--

LOCK TABLES `achievement` WRITE;
/*!40000 ALTER TABLE `achievement` DISABLE KEYS */;
/*!40000 ALTER TABLE `achievement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `action_category`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `action_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `action_id` bigint(20) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_action_category` (`action_id`,`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action_category`
--

LOCK TABLES `action_category` WRITE;
/*!40000 ALTER TABLE `action_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `action_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `icon` varchar(245) DEFAULT NULL,
  `description` varchar(4500) DEFAULT NULL,
  `ordinal` int(11) NOT NULL DEFAULT '0',
  `parent_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `used_for_search` int(11) DEFAULT NULL,
  `used_for_filter` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_setting`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT '0',
  `value` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_setting`
--

LOCK TABLES `client_setting` WRITE;
/*!40000 ALTER TABLE `client_setting` DISABLE KEYS */;
INSERT INTO `client_setting` VALUES (1,'hello',0,'Xin chào');
/*!40000 ALTER TABLE `client_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_image`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(20) NOT NULL,
  `image_id` bigint(20) NOT NULL,
  `created_time` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_comment_image` (`comment_id`,`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_image`
--

LOCK TABLES `comment_image` WRITE;
/*!40000 ALTER TABLE `comment_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `following`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `following` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `following_user_id` bigint(20) NOT NULL,
  `inserted_time` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `updated_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_following` (`user_id`,`following_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `following`
--

LOCK TABLES `following` WRITE;
/*!40000 ALTER TABLE `following` DISABLE KEYS */;
/*!40000 ALTER TABLE `following` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(4500) DEFAULT NULL,
  `image_link` varchar(255) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `created_time` bigint(20) NOT NULL DEFAULT '0',
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kindness_action`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kindness_action` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(1000) DEFAULT NULL,
  `content` longtext,
  `status` int(11) DEFAULT NULL,
  `created_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kindness_action`
--

LOCK TABLES `kindness_action` WRITE;
/*!40000 ALTER TABLE `kindness_action` DISABLE KEYS */;
/*!40000 ALTER TABLE `kindness_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kindness_action_image`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kindness_action_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `kindness_action_id` bigint(20) NOT NULL,
  `image_id` bigint(20) NOT NULL,
  `created_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_image` (`kindness_action_id`,`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kindness_action_image`
--

LOCK TABLES `kindness_action_image` WRITE;
/*!40000 ALTER TABLE `kindness_action_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `kindness_action_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kindness_feed`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kindness_feed` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `source_user_id` bigint(20) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `item_type` varchar(32) DEFAULT NULL,
  `inserted_time` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kindness_feed`
--

LOCK TABLES `kindness_feed` WRITE;
/*!40000 ALTER TABLE `kindness_feed` DISABLE KEYS */;
/*!40000 ALTER TABLE `kindness_feed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `server_setting`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `server_setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT '0',
  `value` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `server_setting`
--

LOCK TABLES `server_setting` WRITE;
/*!40000 ALTER TABLE `server_setting` DISABLE KEYS */;
/*!40000 ALTER TABLE `server_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `story_action`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `story_action` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `story_id` bigint(20) NOT NULL,
  `action_id` bigint(20) NOT NULL,
  `created_time` bigint(20) NOT NULL DEFAULT '0',
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_story_action` (`story_id`,`action_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `story_action`
--

LOCK TABLES `story_action` WRITE;
/*!40000 ALTER TABLE `story_action` DISABLE KEYS */;
/*!40000 ALTER TABLE `story_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `story_comment`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `story_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `story_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `content` longtext,
  `commented_time` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `story_comment`
--

LOCK TABLES `story_comment` WRITE;
/*!40000 ALTER TABLE `story_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `story_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `story_image`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `story_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `story_id` bigint(20) DEFAULT NULL,
  `image_id` bigint(20) DEFAULT NULL,
  `inserted_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_image` (`story_id`,`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `story_image`
--

LOCK TABLES `story_image` WRITE;
/*!40000 ALTER TABLE `story_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `story_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `story_reaction`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `story_reaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `story_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `reaction_id` varchar(45) NOT NULL,
  `reaction_time` bigint(20) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_user_story` (`story_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `story_reaction`
--

LOCK TABLES `story_reaction` WRITE;
/*!40000 ALTER TABLE `story_reaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `story_reaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `story_share`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `story_share` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `story_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `comment` varchar(4500) DEFAULT NULL,
  `shared_time` bigint(20) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_user_share_story` (`story_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `story_share`
--

LOCK TABLES `story_share` WRITE;
/*!40000 ALTER TABLE `story_share` DISABLE KEYS */;
/*!40000 ALTER TABLE `story_share` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suggest_kindness_action`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suggest_kindness_action` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `action_id` bigint(20) NOT NULL,
  `inserted_time` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suggest_kindness_action`
--

LOCK TABLES `suggest_kindness_action` WRITE;
/*!40000 ALTER TABLE `suggest_kindness_action` DISABLE KEYS */;
/*!40000 ALTER TABLE `suggest_kindness_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(64) NOT NULL,
  `email` varchar(64) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `avatar` varchar(245) DEFAULT NULL,
  `created_time` bigint(20) DEFAULT NULL,
  `updated_time` bigint(20) DEFAULT NULL,
  `push_token` varchar(4500) DEFAULT NULL,
  `device_id` varchar(64) DEFAULT NULL,
  `facebook_id` varchar(64) DEFAULT NULL,
  `google_id` varchar(64) DEFAULT NULL,
  `apple_id` varchar(64) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `is_confirm_follower` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_email` (`email`),
  UNIQUE KEY `idx_unique_phone` (`phone`),
  UNIQUE KEY `idx_facebook_id` (`facebook_id`),
  UNIQUE KEY `idx_google_id` (`google_id`),
  UNIQUE KEY `idx_apple_id` (`apple_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Duy Minh','duyminh215@gmail.com',NULL,'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_achievement`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_achievement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `achievement_id` bigint(20) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `reached_time` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_achievement`
--

LOCK TABLES `user_achievement` WRITE;
/*!40000 ALTER TABLE `user_achievement` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_achievement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_device`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_device` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `push_token` varchar(4500) DEFAULT NULL,
  `device_id` varchar(64) DEFAULT NULL,
  `inserted_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_user_device` (`user_id`,`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_device`
--

LOCK TABLES `user_device` WRITE;
/*!40000 ALTER TABLE `user_device` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_kindness_activity`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_kindness_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `kindness_action_id` bigint(20) DEFAULT NULL,
  `activity_title` varchar(450) DEFAULT NULL,
  `activity_content` longtext,
  `action_time` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_kindness_activity`
--

LOCK TABLES `user_kindness_activity` WRITE;
/*!40000 ALTER TABLE `user_kindness_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_kindness_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_notification`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_notification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `created_time` bigint(20) NOT NULL,
  `parent_type` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `hash_key` varchar(125) DEFAULT NULL,
  `icon` varchar(245) NOT NULL,
  `title` varchar(300) DEFAULT NULL,
  `body` varchar(1000) CHARACTER SET utf8mb4 DEFAULT NULL,
  `paramId1` bigint(20) NOT NULL DEFAULT '0',
  `paramId2` bigint(20) NOT NULL DEFAULT '0',
  `url` varchar(245) DEFAULT NULL,
  `is_read` tinyint(4) DEFAULT NULL,
  `icon_name` varchar(45) DEFAULT NULL,
  `paramId3` bigint(20) NOT NULL DEFAULT '0',
  `paramStr1` varchar(450) DEFAULT NULL,
  `reference_id` bigint(20) DEFAULT NULL,
  `push_status` tinyint(4) DEFAULT NULL,
  `param_id1` decimal(19,2) DEFAULT NULL,
  `param_id2` decimal(19,2) DEFAULT NULL,
  `param_id3` decimal(19,2) DEFAULT NULL,
  `param_str1` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_hash_key` (`hash_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_notification`
--

LOCK TABLES `user_notification` WRITE;
/*!40000 ALTER TABLE `user_notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_story`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_story` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `title` varchar(450) NOT NULL,
  `content` longtext NOT NULL,
  `status` int(11) DEFAULT NULL,
  `created_time` bigint(20) DEFAULT NULL,
  `number_of_like` int(11) NOT NULL DEFAULT '0',
  `number_of_dislike` int(11) NOT NULL DEFAULT '0',
  `number_of_comment` int(11) NOT NULL DEFAULT '0',
  `privacy_status` int(11) NOT NULL DEFAULT '0' COMMENT '0: only me\n1: friend\n2: public',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_story`
--

LOCK TABLES `user_story` WRITE;
/*!40000 ALTER TABLE `user_story` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_story` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'social'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-14 15:20:12
