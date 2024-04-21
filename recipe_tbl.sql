DROP TABLE IF EXISTS `recipe_tbl`;

CREATE TABLE `recipe_tbl` (
  `rec_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `rec_title` varchar(255) DEFAULT NULL,
  `rec_description` varchar(255) DEFAULT NULL,
  `rec_prepstep` varchar(255) DEFAULT NULL,
  `rec_cookingtime` varchar(255) DEFAULT NULL,
  `rec_image` varchar(255) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`rec_id`),
  KEY `user_id` (`user_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `recipe_tbl_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`),
  CONSTRAINT `recipe_tbl_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `category_tbl` (`category_id`)
  )