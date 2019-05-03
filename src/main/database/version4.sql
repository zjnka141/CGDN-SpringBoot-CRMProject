ALTER TABLE `codegym_crm`.`students`
ADD COLUMN `email` VARCHAR(45) NULL AFTER `deleted`,
ADD COLUMN `phone_number` VARCHAR(45) NOT NULL AFTER `email`;

