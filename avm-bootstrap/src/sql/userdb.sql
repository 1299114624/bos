/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 127.0.0.1:3306
 Source Schema         : userdb

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 05/08/2021 11:24:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `res_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源编码',
  `parent_id` bigint(11) NULL DEFAULT NULL COMMENT '父资源id',
  `app_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '应用名称',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能名称',
  `disabled` int(11) NULL DEFAULT 1 COMMENT '是否禁用',
  `ismenu` int(11) NULL DEFAULT 1 COMMENT '是否菜单',
  `menu_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `menu_url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `orderby` int(11) NULL DEFAULT 1 COMMENT '排序',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `add_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT 'addTime',
  `add_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'addUser',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'updateTime',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'updateUser',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_resource
-- ----------------------------
INSERT INTO `t_resource` VALUES (1, 'AVM', NULL, 'AVM', '基础信息维护', 1, 1, '0', NULL, 1, NULL, '2021-07-05 10:25:38', NULL, '2021-07-05 10:25:40', NULL);
INSERT INTO `t_resource` VALUES (2, 'AVM01', 1, 'AVM', '组件管理', 1, 1, '1', '', 1, NULL, '2021-07-05 10:27:07', NULL, '2021-07-21 16:23:30', NULL);
INSERT INTO `t_resource` VALUES (3, 'AVM02', 1, 'AVM', '功能管理', 1, 1, '1', NULL, 1, NULL, '2021-07-05 10:28:30', NULL, '2021-07-05 10:29:33', NULL);
INSERT INTO `t_resource` VALUES (4, 'AVM03', 1, 'AVM', '产品管理', 1, 1, '1', '', 1, NULL, '2021-07-05 10:29:39', NULL, '2021-07-06 14:37:01', NULL);
INSERT INTO `t_resource` VALUES (5, 'AVM04', 1, 'AVM', '客户管理', 1, 1, '1', '/company/list', 1, NULL, '2021-07-05 10:30:43', NULL, '2021-07-21 16:38:27', NULL);
INSERT INTO `t_resource` VALUES (6, 'AVM0301', 4, 'AVM', '产品管理', 1, 1, '2', NULL, 1, NULL, '2021-07-05 10:31:55', NULL, '2021-07-05 10:31:56', NULL);
INSERT INTO `t_resource` VALUES (7, 'AVM0302', 4, 'AVM', '产品管理详情', 1, 1, '2', NULL, 1, NULL, '2021-07-05 10:32:26', NULL, '2021-07-05 10:32:28', NULL);
INSERT INTO `t_resource` VALUES (8, 'AVM0401', 5, 'AVM', '客户管理', 1, 1, '2', NULL, 1, NULL, '2021-07-05 10:33:10', NULL, '2021-07-05 10:33:11', NULL);
INSERT INTO `t_resource` VALUES (9, 'AVM0402', 5, 'AVM', '客户管理详情', 1, 1, '2', NULL, 1, NULL, '2021-07-05 10:33:35', NULL, '2021-07-05 10:33:37', NULL);
INSERT INTO `t_resource` VALUES (10, 'AVM0101', 2, 'AVM', '新增组件', 1, 1, '2', '/component/add', 1, NULL, '2021-07-21 15:59:10', NULL, '2021-07-21 15:59:10', NULL);
INSERT INTO `t_resource` VALUES (11, 'AVM0102', 2, 'AVM', '批量新增组件', 1, 1, '2', '', 1, NULL, '2021-07-21 15:59:23', NULL, '2021-07-21 16:23:17', NULL);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `business_type` int(11) NULL DEFAULT -1 COMMENT '业务类型',
  `account_range` int(11) NULL DEFAULT -1 COMMENT '账户范围',
  `org_type` int(11) NULL DEFAULT -1 COMMENT '组织类型',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'allOperation', -1, 1, -1, NULL);
INSERT INTO `t_role` VALUES (2, '运维', -1, -1, -4, NULL);

-- ----------------------------
-- Table structure for t_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_role_resource`;
CREATE TABLE `t_role_resource`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '目录ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_resource
-- ----------------------------
INSERT INTO `t_role_resource` VALUES (1, 1);
INSERT INTO `t_role_resource` VALUES (1, 2);
INSERT INTO `t_role_resource` VALUES (1, 3);
INSERT INTO `t_role_resource` VALUES (1, 4);
INSERT INTO `t_role_resource` VALUES (1, 5);
INSERT INTO `t_role_resource` VALUES (1, 6);
INSERT INTO `t_role_resource` VALUES (1, 7);
INSERT INTO `t_role_resource` VALUES (1, 8);
INSERT INTO `t_role_resource` VALUES (1, 9);
INSERT INTO `t_role_resource` VALUES (1, 10);
INSERT INTO `t_role_resource` VALUES (1, 11);
INSERT INTO `t_role_resource` VALUES (2, 1);
INSERT INTO `t_role_resource` VALUES (2, 2);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `add_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT 'addTime',
  `add_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'addUser',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT 'updateTime',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'updateUser',
  `is_limit` bit(1) NULL DEFAULT b'0' COMMENT '是否受限用户',
  `is_close` bit(1) NULL DEFAULT b'0' COMMENT '注销用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'allOp', '5a172a4673460c90736ecf86a8596588a7c13b0a3f681d6271eccd21833487b4', '全部权限用户', '2021-06-18 13:50:25', '', '2021-06-18 13:50:25', '', b'0', b'0');
INSERT INTO `t_user` VALUES (3, 'ceshi1', '5a172a4673460c90736ecf86a8596588a7c13b0a3f681d6271eccd21833487b4', '权限测试用户1', '2021-07-05 19:17:39', '', '2021-07-05 19:17:41', '', b'0', b'0');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, 1);
INSERT INTO `t_user_role` VALUES (3, 2);

SET FOREIGN_KEY_CHECKS = 1;
