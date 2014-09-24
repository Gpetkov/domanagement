



-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
-- SET FOREIGN_KEY_CHECKS=0;

-- ---
-- Table 'employee'
-- 
-- ---
DROP DATABASE IF EXISTS `pl_db`;

CREATE DATABASE `pl_db`;

USE `pl_db`;

DROP TABLE IF EXISTS `employee`;
		
CREATE TABLE `employee` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(76) NOT NULL DEFAULT 'NULL',
  `second_name` VARCHAR(76) NOT NULL DEFAULT 'NULL',
  `last_name` VARCHAR(76) NOT NULL DEFAULT 'NULL',
  `username` VARCHAR(200) NOT NULL DEFAULT 'NULL',
  `password` VARCHAR(16) NOT NULL DEFAULT 'NULL',
  `education_id` BIGINT NOT NULL,
  `department_id` BIGINT NOT NULL,
  `city_id` BIGINT NOT NULL,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NOT NULL,
  `is_active` bit NOT NULL,
  `email_address` VARCHAR(300) NOT NULL,
  `role_id` BIGINT NOT NULL,
  `date_created` DATETIME NOT NULL,
  `date_updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
KEY (`education_id`),
KEY (`department_id`)
);

-- ---
-- Table 'area'
-- 
-- ---

DROP TABLE IF EXISTS `area`;
		
CREATE TABLE `area` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `manager_id` BIGINT NOT NULL,
  `country_id` BIGINT NOT NULL,
  `date_created` DATETIME NOT NULL,
  `date_updated` TIMESTAMP NOT NULL,
  `hr_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
KEY (`manager_id`)
);

-- ---
-- Table 'region'
-- 
-- ---

DROP TABLE IF EXISTS `region`;
		
CREATE TABLE `region` (
  `id` BIGINT NOT NULL AUTO_INCREMENT DEFAULT NULL,
  `name` VARCHAR(200) NOT NULL,
  `area_id` BIGINT NOT NULL,
  `manager_id` BIGINT NOT NULL,
  `date_created` DATETIME NOT NULL,
  `date_updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
KEY (`area_id`)
);

-- ---
-- Table 'department'
-- 
-- ---

DROP TABLE IF EXISTS `department`;
		
CREATE TABLE `department` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(300) NOT NULL,
  `date_created` DATETIME NOT NULL,
  `date_updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'education'
-- 
-- ---

DROP TABLE IF EXISTS `education`;
		
CREATE TABLE `education` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL DEFAULT 'NULL',
  `date_created` DATETIME NOT NULL,
  `date_updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'city'
-- 
-- ---

DROP TABLE IF EXISTS `city`;
		
CREATE TABLE `city` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `postal_code` INTEGER(100) NOT NULL,
  `region_id` BIGINT NOT NULL,
  `date_created` DATETIME NOT NULL,
  `date_updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
KEY (`region_id`)
);

-- ---
-- Table 'country'
-- 
-- ---

DROP TABLE IF EXISTS `country`;
		
CREATE TABLE `country` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `language` VARCHAR(100) NOT NULL,
  `postal_code` INTEGER(100) NOT NULL,
  `date_created` DATETIME NOT NULL,
  `date_updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'address'
-- 
-- ---

DROP TABLE IF EXISTS `address`;
		
CREATE TABLE `address` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(312) NOT NULL,
  `building` TINYINT NOT NULL,
  `floor` TINYINT NULL DEFAULT NULL,
  `entrance` VARCHAR(9) NULL,
  `city_id` BIGINT NOT NULL,
  `date_created` DATETIME NOT NULL,
  `date_updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'employee_to_address'
-- 
-- ---

DROP TABLE IF EXISTS `employee_to_address`;
		
