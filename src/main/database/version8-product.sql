ALTER TABLE `codegym_crm`.`courses` 
DROP COLUMN `end_day`,
CHANGE COLUMN `start_day` `description` LONGTEXT NULL DEFAULT NULL , RENAME TO  `codegym_crm`.`products` ;