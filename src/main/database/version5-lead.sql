ALTER TABLE `codegym_crm`.`leads`
ADD COLUMN `product` VARCHAR(45) NOT NULL AFTER `id`,
ADD COLUMN `admission_date` DATETIME NULL AFTER `last_updated_by`,
ADD COLUMN `last_update_status_date` DATETIME NULL AFTER `campaigns_id`,
ADD COLUMN `job` VARCHAR(45) NULL AFTER `last_update_status_date`,
ADD COLUMN `gender` VARCHAR(45) NOT NULL AFTER `job`;
CHANGE COLUMN `status` `status` VARCHAR(45) NOT NULL AFTER `product`,
CHANGE COLUMN `source` `source` VARCHAR(45) NOT NULL ,
CHANGE COLUMN `last_updated_date` `last_updated_date` DATETIME NULL ;
ALTER TABLE `codegym_crm`.`leads`
DROP FOREIGN KEY `fk_leads_campaigns1`;
ALTER TABLE `codegym_crm`.`leads`
CHANGE COLUMN `campaigns_id` `campaigns_id` VARCHAR(36) NULL ;

ADD CONSTRAINT `fk_leads_campaigns1`
  FOREIGN KEY (`campaigns_id`)
  REFERENCES `codegym_crm`.`campaigns` (`id`);