CREATE TABLE `employee_to_address` (
  `employee_id` BIGINT NOT NULL,
  `address_id` BIGINT NOT NULL,
  `date_created` DATETIME NOT NULL,
  `date_updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`employee_id`, `address_id`)
);

-- ---
-- Table 'role'
-- 
-- ---

DROP TABLE IF EXISTS `role`;
		
CREATE TABLE `role` (
  `id` BIGINT NULL AUTO_INCREMENT DEFAULT NULL,
  `date_created` DATETIME NOT NULL,
  `date_updated` TIMESTAMP NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'user_to_role'
-- 
-- ---

DROP TABLE IF EXISTS `user_to_role`;
		
CREATE TABLE `user_to_role` (
  `employee_id` BIGINT NOT NULL,
  `role_id` BIGINT NOT NULL,
  `date_created` DATETIME NOT NULL,
  `date_updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`employee_id`, `role_id`)
);

-- ---
-- Table 'request'
-- 
-- ---

DROP TABLE IF EXISTS `request`;
		
CREATE TABLE `request` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `employee_id` BIGINT NOT NULL,
  `request_type_id` BIGINT NOT NULL,
  `year` INTEGER NOT NULL,
  `month` INTEGER NOT NULL,
  `list_of_days` VARCHAR(310) NOT NULL,
  `comment_id` BIGINT NULL,
  `request_status_id` BIGINT NOT NULL,
  `date_created` DATETIME NOT NULL,
  `date_updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'request_type'
-- paid,unpaid,year
-- ---

DROP TABLE IF EXISTS `request_type`;
		
CREATE TABLE `request_type` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `date_created` DATETIME NOT NULL,
  `date_updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
) COMMENT 'paid,unpaid,year';

-- ---
-- Table 'comment'
-- 
-- ---

DROP TABLE IF EXISTS `comment`;
		
CREATE TABLE `comment` (
  `id` BIGINT NULL AUTO_INCREMENT DEFAULT NULL,
  `content` MEDIUMTEXT NOT NULL,
  `employee_id` BIGINT NOT NULL,
  `date_created` DATETIME NOT NULL,
  `date_updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'request_status'
-- waiting for approval, waiting for archive, approved, rejected
-- ---

DROP TABLE IF EXISTS `request_status`;
		
CREATE TABLE `request_status` (
  `id` BIGINT NULL AUTO_INCREMENT DEFAULT NULL,
  `name` VARCHAR(100) NOT NULL,
  `date_created` DATETIME NULL,
  `date_updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
) COMMENT 'waiting for approval, waiting for archive, approved, rejecte';

-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `employee` ADD FOREIGN KEY (education_id) REFERENCES `education` (`id`);
ALTER TABLE `employee` ADD FOREIGN KEY (department_id) REFERENCES `department` (`id`);
ALTER TABLE `employee` ADD FOREIGN KEY (city_id) REFERENCES `city` (`id`);
ALTER TABLE `employee` ADD UNIQUE (username);
ALTER TABLE `area` ADD FOREIGN KEY (manager_id) REFERENCES `employee` (`id`);
ALTER TABLE `area` ADD FOREIGN KEY (country_id) REFERENCES `country` (`id`);
ALTER TABLE `area` ADD FOREIGN KEY (hr_id) REFERENCES `employee` (`id`);
ALTER TABLE `region` ADD FOREIGN KEY (area_id) REFERENCES `area` (`id`);
ALTER TABLE `region` ADD FOREIGN KEY (manager_id) REFERENCES `employee` (`id`);
ALTER TABLE `city` ADD FOREIGN KEY (region_id) REFERENCES `region` (`id`);
ALTER TABLE `address` ADD FOREIGN KEY (city_id) REFERENCES `city` (`id`);
ALTER TABLE `employee_to_address` ADD FOREIGN KEY (employee_id) REFERENCES `employee` (`id`);
ALTER TABLE `employee_to_address` ADD FOREIGN KEY (employee_id) REFERENCES `employee` (`id`);
ALTER TABLE `employee_to_address` ADD FOREIGN KEY (employee_id) REFERENCES `employee` (`id`);
ALTER TABLE `employee_to_address` ADD FOREIGN KEY (address_id) REFERENCES `address` (`id`);
ALTER TABLE `user_to_role` ADD FOREIGN KEY (employee_id) REFERENCES `employee` (`id`);
ALTER TABLE `user_to_role` ADD FOREIGN KEY (role_id) REFERENCES `role` (`id`);
ALTER TABLE `request` ADD FOREIGN KEY (employee_id) REFERENCES `employee` (`id`);
ALTER TABLE `request` ADD FOREIGN KEY (request_type_id) REFERENCES `request_type` (`id`);
ALTER TABLE `request` ADD FOREIGN KEY (comment_id) REFERENCES `comment` (`id`);
ALTER TABLE `request` ADD FOREIGN KEY (request_status_id) REFERENCES `request_status` (`id`);
ALTER TABLE `comment` ADD FOREIGN KEY (employee_id) REFERENCES `employee` (`id`);





