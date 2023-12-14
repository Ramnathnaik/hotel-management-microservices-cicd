CREATE database if not exists microservices;

USE microservices;

DROP TABLE IF exists `question`;

CREATE TABLE `question` (
  `question_id` bigint NOT NULL AUTO_INCREMENT,
  `question` varchar(255) DEFAULT NULL,
  `quiz_id` bigint DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF exists `quiz`;

CREATE TABLE `quiz` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF exists `user`;

CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `about` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` int DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE database if not exists rating_microservices;

use rating_microservices;

create table `hibernate_sequence` (`next_val` bigint);

insert into `hibernate_sequence` values ( 1 );

CREATE TABLE `rating` (
  `rating_id` INT NOT NULL,
  `user_id` VARCHAR(45) NULL,
  `hotel_id` VARCHAR(45) NULL,
  `rating` INT NULL,
  `feedback` LONGTEXT NULL,
  PRIMARY KEY (`rating_id`));
