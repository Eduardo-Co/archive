CREATE TABLE IF NOT EXISTS `theme` (
  `theme_id` int AUTO_INCREMENT  PRIMARY KEY,
  `description` varchar(100) NOT NULL,
  `created_at` date NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `subtopic` (
  `subtopic_id` int AUTO_INCREMENT  PRIMARY KEY,
  `description` varchar(100) NOT NULL,
  `content` varchar(1000) NOT NULL,
  `topic_id` int,
  `created_at` date NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  FOREIGN KEY (`topic_id`) REFERENCES `topic`(`topic_id`)
);