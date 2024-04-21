DROP TABLE IF EXISTS `comment_tbl`;

CREATE TABLE `comment_tbl` (
  `comment_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `recipe_id` int DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `user_id` (`user_id`),
  KEY `recipe_id` (`recipe_id`),
  CONSTRAINT `comment_tbl_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`),
  CONSTRAINT `comment_tbl_ibfk_2` FOREIGN KEY (`recipe_id`) REFERENCES `recipe_tbl` (`recipe_id`)
  )