-- ---
-- Unique columns for city, region, area
-- ---

ALTER TABLE `city` ADD UNIQUE `unique_city`(`name`, `region_id`);
ALTER TABLE `region` ADD UNIQUE `unique_region`(`name`, `area_id`);
ALTER TABLE `area` ADD UNIQUE `unique_city`(`name`, `country_id`);


-- ---
-- Table Properties
-- ---

-- ALTER TABLE `employee` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `area` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `region` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `department` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `education` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `city` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `country` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `address` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `employee_to_address` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `role` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `user_to_role` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `request` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `request_type` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `comment` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `request_status` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Test Data
-- ---

-- INSERT INTO `employee` (`id`,`first_name`,`second_name`,`last_name`,`education_id`,`new field`,`department_id`,`city_id`,`start_date`,`end_date`,`is_active`,`email_address`,`role_id`) VALUES
-- ('','','','','','','','','','','','','');
-- INSERT INTO `area` (`id`,`name`,`manager_id`,`country_id`,`date_created`,`date_updated`,`hr_id`) VALUES
-- ('','','','','','','');
-- INSERT INTO `region` (`id`,`name`,`area_id`,`manager_id`,`date_created`,`date_updated`) VALUES
-- ('','','','','','');
-- INSERT INTO `department` (`id`,`name`,`date_created`,`date_updated`) VALUES
-- ('','','','');
-- INSERT INTO `education` (`id`,`name`,`date_created`,`date_updated`) VALUES
-- ('','','','');
-- INSERT INTO `city` (`id`,`name`,`postal_code`,`region_id`,`date_created`,`date_updated`) VALUES
-- ('','','','','','');
-- INSERT INTO `country` (`id`,`name`,`language`,`postal_code`,`date_created`,`date_updated`) VALUES
-- ('','','','','','');
-- INSERT INTO `address` (`id`,`street`,`building`,`floor`,`entrance`,`city_id`,`date_created`,`date_updated`) VALUES
-- ('','','','','','','','');
-- INSERT INTO `employee_to_address` (`employee_id`,`address_id`,`date_created`,`date_updated`) VALUES
-- ('','','','');
-- INSERT INTO `role` (`id`,`date_created`,`date_updated`,`name`) VALUES
-- ('','','','');
-- INSERT INTO `user_to_role` (`employee_id`,`role_id`,`date_created`,`date_updated`) VALUES
-- ('','','','');
-- INSERT INTO `request` (`id`,`employee_id`,`request_type_id`,`year`,`month`,`list_of_days`,`comment_id`,`request_status_id`,`date_created`,`date_updated`) VALUES
-- ('','','','','','','','','','');
-- INSERT INTO `request_type` (`id`,`name`,`date_created`,`date_updated`) VALUES
-- ('','','','');
-- INSERT INTO `comment` (`id`,`content`,`employee_id`,`date_created`,`date_updated`) VALUES
-- ('','','','','');
-- INSERT INTO `request_status` (`id`,`name`,`date_created`,`date_updated`) VALUES
-- ('','','','');

