CREATE DATABASE `movies` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `movies`; 

CREATE TABLE `movies` (
  `movieId` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(75) NOT NULL,
  `director` varchar(40) NOT NULL,
  `description` varchar(400) NOT NULL,
  `released` int(11) NOT NULL,
  PRIMARY KEY (`movieId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
