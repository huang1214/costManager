






-- ----------------------------
-- Table structure for allot
-- ----------------------------
DROP TABLE IF EXISTS `allot`;
CREATE TABLE `allot`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NULL DEFAULT NULL,
  `expert_id` int(11) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `end` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `allot_project_id`(`project_id`) USING BTREE,
  INDEX `allot_expert_id`(`expert_id`) USING BTREE,
  CONSTRAINT `allot_expert_id` FOREIGN KEY (`expert_id`) REFERENCES `expert` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `allot_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of allot
-- ----------------------------
INSERT INTO `allot` VALUES (1, 1, 1, '1111', '2018-04-07', '2018-04-07');