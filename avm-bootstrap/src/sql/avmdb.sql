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

 Date: 13/05/2021 15:19:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_company
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `company_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '公司名称',
  `english_company_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '公司英文名称',
  `simple_company_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '公司简称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '描述',
  `del_status` int(0) NOT NULL DEFAULT 0 COMMENT '删除状态\r\n\r\n',
  `update_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `add_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '添加人',
  `add_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_company' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_company
-- ----------------------------
INSERT INTO `t_company` VALUES (2, '平安证券股份有限公司', 'Ping An Securities Limited', '平安证券', '', 0, '', '2021-02-27 16:04:22', '', '2021-02-27 16:04:22');
INSERT INTO `t_company` VALUES (3, '长江证券股份有限公司', 'Changjiang Securities Co.,Ltd', '长江证券', '', 0, '', '2021-02-27 16:21:16', '', '2021-02-27 16:21:16');
INSERT INTO `t_company` VALUES (4, '财通证券股份有限公司', 'Caitong Security Co.,Ltd', '财通证券', '', 0, '', '2021-03-01 14:31:10', '', '2021-03-01 14:31:10');
INSERT INTO `t_company` VALUES (5, '招商证券股份有限公司', 'China Merchants Securities Co.,Ltd', '招商证券', '', 0, '', '2021-03-01 14:32:15', '', '2021-03-01 14:32:15');
INSERT INTO `t_company` VALUES (6, '华林证券股份有限公司', 'Chinalin Securities Co.,Ltd', '华林证券', '', 0, '', '2021-03-01 14:33:10', '', '2021-03-01 14:33:10');
INSERT INTO `t_company` VALUES (7, '万和证券股份有限公司', 'Vanho Securities', '万和证券', '', 0, '', '2021-03-01 14:33:51', '', '2021-03-01 14:33:51');
INSERT INTO `t_company` VALUES (8, '华西证券有限责任公司', 'Huaxi Securities Co.,Ltd', '华西证券', '', 0, '', '2021-03-01 14:34:34', '', '2021-03-01 14:34:34');
INSERT INTO `t_company` VALUES (9, '南京证券股份有限公司', 'Nanjing Securities Co.,Ltd', '南京证券', '', 0, '', '2021-03-01 14:35:17', '', '2021-03-01 14:35:17');
INSERT INTO `t_company` VALUES (10, '广发证券股份有限公司', 'GF Securities Co.,Ltd', '广发证券', '', 0, '', '2021-03-01 14:36:39', '', '2021-03-01 14:36:39');
INSERT INTO `t_company` VALUES (11, '华宝证券有限责任公司', 'Hwabao Securities', '华宝证券', '', 0, '', '2021-03-01 14:37:18', '', '2021-03-01 14:37:18');
INSERT INTO `t_company` VALUES (12, '长城证券股份有限公司', 'China Great Wall Securities', '长城证券', '', 0, '', '2021-03-01 14:38:00', '', '2021-03-01 14:38:00');
INSERT INTO `t_company` VALUES (13, '安信证券股份有限公司', 'Essence Securities Co.,Ltd', '安信证券', '', 0, '', '2021-03-01 14:38:45', '', '2021-03-01 14:38:45');
INSERT INTO `t_company` VALUES (14, '海通证券股份有限公司', 'Haitong Securities Co.,Ltd', '海通证券', '', 0, '', '2021-03-01 14:39:30', '', '2021-03-01 14:39:30');
INSERT INTO `t_company` VALUES (15, '中国银河证券股份有限公司', 'China Galaxy Securities Co.,Ltd', '银河证券', '', 0, '', '2021-03-01 14:40:27', '', '2021-03-01 14:40:27');
INSERT INTO `t_company` VALUES (16, '国泰君安国际控股有限公司', 'Guotai Junan International Holdings Limited', '国泰君安', '', 0, '', '2021-03-01 14:41:30', '', '2021-03-01 14:41:30');
INSERT INTO `t_company` VALUES (17, '东方证券股份有限公司', 'Orient Securities Company Limited', '东方证券', '', 0, '', '2021-03-01 14:42:23', '', '2021-03-01 14:42:23');
INSERT INTO `t_company` VALUES (18, '国信证券股份有限公司', 'Guosen Securities Co.,Ltd', '国信证券', '', 0, '', '2021-03-01 14:43:00', '', '2021-03-01 14:43:00');
INSERT INTO `t_company` VALUES (19, '天风证券股份有限公司', 'TF Securities Co.,Ltd', '天风证券', '', 0, '', '2021-05-01 02:29:47', '', '2021-05-01 10:29:46');
INSERT INTO `t_company` VALUES (20, '中信建投证券股份有限公司', 'China Securities Co.,Ltd', '中信建投', '', 0, '', '2021-03-03 08:36:50', '', '2021-03-03 16:36:50');

-- ----------------------------
-- Table structure for t_company_component
-- ----------------------------
DROP TABLE IF EXISTS `t_company_component`;
CREATE TABLE `t_company_component`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `company_id` int(0) NOT NULL DEFAULT -1 COMMENT 'companyId',
  `product_id` int(0) NOT NULL DEFAULT -1 COMMENT 'productId',
  `component_id` int(0) NOT NULL DEFAULT -1 COMMENT 'componentId',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_company_component' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_company_product
