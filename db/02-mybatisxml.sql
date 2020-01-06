/*
 Navicat Premium Data Transfer

 Source Server         : springboot-教程示例
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : 02-mybatisxml

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 06/01/2020 17:00:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sort` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_UNIQUE`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '高等数学', 1);
INSERT INTO `course` VALUES (2, '离散数学', 2);
INSERT INTO `course` VALUES (3, '软件工程', 3);
INSERT INTO `course` VALUES (4, '大学英语', 4);
INSERT INTO `course` VALUES (5, '计算机导论', 5);
INSERT INTO `course` VALUES (6, 'Java高级语言', 0);

-- ----------------------------
-- Table structure for course_student_mid
-- ----------------------------
DROP TABLE IF EXISTS `course_student_mid`;
CREATE TABLE `course_student_mid`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NULL DEFAULT NULL,
  `student_id` int(11) NULL DEFAULT NULL,
  UNIQUE INDEX `id_UNIQUE`(`id`) USING BTREE,
  INDEX `course_id_idx`(`course_id`) USING BTREE,
  INDEX `student_id_idx`(`student_id`) USING BTREE,
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_student_mid
-- ----------------------------
INSERT INTO `course_student_mid` VALUES (29, 1, 1);
INSERT INTO `course_student_mid` VALUES (30, 1, 13);
INSERT INTO `course_student_mid` VALUES (31, 1, 3);
INSERT INTO `course_student_mid` VALUES (32, 1, 4);
INSERT INTO `course_student_mid` VALUES (33, 1, 6);
INSERT INTO `course_student_mid` VALUES (34, 2, 1);
INSERT INTO `course_student_mid` VALUES (35, 2, 4);
INSERT INTO `course_student_mid` VALUES (36, 2, 6);
INSERT INTO `course_student_mid` VALUES (37, 2, 8);
INSERT INTO `course_student_mid` VALUES (38, 2, 12);
INSERT INTO `course_student_mid` VALUES (39, 3, 11);
INSERT INTO `course_student_mid` VALUES (40, 3, 15);
INSERT INTO `course_student_mid` VALUES (41, 3, 1);
INSERT INTO `course_student_mid` VALUES (42, 3, 3);

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `grade_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '年级信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (1, '大一');
INSERT INTO `grade` VALUES (2, '大二');
INSERT INTO `grade` VALUES (3, '大三');
INSERT INTO `grade` VALUES (4, '大四');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `student_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '学生姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '性别',
  `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '家庭住址',
  `grade_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `grade_id`(`grade_id`) USING BTREE,
  CONSTRAINT `grade_id` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '学生信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '小乔', 18, '女', '安徽', 2);
INSERT INTO `student` VALUES (3, '刘备', 35, '男', '当时的蜀地-荆州', 4);
INSERT INTO `student` VALUES (4, '张飞', 18, '男', '河北', 2);
INSERT INTO `student` VALUES (6, '关于', 38, '男', '山西', 4);
INSERT INTO `student` VALUES (7, '赵子龙', 28, '男', '长白山赵子龙也。。。', 3);
INSERT INTO `student` VALUES (8, '岳飞', 28, '男', '河北', 2);
INSERT INTO `student` VALUES (11, '张三111', 32, '男', '广西', 2);
INSERT INTO `student` VALUES (12, '小芳', 15, '女', '广东', 1);
INSERT INTO `student` VALUES (13, '王五55', 29, '男', '合肥', 3);
INSERT INTO `student` VALUES (14, '小美22', 23, '女', '黑龙江', 4);
INSERT INTO `student` VALUES (15, '小莲44', 19, '女', '内蒙古', 3);

SET FOREIGN_KEY_CHECKS = 1;
