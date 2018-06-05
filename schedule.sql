/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : xksystem

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-05-15 11:11:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `schedule`
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `arrtabId` int(20) NOT NULL AUTO_INCREMENT,
  `campus` varchar(50) NOT NULL,
  `classroom` varchar(50) NOT NULL,
  `schooltime` varchar(50) NOT NULL,
  `teaId` int(20) NOT NULL,
  `courseId` int(20) NOT NULL,
  `classId` int(20) NOT NULL,
  `majorId` int(20) NOT NULL,
  PRIMARY KEY (`arrtabId`),
  KEY `courseId` (`courseId`),
  KEY `classId` (`classId`),
  KEY `teaId` (`teaId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('1', '西青区', 'C509', '2018-02-05', '1', '1', '1', '1');
INSERT INTO `schedule` VALUES ('2', '西青区', 'B301', '2018-02-06', '2', '1', '2', '1');
