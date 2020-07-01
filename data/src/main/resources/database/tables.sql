CREATE TABLE `workflowDetail`.`workflow_detail` (
    `id` INT NOT NULL,
    `name` VARCHAR(128) NOT NULL,
    `status` VARCHAR(12) NOT NULL,
    `created_on` DATETIME NOT NULL,
    `created_by` VARCHAR(150) NOT NULL,
    `updated_on` DATETIME NULL,
    `updated_by` VARCHAR(150) NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `workflowDetail`.`step_detail` (
    `id` INT NOT NULL,
    `name` VARCHAR(128) NOT NULL,
    `bean` VARCHAR(1024) NOT NULL,
    `payload` BLOB NULL,
    `status` VARCHAR(12) NOT NULL,
    `created_on` DATETIME NOT NULL,
    `created_by` VARCHAR(150) NOT NULL,
    `updated_on` DATETIME NULL,
    `updated_by` VARCHAR(150) NULL,
    PRIMARY KEY (`id`)
);

 CREATE TABLE `workflowDetail`.`workflow_step_detail` (
    `id` INT NOT NULL,
    `workflow_id` INT NOT NULL,
    `step_id` INT NOT NULL,
    `previous_id` INT NULL,
    `next_id` INT NULL,
    `response_code` CHAR(3) NULL,
    `payload` BLOB NULL,
    `status` VARCHAR(12) NULL,
    `created_on` DATETIME NOT NULL,
    `created_by` VARCHAR(150) NOT NULL,
    `updated_on` DATETIME NULL,
    `updated_by` VARCHAR(150) NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_sd_wkfl_id` FOREIGN KEY (`workflow_id`)
        REFERENCES `workflowDetail`.`workflow_detail` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_sd_step_id` FOREIGN KEY (`step_id`)
        REFERENCES `workflowDetail`.`step_detail` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_sd_step_prv_id` FOREIGN KEY (`previous_id`)
        REFERENCES `workflowDetail`.`workflow_step_detail` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_sd_step_nxt_id` FOREIGN KEY (`next_id`)
        REFERENCES `workflowDetail`.`workflow_step_detail` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `workflowDetail`.`workflow_instance_detail` (
    `id` INT NOT NULL,
    `workflow_id` INT NOT NULL,
    `schedule` VARCHAR(128) NOT NULL,
    `payload` BLOB NULL,
    `status` VARCHAR(12) NOT NULL,
    `created_on` DATETIME NOT NULL,
    `created_by` VARCHAR(150) NOT NULL,
    `updated_on` DATETIME NULL,
    `updated_by` VARCHAR(150) NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_ins_dtl_wkfl_id` FOREIGN KEY (`workflow_id`)
        REFERENCES `workflowDetail`.`workflow_detail` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

create TABLE `workflowDetail`.`workflow_instance_footprint` (
  `id` INT NOT NULL,
  `workflow_instance_id` INT NOT NULL,
  `workflow_step_id` INT NOT NULL,
  `response_code` CHAR(3) NULL,
  `response` BLOB NULL,
  `started_at` DATETIME NULL,
  `ended_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_fp_wkfl_ins_id_idx` (`workflow_instance_id` ASC) VISIBLE,
  INDEX `fk_fp_wkfl_step_id_idx` (`workflow_step_id` ASC) VISIBLE,
  CONSTRAINT `fk_fp_wkfl_ins_id`
    FOREIGN KEY (`workflow_instance_id`)
    REFERENCES `workflowDetail`.`workflow_instance_detail` (`id`)
    ON delete NO ACTION
    ON update NO ACTION,
  CONSTRAINT `fk_fp_wkfl_step_id`
    FOREIGN KEY (`workflow_step_id`)
    REFERENCES `workflowDetail`.`workflow_step_detail` (`id`)
    ON delete NO ACTION
    ON update NO ACTION);
