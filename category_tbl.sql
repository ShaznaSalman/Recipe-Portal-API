DROP TABLE IF EXISTS `category_tbl`;

CREATE TABLE `category_tbl` (
  `category_id` int NOT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `category_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
  )