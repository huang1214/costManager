DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_num` int(20) DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `operation` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `operation_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;