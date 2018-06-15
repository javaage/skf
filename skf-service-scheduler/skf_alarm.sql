DROP TABLE IF EXISTS `SKF_ALRM`;
CREATE TABLE `SKF_ALRM`  (
  `CMPT_CODE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ALRM_TYPE` int(11) NOT NULL,
  `ALRM_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `STATUS` int(11) NULL DEFAULT NULL,
  `TOTAL_VALUE` float NULL DEFAULT NULL,
  `DANDER_LAVEL` float NULL DEFAULT NULL,
  `SCORE` float NULL DEFAULT NULL,
  `CLASS` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DEFECT_FREQ_ORDER` float NULL DEFAULT NULL,
  `BP_TYPE` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`CMPT_CODE`, `ALRM_TYPE`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for skf_alrm_cmmt
-- ----------------------------
DROP TABLE IF EXISTS `SKF_ALRM_CMMT`;
CREATE TABLE `SKF_ALRM_CMMT`  (
  `CMPT_CODE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ALRM_TYPE` int(11) NOT NULL,
  `USR_CODE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TYPE` int(11) NULL DEFAULT NULL,
  `TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `COMMENT` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for skf_dglv_log
-- ----------------------------
DROP TABLE IF EXISTS `SKF_DGLV_LOG`;
CREATE TABLE `SKF_DGLV_LOG`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CMPT_CODE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DANGER_LEVEL` float NOT NULL,
  `TOTAL_VALUE_DANGER_LEVEL` float NOT NULL,
  `USR_CODE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for skf_scan_sign
-- ----------------------------
DROP TABLE IF EXISTS `SKF_SCAN_SIGN`;
CREATE TABLE `SKF_SCAN_SIGN`  (
  `SCHEMA` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SIGN` int(11) NOT NULL,
  PRIMARY KEY (`schema`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for skf_cmpt_score
-- ----------------------------
DROP TABLE IF EXISTS `SKF_CMPT_SCORE`;
CREATE TABLE `SKF_CMPT_SCORE`  (
  `CMPT_CODE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `CALSS` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SCORE` float NOT NULL,
  `TOTAL_VALUE` float NOT NULL,
  `DANGER_LEVEL` float NOT NULL,
  `BP_TYPE` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`CMPT_CODE`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;