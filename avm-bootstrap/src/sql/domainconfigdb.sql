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

 Date: 05/08/2021 11:24:13
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
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `para_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数名',
  `para_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数值',
  `para_desc` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数描述',
  `status` bit(1) NULL DEFAULT NULL COMMENT '是否启用',
  `is_encrypt` bit(1) NULL DEFAULT NULL COMMENT '0-不加密 1-加密',
  `sort_field` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排序字段',
  `sort_num` int(11) NULL DEFAULT NULL COMMENT '排序顺序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_environment_parameter
-- ----------------------------
INSERT INTO `t_environment_parameter` VALUES (1, 'tsm.upload.dir', '/home/archforce/files/', '上传文件基础路径', b'1', b'0', 'tsm', 1);
INSERT INTO `t_environment_parameter` VALUES (2, 'expireTime', '18000000', '会话超时时间，单位毫秒', b'1', b'0', 'userdb', 2);
INSERT INTO `t_environment_parameter` VALUES (3, 'domainconfigdb.database.host', '127.0.0.1:3306', '配置中心数据库ip', b'1', b'0', 'domainconfigdb', 3);
INSERT INTO `t_environment_parameter` VALUES (4, 'domainconfigdb.database.username', 'root', '配置中心数据库用户名', b'1', b'0', 'domainconfigdb', 4);
INSERT INTO `t_environment_parameter` VALUES (5, 'domainconfigdb.database.password', 'Vl9kolqsxX65cWET7SKx2g==', '配置中心数据库密码', b'1', b'1', 'domainconfigdb', 5);
INSERT INTO `t_environment_parameter` VALUES (6, 'userdb.database.host', '127.0.0.1:3306', '用户管理数据库ip', b'1', b'0', 'userdb', 6);
INSERT INTO `t_environment_parameter` VALUES (7, 'userdb.database.username', 'root', '用户管理数据库用户名', b'1', b'0', 'userdb', 7);
INSERT INTO `t_environment_parameter` VALUES (8, 'userdb.database.password', 'Vl9kolqsxX65cWET7SKx2g==', '用户管理数据库密码', b'1', b'0', 'userdb', 8);
INSERT INTO `t_environment_parameter` VALUES (9, 'avmdb.database.host', '127.0.0.1:3306', 'avmdb数据库ip', b'1', b'0', 'avmdb', 9);
INSERT INTO `t_environment_parameter` VALUES (10, 'avmdb.database.username', 'root', 'avmdb数据库用户名', b'1', b'0', 'avmdb', 10);
INSERT INTO `t_environment_parameter` VALUES (11, 'avmdb.database.password', 'Vl9kolqsxX65cWET7SKx2g==', 'avmdb数据库密码', b'1', b'1', 'avmdb', 11);
INSERT INTO `t_environment_parameter` VALUES (12, 'tsm.upload.dir', 'D:/workspace/java/upload/', '上传文件基础路径', b'1', b'0', 'tsm', NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 't_sys_parameter' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_parameter
-- ----------------------------
INSERT INTO `t_sys_parameter` VALUES (1, 1, 'BOS', 'BOS_1_1_11', 'conf.instance.name', 'BOS_1_1_11', 2, b'1', '实例名', b'0', NULL, NULL);
INSERT INTO `t_sys_parameter` VALUES (2, 1, 'BOS', '', 'upload-dir', '${tsm.upload.dir}', 1, b'1', '上传文件基础路径', b'0', NULL, NULL);
INSERT INTO `t_sys_parameter` VALUES (3, 1, 'BOS', NULL, 'identity.expireTime', '${expireTime}', 1, b'1', '会话超时时间（毫秒）', b'0', 'identity', NULL);
INSERT INTO `t_sys_parameter` VALUES (4, 1, 'BOS', NULL, 'domainconfigdb.datasource.jdbc-url', 'jdbc:mysql://${domainconfigdb.database.host}/domainconfigdb?useSSL=false&allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&autoReconnectForPools=true', 1, b'1', '配置数据库地址', b'0', 'domainconfigdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (5, 1, 'BOS', NULL, 'domainconfigdb.datasource.username', '${domainconfigdb.database.username}', 1, b'1', '数据库账户', b'0', 'domainconfigdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (6, 1, 'BOS', NULL, 'domainconfigdb.datasource.password', '${domainconfigdb.database.username}', 1, b'1', '数据库账户登录密码', b'0', 'domainconfigdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (7, 1, 'BOS', NULL, 'domainconfigdb.datasource.driver-class-name', 'com.mysql.cj.jdbc.Driver', 1, b'1', '指定driver的类名', b'0', 'domainconfigdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (8, 1, 'BOS', NULL, 'userdb.datasource.jdbc-url', 'jdbc:mysql://${userdb.database.host}/userdb?allowPublicKeyRetrieval=true&useSSL=false&allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&autoReconnectForPools=true', 1, b'1', '用户管理数据库地址', b'0', 'domainconfigdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (9, 1, 'BOS', NULL, 'userdb.datasource.username', '${userdb.database.username}', 1, b'1', '用户管理账户', b'0', 'domainconfigdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (10, 1, 'BOS', NULL, 'userdb.datasource.password', '${userdb.database.username}', 1, b'1', '用户管理登录密码', b'0', 'domainconfigdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (11, 1, 'BOS', NULL, 'userdb.datasource.driver-class-name', 'com.mysql.cj.jdbc.Driver', 1, b'1', '指定driver的类名', b'0', 'domainconfigdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (12, 1, 'BOS', NULL, 'avmdb.datasource.jdbc-url', 'jdbc:mysql://${avmdb.database.host}/avmdb?useSSL=false&allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&autoReconnectForPools=true', 1, b'1', 'avmdb数据库地址', b'0', 'avmdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (13, 1, 'BOS', NULL, 'avmdb.datasource.username', '${avmdb.database.username}', 1, b'1', 'avmdb账户', b'0', 'avmdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (14, 1, 'BOS', NULL, 'avmdb.datasource.password', '${avmdb.database.username}', 1, b'1', 'avmdb登录密码', b'0', 'avmdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (15, 1, 'BOS', NULL, 'avmdb.datasource.driver-class-name', 'com.mysql.cj.jdbc.Driver', 1, b'1', '指定driver的类名', b'0', 'avmdb', NULL);
INSERT INTO `t_sys_parameter` VALUES (16, 1, 'BOS', NULL, 'server.port', '8080', 1, b'1', 'BOS端口', b'0', NULL, NULL);
INSERT INTO `t_sys_parameter` VALUES (17, 1, 'BOS', NULL, 'server.servlet.context-path', '/arc', 1, b'1', '当前项目相对路径', b'0', NULL, NULL);
INSERT INTO `t_sys_parameter` VALUES (18, 1, 'BOS', NULL, 'identity.login.validateCode', '0', 1, b'1', '验证码开关', b'0', NULL, NULL);
INSERT INTO `t_sys_parameter` VALUES (19, 1, 'BOS', NULL, 'identity.kaptcha', '/login', 1, b'1', '校验图形验证器', b'0', 'identity', NULL);
INSERT INTO `t_sys_parameter` VALUES (20, 1, 'BOS', NULL, 'bos.websocket', '/websocket', 1, b'1', 'BOS访问websocket路径', b'0', 'oss', NULL);
INSERT INTO `t_sys_parameter` VALUES (21, 1, 'BOS', NULL, 'sys.datetime', 'sys.datetime', 1, b'1', 'websocket推送的时间前缀', b'0', 'oss', NULL);
INSERT INTO `t_sys_parameter` VALUES (22, 1, 'BOS', NULL, 'bos.login', 'login-', 1, b'1', '用户登录成功后建立连接标志', b'0', 'oss', NULL);
INSERT INTO `t_sys_parameter` VALUES (23, 1, 'BOS', NULL, 'bos.logout', 'logout-', 1, b'1', '用户退出后注销', b'0', 'oss', NULL);
INSERT INTO `t_sys_parameter` VALUES (24, 1, 'BOS', NULL, 'upload-dir', '${tsm.upload.dir}', 1, b'1', '上传文件的基础路径', b'0', 'upload-dir', NULL);
INSERT INTO `t_sys_parameter` VALUES (25, 1, 'BOS', NULL, 'support-ext-names', '', 1, b'1', '支持的文件上传格式', b'0', 'support-ext-names', NULL);

SET FOREIGN_KEY_CHECKS = 1;
