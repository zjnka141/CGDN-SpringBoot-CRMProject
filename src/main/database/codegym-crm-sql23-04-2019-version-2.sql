ALTER TABLE `codegym_crm`.`campaigns`
CHANGE COLUMN `delected` `deleted` BIT(1) NOT NULL ;

ALTER TABLE `codegym_crm`.`classes`
CHANGE COLUMN `delected` `deleted` BIT(1) NOT NULL ;

ALTER TABLE `codegym_crm`.`leads`
CHANGE COLUMN `delected` `deleted` BIT(1) NOT NULL ;

ALTER TABLE `codegym_crm`.`students`
CHANGE COLUMN `delected` `deleted` BIT(1) NOT NULL ;

ALTER TABLE `codegym_crm`.`campaigns`
ADD COLUMN `start_day` DATE NOT NULL AFTER `deleted`,
ADD COLUMN `end_day` DATE NOT NULL AFTER `start_day`,
ADD COLUMN `phone_number` VARCHAR(45) NOT NULL AFTER `end_day`;
