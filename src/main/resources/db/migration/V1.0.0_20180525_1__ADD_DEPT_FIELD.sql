



ALTER TABLE `dept` ADD   `create_date` varchar(50) NULL DEFAULT NULL COMMENT '创建时间';

ALTER TABLE `dept` ADD   `update_date` varchar(50) NULL DEFAULT NULL COMMENT '更新时间';

ALTER TABLE `major` ADD   `create_date` varchar(50) NULL DEFAULT NULL COMMENT '创建时间';

ALTER TABLE `major` ADD   `update_date` varchar(50) NULL DEFAULT NULL COMMENT '更新时间';

CREATE TABLE `type` (
  `id`  int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '类型名称',
  `num` int(22) NOT NULL,
  `number` int(11) DEFAULT NULL COMMENT '类型拥有的app数量',
  `create_date` varchar(50) NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` varchar(50) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='类型';

ALTER TABLE `project` ADD  `type_id`  int(11) NULL DEFAULT NULL;

ALTER TABLE `project` ADD CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`);