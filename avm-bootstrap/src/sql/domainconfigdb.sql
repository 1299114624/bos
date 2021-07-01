/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 127.0.0.1:3306
 Source Schema         : domainconfigdb

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 01/07/2021 19:42:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_app
-- ----------------------------
DROP TABLE IF EXISTS `t_app`;
CREATE TABLE `t_app`  (
  `app_id` int(11) NOT NULL COMMENT '应用编号',
  `app_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用名称',
  `app_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`app_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_app
-- ----------------------------
INSERT INTO `t_app` VALUES (1, 'TSM', '异常交易行为监控和处置系统');
INSERT INTO `t_app` VALUES (2, 'ERS', '外部接入管理系统');

-- ----------------------------
-- Table structure for t_environment_parameter
-- ----------------------------
DROP TABLE IF EXISTS `t_environment_parameter`;
CREATE TABLE `t_environment_parameter`  (
  `id` int(11) NOT NULL COMMENT 'ID',
  `para_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数名',
  `para_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数值',
  `para_desc` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数描述',
  `status` bit(1) NULL DEFAULT NULL COMMENT '是否启用',
  `is_encrypt` bit(1) NULL DEFAULT NULL COMMENT '0-不加密 1-加密',
  `sort_field` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排序字段',
  `sort_num` int(11) NULL DEFAULT NULL COMMENT '排序顺序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_environment_parameter
-- ----------------------------
INSERT INTO `t_environment_parameter` VALUES (1, 'tsm.upload.dir', '/home/archforce/files/', '上传文件基础路径', b'1', b'0', 'tsm', 1);
INSERT INTO `t_environment_parameter` VALUES (2, 'expireTime', '18000000', '会话超时时间，单位毫秒', b'1', b'0', 'userdb', 2);
INSERT INTO `t_environment_parameter` VALUES (3, 'domainconfigdb.database.host', '127.0.0.1:3306', '配置中心数据库ip', b'1', b'0', 'domainconfigdb', 3);
INSERT INTO `t_environment_parameter` VALUES (4, 'domainconfigdb.database.username', 'root', '配置中心数据库用户名', b'1', b'0', 'domainconfigdb', 4);
INSERT INTO `t_environment_parameter` VALUES (5, 'domainconfigdb.database.password', 'Vl9kolqsxX65cWET7SKx2g==', '配置中心数据库密码', b'1', b'1', 'domainconfigdb', 5);

-- ----------------------------
-- Table structure for t_sys_parameter
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_parameter`;
CREATE TABLE `t_sys_parameter`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `app_id` int(11) NULL DEFAULT NULL COMMENT '应用',
  `module_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组件编码',
  `broker_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件实例名',
  `para_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '参数名',
  `para_value` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '参数值',
  `para_type` tinyint(1) NULL DEFAULT NULL COMMENT '类别：1产品参数、2客制化参数，默认是2',
  `status` bit(1) NULL DEFAULT NULL COMMENT '状态（0启用 1禁用）',
  `para_desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数描述',
  `is_encrypt` bit(1) NULL DEFAULT NULL COMMENT '0-不加密 1-加密',
  `sort_field` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排序字段',
  `sort_num` int(11) NULL DEFAULT NULL COMMENT '排序顺序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 't_sys_parameter' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_parameter
-- ----------------------------
INSERT INTO `t_sys_parameter` VALUES (1, 1, 'BOS', 'BOS_1_1_11', 'conf.instance.name', 'BOS_1_1_11', 2, b'1', '实例名', b'0', NULL, NULL);
INSERT INTO `t_sys_parameter` VALUES (2, 1, 'BOS', '', 'upload-dir', '${tsm.upload.dir}', 1, b'1', '上传文件基础路径', b'0', NULL, NULL);
INSERT INTO `t_sys_parameter` VALUES (3, 1, 'BOS', NULL, 'identity.expireTime', '${expireTime}', 1, b'1', '会话超时时间（毫秒）', b'0', 'identity', NULL);
INSERT INTO `t_sys_parameter` VALUES (4, 1, 'BOS', NULL, 'domainconfigdb.datasource.url', 'jdbc:mysql://${domainconfigdb.database.host}/domainconfigdb?useSSL=false&allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&autoReconnectForPools=true', 1, b'1', '配置数据库地址', b'0', 'domainconfigdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (5, 1, 'BOS', NULL, 'domainconfigdb.datasource.username', '${domainconfigdb.database.username}', 1, b'1', '数据库账户', b'0', 'domainconfigdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (6, 1, 'BOS', NULL, 'domainconfigdb.datasource.password', '${domainconfigdb.database.password}', 1, b'1', '数据库账户登录密码', b'0', 'domainconfigdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (7, 1, 'BOS', NULL, 'domainconfigdb.datasource.driver-class-name', 'com.mysql.jdbc.Driver', 1, b'1', '指定driver的类名', b'0', 'domainconfigdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (8, 1, 'BOS', NULL, 'spring.datasource.url', 'jdbc:mysql://localhost:3306/domainconfigdb?serverTimezone=UTC', 1, b'1', '配置数据库地址', b'0', 'domainconfigdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (9, 1, 'BOS', NULL, 'spring.datasource.username', 'root', 1, b'1', '数据库账户', b'0', 'domainconfigdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (10, 1, 'BOS', NULL, 'spring.datasource.password', 'root', 1, b'1', '数据库账户登录密码', b'0', 'domainconfigdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (11, 1, 'BOS', NULL, 'spring.datasource.driver-class-name', 'com.mysql.jdbc.Driver', 1, b'1', '指定driver的类名', b'0', 'domainconfigdb', NULL);

SET FOREIGN_KEY_CHECKS = 1;
