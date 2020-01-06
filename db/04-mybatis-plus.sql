/*
 Navicat MySQL Data Transfer

 Source Server         : localhost-MAMP
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost
 Source Database       : 04-mybatis-plus

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : utf-8

 Date: 01/06/2020 18:35:49 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `sort` int(11) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `course`
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES ('1', '高等数学', '1'), ('2', '离散数学', '2'), ('3', '软件工程', '3'), ('4', '大学英语', '4'), ('5', '计算机导论', '5'), ('6', 'Java高级语言', '0');
COMMIT;

-- ----------------------------
--  Table structure for `course_student_mid`
-- ----------------------------
DROP TABLE IF EXISTS `course_student_mid`;
CREATE TABLE `course_student_mid` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE,
  KEY `course_id_idx` (`course_id`) USING BTREE,
  KEY `student_id_idx` (`student_id`) USING BTREE,
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `course_student_mid`
-- ----------------------------
BEGIN;
INSERT INTO `course_student_mid` VALUES ('29', '1', '1'), ('30', '1', '13'), ('31', '1', '3'), ('32', '1', '4'), ('33', '1', '6'), ('34', '2', '1'), ('35', '2', '4'), ('36', '2', '6'), ('37', '2', '8'), ('38', '2', '12'), ('39', '3', '11'), ('40', '3', '15'), ('41', '3', '1'), ('42', '3', '3');
COMMIT;

-- ----------------------------
--  Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `grade_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='年级信息表';

-- ----------------------------
--  Records of `grade`
-- ----------------------------
BEGIN;
INSERT INTO `grade` VALUES ('1', '大一'), ('2', '大二'), ('3', '大三'), ('4', '大四');
COMMIT;

-- ----------------------------
--  Table structure for `product_stock`
-- ----------------------------
DROP TABLE IF EXISTS `product_stock`;
CREATE TABLE `product_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `product_num` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `version` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `product_stock`
-- ----------------------------
BEGIN;
INSERT INTO `product_stock` VALUES ('1', '1', '45', '1'), ('2', '2', '30', '1'), ('3', '3', '2', '0');
COMMIT;

-- ----------------------------
--  Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `student_name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '学生姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `addr` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '家庭住址',
  `grade_id` int(11) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `grade_id` (`grade_id`) USING BTREE,
  CONSTRAINT `grade_id` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='学生信息表';

-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('1', '小乔', '18', '女', '安徽', '2', null), ('3', '刘备', '28', '男', '美国洛杉矶', '4', '-1'), ('4', '张飞', '18', '男', '河北', '2', '-1'), ('6', '关于', '38', '男', '山西', '4', null), ('7', '赵子龙', '28', '男', '长白山赵子龙也。。。', '3', '-1'), ('8', '岳飞', '28', '男', '河北', '2', null), ('11', '张三111', '32', '男', '广西', '2', null), ('12', '小芳', '15', '女', '广东', '1', null), ('13', '王五55', '29', '男', '合肥', '3', null), ('14', '孙小美', '18', '密', '内蒙古', '2', null), ('15', '刘小莲', '23', '密', '内蒙古', '3', null), ('17', '李超', '23', '男', '重庆', '4', null), ('18', '李娜', '21', '女', '广东', '4', null), ('19', '丽丽', '19', '女', '广西', '3', null), ('20', '刘楠楠2', '21', '女', '广东', '4', null), ('21', '刘楠楠3', '23', '男', '重庆', '4', null), ('22', '刘楠楠1', '19', '女', '广西', '3', null), ('23', '刘楠楠1', '19', '女', '广西', '3', null), ('24', '刘楠楠1', '19', '女', '广西', '3', null), ('25', '刘楠楠1', '19', '女', '广西', '3', null), ('26', '刘楠楠A', '19', '女', '广西', '3', null), ('27', '刘先', '21', '女', '广东', '4', null), ('28', '刘徐', '23', '男', '重庆', '4', null), ('29', '刘巧', '22', '女', '广西', '3', null), ('30', '刘艳', '20', '女', '广西', '3', null), ('31', '刘再先', '25', '男', '河南', '1', null), ('32', '香妃', '19', '女', '河南', '1', '0'), ('33', '腾格尔', '30', '女', '河南', '1', '0'), ('34', '小燕子', '28', '女', '湖南', '3', '0'), ('35', '朱哥哥', '23', '女', '贵州', '4', '0'), ('36', '李逵', null, '男', null, '3', '-1'), ('39', '莫瑞雪', '9', '男', '重庆', '1', '-1'), ('40', '我是AR', null, null, null, null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
