

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `circular`;
CREATE TABLE `circular` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` mediumtext NOT NULL COMMENT '公告内容',
  `start` datetime NOT NULL COMMENT '开始时间',
  `end` datetime NOT NULL COMMENT '结束时间',
  `visible` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0,不可见，1可见',
  `url` VARCHAR (255) NOT NULL DEFAULT '' COMMENT 'url',
  `create_date` timestamp NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='公告|jiac|20180117';