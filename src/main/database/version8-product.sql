ALTER TABLE `codegym_crm`.`courses` 
DROP COLUMN `end_day`,
CHANGE COLUMN `start_day` `description` LONGTEXT NULL DEFAULT NULL , RENAME TO  `codegym_crm`.`products` ;

DROP TABLE IF EXISTS `accounts`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `accounts` (
  `id` varchar(40) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(45) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;