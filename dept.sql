/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : scis

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2018-04-11 21:00:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `chairman` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '1001', '计算机科学与工程', '小高', '12345678944', '计算机学院');
INSERT INTO `dept` VALUES ('2', '2001', '机械制造', '小倩', '12345678944', '机械制造学院');
INSERT INTO `dept` VALUES ('3', '3001', '人文', '小段', '12345678944', '人文学院');
