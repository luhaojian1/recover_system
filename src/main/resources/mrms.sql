/*
 Navicat Premium Data Transfer

 Source Server         : database
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : mrms

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 27/01/2019 10:43:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `deptId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门编号',
  `deptName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `deptCapacity` int(11) NOT NULL COMMENT '部门人数',
  `nowCapacity` int(11) NOT NULL COMMENT '现有人数',
  PRIMARY KEY (`deptId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for diagnosis
-- ----------------------------
DROP TABLE IF EXISTS `diagnosis`;
CREATE TABLE `diagnosis`  (
  `diagnosisId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '诊断表编号',
  `registerId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '流水登记号',
  `doctorId` int(11) NOT NULL COMMENT '诊断医生',
  `patientId` int(11) NOT NULL COMMENT '患者编号',
  `sickClassification` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '诊断病情分类',
  `sickLevel` int(2) DEFAULT NULL COMMENT '病情等级',
  `chiefComplaint` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主诉',
  `recoverPlan` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '康复计划',
  `diagnosisResult` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '诊断结论',
  `diagnosisDate` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '诊断日期',
  PRIMARY KEY (`diagnosisId`) USING BTREE,
  INDEX `FK_diagnosisResult2`(`registerId`) USING BTREE,
  INDEX `FK_diagnosis_doctor`(`doctorId`) USING BTREE,
  INDEX `FK_diagnosis_patient`(`patientId`) USING BTREE,
  CONSTRAINT `FK_diagnosisResult2` FOREIGN KEY (`registerId`) REFERENCES `register` (`registerId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_diagnosis_doctor` FOREIGN KEY (`doctorId`) REFERENCES `medicalpersonal` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_diagnosis_patient` FOREIGN KEY (`patientId`) REFERENCES `patient` (`patientId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of diagnosis
-- ----------------------------
INSERT INTO `diagnosis` VALUES ('000000001', '000000004', 10000001, 100000001, '精神病', 3, '防守打法', '发生', '范德萨', '2019-01-05 23:26:36');
INSERT INTO `diagnosis` VALUES ('000000002', '000000004', 10000001, 100000001, '精神病', 2, 'fdsf', 'fggg', 'fs', '2019-01-06 18:57:48');
INSERT INTO `diagnosis` VALUES ('000000003', '000000009', 10000001, 100000004, '精神病', 2, 'fdsf1', 'ffff', 'fsf1', '2019-01-06 19:11:06');
INSERT INTO `diagnosis` VALUES ('000000004', '000000009', 10000001, 100000004, '精神病', 2, 'fdsf', 'gg', 'ggg', '2019-01-06 19:15:47');
INSERT INTO `diagnosis` VALUES ('000000005', '000000009', 10000001, 100000004, '精神病', 2, '佛挡杀佛', '辅导费', '风法', '2019-01-06 19:26:58');
INSERT INTO `diagnosis` VALUES ('000000006', '000000004', 10000010, 100000001, '精神病', 2, '荆防颗粒撒酒疯', '发送到发送到', '发萨菲罗斯', '2019-01-08 17:29:29');
INSERT INTO `diagnosis` VALUES ('000000007', '000000011', 10000010, 100000002, '精神病', 2, '热污染无', '开服了双开', '放松放松东方', '2019-01-08 17:40:43');
INSERT INTO `diagnosis` VALUES ('000000008', '000000017', 10000001, 100000001, '精神病', 2, '发放', '发送方', '放松放松', '2019-01-12 18:06:32');
INSERT INTO `diagnosis` VALUES ('000000009', '000000016', 10000001, 100000003, '精神病', 2, '防守打法', '灌灌灌灌', '哈哈哈哈', '2019-01-12 18:07:20');
INSERT INTO `diagnosis` VALUES ('000000010', '000000015', 10000001, 100000002, '精神病', 1, 'gdfgdf', '发送到发送到', '个电饭锅电饭锅电饭锅', '2019-01-12 18:19:57');
INSERT INTO `diagnosis` VALUES ('000000011', '000000003', 10000001, 100000001, '精神病', 2, '记录康复时代峻峰', '发放', '发电房', '2019-01-12 18:21:37');

-- ----------------------------
-- Table structure for drug
-- ----------------------------
DROP TABLE IF EXISTS `drug`;
CREATE TABLE `drug`  (
  `drugId` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药物编号',
  `drugName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药物名称',
  `drugProperties` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药物性状',
  `function` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药物功效',
  `dosage` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用法用量',
  `attention` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注意事项',
  `specifications` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '规格',
  `manufactureDate` date DEFAULT NULL COMMENT '生产日期',
  `effectiveDate` date DEFAULT NULL COMMENT '有效日期',
  `adress` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '生产地址',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `unitPrice` double(5, 2) NOT NULL COMMENT '单价',
  PRIMARY KEY (`drugId`) USING BTREE,
  UNIQUE INDEX `Index_drugId`(`drugId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drug
-- ----------------------------
INSERT INTO `drug` VALUES ('z22022342', '复方丹心片', '薄膜衣片', '活血化瘀，理气止痛。用于气滞血瘀所指的胸痹，症见胸闷，心前区刺痛；', '口服，一次3片，一天三次', '孕妇慎用', '薄膜衣小片，每片约重0.32g', '2018-12-12', '2019-12-12', '吉林省图们市图们大路231号', 1000, 30.00);

-- ----------------------------
-- Table structure for druglist
-- ----------------------------
DROP TABLE IF EXISTS `druglist`;
CREATE TABLE `druglist`  (
  `drugListId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药物清单id',
  `drugId` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药品编号',
  `diagnosisId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '诊断表id',
  `drugDosage` int(11) DEFAULT NULL COMMENT '药物用量',
  `drugPrice` double(7, 2) NOT NULL COMMENT '药品价格',
  `drugListDate` datetime(0) DEFAULT NULL COMMENT '开单时间',
  PRIMARY KEY (`drugListId`) USING BTREE,
  INDEX `FK_diagnosis_drugList2`(`diagnosisId`) USING BTREE,
  INDEX `FK_drugList_drug2`(`drugId`) USING BTREE,
  CONSTRAINT `FK_diagnosis_drugList2` FOREIGN KEY (`diagnosisId`) REFERENCES `diagnosis` (`diagnosisId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_drugList_drug2` FOREIGN KEY (`drugId`) REFERENCES `drug` (`drugId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of druglist
-- ----------------------------
INSERT INTO `druglist` VALUES ('00000000001', 'z22022342', '000000004', 3, 90.00, '2019-01-06 19:15:47');
INSERT INTO `druglist` VALUES ('00000000002', 'z22022342', '000000006', 2, 60.00, '2019-01-06 19:26:58');
INSERT INTO `druglist` VALUES ('00000000003', 'z22022342', '000000007', 1, 30.00, '2019-01-08 19:11:02');
INSERT INTO `druglist` VALUES ('00000000004', 'z22022342', '000000008', 1, 30.00, '2019-01-12 18:06:32');
INSERT INTO `druglist` VALUES ('00000000005', 'z22022342', '000000009', 4, 120.00, '2019-01-12 18:07:20');
INSERT INTO `druglist` VALUES ('00000000006', 'z22022342', '000000010', 4, 120.00, '2019-01-12 18:19:57');
INSERT INTO `druglist` VALUES ('00000000007', 'z22022342', '000000011', 1, 30.00, '2019-01-12 18:21:37');

-- ----------------------------
-- Table structure for equipmentlist
-- ----------------------------
DROP TABLE IF EXISTS `equipmentlist`;
CREATE TABLE `equipmentlist`  (
  `equipmentListId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '器材清单编号',
  `rm_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '治疗器材',
  `diagnosisId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '诊断表id',
  `userId` int(11) DEFAULT NULL COMMENT '医疗人员编号',
  `useTimes` int(11) DEFAULT NULL COMMENT '治疗次数',
  `usePrice` double(7, 2) DEFAULT NULL COMMENT '治疗价格',
  `equipmentListDate` datetime(0) DEFAULT NULL COMMENT '康复器材开单时间',
  PRIMARY KEY (`equipmentListId`) USING BTREE,
  INDEX `FK_diagnosis_equiement2`(`diagnosisId`) USING BTREE,
  INDEX `FK_treatDoctor_work`(`userId`) USING BTREE,
  INDEX `FK_rm_equipmentList`(`rm_id`) USING BTREE,
  CONSTRAINT `FK_diagnosis_equiement2` FOREIGN KEY (`diagnosisId`) REFERENCES `diagnosis` (`diagnosisId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_rm_equipmentList` FOREIGN KEY (`rm_id`) REFERENCES `recoverequipment` (`rm_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_treatDoctor_work` FOREIGN KEY (`userId`) REFERENCES `medicalpersonal` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of equipmentlist
-- ----------------------------
INSERT INTO `equipmentlist` VALUES ('00000000001', 'ph101', '000000006', 10000010, 1, 30.00, '2019-01-08 17:29:29');
INSERT INTO `equipmentlist` VALUES ('00000000002', 'ph102', '000000006', 10000010, 1, 100.00, '2019-01-08 17:40:43');
INSERT INTO `equipmentlist` VALUES ('00000000003', 'ph102', '000000008', 10000001, 1, 100.00, '2019-01-12 18:06:32');
INSERT INTO `equipmentlist` VALUES ('00000000004', 'ph101', '000000009', 10000001, 6, 180.00, '2019-01-12 18:07:20');
INSERT INTO `equipmentlist` VALUES ('00000000005', 'ph102', '000000010', 10000001, 8, 30.00, '2019-01-12 18:19:57');
INSERT INTO `equipmentlist` VALUES ('00000000006', 'ph102', '000000011', 10000001, 1, 30.00, '2019-01-12 18:21:37');

-- ----------------------------
-- Table structure for followupplan
-- ----------------------------
DROP TABLE IF EXISTS `followupplan`;
CREATE TABLE `followupplan`  (
  `rapId` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '随访计划编号',
  `userId` int(11) DEFAULT NULL COMMENT '医疗人员编号',
  `rapurpose` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '随访目的',
  `reCoverPropaganda` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '康复宣传指导',
  `followUpAddress` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '随访地点',
  `chiefComplaint` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '病人主诉',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `followUpTime` datetime(0) DEFAULT NULL COMMENT '随访时间',
  PRIMARY KEY (`rapId`) USING BTREE,
  INDEX `FK_doctor_rap`(`userId`) USING BTREE,
  CONSTRAINT `FK_doctor_rap` FOREIGN KEY (`userId`) REFERENCES `medicalpersonal` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for inhospitaltreatment
-- ----------------------------
DROP TABLE IF EXISTS `inhospitaltreatment`;
CREATE TABLE `inhospitaltreatment`  (
  `inHospitalTreatId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `inPatientSheet` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `inTreatmentDate` date DEFAULT NULL,
  `inTreatProject` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `treatCode` double(6, 2) DEFAULT NULL,
  `treatCount` int(11) DEFAULT NULL,
  `finishCount` int(11) DEFAULT NULL,
  `treatMethod` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `recoverRemarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `treatmentDoctor` int(8) DEFAULT NULL,
  `visitDate` datetime(0) DEFAULT NULL,
  `visSerialNum` int(11) DEFAULT NULL,
  `treatmentRoom` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  `unitPrice` double(5, 2) DEFAULT NULL,
  `diagnosisSumPrice` float DEFAULT NULL,
  PRIMARY KEY (`inHospitalTreatId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for medicalpersonal
-- ----------------------------
DROP TABLE IF EXISTS `medicalpersonal`;
CREATE TABLE `medicalpersonal`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '医疗人员编号',
  `officeId` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '科室编号',
  `userName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '医疗人员姓名',
  `passWord` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `jobPosition` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职称',
  `power` int(2) NOT NULL COMMENT '用户权限',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `mpBirthday` date DEFAULT NULL COMMENT '出生日期',
  `subject` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学科专业',
  `doctorIntroduction` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '医生简介',
  `registerSum` int(11) DEFAULT NULL COMMENT '可挂号数',
  PRIMARY KEY (`userId`) USING BTREE,
  INDEX `FK_office_doctor`(`officeId`) USING BTREE,
  CONSTRAINT `FK_office_doctor` FOREIGN KEY (`officeId`) REFERENCES `office` (`officeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10000030 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medicalpersonal
-- ----------------------------
INSERT INTO `medicalpersonal` VALUES (111, 'JF101', '管理员', '111', '系统管理员', 0, 0, NULL, NULL, NULL, NULL, 30);
INSERT INTO `medicalpersonal` VALUES (201, 'JF101', '收费员1', '123', '收费员', 5, 0, 20, '1990-10-11', '会计', '收费', 20);
INSERT INTO `medicalpersonal` VALUES (10000001, 'JS301', '王芳', '123', '主任', 1, 0, 40, '1978-10-12', '精神科', '擅长治疗精神病', 30);
INSERT INTO `medicalpersonal` VALUES (10000002, 'JS301', '王老', '123456', '副主任', 2, 0, NULL, NULL, NULL, NULL, 20);
INSERT INTO `medicalpersonal` VALUES (10000003, 'KF201', '李医师', '123', '治疗师', 4, 0, NULL, NULL, NULL, NULL, 10);
INSERT INTO `medicalpersonal` VALUES (10000005, 'CJ301', '王生', '123456', '主任', 1, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 30);
INSERT INTO `medicalpersonal` VALUES (10000006, 'CJ302', '李1', '123456', '副主任', 2, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 20);
INSERT INTO `medicalpersonal` VALUES (10000007, 'CJ303', '李2', '123456', '医生', 3, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 20);
INSERT INTO `medicalpersonal` VALUES (10000008, 'CJ304', '李3', '123456', '医生', 3, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 30);
INSERT INTO `medicalpersonal` VALUES (10000009, 'JS301', '李4', '123456', '医生', 3, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 3);
INSERT INTO `medicalpersonal` VALUES (10000010, 'JS302', '李5', '123456', '医生', 3, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 30);
INSERT INTO `medicalpersonal` VALUES (10000011, 'JS302', '李6', '123456', '医生', 3, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 20);
INSERT INTO `medicalpersonal` VALUES (10000012, 'JS303', '李7', '123456', '医生', 3, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 30);
INSERT INTO `medicalpersonal` VALUES (10000013, 'JS304', '李8', '123456', '医生', 3, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 20);
INSERT INTO `medicalpersonal` VALUES (10000014, 'JS305', '李9', '123456', '医生', 3, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 20);
INSERT INTO `medicalpersonal` VALUES (10000015, 'KF201', '李10', '123456', '治疗师', 4, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 20);
INSERT INTO `medicalpersonal` VALUES (10000016, 'KF202', '李11', '123456', '治疗师', 4, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 50);
INSERT INTO `medicalpersonal` VALUES (10000017, 'JF101', '收费员2', '123456', '收费员', 5, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 30);
INSERT INTO `medicalpersonal` VALUES (10000018, 'KF202', '李13', '123456', '治疗师', 4, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 2);
INSERT INTO `medicalpersonal` VALUES (10000019, 'JF101', '收费员3', '123456', '收费员', 5, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 20);
INSERT INTO `medicalpersonal` VALUES (10000020, 'KF201', '李15', '123456', '治疗师', 4, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 10);
INSERT INTO `medicalpersonal` VALUES (10000021, 'JF101', '收费员4', '123456', '收费员', 5, 1, 30, '1995-07-14', '精神科专业', '擅长治疗精神病', 20);
INSERT INTO `medicalpersonal` VALUES (10000028, 'KF202', '王尚', '123456', '管理员', 0, 1, 0, '2019-01-10', '精神科', '弗利萨开发绿山咖啡', NULL);
INSERT INTO `medicalpersonal` VALUES (10000029, 'CJ302', '王尚', '123456', '管理员', 0, 1, 0, '2019-01-01', '精神科', '弗利萨开发绿山咖啡', NULL);

-- ----------------------------
-- Table structure for office
-- ----------------------------
DROP TABLE IF EXISTS `office`;
CREATE TABLE `office`  (
  `officeId` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '科室编号',
  `officeCategory` int(1) NOT NULL COMMENT '科室类别[0-残疾，1-精神病，2-康复科，3-财务科，4-管理科]',
  `officeName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '科室名称',
  `srPosition` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '科室地址',
  `officeCapacity` int(2) DEFAULT 0 COMMENT '科室容量',
  PRIMARY KEY (`officeId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of office
-- ----------------------------
INSERT INTO `office` VALUES ('CJ301', 1, '残疾科1室', '综合楼401', 1);
INSERT INTO `office` VALUES ('CJ302', 1, '残疾科2室', '综合楼402', 1);
INSERT INTO `office` VALUES ('CJ303', 1, '残疾科3室', '综合楼403', 1);
INSERT INTO `office` VALUES ('CJ304', 1, '残疾科4室', '综合楼404', 1);
INSERT INTO `office` VALUES ('JF101', 3, '缴费处', '综合楼101', 5);
INSERT INTO `office` VALUES ('JS301', 0, '精神科1室', '综合楼301', 1);
INSERT INTO `office` VALUES ('JS302', 0, '精神科2室', '综合楼302', 1);
INSERT INTO `office` VALUES ('JS303', 0, '精神科3室', '综合楼303', 1);
INSERT INTO `office` VALUES ('JS304', 0, '精神科4室', '综合楼304', 1);
INSERT INTO `office` VALUES ('JS305', 0, '精神科5室', '综合楼305', 1);
INSERT INTO `office` VALUES ('KF201', 2, '康复科1室', '康复楼201', 3);
INSERT INTO `office` VALUES ('KF202', 2, '康复科2室', '综合楼202', 3);

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`  (
  `patientId` int(11) NOT NULL AUTO_INCREMENT COMMENT '病人编号',
  `patientName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '病人姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `nation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '民族',
  `nativePlace` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '籍贯',
  `carId` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证号码',
  `homeAdress` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '家庭住址',
  `phoneNumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系方式',
  `mpBirthday` date DEFAULT NULL COMMENT '出生日期',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `occupation` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职业',
  `workPlace` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '单位',
  `height` double(4, 1) DEFAULT 0.0 COMMENT '身高',
  `weight` double(4, 1) DEFAULT 0.0 COMMENT '体重',
  `bloodType` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '血型',
  `famSickHistroy` tinyint(1) DEFAULT NULL COMMENT '是否家族病史',
  `sickHistrionicInstruction` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '家族病史说明',
  `drugAllergy` tinyint(1) DEFAULT NULL COMMENT '是否药物过敏',
  `drugAllergyIntroduction` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '药物过敏说明',
  PRIMARY KEY (`patientId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100000011 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES (100000001, '王芳', 16, '汉族', '广东省,韶关市', '44538119961213451x', '天河区华南农业大学华山区4号', '13602805185', '2018-11-15', 0, '护士', '罗定人民医院', 160.0, 50.0, 'B', 0, '', 0, '');
INSERT INTO `patient` VALUES (100000002, '李仁', 18, '汉族', '广东省,阳江市', '445381199612134515', '天河区华南农业大学华山区9号', '13602805186', '2018-12-25', 1, '农民', '在家务农', 172.3, 50.0, 'A', 0, '', 0, '');
INSERT INTO `patient` VALUES (100000003, '王二', 30, '汉族', 'null', '445381199312134515', '', '13602805186', '1993-12-13', 1, '', '', 0.0, 0.0, 'A', 0, '', 0, '');
INSERT INTO `patient` VALUES (100000004, '王美美', 20, '白族', 'null', '445381199812134515', '', '', '1998-12-13', 0, '', '', 0.0, 0.0, 'A', 0, '', 0, '');
INSERT INTO `patient` VALUES (100000005, '王非', 50, '蒙古族', '北京市,北京市辖区', '445381197612134515', '新江村9号', '13602805189', '1976-12-13', 0, '农民', '', 0.0, 0.0, 'A', 0, '', 0, '');
INSERT INTO `patient` VALUES (100000006, '张一发', 23, '汉族', '广东省,韶关市', '445381199612234515', '秋江村鸿福路9号', '13602805186', '1996-12-23', 1, '农民', '在家务农', 172.0, 78.0, 'AB', 1, '的积分历史快递分', 0, '');
INSERT INTO `patient` VALUES (100000008, '张飞', 23, '蒙古族', '吉林省,吉林市', '445381197512134515', '佛挡杀佛', '13602805189', '1975-12-14', 0, '农民', '', 165.0, 66.0, 'A', 0, '', 0, '');
INSERT INTO `patient` VALUES (100000009, '圣斗士', 23, '汉族', '天津市,天津市区', '445381198512134515', '秋江村鸿福路9号', '13602805189', '1985-12-13', 1, '农民', '', 0.0, 0.0, 'A', 1, 'hfksdjfl', 1, 'fsf;lks;f');
INSERT INTO `patient` VALUES (100000010, '汪峰', 39, '汉族', '上海市,上海市辖区', '445381198912134515', '秋江村鸿福路9号', '13602805186', '1989-12-13', 1, '', '', 0.0, 0.0, 'A', 0, '', 0, '');

-- ----------------------------
-- Table structure for patientassessment
-- ----------------------------
DROP TABLE IF EXISTS `patientassessment`;
CREATE TABLE `patientassessment`  (
  `assessId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评定表编号',
  `patientId` int(11) DEFAULT NULL COMMENT '病人编号',
  `userId` int(11) DEFAULT NULL COMMENT '医疗人员编号',
  `cranium` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '颅脑',
  `spinalCord` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '脊髓',
  `fracture` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '骨折',
  `other` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '其他',
  `imagingFindings` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '影像学结论',
  `pastDisease` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '既往疾病',
  `complication` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '并发症',
  `stageDisease` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '现阶段病情',
  `jointLimitation` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关节受限',
  `muscleWeakness` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '肌力下降',
  `muscularTension` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '肌张力',
  `standingBalance` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '站位平衡',
  `sensoryFunction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '感觉功能',
  `emotionalAssessment` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '情绪评定',
  `pain` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '疼痛',
  `heartFunction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '心功能',
  `pulmonaryFunction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '肺功能',
  `renalFunction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '肾功能',
  `sexualFunction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性功能',
  `otherFunction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '其他功能',
  `feed` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '进食',
  `bathe` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '洗澡',
  `veneer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '饰面',
  `dressing` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '穿衣',
  `controlStool` int(11) DEFAULT NULL COMMENT '控制大便',
  `controluriation` int(11) DEFAULT NULL COMMENT '控制小便',
  `toiletUsage` int(11) DEFAULT NULL COMMENT '用厕所',
  `bedChairMovement` int(11) DEFAULT NULL COMMENT '床椅移动',
  `walk45m` int(11) DEFAULT NULL COMMENT '平地走45m',
  `stairActivity` int(11) DEFAULT NULL COMMENT '上下楼梯',
  `totalScore` double(3, 1) DEFAULT NULL COMMENT '总分',
  `limitedOccupationalAbility` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职业能力受限',
  `entertainmentLimitation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '休闲娱乐受限',
  `socialCommunication` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '社会交往',
  `assessDate` date DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`assessId`) USING BTREE,
  INDEX `FK_assess_patient`(`userId`) USING BTREE,
  INDEX `FK_assess_result`(`patientId`) USING BTREE,
  CONSTRAINT `FK_assess_patient` FOREIGN KEY (`userId`) REFERENCES `medicalpersonal` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_assess_result` FOREIGN KEY (`patientId`) REFERENCES `patient` (`patientId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for paymentlist
-- ----------------------------
DROP TABLE IF EXISTS `paymentlist`;
CREATE TABLE `paymentlist`  (
  `treatSheetId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '治疗缴费单号',
  `userId` int(11) DEFAULT NULL COMMENT '医生',
  `patientId` int(11) DEFAULT NULL COMMENT '病人',
  `diagnosisId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '治疗单',
  `diagnosisSumPrice` double(9, 2) DEFAULT NULL COMMENT '总价',
  `payStatus` int(11) NOT NULL COMMENT '缴费状态【1-未缴费，2-缴费】',
  `payTime` datetime(0) DEFAULT NULL COMMENT '缴费时间',
  `treatFinished` tinyint(1) DEFAULT NULL COMMENT '是否完成治疗',
  `treatTimes` int(11) DEFAULT NULL COMMENT '已经治疗的次数',
  `recoverRemarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `tollCollector` int(11) DEFAULT NULL COMMENT '收费员',
  PRIMARY KEY (`treatSheetId`) USING BTREE,
  INDEX `FK_diagnosisInfo`(`diagnosisId`) USING BTREE,
  INDEX `FK_pay`(`userId`) USING BTREE,
  INDEX `FK_prescription`(`patientId`) USING BTREE,
  INDEX `FK_tollCollector_paymentlist`(`tollCollector`) USING BTREE,
  CONSTRAINT `FK_diagnosisInfo` FOREIGN KEY (`diagnosisId`) REFERENCES `diagnosis` (`diagnosisId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_pay` FOREIGN KEY (`userId`) REFERENCES `medicalpersonal` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_prescription` FOREIGN KEY (`patientId`) REFERENCES `patient` (`patientId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_tollCollector_paymentlist` FOREIGN KEY (`tollCollector`) REFERENCES `medicalpersonal` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paymentlist
-- ----------------------------
INSERT INTO `paymentlist` VALUES ('000000001', 10000010, 100000001, '000000006', 190.00, 2, '2019-01-09 20:59:10', 0, 0, NULL, 201);
INSERT INTO `paymentlist` VALUES ('000000002', 10000001, 100000002, '000000010', 150.00, 2, '2019-01-12 18:23:19', NULL, NULL, NULL, 201);

-- ----------------------------
-- Table structure for recoverassess
-- ----------------------------
DROP TABLE IF EXISTS `recoverassess`;
CREATE TABLE `recoverassess`  (
  `reAssessId` int(11) NOT NULL AUTO_INCREMENT COMMENT '康复评定表编号',
  `diagnosisId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '诊断记录表编号',
  `patientId` int(11) DEFAULT NULL COMMENT '病人编号',
  `userId` int(11) DEFAULT NULL COMMENT '医疗人员编号',
  `assessmentTimes` int(11) DEFAULT NULL COMMENT '评估次数',
  `recoverRemarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '训练目标',
  `recoverSituation` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '康复进展情况',
  `recoverAssessment` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '康复评估',
  `assessTime` date DEFAULT NULL COMMENT '评估时间',
  PRIMARY KEY (`reAssessId`) USING BTREE,
  INDEX `FK_recover_assess`(`patientId`) USING BTREE,
  INDEX `FK_recover_doctor`(`userId`) USING BTREE,
  INDEX `FK_recoverassess_diagnosis`(`diagnosisId`) USING BTREE,
  CONSTRAINT `FK_recover_assess` FOREIGN KEY (`patientId`) REFERENCES `patient` (`patientId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_recover_doctor` FOREIGN KEY (`userId`) REFERENCES `medicalpersonal` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_recoverassess_diagnosis` FOREIGN KEY (`diagnosisId`) REFERENCES `diagnosis` (`diagnosisId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of recoverassess
-- ----------------------------
INSERT INTO `recoverassess` VALUES (4, '000000006', 100000001, 10000001, NULL, '就发了康师傅', '副书记联发科', '福建省路费', '2019-01-12');
INSERT INTO `recoverassess` VALUES (5, '000000006', 100000001, 10000001, NULL, '放松放松', '发对方的说法', '发的所发生的', '2019-01-12');

-- ----------------------------
-- Table structure for recoverequipment
-- ----------------------------
DROP TABLE IF EXISTS `recoverequipment`;
CREATE TABLE `recoverequipment`  (
  `rm_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '器材编号',
  `officeId` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '科室编号',
  `rm_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '器材名称',
  `rm_number` int(11) NOT NULL COMMENT '器材数量',
  `rm_specifications` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '器材规格',
  `rm_classification` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '器材分类',
  `rm_function` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '器材作用',
  `hourUnitPrice` double(5, 2) DEFAULT NULL COMMENT '单价',
  PRIMARY KEY (`rm_id`) USING BTREE,
  INDEX `FK_equipmentPosition`(`officeId`) USING BTREE,
  CONSTRAINT `FK_equipmentPosition` FOREIGN KEY (`officeId`) REFERENCES `office` (`officeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of recoverequipment
-- ----------------------------
INSERT INTO `recoverequipment` VALUES ('ph101', 'KF201', '平衡椅', 1, '111111', '腿部回复', '站立平衡回复', 30.00);
INSERT INTO `recoverequipment` VALUES ('ph102', 'KF202', '四肢活动椅', 1, '111111', '全身回复', '全身平衡回复', 30.00);

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register`  (
  `registerId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '流水登记号',
  `patientId` int(11) NOT NULL COMMENT '病人编号',
  `diagnosisId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '诊断表编号',
  `userId` int(11) DEFAULT NULL COMMENT '医疗人员编号',
  `patientName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '病人姓名',
  `visStatus` int(11) DEFAULT NULL COMMENT '就诊状态',
  `registrationCategory` int(11) DEFAULT NULL COMMENT '挂号类别',
  `diagnosisPrice` int(3) DEFAULT NULL COMMENT '挂号费',
  `registerDate` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '挂号日期',
  `tollCollector` int(11) DEFAULT NULL COMMENT '收费员',
  `diagnosisNo` int(11) DEFAULT NULL COMMENT '就诊序号',
  PRIMARY KEY (`registerId`) USING BTREE,
  INDEX `FK_Relationship_5`(`userId`) USING BTREE,
  INDEX `FK_diagnosisResult`(`diagnosisId`) USING BTREE,
  INDEX `FK_patientRegister`(`patientId`) USING BTREE,
  INDEX `FK_register_collector`(`tollCollector`) USING BTREE,
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`userId`) REFERENCES `medicalpersonal` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_diagnosisResult` FOREIGN KEY (`diagnosisId`) REFERENCES `diagnosis` (`diagnosisId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_patientRegister` FOREIGN KEY (`patientId`) REFERENCES `patient` (`patientId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_register_collector` FOREIGN KEY (`tollCollector`) REFERENCES `medicalpersonal` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES ('000000001', 100000001, NULL, 10000002, '王芳', 1, 2, 7, '2018-12-30 19:37:11', 201, 1);
INSERT INTO `register` VALUES ('000000002', 100000003, NULL, 10000006, '王二', 1, 2, 7, '2019-01-09 22:20:53', 10000017, 2);
INSERT INTO `register` VALUES ('000000003', 100000001, '000000011', 10000001, '王芳', 2, 1, 10, '2019-01-08 17:37:52', 201, 2);
INSERT INTO `register` VALUES ('000000004', 100000001, '000000006', 10000001, '王芳', 1, 3, 2, '2019-01-09 22:20:54', 10000017, 3);
INSERT INTO `register` VALUES ('000000008', 100000005, NULL, 10000013, '王非', 1, 3, 2, '2019-01-09 22:21:25', 10000019, 5);
INSERT INTO `register` VALUES ('000000009', 100000004, '000000005', 10000001, '王美美', 1, 1, 10, '2019-01-09 22:20:57', 10000017, 7);
INSERT INTO `register` VALUES ('000000010', 100000003, NULL, 10000010, '王二', 1, 3, 2, '2019-01-09 22:20:58', 10000017, 8);
INSERT INTO `register` VALUES ('000000011', 100000002, '000000007', 10000010, '李仁', 1, 3, 2, '2019-01-09 22:21:35', 10000019, 7);
INSERT INTO `register` VALUES ('000000012', 100000004, NULL, 10000010, '王美美', 1, 2, 7, '2019-01-09 22:21:37', 10000017, 4);
INSERT INTO `register` VALUES ('000000015', 100000002, '000000010', 10000001, '李仁', 2, 1, 10, '2019-01-12 16:42:47', 201, NULL);
INSERT INTO `register` VALUES ('000000016', 100000003, '000000009', 10000001, '王二', 2, 1, 10, '2019-01-12 16:42:48', 201, NULL);
INSERT INTO `register` VALUES ('000000017', 100000001, '000000008', 10000001, '王芳', 2, 1, 10, '2019-01-12 16:42:52', 201, NULL);
INSERT INTO `register` VALUES ('000000019', 100000002, NULL, 10000001, '李仁', 1, 1, 10, '2019-01-13 21:13:02', 201, NULL);

-- ----------------------------
-- Table structure for sickroom
-- ----------------------------
DROP TABLE IF EXISTS `sickroom`;
CREATE TABLE `sickroom`  (
  `sickRoomId` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sickRoomName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `srPosition` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bedNumber` int(11) NOT NULL,
  `bedId` int(11) NOT NULL,
  PRIMARY KEY (`sickRoomId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Procedure structure for diagnosis_orderNo
-- ----------------------------
DROP PROCEDURE IF EXISTS `diagnosis_orderNo`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `diagnosis_orderNo`(IN orderNamePre char(2), OUT `newOrderNo` varchar(15))
BEGIN
	DEClare currentDate varCHAR(8); -- 当前日期
	DECLARE maxNo int DEFAULT 0;       -- 离现在最近的满足条件的订单编号的流水号最后5位
	DECLARE oldOrderNo varchar(15) DEFAULT ''; -- 离现在最近的满足条件的订单编号
	
	SELECT DATE_FORMAT(NOW(),'%Y%m%d') into currentDate ;
  SELECT IFNULL(diagnosisId,'') into oldOrderNo
	from druglist                
	WHERE SUBSTRING(diagnosisId,3,8) = currentDate 
	 AND SUBSTRING(diagnosisId,1,2) = orderNamePre
   ORDER BY diagnosisId limit 1; -- 有多条时只显示离现在最近的一条 
	 
  IF oldOrderNo !='' THEN
		SET maxNo = CONVERT(SUBSTRING(oldOrderNo,-5),DECIMAL); -- SUBSTRING(oldOrderNo,-5)：订单编号如果不为‘‘截取订单的最后5位  
	END IF;
	SELECT
		CONCAT(orderNamePre,currentDate,LPAD((maxNo+1),5,'0')) into newOrderNo ;-- LPAD((maxNo + 1), 5, '0')：如果不足5位，将用0填充左边 
		select newOrderNo;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
