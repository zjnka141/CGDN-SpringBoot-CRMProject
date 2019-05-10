ALTER TABLE `codegym_crm`.`classes`
ADD COLUMN `start_day` DATETIME NULL AFTER `deleted`,
ADD COLUMN `end_day` DATETIME NULL AFTER `start_day`,
ADD COLUMN `learning_status` VARCHAR(45) NULL AFTER `end_day`;
ADD COLUMN `total_student` INT NULL AFTER `learning_status`;
