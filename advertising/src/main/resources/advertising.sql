/*
Navicat MySQL Data Transfer

Source Server         : database
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : working

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-11-21 13:44:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for advertising
-- ----------------------------
DROP TABLE IF EXISTS `advertising`;
CREATE TABLE `advertising` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `source` varchar(255) NOT NULL COMMENT '源地址',
  `client` varchar(20) NOT NULL COMMENT '客户',
  `format` varchar(10) NOT NULL COMMENT '格式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `province` varchar(20) NOT NULL COMMENT '省',
  `city` varchar(20) NOT NULL DEFAULT '0' COMMENT '市',
  `district` varchar(20) NOT NULL COMMENT '区',
  `street` varchar(20) NOT NULL COMMENT '街道',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for distribution
-- ----------------------------
DROP TABLE IF EXISTS `distribution`;
CREATE TABLE `distribution` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `terminal_id` int(11) NOT NULL COMMENT '终端id',
  `advertising_id` int(11) NOT NULL COMMENT '广告id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for terminal
-- ----------------------------
DROP TABLE IF EXISTS `terminal`;
CREATE TABLE `terminal` (
  `id` int(11) NOT NULL COMMENT '编号',
  `name` varchar(10) NOT NULL COMMENT '终端名称',
  `area_id` int(11) NOT NULL COMMENT '所在区域',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `name` varchar(20) NOT NULL COMMENT '名字',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
