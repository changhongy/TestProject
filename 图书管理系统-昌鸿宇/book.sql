/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : localhost:3306
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : 65001

 Date: 30/05/2019 19:44:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bookinfo
-- ----------------------------
DROP TABLE IF EXISTS `bookinfo`;
CREATE TABLE `bookinfo`  (
  `bid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bookname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bookcategory` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uptime` datetime(0) NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `hot` int(11) NULL DEFAULT NULL,
  `realbookname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bookinfo
-- ----------------------------
INSERT INTO `bookinfo` VALUES ('14dda956915d', 'C语言1', '教科书', '2019-05-10 00:00:00', 13.25, 3, 'C语言');
INSERT INTO `bookinfo` VALUES ('14dda956916d', 'JAVA编程思想', '教科书', '2019-05-21 10:44:24', 12.25, 10, 'JAVA编程思想');
INSERT INTO `bookinfo` VALUES ('1c636b4ad72543f2b5d648acd1b89a9b', '语文(2)', '教科书', '2019-05-11 00:00:00', 13.46, 36, '语文');
INSERT INTO `bookinfo` VALUES ('1fe8032928dd46998e27c8c3576e0522', 'C语言(2)', '教科书', '2019-05-02 00:00:00', 56.32, NULL, NULL);
INSERT INTO `bookinfo` VALUES ('44bd075dd6d443409513dbe6b4695f87', '概率论(2)', '教科书', '2019-05-08 00:00:00', 12.29, NULL, NULL);
INSERT INTO `bookinfo` VALUES ('5387768dadbd4c0c9e7eebc70277baca', '五年高考三年模拟(4)', '习题', '2019-05-22 00:00:00', 123.48, 0, '五年高考三年模拟');
INSERT INTO `bookinfo` VALUES ('61b64ef81aab47acaf598bb941b4544a', '语文', '教科书', '2019-05-03 00:00:00', 12.325, 64, '语文');
INSERT INTO `bookinfo` VALUES ('7b41d70a20274c2b8192ae1d79b5f33d', '小题狂做', '习题', '2019-05-13 00:00:00', 33.46, 15, '小题狂做');
INSERT INTO `bookinfo` VALUES ('9767f7422c8d48d38cc7d0cd9cd6ea85', '五年高考三年模拟', '习题', '2019-05-02 00:00:00', 123.46, 100, '五年高考三年模拟');
INSERT INTO `bookinfo` VALUES ('a7770213e883485a894868a4276773b7', '五年高考三年模拟(3)', '习题', '2019-05-31 00:00:00', 123.47, 61, '五年高考三年模拟');
INSERT INTO `bookinfo` VALUES ('f4a5a736f8ca4783bea9e7ff02b29688', '概率论2', '教科书', '2019-05-16 00:00:00', 132.2, 1, '概率论');
INSERT INTO `bookinfo` VALUES ('fc0fce69f5b346089014c30917f9aadc', '小题狂做(2)', '习题', '2019-05-25 00:00:00', 23.46, 65, '小题狂做');
INSERT INTO `bookinfo` VALUES ('fc18b0ab359347e39c58b1dc9e5cb806', '五年高考三年模拟(2)', '习题', '2019-05-03 00:00:00', 123.47, 46, '五年高考三年模拟');

SET FOREIGN_KEY_CHECKS = 1;
