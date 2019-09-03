

ALTER TABLE `project` ADD  `t_status` tinyint(1) NULL DEFAULT NULL;

ALTER TABLE `project` ADD `t_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL;