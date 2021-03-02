/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : 127.0.0.1:3306
 Source Schema         : avmdb

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 02/03/2021 14:24:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_function_group
-- ----------------------------
DROP TABLE IF EXISTS `t_function_group`;
CREATE TABLE `t_function_group`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `group_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '分组名称',
  `group_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '分组编号',
  `parent_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'parentCode',
  `group_desc` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'groupDesc',
  `group_type` int(0) NOT NULL DEFAULT -1 COMMENT 'groupType',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_function_group' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