-- ----------------------------
DROP TABLE IF EXISTS `t_company_product`;
CREATE TABLE `t_company_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `company_id` int(0) NOT NULL DEFAULT -1 COMMENT 'companyId',
  `product_id` int(0) NOT NULL DEFAULT -1 COMMENT 'productId',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_company_product' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_company_product
-- ----------------------------
INSERT INTO `t_company_product` VALUES (9, 2, 6);
INSERT INTO `t_company_product` VALUES (10, 10, 6);
INSERT INTO `t_company_product` VALUES (11, 10, 8);
INSERT INTO `t_company_product` VALUES (13, 18, 6);
INSERT INTO `t_company_product` VALUES (14, 17, 6);
INSERT INTO `t_company_product` VALUES (15, 16, 6);
INSERT INTO `t_company_product` VALUES (16, 15, 6);
INSERT INTO `t_company_product` VALUES (17, 14, 6);
INSERT INTO `t_company_product` VALUES (18, 13, 6);
INSERT INTO `t_company_product` VALUES (19, 12, 6);
INSERT INTO `t_company_product` VALUES (20, 11, 6);
INSERT INTO `t_company_product` VALUES (21, 9, 6);
INSERT INTO `t_company_product` VALUES (22, 8, 6);
INSERT INTO `t_company_product` VALUES (23, 7, 6);
INSERT INTO `t_company_product` VALUES (24, 6, 6);
INSERT INTO `t_company_product` VALUES (25, 5, 6);
INSERT INTO `t_company_product` VALUES (26, 4, 6);
INSERT INTO `t_company_product` VALUES (27, 3, 6);
INSERT INTO `t_company_product` VALUES (42, 20, 6);
INSERT INTO `t_company_product` VALUES (43, 20, 7);
INSERT INTO `t_company_product` VALUES (44, 20, 8);
INSERT INTO `t_company_product` VALUES (46, 19, 6);

-- ----------------------------
-- Table structure for t_component
-- ----------------------------
DROP TABLE IF EXISTS `t_component`;
CREATE TABLE `t_component`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `component_english_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'componentEnglishName',
  `component_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'componentName',
  `component_code` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'componentCode',
  `component_type` int(0) NOT NULL DEFAULT 0 COMMENT 'componentType',
  `description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'description',
  `language_type` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'languageType',
  `chargeman` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'chargeman',
  `del_status` int(0) NOT NULL DEFAULT 0 COMMENT 'delStatus',
  `update_user` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'updateUser',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'updateTime',
  `add_user` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'addUser',
  `add_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'addTime',
  `design_svn_address` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'designSvnAddress',
  `require_svn_address` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'requireSvnAddress',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_component' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_component
-- ----------------------------
INSERT INTO `t_component` VALUES (3, 'Data Distribution Router', 'DDR', '', 0, '数据分发路由器', '1', '闫红智', 0, '', '2021-04-13 11:16:34', '', '2021-04-13 11:16:34', '', '');
INSERT INTO `t_component` VALUES (4, 'Intercept Gateway', 'IGW', '', 0, '通用拦截网关', '2', '李云翀', 0, '', '2021-04-13 11:16:19', '', '2021-04-13 11:16:19', '', '');
INSERT INTO `t_component` VALUES (5, 'File System Data Acquisition', 'FSDA', '', 0, '文件数据采集', '2', '李云翀', 0, '', '2021-04-13 11:16:16', '', '2021-04-13 11:16:16', '', '');
INSERT INTO `t_component` VALUES (6, 'External Access Risk Gateway', 'ERGW', '', 1, 'ATP的AGW改造，后续不再维护', '2', '李云翀', 0, '', '2021-04-13 11:16:13', '', '2021-04-13 11:16:13', '', '');
INSERT INTO `t_component` VALUES (7, '', '旧版TRCE', '', 0, '事前计算引擎，用于管控、联合风控、异常交易事前', '1', '黄广立', 0, '', '2021-04-13 11:16:00', '', '2021-04-13 11:16:00', '', '');
INSERT INTO `t_component` VALUES (8, 'Delay-Trading Rule Computing Engine', 'TRCE', '', 0, '旁路计算引擎（因子模式）', '1', '黄广立', 0, '', '2021-04-13 11:15:27', '', '2021-04-13 11:15:27', '', '');
INSERT INTO `t_component` VALUES (9, 'Delay-Trading Rule Computing Engine', 'DTRCE', '', 0, '旁路计算引擎（因子模式）', '1', '黄广立', 0, '', '2021-04-13 11:15:18', '', '2021-04-13 11:15:18', '', '');
INSERT INTO `t_component` VALUES (10, 'Pre-Trading Rule Computing Engine', 'PTRCE', '', 0, '事前风控引擎（因子模式）', '1', '黄广立', 0, '', '2021-04-13 11:15:14', '', '2021-04-13 11:15:14', '', '');
INSERT INTO `t_component` VALUES (11, '', 'AIE', '', 0, '', '1', '闫红智', 0, '', '2021-04-13 11:15:05', '', '2021-04-13 11:15:05', '', '');
INSERT INTO `t_component` VALUES (12, 'Real-time blocking Risk Gateway', 'TRGW', '', 0, '实时风控网关，只用于策略风控，后续统一到UIS', '1', '李云翀', 0, '', '2021-04-13 11:14:53', '', '2021-04-13 11:14:53', '', '');
INSERT INTO `t_component` VALUES (13, 'Order Offer Service', 'OOS', '', 1, '订单路由服务（交易所报盘）', '', '李云翀', 0, '', '2021-04-23 15:19:49', '', '2021-04-23 15:19:49', '', '');
INSERT INTO `t_component` VALUES (14, 'Intercept Gateway', 'IGWSZ', '', 0, '深圳拦截网关', '2', '李云翀', 0, '', '2021-04-13 11:14:40', '', '2021-04-13 11:14:40', '', '');
INSERT INTO `t_component` VALUES (15, 'Forwar Gateway', 'FGW', '', 0, '报盘转发网关\n', '2', '李云翀', 0, '', '2021-04-13 11:14:34', '', '2021-04-13 11:14:34', '', '');
INSERT INTO `t_component` VALUES (16, 'Intercept Gateway', 'IGWSH', '', 0, '上海拦截网关', '1', '李云翀', 0, '', '2021-04-13 11:14:27', '', '2021-04-13 11:14:27', '', '');
INSERT INTO `t_component` VALUES (17, 'Customer Adapter', 'CA', '', 0, '客户协议适配器，将外部协议转成内部协议', '1', '李云翀', 0, '', '2021-04-13 11:14:19', '', '2021-04-13 11:14:19', '', '');
INSERT INTO `t_component` VALUES (18, 'Protocol Adapter', 'PA', '', 0, '协议适配器，将内部协议转成外部协议', '2', '李云翀', 0, '', '2021-04-13 11:14:15', '', '2021-04-13 11:14:15', '', '');
INSERT INTO `t_component` VALUES (19, '', 'API', '', 0, '', '2', '李云翀', 0, '', '2021-04-13 11:14:11', '', '2021-04-13 11:14:11', '', '');
INSERT INTO `t_component` VALUES (20, 'Unified GateWay', 'UGW', '', 0, '统一接入网关', '1', '李云翀', 0, '', '2021-04-13 11:14:07', '', '2021-04-13 11:14:07', '', '');
INSERT INTO `t_component` VALUES (21, 'Data Acquisition System', 'DAS', '', 0, '数据采集系统', '2', '李云翀', 0, '', '2021-04-13 11:14:02', '', '2021-04-13 11:14:02', '', '');
INSERT INTO `t_component` VALUES (22, '', 'SRM-BOS', '', 1, '策略风控系统', '1', '汝龙', 0, '', '2021-04-23 15:19:12', '', '2021-04-23 15:19:12', '', '');
INSERT INTO `t_component` VALUES (23, '', 'JRM-BOS', '', 1, '联合风控系统', '1', '黄广立', 0, '', '2021-04-23 15:19:14', '', '2021-04-23 15:19:14', '', '');
INSERT INTO `t_component` VALUES (24, '', 'ERS-BOS', '', 1, '外部接入风险管理系统', '1', '周胜兵', 0, '', '2021-04-23 15:19:18', '', '2021-04-23 15:19:18', '', '');
INSERT INTO `t_component` VALUES (25, 'Trading Supervision Management', 'TSM-BOS', '', 0, '异常交易行为监控与处置系统', '1', '周胜兵', 0, '', '2021-04-13 11:10:05', '', '2021-04-13 11:10:05', '', '');
INSERT INTO `t_component` VALUES (26, 'Rule Computing Engine', 'RCE', '', 0, '旁路规则计算引擎', '1', '闫红智', 0, '', '2021-04-13 11:08:15', '', '2021-04-13 11:08:15', '', '');
INSERT INTO `t_component` VALUES (27, '', 'AgentServer', '', 0, '日志收集服务', '1', '', 0, '', '2021-02-26 20:07:17', '', '2021-02-26 20:07:17', '', '');
INSERT INTO `t_component` VALUES (28, '', 'Agent', '', 0, '日志采集服务', '1', '', 0, '', '2021-02-26 20:07:49', '', '2021-02-26 20:07:49', '', '');
INSERT INTO `t_component` VALUES (29, 'Task Scheduler', 'TS', '', 0, '任务调度器', '1', '周胜兵', 0, '', '2021-04-13 11:17:16', '', '2021-04-13 11:17:16', '', '');
INSERT INTO `t_component` VALUES (30, 'Unified Interface Server', 'UIS', '', 0, '统一接口服务', '1', '', 0, '', '2021-02-26 20:09:12', '', '2021-02-26 20:09:12', '', '');
INSERT INTO `t_component` VALUES (31, 'Single Sign On', 'SSO', '', 0, '单点登陆', '1', '', 0, '', '2021-02-26 20:09:53', '', '2021-02-26 20:09:53', '', '');
INSERT INTO `t_component` VALUES (32, 'Unified User Management', 'UUM', '', 0, '统一用户管理', '1', '', 0, '', '2021-02-26 20:10:35', '', '2021-02-26 20:10:35', '', '');
INSERT INTO `t_component` VALUES (33, 'Data Adapt', 'DA', '', 0, '数据适配器', '1', '周胜兵', 0, '', '2021-04-13 11:17:02', '', '2021-04-13 11:17:02', '', '');
INSERT INTO `t_component` VALUES (34, 'Data Persistence', 'DP', '', 0, '数据持久化', '1', '周胜兵', 0, '', '2021-04-13 11:16:47', '', '2021-04-13 11:16:47', '', '');
INSERT INTO `t_component` VALUES (35, '', 'RA', '', 0, '数据重演', '1', '', 0, '', '2021-04-13 11:16:54', '', '2021-04-13 11:16:54', '', '');

-- ----------------------------
-- Table structure for t_component_company
-- ----------------------------
DROP TABLE IF EXISTS `t_component_company`;
CREATE TABLE `t_component_company`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `component_id` int(0) NOT NULL DEFAULT -1 COMMENT 'componentId',
  `company_id` int(0) NOT NULL DEFAULT -1 COMMENT 'companyId',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_component_company' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_component_company
-- ----------------------------
INSERT INTO `t_component_company` VALUES (5, 6, 17);
INSERT INTO `t_component_company` VALUES (6, 24, 15);
INSERT INTO `t_component_company` VALUES (7, 23, 10);
INSERT INTO `t_component_company` VALUES (8, 22, 20);
INSERT INTO `t_component_company` VALUES (9, 13, 5);
INSERT INTO `t_component_company` VALUES (10, 13, 6);

-- ----------------------------
-- Table structure for t_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dict_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '编码',
  `dict_value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '值',
  `dict_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '名称',
  `category_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '类型编码',
  `sort_no` int(0) NOT NULL DEFAULT -1 COMMENT '排序',
  `status` int(0) NOT NULL DEFAULT -1 COMMENT '状态',
  `remark` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '字典描述',
  `add_time` datetime(0) NOT NULL DEFAULT '1000-01-01 00:00:00' ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'addTime',
  `add_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'addUser',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'updateTime',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'updateUser',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_dict' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dict
-- ----------------------------
INSERT INTO `t_dict` VALUES (1, 'tecknology', '1', '技术类', 'QuestionType', 1, 1, '', '2021-02-22 20:15:56', '', '2021-02-22 20:16:04', '');
INSERT INTO `t_dict` VALUES (2, 'business', '2', '业务类', 'QuestionType', 2, 1, '', '2021-02-22 20:15:56', '', '2021-02-22 20:16:04', '');
INSERT INTO `t_dict` VALUES (3, 'java', '1', 'java', 'LanguageType', 1, 1, '', '2021-02-22 20:15:56', '', '2021-02-22 20:16:04', '');
INSERT INTO `t_dict` VALUES (4, 'c++', '2', 'C++', 'LanguageType', 2, 1, '', '2021-02-22 20:15:56', '', '2021-02-22 20:16:04', '');
INSERT INTO `t_dict` VALUES (5, 'html', '3', '前端', 'LanguageType', 3, 1, '', '2021-02-22 20:15:56', '', '2021-02-22 20:16:04', '');
INSERT INTO `t_dict` VALUES (6, 'python', '4', 'Python', 'LanguageType', 4, 1, '', '2021-02-22 20:15:56', '', '2021-02-22 20:16:04', '');
INSERT INTO `t_dict` VALUES (7, 'common', '0', '通用功能', 'FunctionType', 1, 1, '', '2021-02-22 20:15:56', '', '2021-02-22 20:16:04', '');
INSERT INTO `t_dict` VALUES (8, 'customer', '1', '客制功能', 'FunctionType', 2, 1, '', '2021-02-22 20:15:56', '', '2021-02-22 20:16:04', '');
INSERT INTO `t_dict` VALUES (9, ' commonCom', '0', '通用组件', 'ComponentType', 1, 1, '', '2021-05-12 15:38:45', '', '2021-05-12 15:38:52', '');
INSERT INTO `t_dict` VALUES (10, 'customerCom', '1', '客制组件', 'ComponentType', 1, 1, '', '2021-05-12 15:39:42', '', '2021-05-12 15:39:47', '');

-- ----------------------------
-- Table structure for t_dict_category
-- ----------------------------
DROP TABLE IF EXISTS `t_dict_category`;
CREATE TABLE `t_dict_category`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `category_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '编码',
  `category_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '名称',
  `sort_no` int(0) NOT NULL DEFAULT 0 COMMENT '排序',
  `status` int(0) NOT NULL DEFAULT 1 COMMENT '状态 0停用   1启用',
  `remark` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '字典描述',
  `maintain_type` int(0) NOT NULL DEFAULT 0 COMMENT '字典维护方式：0 不在界面维护  1 在界面维护',
  `add_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'addTime',
  `add_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'addUser',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'updateTime',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'updateUser',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_dict_category' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dict_category
-- ----------------------------
INSERT INTO `t_dict_category` VALUES (1, 'QuestionType', '问题类型', 1, 1, '', 0, '2021-02-22 20:19:53', '', '2021-02-22 20:19:57', '');
INSERT INTO `t_dict_category` VALUES (2, 'LanguageType', '开发语言', 2, 1, '', 0, '2021-02-22 20:19:53', '', '2021-02-22 20:19:57', '');
INSERT INTO `t_dict_category` VALUES (3, 'FunctionType', '功能类型', 3, 1, '', 0, '2021-02-22 20:19:53', '', '2021-03-05 16:06:44', '');
INSERT INTO `t_dict_category` VALUES (4, 'ComponentType', '组件类型', 4, 1, '', 0, '2021-05-12 15:36:17', '', '2021-05-12 15:36:21', '');

-- ----------------------------
-- Table structure for t_function
-- ----------------------------
DROP TABLE IF EXISTS `t_function`;
CREATE TABLE `t_function`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `function_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '功能名称',
  `function_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '功能编号',
  `function_type` int(0) NOT NULL DEFAULT 0 COMMENT '0通用共能，1客制功能',
  `chargeman` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'chargeman',
  `description` varchar(8000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'descirption',
  `add_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'addUser',
  `add_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'addTime',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'updateUser',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'updateTime',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_function' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_function
-- ----------------------------
INSERT INTO `t_function` VALUES (26, '流程配置', 'OM0106', 0, '', '', '', '2021-03-20 14:18:51', '', '2021-03-20 14:18:51');
INSERT INTO `t_function` VALUES (27, '客户信息管理', 'OM0113', 0, '', '', '', '2021-03-20 14:22:18', '', '2021-03-20 14:22:18');
INSERT INTO `t_function` VALUES (28, '组织架构管理', 'OM0119', 0, '', '', '', '2021-03-20 14:22:38', '', '2021-03-20 14:22:38');
INSERT INTO `t_function` VALUES (29, '短信模板管理', 'OM0114', 0, '', '', '', '2021-03-20 14:23:16', '', '2021-03-20 14:23:16');
INSERT INTO `t_function` VALUES (30, '短信发送记录', 'OM0115', 0, '', '', '', '2021-03-20 14:24:09', '', '2021-03-20 14:24:09');
INSERT INTO `t_function` VALUES (31, '邮件模板管理', 'OM0116', 0, '', '', '', '2021-03-20 14:24:45', '', '2021-03-20 14:24:45');
INSERT INTO `t_function` VALUES (32, '邮件发送记录', 'OM0117', 0, '', '', '', '2021-03-20 14:25:00', '', '2021-03-20 14:25:00');
INSERT INTO `t_function` VALUES (33, '数据字典', 'OM0120', 0, '', '', '', '2021-03-20 14:25:15', '', '2021-03-20 14:25:15');
INSERT INTO `t_function` VALUES (34, '报警处置', 'TSM02', 0, '', '', '', '2021-03-20 14:25:54', '', '2021-03-20 14:25:54');
INSERT INTO `t_function` VALUES (35, '监管函件', 'TSM0501', 0, '', '', '', '2021-03-20 14:28:50', '', '2021-03-20 14:28:50');
INSERT INTO `t_function` VALUES (36, '监管报送', 'TSM0701', 0, '', '', '', '2021-03-20 14:29:37', '', '2021-03-20 14:29:37');
INSERT INTO `t_function` VALUES (37, '监控名单管理', 'ERC01', 0, '', '', '', '2021-03-24 15:37:06', '', '2021-03-24 15:37:06');
INSERT INTO `t_function` VALUES (38, '监控规则管理', 'ERC02', 0, '', '', '', '2021-03-24 15:37:02', '', '2021-03-24 15:37:02');
INSERT INTO `t_function` VALUES (39, '监控统计', 'ERC03', 0, '', '', '', '2021-03-24 16:07:35', '', '2021-03-24 16:07:35');
INSERT INTO `t_function` VALUES (40, '规则配资', 'FSM03', 0, '', '', '', '2021-03-24 16:08:45', '', '2021-03-24 16:08:45');
INSERT INTO `t_function` VALUES (41, '疑似配资客户管理', 'IA0102', 0, '', '', '', '2021-03-24 16:09:11', '', '2021-03-24 16:09:11');
INSERT INTO `t_function` VALUES (42, '监控中心', 'TSM08', 0, '', '', '', '2021-03-24 16:09:26', '', '2021-03-24 16:09:26');
INSERT INTO `t_function` VALUES (43, '监控名单', 'TSM0401', 0, '', '', '', '2021-03-24 16:10:36', '', '2021-03-24 16:10:36');
INSERT INTO `t_function` VALUES (44, '历史监控名单', 'TSM0402', 0, '', '', '', '2021-03-24 16:10:52', '', '2021-03-24 16:10:52');
INSERT INTO `t_function` VALUES (45, '白名单', 'TSM0403', 0, '', '', '', '2021-03-24 16:11:10', '', '2021-03-24 16:11:10');
INSERT INTO `t_function` VALUES (46, '多账户客户', 'TSM0404', 0, '', '', '', '2021-03-24 16:11:24', '', '2021-03-24 16:11:24');
INSERT INTO `t_function` VALUES (47, '事中事后规则配置', 'TSM0601', 0, '', '', '', '2021-03-24 16:11:59', '', '2021-03-24 16:11:59');
INSERT INTO `t_function` VALUES (48, '异常交易指数', 'TSM0602', 0, '', '', '', '2021-03-24 16:12:20', '', '2021-03-24 16:12:20');
INSERT INTO `t_function` VALUES (49, '敏感期设置', 'TSM0603', 0, '', '', '', '2021-03-24 16:12:38', '', '2021-03-24 16:12:38');
INSERT INTO `t_function` VALUES (50, '重点监控情形规则配置', 'TSM0604', 0, '', '', '', '2021-03-24 16:13:20', '', '2021-03-24 16:13:20');
INSERT INTO `t_function` VALUES (51, '审计日志', 'OM0127', 0, '', '', '', '2021-03-24 16:17:03', '', '2021-03-24 16:17:03');
INSERT INTO `t_function` VALUES (52, '组件参数配置', 'OM0105', 0, '', '', '', '2021-03-24 16:17:38', '', '2021-03-24 16:17:38');
INSERT INTO `t_function` VALUES (53, 'IDG配置', 'OM0108', 0, '', '', '', '2021-03-25 15:48:24', '', '2021-03-25 15:48:24');
INSERT INTO `t_function` VALUES (54, '监控组配置', 'OM0109', 0, '', '', '', '2021-03-25 15:48:40', '', '2021-03-25 15:48:40');
INSERT INTO `t_function` VALUES (55, '定时任务管理', 'OM0111', 0, '', '', '', '2021-03-25 15:49:03', '', '2021-03-25 15:49:03');
INSERT INTO `t_function` VALUES (56, '实时指令管理', 'OM0112', 0, '', '', '', '2021-03-25 15:49:21', '', '2021-03-25 15:49:21');
INSERT INTO `t_function` VALUES (57, '日志监控', 'OM0103', 0, '', '', '', '2021-03-25 15:49:37', '', '2021-03-25 15:49:37');
INSERT INTO `t_function` VALUES (58, '行情监控', 'OM0107', 0, '', '', '', '2021-03-25 15:49:49', '', '2021-03-25 15:49:49');
INSERT INTO `t_function` VALUES (59, '指标监控', 'OM0110', 0, '', '', '', '2021-03-25 15:50:02', '', '2021-03-25 15:50:02');
INSERT INTO `t_function` VALUES (60, '客户画像', 'TSM13', 0, '', '', '', '2021-03-25 15:51:57', '', '2021-03-25 15:51:57');
INSERT INTO `t_function` VALUES (61, '限制交易', 'TSM10', 0, '', '', '', '2021-03-25 15:50:55', '', '2021-03-25 15:50:55');
INSERT INTO `t_function` VALUES (62, '数据重演', 'TSM12', 0, '', '', '', '2021-03-25 15:51:36', '', '2021-03-25 15:51:36');
INSERT INTO `t_function` VALUES (63, '异常交易档案', 'TSM03', 0, '', '', '', '2021-03-25 15:52:32', '', '2021-03-25 15:52:32');
INSERT INTO `t_function` VALUES (64, '数据查询', 'TSM11', 0, '', '', '', '2021-03-25 15:52:52', '', '2021-03-25 15:52:52');

-- ----------------------------
-- Table structure for t_function_company
-- ----------------------------
DROP TABLE IF EXISTS `t_function_company`;
CREATE TABLE `t_function_company`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `function_id` int(0) NOT NULL DEFAULT -1 COMMENT 'functionId',
  `company_id` int(0) NOT NULL DEFAULT -1 COMMENT 'companyId',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_function_company' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_function_component
-- ----------------------------
DROP TABLE IF EXISTS `t_function_component`;
CREATE TABLE `t_function_component`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `function_id` int(0) NOT NULL DEFAULT -1 COMMENT 'componentEnglishName',
  `component_id` int(0) NOT NULL DEFAULT -1 COMMENT 'componentName',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_function_component' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_function_component
-- ----------------------------
INSERT INTO `t_function_component` VALUES (24, 60, 25);
INSERT INTO `t_function_component` VALUES (25, 62, 35);
INSERT INTO `t_function_component` VALUES (26, 62, 25);

-- ----------------------------
-- Table structure for t_function_function_group
-- ----------------------------
DROP TABLE IF EXISTS `t_function_function_group`;
CREATE TABLE `t_function_function_group`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `function_id` int(0) NOT NULL DEFAULT -1 COMMENT '功能ID',
  `function_group_id` int(0) NOT NULL DEFAULT -1 COMMENT '分组ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_function_function_group' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_function_function_group
-- ----------------------------
INSERT INTO `t_function_function_group` VALUES (24, 26, 35);
INSERT INTO `t_function_function_group` VALUES (25, 27, 35);
INSERT INTO `t_function_function_group` VALUES (26, 28, 35);
INSERT INTO `t_function_function_group` VALUES (27, 29, 36);
INSERT INTO `t_function_function_group` VALUES (28, 30, 36);
INSERT INTO `t_function_function_group` VALUES (29, 31, 36);
INSERT INTO `t_function_function_group` VALUES (30, 32, 36);
INSERT INTO `t_function_function_group` VALUES (31, 33, 36);
INSERT INTO `t_function_function_group` VALUES (32, 34, 27);
INSERT INTO `t_function_function_group` VALUES (33, 35, 38);
INSERT INTO `t_function_function_group` VALUES (34, 36, 39);
INSERT INTO `t_function_function_group` VALUES (35, 37, 40);
INSERT INTO `t_function_function_group` VALUES (36, 38, 41);
INSERT INTO `t_function_function_group` VALUES (37, 39, 42);
INSERT INTO `t_function_function_group` VALUES (38, 40, 43);
INSERT INTO `t_function_function_group` VALUES (39, 41, 44);
INSERT INTO `t_function_function_group` VALUES (40, 42, 31);
INSERT INTO `t_function_function_group` VALUES (41, 43, 45);
INSERT INTO `t_function_function_group` VALUES (42, 44, 45);
INSERT INTO `t_function_function_group` VALUES (43, 45, 45);
INSERT INTO `t_function_function_group` VALUES (44, 46, 45);
INSERT INTO `t_function_function_group` VALUES (45, 47, 46);
INSERT INTO `t_function_function_group` VALUES (46, 48, 46);
INSERT INTO `t_function_function_group` VALUES (47, 49, 46);
INSERT INTO `t_function_function_group` VALUES (48, 50, 46);
INSERT INTO `t_function_function_group` VALUES (49, 51, 47);
INSERT INTO `t_function_function_group` VALUES (50, 52, 48);
INSERT INTO `t_function_function_group` VALUES (51, 53, 48);
INSERT INTO `t_function_function_group` VALUES (52, 54, 48);
INSERT INTO `t_function_function_group` VALUES (53, 55, 49);
INSERT INTO `t_function_function_group` VALUES (54, 56, 49);
INSERT INTO `t_function_function_group` VALUES (55, 57, 50);
INSERT INTO `t_function_function_group` VALUES (56, 58, 50);
INSERT INTO `t_function_function_group` VALUES (57, 59, 50);
INSERT INTO `t_function_function_group` VALUES (58, 60, 34);
INSERT INTO `t_function_function_group` VALUES (59, 61, 34);
INSERT INTO `t_function_function_group` VALUES (60, 62, 34);
INSERT INTO `t_function_function_group` VALUES (61, 63, 34);
INSERT INTO `t_function_function_group` VALUES (62, 64, 34);

-- ----------------------------
-- Table structure for t_function_group
-- ----------------------------
DROP TABLE IF EXISTS `t_function_group`;
CREATE TABLE `t_function_group`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `group_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '分组名称',
  `group_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '分组编号',
  `parent_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'parentCode',
  `group_desc` varchar(8000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'groupDesc',
  `group_type` int(0) NOT NULL DEFAULT 0 COMMENT '0通用功能下分组，1客制功能下分组',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_function_group' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_function_group
-- ----------------------------
INSERT INTO `t_function_group` VALUES (1, '通用功能', 'commonFunctionGroup', '0', '', 0);
INSERT INTO `t_function_group` VALUES (2, '客制功能', 'customerFunctionGroup', '0', '', 1);
INSERT INTO `t_function_group` VALUES (26, 'OM-系统管理', '023bfd05-3191-4fd4-8f24-806c372ce92d', 'dba2974a-213e-47d6-99c5-f3674e466e8b', '', 0);
INSERT INTO `t_function_group` VALUES (27, '报警处置', 'b0f2b5ef-144b-488e-8c65-63e5e2092e00', 'dba2974a-213e-47d6-99c5-f3674e466e8b', '', 0);
INSERT INTO `t_function_group` VALUES (28, '监管协同', 'd84c8d69-e7ad-41e7-97bf-ec5d334656af', 'dba2974a-213e-47d6-99c5-f3674e466e8b', '', 0);
INSERT INTO `t_function_group` VALUES (29, '交易风控', 'f9b8f3bd-f438-43fe-a4cc-74136f3fea88', 'dba2974a-213e-47d6-99c5-f3674e466e8b', '', 0);
INSERT INTO `t_function_group` VALUES (30, '智能分析', '8ae31512-8001-488f-9c1c-6fc5bdd68898', 'dba2974a-213e-47d6-99c5-f3674e466e8b', '', 0);
INSERT INTO `t_function_group` VALUES (31, '监控中心', '178b8fcb-ba06-4ec2-bebf-e3f608e22d9b', 'dba2974a-213e-47d6-99c5-f3674e466e8b', '', 0);
INSERT INTO `t_function_group` VALUES (32, '异常交易行为', 'fe99a4da-ede7-45f8-af18-bdc9f86689c8', 'dba2974a-213e-47d6-99c5-f3674e466e8b', '', 0);
INSERT INTO `t_function_group` VALUES (33, '运维管理', '9b574de5-2d71-4641-a2cd-5daff02bc6c4', 'dba2974a-213e-47d6-99c5-f3674e466e8b', '', 0);
INSERT INTO `t_function_group` VALUES (34, '运营管理', '485b5270-e4ee-44c7-920e-31ec68c9b8c6', 'dba2974a-213e-47d6-99c5-f3674e466e8b', '', 0);
INSERT INTO `t_function_group` VALUES (35, 'OM01-系统管理', '67bd5e42-777d-406c-9092-8bd4bf1ba8ca', '023bfd05-3191-4fd4-8f24-806c372ce92d', '', 0);
INSERT INTO `t_function_group` VALUES (36, 'OM04-业务参数管理', '6eff5ca8-8ccf-4e5b-a510-efb12b7aaedb', '023bfd05-3191-4fd4-8f24-806c372ce92d', '', 0);
INSERT INTO `t_function_group` VALUES (37, 'TSM', 'dba2974a-213e-47d6-99c5-f3674e466e8b', 'commonFunctionGroup', '', 0);
INSERT INTO `t_function_group` VALUES (38, 'TSM13-监管函件', '5c6fcf5b-56f1-40fc-8ff5-e5b094425f93', 'd84c8d69-e7ad-41e7-97bf-ec5d334656af', '', 0);
INSERT INTO `t_function_group` VALUES (39, 'TSM14-监管报送', '908c759b-2cc7-4933-a959-4ee36a502488', 'd84c8d69-e7ad-41e7-97bf-ec5d334656af', '', 0);
INSERT INTO `t_function_group` VALUES (40, 'ERC01-监控名单管理', '109b2156-41bf-47af-8204-721c4615796e', 'f9b8f3bd-f438-43fe-a4cc-74136f3fea88', '', 0);
INSERT INTO `t_function_group` VALUES (41, 'ERC02-监控规则管理', '9147d40c-9b21-41b2-960f-0de7287f030d', 'f9b8f3bd-f438-43fe-a4cc-74136f3fea88', '', 0);
INSERT INTO `t_function_group` VALUES (42, 'ERC03-监控统计', 'f433dddb-b194-46af-85ad-5f3df28a29d1', 'f9b8f3bd-f438-43fe-a4cc-74136f3fea88', '', 0);
INSERT INTO `t_function_group` VALUES (43, 'FSM-资金异动', 'f6c05216-8d80-4fc7-a3f2-645f87fc7c76', '8ae31512-8001-488f-9c1c-6fc5bdd68898', '', 0);
INSERT INTO `t_function_group` VALUES (44, 'IA01-配资行为识别', 'ee2b48f8-19f9-4391-a842-661c336b5c36', '8ae31512-8001-488f-9c1c-6fc5bdd68898', '', 0);
INSERT INTO `t_function_group` VALUES (45, 'TSM04-名单管理', '6b794955-7953-4e77-b01c-1088bd2f733a', 'fe99a4da-ede7-45f8-af18-bdc9f86689c8', '', 0);
INSERT INTO `t_function_group` VALUES (46, 'TSM06-规则配置', 'ea8ecddb-c3ae-4309-b258-1f214334eab4', 'fe99a4da-ede7-45f8-af18-bdc9f86689c8', '', 0);
INSERT INTO `t_function_group` VALUES (47, 'OM05-审计日志', 'c60b7160-bb4a-4b2b-8947-fb7bf8e51043', '9b574de5-2d71-4641-a2cd-5daff02bc6c4', '', 0);
INSERT INTO `t_function_group` VALUES (48, 'OSS01-系统配置', '0a3f7c68-ce5f-4d4b-ad92-fdb503ba42cf', '9b574de5-2d71-4641-a2cd-5daff02bc6c4', '', 0);
INSERT INTO `t_function_group` VALUES (49, 'OSS03-系统运维', '3463dd00-9d36-4cbe-b4dd-eaa83f58b2de', '9b574de5-2d71-4641-a2cd-5daff02bc6c4', '', 0);
INSERT INTO `t_function_group` VALUES (50, 'OSS04-系统监控', '9416cee6-c62a-40da-917e-5153215fe863', '9b574de5-2d71-4641-a2cd-5daff02bc6c4', '', 0);

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `simple_english_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'simpleEnglishName',
  `full_english_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'fullEnglishName',
  `full_chinese_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'fullChineseName',
  `group_member_names` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'groupMemberNames',
  `product_desc` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'productDesc',
  `add_user` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'addUser',
  `add_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'addTime',
  `update_user` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'updateUser',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'updateTime',
  `del_status` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'delStatus',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_product' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES (5, 'ARC', 'Archforce Risk Control', '华锐实时风控平台', '', '', '', '2021-02-26 14:21:55', '', '2021-02-26 14:21:55', '');
INSERT INTO `t_product` VALUES (6, 'TSM', 'Trading Supervision Management', '异常交易行为与处置系统', '', '', '', '2021-02-26 14:21:49', '', '2021-02-26 14:21:49', '');
INSERT INTO `t_product` VALUES (7, 'ERS', 'eXtreme Risk System', '外部接入管理与风控系统', '', '', '', '2021-02-26 14:21:38', '', '2021-02-26 14:21:38', '');

-- ----------------------------
-- Table structure for t_product_component
-- ----------------------------
DROP TABLE IF EXISTS `t_product_component`;
CREATE TABLE `t_product_component`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `product_id` int(0) NOT NULL DEFAULT -1 COMMENT 'productId',
  `component_id` int(0) NOT NULL DEFAULT -1 COMMENT 'componentId',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_product_component' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_product_component
-- ----------------------------
INSERT INTO `t_product_component` VALUES (7, 6, 5);
INSERT INTO `t_product_component` VALUES (8, 7, 5);
INSERT INTO `t_product_component` VALUES (9, 7, 7);
INSERT INTO `t_product_component` VALUES (10, 7, 8);
INSERT INTO `t_product_component` VALUES (11, 6, 4);
INSERT INTO `t_product_component` VALUES (12, 6, 7);
INSERT INTO `t_product_component` VALUES (13, 6, 9);
INSERT INTO `t_product_component` VALUES (14, 6, 10);
INSERT INTO `t_product_component` VALUES (15, 6, 11);
INSERT INTO `t_product_component` VALUES (16, 6, 12);
INSERT INTO `t_product_component` VALUES (17, 6, 10);
INSERT INTO `t_product_component` VALUES (18, 6, 11);
INSERT INTO `t_product_component` VALUES (19, 6, 12);
INSERT INTO `t_product_component` VALUES (20, 6, 22);
INSERT INTO `t_product_component` VALUES (21, 6, 7);
INSERT INTO `t_product_component` VALUES (22, 6, 9);
INSERT INTO `t_product_component` VALUES (23, 6, 12);
INSERT INTO `t_product_component` VALUES (24, 6, 22);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `pass_word` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '密码',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '真实名称',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'email',
  `ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'ip',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_user' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'liyunchong', '', '李云翀', '', '');
INSERT INTO `t_user` VALUES (2, 'niliqiong', '', '倪丽琼', '', '');
INSERT INTO `t_user` VALUES (3, 'huangguangli', '', '黄广立', '', '');
INSERT INTO `t_user` VALUES (4, 'yanhongzhi', '', '闫红智', '', '');
INSERT INTO `t_user` VALUES (5, 'panbo', '', '潘博', '', '');
INSERT INTO `t_user` VALUES (6, 'fengxiangyang', '', '冯向阳', '', '');
INSERT INTO `t_user` VALUES (7, 'chenkang', '', '陈康', '', '');
INSERT INTO `t_user` VALUES (8, 'weidongdong', '', '魏冬冬', '', '');
INSERT INTO `t_user` VALUES (9, 'hefatao', '', '何发涛', '', '');
INSERT INTO `t_user` VALUES (10, 'zhuxiaowu', '', '朱晓武', '', '');
INSERT INTO `t_user` VALUES (11, 'zhangyu', '', '张玉', '', '');
INSERT INTO `t_user` VALUES (12, 'tiantao', '', '田涛', '', '');
INSERT INTO `t_user` VALUES (13, 'chenquan', '', '陈权', '', '');
INSERT INTO `t_user` VALUES (14, 'hujun', '', '胡军', '', '');
INSERT INTO `t_user` VALUES (15, 'songwenhui', '', '宋文慧', '', '');
INSERT INTO `t_user` VALUES (16, 'zhoushengbing', '', '周胜兵', '', '');
INSERT INTO `t_user` VALUES (17, 'rulong', '', '汝龙', '', '');

SET FOREIGN_KEY_CHECKS = 1;
