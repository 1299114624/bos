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

 Date: 15/03/2021 15:12:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_user' ROW_FORMAT = Dynamic;

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

SET FOREIGN_KEY_CHECKS = 1;
