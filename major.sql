/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : scis

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2018-04-11 21:00:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `assistant` varchar(50) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `major_dept_id` (`dept_id`) USING BTREE,
  CONSTRAINT `major_dept_id` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '100101', '软件工程', '12345678944', '小高', '1');
INSERT INTO `major` VALUES ('2', '100102', '信息工程', '12345678944', '小高', '1');
INSERT INTO `major` VALUES ('3', '100103', '网络工程', '12345678944', '小胡', '1');
INSERT INTO `major` VALUES ('4', '100104', '物联网', '12345678944', '小倩', '1');
INSERT INTO `major` VALUES ('5', '200101', '机械制造', '12345678944', '小花', '2');
INSERT INTO `major` VALUES ('6', '200102', '数控技术', '12345678944', '小资', '2');
INSERT INTO `major` VALUES ('7', '200103', '铸造技术', '12345678944', '小南', '2');
INSERT INTO `major` VALUES ('8', '300101', '中国语言文学', '12345678944', 'GodV', '3');
INSERT INTO `major` VALUES ('9', '300102', '语言学及应用语言学', '12345678944', '小朱', '3');
INSERT INTO `major` VALUES ('10', '300103', '汉语言文字学', '12345678944', '笑笑', '3');
