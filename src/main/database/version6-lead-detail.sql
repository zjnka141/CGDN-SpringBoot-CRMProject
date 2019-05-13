CREATE TABLE `lead_detail` (
  `id` varchar(45) NOT NULL,
  `leads_id` varchar(45) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `last_update_lead_detail_date` datetime DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `last_updated_by` varchar(45) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `version` bigint(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lead_detail_leads1_idx` (`leads_id`),
  CONSTRAINT `fk_lead_detail_leads1` FOREIGN KEY (`leads_id`) REFERENCES `leads` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci