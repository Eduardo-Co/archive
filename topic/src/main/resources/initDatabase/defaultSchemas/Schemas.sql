CREATE TABLE IF NOT EXISTS `topic` (
    `topic_id` INT AUTO_INCREMENT PRIMARY KEY,
    `theme_id` BIGINT NOT NULL,
    `title` VARCHAR(100) NOT NULL,
    `content` TEXT NOT NULL,
    `created_at` DATE NOT NULL,
    `created_by` VARCHAR(20) NOT NULL,
    `updated_at` DATE DEFAULT NULL,
    `updated_by` VARCHAR(20) DEFAULT NULL,
    FOREIGN KEY (`theme_id`) REFERENCES `theme`(`theme_id`)
);