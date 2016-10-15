/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.5.0

Source Server         : Oracle_Blade
Source Server Version : 100200
Source Host           : 192.168.30.172:1521
Source Schema         : BLADE

Target Server Type    : ORACLE
Target Server Version : 100200
File Encoding         : 65001

Date: 2016-06-23 15:28:26
*/


-- ----------------------------
-- Table structure for TB_TFW_GSDT
-- ----------------------------
DROP TABLE "TB_TFW_GSDT";
CREATE TABLE "TB_TFW_GSDT" (
"F_IT_XL" NUMBER(11) NOT NULL ,
"F_IT_QZ" NUMBER(11) NULL ,
"F_VC_BT" NVARCHAR2(500) NULL ,
"F_VC_LJBT" NVARCHAR2(255) NULL ,
"F_IT_CJR" NUMBER(11) NULL ,
"F_DT_CJSJ" DATE NULL ,
"F_VC_BJBM" NVARCHAR2(255) NULL ,
"F_VC_BJSJ" NVARCHAR2(255) NULL ,
"F_IT_XGR" NUMBER(11) NULL ,
"F_DT_XGSJ" DATE NULL ,
"F_IT_ZT" NUMBER(11) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_TFW_GSDT
-- ----------------------------
INSERT INTO "TB_TFW_GSDT" VALUES ('12', '100', '123', '123', '1', TO_DATE('2016-02-02 15:05:30', 'YYYY-MM-DD HH24:MI:SS'), '常州同步软件技术有限公司', '2016年02月01日', null, null, null);
INSERT INTO "TB_TFW_GSDT" VALUES ('13', '100', '1', '1', '1', TO_DATE('2016-02-02 15:41:52', 'YYYY-MM-DD HH24:MI:SS'), '常州同步软件技术有限公司', '2016年03月07日', null, null, null);
INSERT INTO "TB_TFW_GSDT" VALUES ('7', '100', '123123', '123123', '1', TO_DATE('2016-02-02 14:06:29', 'YYYY-MM-DD HH24:MI:SS'), '常州同步软件技术有限公司', null, null, null, null);
INSERT INTO "TB_TFW_GSDT" VALUES ('8', '100', '21312', '21312', '1', TO_DATE('2016-02-02 14:06:45', 'YYYY-MM-DD HH24:MI:SS'), '常州同步软件技术有限公司', '2016年02月02日', null, null, null);
INSERT INTO "TB_TFW_GSDT" VALUES ('11', '100', '312322223333333333', '3123', '1', TO_DATE('2016-02-24 13:23:20', 'YYYY-MM-DD HH24:MI:SS'), '常州同步软件技术有限公司', '2016年02月08日', '1', TO_DATE('2016-02-24 13:23:20', 'YYYY-MM-DD HH24:MI:SS'), '1');
INSERT INTO "TB_TFW_GSDT" VALUES ('16', '100', '23333333333333333333332', '23333333333333333333332', '1', TO_DATE('2016-02-03 11:18:27', 'YYYY-MM-DD HH24:MI:SS'), '常州同步软件技术有限公司', '2016年02月07日', '1', TO_DATE('2016-02-03 11:18:27', 'YYYY-MM-DD HH24:MI:SS'), '2');

-- ----------------------------
-- Table structure for TB_TFW_GSDTNR
-- ----------------------------
DROP TABLE "TB_TFW_GSDTNR";
CREATE TABLE "TB_TFW_GSDTNR" (
"F_IT_XL" NUMBER(11) NOT NULL ,
"F_IT_DTXL" NUMBER(11) NULL ,
"F_TX_NR" NVARCHAR2(2000) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_TFW_GSDTNR
-- ----------------------------
INSERT INTO "TB_TFW_GSDTNR" VALUES ('12', '12', '3123123');
INSERT INTO "TB_TFW_GSDTNR" VALUES ('13', '13', '12');
INSERT INTO "TB_TFW_GSDTNR" VALUES ('11', '11', '123123123111111111111111111111111111111111111112');
INSERT INTO "TB_TFW_GSDTNR" VALUES ('16', '16', '1');

-- ----------------------------
-- Table structure for TB_TFW_GZBG
-- ----------------------------
DROP TABLE "TB_TFW_GZBG";
CREATE TABLE "TB_TFW_GZBG" (
"F_IT_XL" NUMBER(11) NOT NULL ,
"F_VC_BT" NVARCHAR2(255) NULL ,
"F_IT_BGBM" NUMBER(11) NULL ,
"F_DT_BGSJ" DATE NULL ,
"F_DT_CJSJ" DATE NULL ,
"F_DT_XGSJ" DATE NULL ,
"F_IT_CJR" NUMBER(11) NULL ,
"F_IT_XGR" NUMBER(11) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_TFW_GZBG
-- ----------------------------
INSERT INTO "TB_TFW_GZBG" VALUES ('269', 'test', '3', TO_DATE('2016-03-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-03-07 08:49:08', 'YYYY-MM-DD HH24:MI:SS'), null, '1', null);

-- ----------------------------
-- Table structure for TB_TFW_GZBGNR
-- ----------------------------
DROP TABLE "TB_TFW_GZBGNR";
CREATE TABLE "TB_TFW_GZBGNR" (
"F_IT_XL" NUMBER(11) NOT NULL ,
"F_IT_BGXL" NUMBER(11) NULL ,
"F_TX_BGNR" NVARCHAR2(2000) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_TFW_GZBGNR
-- ----------------------------
INSERT INTO "TB_TFW_GZBGNR" VALUES ('111', '269', 'test');

-- ----------------------------
-- Table structure for TB_TFW_TZGG
-- ----------------------------
DROP TABLE "TB_TFW_TZGG";
CREATE TABLE "TB_TFW_TZGG" (
"F_IT_XL" NUMBER(11) NOT NULL ,
"F_VC_BT" NVARCHAR2(255) NULL ,
"F_IT_LX" NUMBER(11) NULL ,
"F_TX_NR" NVARCHAR2(2000) NULL ,
"F_DT_FBSJ" DATE NULL ,
"F_DT_CJSJ" DATE NULL ,
"F_IT_CJR" NUMBER(11) NULL ,
"F_IT_TP" NUMBER(11) NULL ,
"VERSION" NUMBER(11) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_TFW_TZGG
-- ----------------------------
INSERT INTO "TB_TFW_TZGG" VALUES ('1411', '23333', null, null, null, null, null, null, null);
INSERT INTO "TB_TFW_TZGG" VALUES ('1414', '2333333', '10', '11222', TO_DATE('2016-02-24 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null);
INSERT INTO "TB_TFW_TZGG" VALUES ('1412', '23333', '6', '1', TO_DATE('2016-02-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null);
INSERT INTO "TB_TFW_TZGG" VALUES ('1418', 'tom', '1', '1', TO_DATE('2016-02-18 10:58:44', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null);
INSERT INTO "TB_TFW_TZGG" VALUES ('1430', 'ceshi233333333333', null, null, null, null, null, null, null);
INSERT INTO "TB_TFW_TZGG" VALUES ('1431', 'ceshi233333333333', null, null, null, null, null, null, null);
INSERT INTO "TB_TFW_TZGG" VALUES ('123', 'sssssss', '2', null, null, null, null, null, null);
INSERT INTO "TB_TFW_TZGG" VALUES ('1420', 'ceshi233333333333', null, null, null, null, null, null, null);
INSERT INTO "TB_TFW_TZGG" VALUES ('1429', 'asdfasdf23312', '10', 'asdfdd1', TO_DATE('2016-01-31 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null);
INSERT INTO "TB_TFW_TZGG" VALUES ('1409', '23333', null, null, null, null, null, null, null);
INSERT INTO "TB_TFW_TZGG" VALUES ('1410', '23333', null, null, null, null, null, null, null);
INSERT INTO "TB_TFW_TZGG" VALUES ('1404', 'asdfasdf23312', '1', 'asdfdd1', TO_DATE('2016-01-31 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null);
INSERT INTO "TB_TFW_TZGG" VALUES ('1419', 'ceshi', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for TB_TFW_XWB
-- ----------------------------
DROP TABLE "TB_TFW_XWB";
CREATE TABLE "TB_TFW_XWB" (
"F_IT_XL" NUMBER(11) NOT NULL ,
"F_VC_BT" NVARCHAR2(100) NULL ,
"F_VC_FBT" NVARCHAR2(100) NULL ,
"F_VC_LJBT" NVARCHAR2(2000) NULL ,
"F_VC_TTBT" NVARCHAR2(2000) NULL ,
"F_VC_DD" NVARCHAR2(2000) NULL ,
"F_VC_TP" NVARCHAR2(100) NULL ,
"F_VC_GJZ" NVARCHAR2(200) NULL ,
"F_VC_SSLP" NVARCHAR2(200) NULL ,
"F_VC_ZLDZ" NVARCHAR2(200) NULL ,
"F_IT_DJJS" NUMBER(11) NULL ,
"F_IT_DJS" NUMBER(11) NULL ,
"F_VC_BJ" NVARCHAR2(30) NULL ,
"F_VC_LY" NVARCHAR2(30) NULL ,
"F_CR_FBZT" NCHAR(1) NULL ,
"F_CR_GKZT" NCHAR(1) NULL ,
"F_DT_FBSJ" DATE NULL ,
"F_CR_SHZT" NCHAR(1) NULL ,
"F_IT_SHR" NUMBER(11) NULL ,
"F_DT_SHSJ" DATE NULL ,
"F_VC_SHYJ" NVARCHAR2(2000) NULL ,
"F_CR_TBLX" NUMBER(11) NULL ,
"F_IT_CJR" NUMBER(11) NULL ,
"F_DT_CJSJ" DATE NULL ,
"F_IT_ZHXGR" NUMBER(11) NULL ,
"F_DT_ZHXGSJ" DATE NULL ,
"F_VC_TPFJ" NVARCHAR2(100) NULL ,
"F_VC_SPFJ" NVARCHAR2(100) NULL ,
"F_CR_SFYC" NCHAR(1) NULL ,
"F_IT_QZ" NUMBER(11) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_TFW_XWB
-- ----------------------------
INSERT INTO "TB_TFW_XWB" VALUES ('85060', '123', '121', '12', null, '1212', null, '121', null, '21212', null, null, '管理员', '12', null, '2', TO_DATE('2016-02-03 15:08:44', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, null, '1', TO_DATE('2016-02-03 15:08:44', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2016-02-26 08:42:40', 'YYYY-MM-DD HH24:MI:SS'), null, null, '0', '10011');
INSERT INTO "TB_TFW_XWB" VALUES ('1', '233333', '121', '12', '12', '1212', null, '121', '12', '21212', '1', '1', '管理员', '12', null, '2', TO_DATE('2016-02-03 15:08:44', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, null, null, null, '1', TO_DATE('2016-02-22 13:18:06', 'YYYY-MM-DD HH24:MI:SS'), null, null, '0', '10011');

-- ----------------------------
-- Table structure for TB_TFW_XWXQB
-- ----------------------------
DROP TABLE "TB_TFW_XWXQB";
CREATE TABLE "TB_TFW_XWXQB" (
"F_IT_XL" NUMBER(11) NOT NULL ,
"F_IT_SSXW" NUMBER(11) NULL ,
"F_TX_NR" NVARCHAR2(2000) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_TFW_XWXQB
-- ----------------------------
INSERT INTO "TB_TFW_XWXQB" VALUES ('40060', '85060', '12121');
INSERT INTO "TB_TFW_XWXQB" VALUES ('1', '1', '12121');

-- ----------------------------
-- Table structure for TFW_ATTACH
-- ----------------------------
DROP TABLE "TFW_ATTACH";
CREATE TABLE "TFW_ATTACH" (
"ID" NUMBER(11) NOT NULL ,
"CODE" NVARCHAR2(255) NULL ,
"NAME" NVARCHAR2(255) NULL ,
"URL" NVARCHAR2(2000) NULL ,
"STATUS" NUMBER(11) NULL ,
"CREATER" NUMBER(11) NULL ,
"CREATETIME" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TFW_ATTACH
-- ----------------------------

-- ----------------------------
-- Table structure for TFW_DEPT
-- ----------------------------
DROP TABLE "TFW_DEPT";
CREATE TABLE "TFW_DEPT" (
"ID" NUMBER(11) NOT NULL ,
"NUM" NUMBER(11) NULL ,
"PID" NUMBER(11) NULL ,
"SIMPLENAME" NVARCHAR2(45) NULL ,
"FULLNAME" NVARCHAR2(255) NULL ,
"TIPS" NVARCHAR2(255) NULL ,
"VERSION" NUMBER(11) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TFW_DEPT
-- ----------------------------
INSERT INTO "TFW_DEPT" VALUES ('1', '0', '0', 'Tonbu', 'Tonbu', null, '1');
INSERT INTO "TFW_DEPT" VALUES ('2', '1', '1', '江苏同步', '江苏同步信息技术有限公司', null, '1');
INSERT INTO "TFW_DEPT" VALUES ('3', '1', '2', '技服部', '技术服务部', null, '1');
INSERT INTO "TFW_DEPT" VALUES ('4', '2', '2', '客服部', '客户服务部', null, '1');
INSERT INTO "TFW_DEPT" VALUES ('5', '3', '2', '销售部', '销售部', null, '1');
INSERT INTO "TFW_DEPT" VALUES ('6', '4', '2', '综合管理部', '综合管理部', null, '1');
INSERT INTO "TFW_DEPT" VALUES ('7', '2', '1', '常州同步', '常州同步软件技术有限公司', null, '1');
INSERT INTO "TFW_DEPT" VALUES ('8', '1', '7', '产品部', '产品部', null, '1');
INSERT INTO "TFW_DEPT" VALUES ('9', '2', '7', '研发部', '研发部', null, '1');
INSERT INTO "TFW_DEPT" VALUES ('10', '3', '7', '项目部', '项目部', null, '1');
INSERT INTO "TFW_DEPT" VALUES ('11', '4', '7', '运维部', '运维部', null, '1');
INSERT INTO "TFW_DEPT" VALUES ('12', '5', '7', '销售部', '销售部', null, '1');
INSERT INTO "TFW_DEPT" VALUES ('13', '6', '7', '行政部', '行政部', null, '1');

-- ----------------------------
-- Table structure for TFW_DICT
-- ----------------------------
DROP TABLE "TFW_DICT";
CREATE TABLE "TFW_DICT" (
"ID" NUMBER(11) NOT NULL ,
"CODE" NVARCHAR2(255) NULL ,
"NUM" NUMBER(11) NULL ,
"PID" NUMBER(11) NULL ,
"NAME" NVARCHAR2(255) NULL ,
"TIPS" NVARCHAR2(255) NULL ,
"VERSION" NUMBER(11) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TFW_DICT
-- ----------------------------
INSERT INTO "TFW_DICT" VALUES ('44', '102', '1', '14', '发布测试', null, '0');
INSERT INTO "TFW_DICT" VALUES ('45', '102', '2', '16', '测试222', null, '1');
INSERT INTO "TFW_DICT" VALUES ('1', '101', '0', '0', '性别', null, '0');
INSERT INTO "TFW_DICT" VALUES ('2', '101', '1', '1', '男', null, '1');
INSERT INTO "TFW_DICT" VALUES ('3', '101', '2', '1', '女', null, '0');
INSERT INTO "TFW_DICT" VALUES ('5', '901', '0', '0', '账号状态', null, '0');
INSERT INTO "TFW_DICT" VALUES ('6', '901', '1', '5', '启用', null, '0');
INSERT INTO "TFW_DICT" VALUES ('7', '901', '2', '5', '冻结', null, '0');
INSERT INTO "TFW_DICT" VALUES ('8', '901', '3', '5', '待审核', null, '0');
INSERT INTO "TFW_DICT" VALUES ('9', '901', '4', '5', '审核拒绝', null, '0');
INSERT INTO "TFW_DICT" VALUES ('10', '901', '5', '5', '已删除', null, '0');
INSERT INTO "TFW_DICT" VALUES ('11', '902', '0', '0', '状态', null, '0');
INSERT INTO "TFW_DICT" VALUES ('12', '902', '1', '11', '启用', null, '0');
INSERT INTO "TFW_DICT" VALUES ('13', '902', '2', '11', '禁用', null, '0');
INSERT INTO "TFW_DICT" VALUES ('14', '102', '0', '0', '公告类型', null, '0');
INSERT INTO "TFW_DICT" VALUES ('15', '102', '10', '14', '通知公告', null, '0');
INSERT INTO "TFW_DICT" VALUES ('16', '102', '9', '14', '发布计划', null, '0');
INSERT INTO "TFW_DICT" VALUES ('17', '903', '0', '0', '审核状态', null, '0');
INSERT INTO "TFW_DICT" VALUES ('18', '903', '1', '17', '待审核', null, '0');
INSERT INTO "TFW_DICT" VALUES ('19', '903', '2', '17', '审核拒绝', null, '0');
INSERT INTO "TFW_DICT" VALUES ('20', '903', '3', '17', '审核通过', null, '0');
INSERT INTO "TFW_DICT" VALUES ('41', '102', '6', '16', '测试', null, '0');

-- ----------------------------
-- Table structure for TFW_GENERATE
-- ----------------------------
DROP TABLE "TFW_GENERATE";
CREATE TABLE "TFW_GENERATE" (
"ID" NUMBER(11) NOT NULL ,
"NAME" NVARCHAR2(255) NULL ,
"REALPATH" NVARCHAR2(255) NULL ,
"PACKAGENAME" NVARCHAR2(255) NULL ,
"MODELNAME" NVARCHAR2(255) NULL ,
"TABLENAME" NVARCHAR2(255) NULL ,
"PKNAME" NVARCHAR2(255) NULL ,
"TIPS" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TFW_GENERATE
-- ----------------------------
INSERT INTO "TFW_GENERATE" VALUES ('1', '测试', 'E:\Workspaces\git\bladepro', 'com.tonbusoft.platform', 'Blog', 'tb_yw_blog', 'f_it_xl', null);

-- ----------------------------
-- Table structure for TFW_LOGIN_LOG
-- ----------------------------
DROP TABLE "TFW_LOGIN_LOG";
CREATE TABLE "TFW_LOGIN_LOG" (
"ID" NUMBER NOT NULL ,
"LOGNAME" NVARCHAR2(255) NULL ,
"USERID" NVARCHAR2(255) NULL ,
"CLASSNAME" NVARCHAR2(255) NULL ,
"METHOD" NVARCHAR2(2000) NULL ,
"CREATETIME" DATE NULL ,
"SUCCEED" NVARCHAR2(255) NULL ,
"MESSAGE" NVARCHAR2(2000) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for TFW_MENU
-- ----------------------------
DROP TABLE "TFW_MENU";
CREATE TABLE "TFW_MENU" (
"ID" NUMBER NOT NULL ,
"CODE" NVARCHAR2(255) NULL ,
"PCODE" NVARCHAR2(255) NULL ,
"NAME" NVARCHAR2(255) NULL ,
"ICON" NVARCHAR2(255) NULL ,
"URL" NVARCHAR2(255) NULL ,
"NUM" NUMBER NULL ,
"LEVELS" NUMBER NULL ,
"SOURCE" NVARCHAR2(2000) NULL ,
"PATH" NVARCHAR2(255) NULL ,
"TIPS" NVARCHAR2(255) NULL ,
"STATUS" NUMBER NULL ,
"ISOPEN" VARCHAR2(255 BYTE) NULL ,
"ISTEMPLATE" VARCHAR2(255 BYTE) NULL ,
"VERSION" NUMBER(11) NULL ,
"ALIAS" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TFW_MENU
-- ----------------------------
INSERT INTO "TFW_MENU" VALUES ('91', 'llog_view', 'llog', '查看', 'btn btn-xs btn-white | fa fa-eye bigger-120', '/llog/view', '4', '4', null, 'llog_view.html', null, '1', '0', '0', '0', 'view');
INSERT INTO "TFW_MENU" VALUES ('84', 'olog_add', 'olog', '新增', 'btn btn-xs btn-white | fa fa-floppy-o bigger-120', '/olog/add', '1', '4', null, 'olog_add.html', null, '1', '0', '0', '0', 'add');
INSERT INTO "TFW_MENU" VALUES ('56', 'parameter', 'system', '参数化管理', 'fa-tags', '/parameter/', '9', '2', null, 'parameter.html', null, '1', '0', '1', '0', null);
INSERT INTO "TFW_MENU" VALUES ('57', 'parameter_add', 'parameter', '新增', 'btn btn-xs btn-white | fa fa-floppy-o bigger-120', '/parameter/add', '1', '3', null, 'parameter_add.html', null, '1', '0', '0', '0', 'add');
INSERT INTO "TFW_MENU" VALUES ('58', 'parameter_edit', 'parameter', '修改', 'btn btn-xs btn-white | fa fa-pencil  bigger-120', '/parameter/edit', '2', '3', null, 'parameter_edit.html', null, '1', '0', '0', '0', 'edit');
INSERT INTO "TFW_MENU" VALUES ('59', 'parameter_del', 'parameter', '删除', 'btn btn-xs btn-white | fa fa-times  bigger-120', '/parameter/del', '3', '3', null, null, null, '1', '0', '0', '1', 'remove');
INSERT INTO "TFW_MENU" VALUES ('60', 'parameter_view', 'parameter', '查看', 'btn btn-xs btn-white | fa fa-eye bigger-120', '/parameter/view', '4', '3', null, 'parameter_view.html', null, '1', '0', '0', '0', 'view');
INSERT INTO "TFW_MENU" VALUES ('61', 'parameter_recycle', 'parameter', '回收站', 'btn btn-xs btn-white | fa fa-recycle  bigger-120', '{"status":"5"}', '5', '3', null, 'parameter_recycle.html', null, '1', '0', '0', '0', 'recycle');
INSERT INTO "TFW_MENU" VALUES ('62', 'parameter_recycle_restore', 'parameter_recycle', '还原', 'btn btn-xs btn-white | fa fa-refresh  bigger-120', '/parameter/restore', '1', '4', null, null, null, '1', '0', '0', '0', 'restore');
INSERT INTO "TFW_MENU" VALUES ('63', 'parameter_recycle_remove', 'parameter_recycle', '彻底删除', 'btn btn-xs btn-white  btn-danger | fa fa fa-times bigger-120', '/parameter/remove', '2', '4', null, null, null, '1', '0', '0', '1', 'remove');
INSERT INTO "TFW_MENU" VALUES ('64', 'parameter_recycle_back', 'parameter_recycle', '返回', 'btn btn-xs btn-white | fa fa-undo  bigger-120', null, '3', '4', null, null, null, '1', '0', '0', '0', 'back');
INSERT INTO "TFW_MENU" VALUES ('65', 'druid', 'system', '连接池监视', 'fa-arrows-v', '/druid', '10', '2', null, null, null, '1', '0', null, '1', null);
INSERT INTO "TFW_MENU" VALUES ('1', 'system', '0', '系统管理', 'fa-cog', null, '9', '1', null, null, null, '1', '1', '0', '1', null);
INSERT INTO "TFW_MENU" VALUES ('2', 'role', 'system', '角色管理', 'fa-key', '/role/', '2', '2', null, null, null, '1', '0', null, '1', null);
INSERT INTO "TFW_MENU" VALUES ('3', 'role_add', 'role', '角色新增', 'btn btn-xs btn-white | fa fa-floppy-o bigger-120', '/role/add', '1', '3', null, 'role_add.html', '800*340', '1', '0', null, '1', 'addex');
INSERT INTO "TFW_MENU" VALUES ('98', 'online', 'system', '在线开发', 'fa-rocket', null, '12', '2', null, null, '800*520', '1', '0', null, '1', null);
INSERT INTO "TFW_MENU" VALUES ('99', 'generate', 'online', '代码生成', 'fa-gavel', '/generate/', '1', '3', null, null, '800*520', '1', '0', null, '1', null);
INSERT INTO "TFW_MENU" VALUES ('100', 'generate_add', 'generate', '新增', 'btn btn-xs btn-white | fa fa-floppy-o bigger-120', '/generate/add', '1', '4', null, null, '800*420', '1', '0', null, '3', 'add');
INSERT INTO "TFW_MENU" VALUES ('101', 'generate_edit', 'generate', '修改', 'btn btn-xs btn-white | fa fa-pencil  bigger-120', '/generate/edit', '2', '4', null, null, '800*420', '1', '0', null, '3', 'edit');
INSERT INTO "TFW_MENU" VALUES ('102', 'generate_remove', 'generate', '删除', 'btn btn-xs btn-white | fa fa-times  bigger-120', '/generate/remove', '3', '4', null, null, '800*520', '1', '0', null, null, 'remove');
INSERT INTO "TFW_MENU" VALUES ('103', 'generate_view', 'generate', '查看', 'btn btn-xs btn-white | fa fa-eye bigger-120', '/generate/view', '4', '4', null, null, '800*420', '1', '0', null, '3', 'view');
INSERT INTO "TFW_MENU" VALUES ('104', 'generate_gencode', 'generate', '代码生成', 'btn btn-xs btn-white | fa fa-gavel bigger-120', '/generate/gencode', '5', '4', null, null, '800*520', '1', '0', null, '1', 'gencode');
INSERT INTO "TFW_MENU" VALUES ('4', 'role_edit', 'role', '修改', 'btn btn-xs btn-white | fa fa-pencil  bigger-120', '/role/edit', '2', '3', null, 'role_edit.html', '800*340', '1', '0', '0', '1', 'edit');
INSERT INTO "TFW_MENU" VALUES ('5', 'role_remove', 'role', '删除', 'btn btn-xs btn-white | fa fa-times  bigger-120', '/role/remove', '3', '3', null, null, null, '1', null, null, '0', 'remove');
INSERT INTO "TFW_MENU" VALUES ('6', 'role_view', 'role', '查看', 'btn btn-xs btn-white | fa fa-eye bigger-120', '/role/view', '4', '3', null, 'role_view.html', '800*340', '1', null, null, '1', 'view');
INSERT INTO "TFW_MENU" VALUES ('7', 'role_authority', 'role', '权限配置', 'btn btn-xs btn-white | fa fa-wrench  bigger-120', '/role/authority', '5', '3', null, 'role_authority.html', '350*500', '1', null, null, '0', 'authority');
INSERT INTO "TFW_MENU" VALUES ('8', 'user', 'system', '用户管理', 'fa-user', '/user/', '1', '2', null, null, null, '1', null, null, '0', null);
INSERT INTO "TFW_MENU" VALUES ('9', 'user_add', 'user', '新增', 'btn btn-xs btn-white | fa fa-floppy-o bigger-120', '/user/add', '1', '3', null, 'user_add.html', '800*430', '1', null, null, '0', 'add');
INSERT INTO "TFW_MENU" VALUES ('10', 'user_edit', 'user', '修改', 'btn btn-xs btn-white | fa fa-pencil  bigger-120', '/user/edit', '2', '3', null, 'user_edit.html', '800*430', '1', null, null, '0', 'edit');
INSERT INTO "TFW_MENU" VALUES ('11', 'user_del', 'user', '删除', 'btn btn-xs btn-white | fa fa fa-times bigger-120', '/user/del', '3', '3', null, null, null, '1', null, null, '0', 'remove');
INSERT INTO "TFW_MENU" VALUES ('12', 'user_view', 'user', '查看', 'btn btn-xs btn-white | fa fa-eye bigger-120', '/user/view', '4', '3', null, 'user_view.html', '800*390', '1', null, null, '0', 'view');
INSERT INTO "TFW_MENU" VALUES ('13', 'user_audit', 'user', '审核', 'btn btn-xs btn-white | fa fa-user  bigger-120', '{"status":"3"}', '5', '3', null, null, null, '1', null, null, '0', 'audit');
INSERT INTO "TFW_MENU" VALUES ('14', 'user_audit_ok', 'user_audit', '通过', 'btn btn-xs btn-white | fa fa-check  bigger-120', '/user/auditOk', '1', '4', null, null, null, '1', null, null, '0', 'ok');
INSERT INTO "TFW_MENU" VALUES ('15', 'user_audit_refuse', 'user_audit', '拒绝', 'btn btn-xs btn-white | fa fa-times  bigger-120', '/user/auditRefuse', '2', '4', null, null, null, '1', null, null, '0', 'refuse');
INSERT INTO "TFW_MENU" VALUES ('16', 'user_audit_back', 'user_audit', '返回', 'btn btn-xs btn-white | fa fa-undo  bigger-120', null, '3', '4', null, null, null, '1', null, null, '0', 'back');
INSERT INTO "TFW_MENU" VALUES ('17', 'user_reset', 'user', '重置密码', 'btn btn-xs btn-white | fa fa-key  bigger-120', '/user/reset', '6', '3', null, null, null, '1', null, null, '0', 'reset');
INSERT INTO "TFW_MENU" VALUES ('18', 'user_ban', 'user', '冻结', 'btn btn-xs btn-white | fa fa-ban  bigger-120', '/user/ban', '7', '3', null, null, null, '1', null, null, '0', 'frozen');
INSERT INTO "TFW_MENU" VALUES ('19', 'user_recycle', 'user', '回收站', 'btn btn-xs btn-white | fa fa-recycle  bigger-120', '{"status":"5"}', '8', '3', null, null, null, '1', null, null, '0', 'recycle');
INSERT INTO "TFW_MENU" VALUES ('20', 'user_recycle_restore', 'user_recycle', '还原', 'btn btn-xs btn-white | fa fa-refresh  bigger-120', '/user/restore', '1', '4', null, null, null, '1', null, null, '0', 'restore');
INSERT INTO "TFW_MENU" VALUES ('21', 'user_recycle_remove', 'user_recycle', '彻底删除', 'btn btn-xs btn-white  btn-danger | fa fa fa-times bigger-120', '/user/remove', '2', '4', null, null, null, '1', null, null, '0', 'remove');
INSERT INTO "TFW_MENU" VALUES ('22', 'user_recycle_back', 'user_recycle', '返回', 'btn btn-xs btn-white | fa fa-undo  bigger-120', null, '3', '4', null, null, null, '1', null, null, '0', 'back');
INSERT INTO "TFW_MENU" VALUES ('24', 'user_extrole', 'user', '权限代理', 'btn btn-xs btn-white | fa fa-wrench  bigger-120', '/user/extrole', '10', '3', null, 'user_extrole.html', null, '1', null, null, '0', 'agent');
INSERT INTO "TFW_MENU" VALUES ('25', 'menu', 'system', '菜单管理', 'fa-tasks', '/menu/', '3', '2', null, null, null, '1', null, null, '0', null);
INSERT INTO "TFW_MENU" VALUES ('26', 'menu_add', 'menu', '菜单新增', 'btn btn-xs btn-white | fa fa-floppy-o bigger-120', '/menu/add', '1', '3', null, 'menu_add.html', '800*430', '1', '0', '0', '1', 'addex');
INSERT INTO "TFW_MENU" VALUES ('27', 'menu_edit', 'menu', '修改', 'btn btn-xs btn-white | fa fa-pencil  bigger-120', '/menu/edit', '2', '3', null, 'menu_edit.html', '800*430', '1', '0', '0', '1', 'edit');
INSERT INTO "TFW_MENU" VALUES ('28', 'menu_del', 'menu', '删除', 'btn btn-xs btn-white | fa fa-times  bigger-120', '/menu/del', '3', '3', null, null, null, '1', '0', null, '1', 'remove');
INSERT INTO "TFW_MENU" VALUES ('29', 'menu_view', 'menu', '查看', 'btn btn-xs btn-white | fa fa-eye bigger-120', '/menu/view', '4', '3', null, 'menu_view.html', '800*430', '1', '0', '0', '1', 'view');
INSERT INTO "TFW_MENU" VALUES ('30', 'menu_recycle', 'menu', '回收站', 'btn btn-xs btn-white | fa fa-recycle  bigger-120', '{"status":"2"}', '5', '3', null, null, null, '1', null, null, '0', 'recycle');
INSERT INTO "TFW_MENU" VALUES ('31', 'menu_recycle_restore', 'menu_recycle', '还原', 'btn btn-xs btn-white | fa fa-refresh  bigger-120', '/menu/restore', '1', '4', null, null, null, '1', null, null, '0', 'restore');
INSERT INTO "TFW_MENU" VALUES ('32', 'menu_recycle_remove', 'menu_recycle', '彻底删除', 'btn btn-xs btn-white  btn-danger | fa fa fa-times bigger-120', '/menu/remove', '2', '4', null, null, null, '1', '0', null, '1', 'remove');
INSERT INTO "TFW_MENU" VALUES ('33', 'menu_recycle_back', 'menu_recycle', '返回', 'btn btn-xs btn-white | fa fa-undo  bigger-120', null, '3', '4', null, null, null, '1', null, null, '0', 'back');
INSERT INTO "TFW_MENU" VALUES ('34', 'dict', 'system', '字典管理', 'fa fa-book', '/dict/', '4', '2', null, null, null, '1', null, null, '0', null);
INSERT INTO "TFW_MENU" VALUES ('35', 'dict_add', 'dict', '字典新增', 'btn btn-xs btn-white | fa fa-floppy-o bigger-120', '/dict/add', '1', '3', null, 'dict_add.html', '800*390', '1', null, null, '0', 'addex');
INSERT INTO "TFW_MENU" VALUES ('36', 'dict_edit', 'dict', '修改', 'btn btn-xs btn-white | fa fa-pencil  bigger-120', '/dict/edit', '2', '3', null, 'dict_edit.html', '800*390', '1', null, null, '0', 'edit');
INSERT INTO "TFW_MENU" VALUES ('37', 'dict_remove', 'dict', '删除', 'btn btn-xs btn-white | fa fa-times  bigger-120', '/dict/remove', '3', '3', null, null, null, '1', null, null, '0', 'remove');
INSERT INTO "TFW_MENU" VALUES ('38', 'dict_view', 'dict', '查看', 'btn btn-xs btn-white | fa fa-eye bigger-120', '/dict/view', '4', '3', null, 'dict_view.html', '800*390', '1', null, null, '0', 'view');
INSERT INTO "TFW_MENU" VALUES ('39', 'dept', 'system', '部门管理', 'fa fa-users', '/dept/', '5', '2', null, null, null, '1', null, null, '0', null);
INSERT INTO "TFW_MENU" VALUES ('40', 'dept_add', 'dept', '部门新增', 'btn btn-xs btn-white | fa fa-floppy-o bigger-120', '/dept/add', '1', '3', null, 'dept_add.html', '800*340', '1', null, null, '0', 'addex');
INSERT INTO "TFW_MENU" VALUES ('41', 'dept_edit', 'dept', '修改', 'btn btn-xs btn-white | fa fa-pencil  bigger-120', '/dept/edit', '2', '3', null, 'dept_edit.html', '800*340', '1', null, null, '0', 'edit');
INSERT INTO "TFW_MENU" VALUES ('42', 'dept_remove', 'dept', '删除', 'btn btn-xs btn-white | fa fa-times  bigger-120', '/dept/remove', '3', '3', null, null, null, '1', null, null, '0', 'remove');
INSERT INTO "TFW_MENU" VALUES ('43', 'dept_view', 'dept', '查看', 'btn btn-xs btn-white | fa fa-eye bigger-120', '/dept/view', '4', '3', null, 'dept_view.html', '800*340', '1', '0', '0', '0', 'view');
INSERT INTO "TFW_MENU" VALUES ('44', 'attach', 'system', '附件管理', 'fa fa-paperclip', '/attach/', '6', '2', null, 'attach.html', null, '1', '0', '0', '0', null);
INSERT INTO "TFW_MENU" VALUES ('45', 'attach_add', 'attach', '新增', 'btn btn-xs btn-white | fa fa-floppy-o bigger-120', '/attach/add', '1', '3', null, 'attach_add.html', '800*450', '1', '0', '0', '0', 'add');
INSERT INTO "TFW_MENU" VALUES ('46', 'attach_edit', 'attach', '修改', 'btn btn-xs btn-white | fa fa-pencil  bigger-120', '/attach/edit', '2', '3', null, 'attach_edit.html', '800*290', '1', '0', null, '0', 'edit');
INSERT INTO "TFW_MENU" VALUES ('47', 'attach_remove', 'attach', '删除', 'btn btn-xs btn-white | fa fa-times  bigger-120', '/attach/remove', '3', '3', null, null, null, '1', null, null, '0', 'remove');
INSERT INTO "TFW_MENU" VALUES ('48', 'attach_view', 'attach', '查看', 'btn btn-xs btn-white | fa fa-eye bigger-120', '/attach/view', '4', '3', null, 'attach_view.html', '800*450', '1', '0', '0', '1', 'view');
INSERT INTO "TFW_MENU" VALUES ('49', 'attach_download', 'attach', '下载', 'btn btn-xs btn-white | fa fa-paperclip bigger-120', '/attach/download', '5', '3', null, null, null, '1', null, null, '0', 'download');
INSERT INTO "TFW_MENU" VALUES ('92', 'office', '0', '工作台', 'fa fa-desktop', null, '1', '1', null, null, null, '1', null, null, '1', null);
INSERT INTO "TFW_MENU" VALUES ('93', 'notice', 'office', '通知公告', 'fa fa-bell', '/notice/', '1', '2', null, 'notice.html', null, '1', '0', '1', '0', null);
INSERT INTO "TFW_MENU" VALUES ('94', 'notice_add', 'notice', '新增', 'btn btn-xs btn-white | fa fa-floppy-o bigger-120', '/notice/add', '1', '3', null, 'notice_add.html', '800*500', '1', '0', '0', '0', 'add');
INSERT INTO "TFW_MENU" VALUES ('95', 'notice_edit', 'notice', '修改', 'btn btn-xs btn-white | fa fa-pencil  bigger-120', '/notice/edit', '2', '3', null, 'notice_edit.html', '800*500', '1', '0', '0', '1', 'edit');
INSERT INTO "TFW_MENU" VALUES ('96', 'notice_remove', 'notice', '删除', 'btn btn-xs btn-white | fa fa-times  bigger-120', '/notice/remove', '3', '3', null, null, null, '1', '0', '0', '0', 'remove');
INSERT INTO "TFW_MENU" VALUES ('97', 'notice_view', 'notice', '查看', 'btn btn-xs btn-white | fa fa-eye bigger-120', '/notice/view', '4', '3', null, null, '800*500', '1', '0', '0', '0', 'view');
INSERT INTO "TFW_MENU" VALUES ('23', 'user_roleAssign', 'user', '角色分配', 'btn btn-xs btn-white | fa fa-users bigger-120', '/user/roleAssign', '9', '3', null, 'user_roleAssign.html', '350*500', '1', null, null, '0', 'assign');
INSERT INTO "TFW_MENU" VALUES ('81', 'log', 'system', '日志管理', 'fa-tasks', null, '11', '2', null, null, null, '1', '0', '0', '1', null);
INSERT INTO "TFW_MENU" VALUES ('82', 'olog', 'log', '操作日志', 'fa-database', '/olog/', '1', '3', null, 'olog.html', null, '1', '0', '0', '0', null);
INSERT INTO "TFW_MENU" VALUES ('83', 'llog', 'log', '登录日志', 'fa-sign-in', '/llog/', '2', '3', null, 'llog.html', null, '1', '0', '1', '0', null);
INSERT INTO "TFW_MENU" VALUES ('85', 'olog_edit', 'olog', '修改', 'btn btn-xs btn-white | fa fa-pencil  bigger-120', '/olog/edit', '2', '4', null, 'olog_edit.html', null, '1', '0', '0', '0', 'edit');
INSERT INTO "TFW_MENU" VALUES ('86', 'olog_remove', 'olog', '删除', 'btn btn-xs btn-white | fa fa-times  bigger-120', '/olog/remove', '3', '4', null, null, null, '1', '0', '0', '0', 'remove');
INSERT INTO "TFW_MENU" VALUES ('87', 'olog_view', 'olog', '查看', 'btn btn-xs btn-white | fa fa-eye bigger-120', '/olog/view', '4', '4', null, 'olog_view.html', null, '1', '0', '0', '0', 'view');
INSERT INTO "TFW_MENU" VALUES ('88', 'llog_add', 'llog', '新增', 'btn btn-xs btn-white | fa fa-floppy-o bigger-120', '/llog/add', '1', '4', null, 'llog_add.html', null, '1', '0', '0', '0', 'add');
INSERT INTO "TFW_MENU" VALUES ('89', 'llog_edit', 'llog', '修改', 'btn btn-xs btn-white | fa fa-pencil  bigger-120', '/llog/edit', '2', '4', null, 'llog_edit.html', null, '1', '0', '0', '0', 'edit');
INSERT INTO "TFW_MENU" VALUES ('90', 'llog_remove', 'llog', '删除', 'btn btn-xs btn-white | fa fa-times  bigger-120', '/llog/remove', '3', '4', null, null, null, '1', '0', '0', '0', 'remove');

-- ----------------------------
-- Table structure for TFW_METADATA
-- ----------------------------
DROP TABLE "TFW_METADATA";
CREATE TABLE "TFW_METADATA" (
"ID" NUMBER NOT NULL ,
"CODE" NVARCHAR2(2000) NULL ,
"SEQ" NVARCHAR2(2000) NULL ,
"KEYSJSON" NVARCHAR2(2000) NULL ,
"COLNAMES" NVARCHAR2(2000) NULL ,
"COLMODEL" NVARCHAR2(2000) NULL ,
"SEARCHJSON" NVARCHAR2(2000) NULL ,
"ADDJSON" NVARCHAR2(2000) NULL ,
"EDITJSON" NVARCHAR2(2000) NULL ,
"VIEWJSON" NVARCHAR2(2000) NULL ,
"SORTSTR" NVARCHAR2(2000) NULL ,
"ORDERSTR" NVARCHAR2(2000) NULL ,
"STATUS" NUMBER NULL ,
"ISFIT" NUMBER NULL ,
"LISTMETHOD" NVARCHAR2(2000) NULL ,
"SAVEMETHOD" NVARCHAR2(2000) NULL ,
"UPDATEMETHOD" NVARCHAR2(2000) NULL ,
"FILTERSTR" NVARCHAR2(2000) NULL ,
"CREATETIME" DATE NULL ,
"CREATER" VARCHAR2(255 BYTE) NULL ,
"EDITTIME" DATE NULL ,
"EDITER" VARCHAR2(255 BYTE) NULL ,
"VERSION" NUMBER(11) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TFW_METADATA
-- ----------------------------
INSERT INTO "TFW_METADATA" VALUES ('21', 'report', null, '[{table:"TB_TMSP_GZBG",key:"F_IT_XL",seq:"SEQ_REPORT.nextval"}, {table:"TB_TMSP_GZBGNR",key:"F_IT_XL",foreignKey:"F_IT_BGXL",foreignPrimaryKey:"TB_TMSP_GZBG.F_IT_XL",seq:"SEQ_REPORTCONTENT.nextval"}]', '["序列","报告标题", "报告部门","报告时间","创建时间","创建人","修改时间","修改人"]', '[{name:"F_IT_XL",index:"F_IT_XL", width:35,hidden:true},
{name:"F_VC_BT",index:"F_VC_BT", width:100},
{name:"DIC_F_IT_BGBM",index:"F_IT_BGBM", width:80},
{name:"F_DT_BGSJ",index:"F_DT_BGSJ", width:80},
{name:"F_DT_CJSJ",index:"F_DT_CJSJ", width:80},
{name:"DIC_F_IT_CJR",index:"F_IT_CJR", width:80},
{name:"F_DT_XGSJ",index:"F_DT_XGSJ", width:80},
{name:"DIC_F_IT_XGR",index:"F_IT_XGR", width:80}]', '[{name:"报告标题",index:"F_VC_BT", type:"text"},
{name:"报告部门",index:"F_IT_BGBM",type:"selectDept"},
{name:"报告时间",index:"F_DT_BGSJ", type:"text"} ]', '[{table:"TB_TMSP_GZBG",name:"报告标题",index:"F_VC_BT",type:"text",newline:true,length:8,required:"required"},
{table:"TB_TMSP_GZBG",name:"报告部门",index:"F_IT_BGBM", type:"selectDept",newline:true,length:3,required:"required"},
{table:"TB_TMSP_GZBG",name:"报告时间",index:"F_DT_BGSJ", type:"laydate",format:"YYYY-MM-DD hh:mm:ss",newline:false,length:3,required:"required"},
 {table:"TB_TMSP_GZBGNR",name:"报告内容",index:"F_TX_BGNR", type:"kindeditor",newline:true,length:8,required:"required"},
{table:"TB_TMSP_GZBG",name:"创建人",index:"F_IT_CJR", type:"hidden",newline:true,value:session.user.ID,length:8},
 {table:"TB_TMSP_GZBG",name:"创建时间",index:"F_DT_CJSJ", type:"hidden",newline:true,value:c.newdate(),length:8} ]', '[ {table:"TB_TMSP_GZBG",name:"报告标题",index:"F_VC_BT",type:"text",newline:true,length:8,required:"required"},
{table:"TB_TMSP_GZBG",name:"报告部门",index:"F_IT_BGBM", type:"selectDept",newline:true,length:3,required:"required"},
{table:"TB_TMSP_GZBG",name:"报告时间",index:"F_DT_BGSJ", type:"laydate",format:"YYYY-MM-DD hh:mm:ss",newline:false,length:3,required:"required"},
{table:"TB_TMSP_GZBGNR",name:"报告内容",index:"F_TX_BGNR", type:"kindeditor",newline:true,length:8,required:"required"},
{table:"TB_TMSP_GZBG",name:"修改人",index:"F_IT_XGR", type:"autohidden",newline:true,value:session.user.ID,length:8},
{table:"TB_TMSP_GZBG",name:"修改时间",index:"F_DT_XGSJ", type:"autohidden",newline:true,value:c.newdate(),length:8}]', '[ {table:"TB_TMSP_GZBG",name:"报告标题",index:"F_VC_BT",type:"text",newline:true,length:8,required:"required"},
 {table:"TB_TMSP_GZBG",name:"报告部门",index:"DIC_F_IT_BGBM", type:"selectDept",newline:true,length:3,required:"required"},
 {table:"TB_TMSP_GZBG",name:"报告时间",index:"F_DT_BGSJ", type:"laydate",newline:false,length:3,required:"required"},
{table:"TB_TMSP_GZBGNR",name:"报告内容",index:"F_TX_BGNR", type:"kindeditor",newline:true,length:8,required:"required"}]', 'f_it_xl', 'desc', '1', '0', '/template/list', '/template/save', '/template/update', null, TO_DATE('2015-11-02 14:25:29', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2015-11-02 14:25:29', 'YYYY-MM-DD HH24:MI:SS'), '1', '2');
INSERT INTO "TFW_METADATA" VALUES ('1', 'notice', null, '[{table:"TB_TMSP_TZGG",key:"F_IT_XL",seq:"SEQ_NOTICE.nextval"}]', '[ "序列","通知标题", "公告类型","发布时间"]', '[{name:"F_IT_XL",index:"F_IT_XL", width:35,hidden:true},
 {name:"F_VC_BT",index:"F_VC_BT", width:100},
 {name:"DIC_F_IT_LX",index:"DIC_F_IT_LX", width:80},
 {name:"F_DT_FBSJ",index:"F_DT_FBSJ", width:80}]', '[{name:"通知标题",index:"F_VC_BT", type:"text"},
 {name:"公告类型",index:"F_IT_LX",type:"select_102"},
 {name:"发布时间",index:"F_DT_FBSJ", type:"text"}]', '[ {table:"TB_TMSP_TZGG",name:"通知标题",index:"F_VC_BT",type:"text",newline:true,length:8,required:"required"},
 {table:"TB_TMSP_TZGG",name:"公告类型",index:"F_IT_LX", type:"select_102",newline:true,length:3,required:"required"},
 {table:"TB_TMSP_TZGG",name:"通知时间",index:"F_DT_FBSJ", type:"laydate",format:"YYYY-MM-DD hh:mm:ss",newline:false,length:3},
 {table:"TB_TMSP_TZGG",name:"通知内容",index:"F_TX_NR", type:"kindeditor",newline:true,length:8,required:"required"} ]', '[{table:"TB_TMSP_TZGG",name:"通知标题",index:"F_VC_BT",type:"text",newline:true,length:8,required:"required"},
 {table:"TB_TMSP_TZGG",name:"公告类型",index:"F_IT_LX", type:"combo_102",newline:true,length:3,required:"required"}, 
 {table:"TB_TMSP_TZGG",name:"通知时间",index:"F_DT_FBSJ", type:"laydate",format:"YYYY-MM-DD hh:mm:ss",newline:false,length:3},
 {table:"TB_TMSP_TZGG",name:"通知内容",index:"F_TX_NR", type:"kindeditor",newline:true,length:8,required:"required"}]', '[{table:"TB_TMSP_TZGG",name:"通知标题",index:"F_VC_BT",type:"text",newline:true,length:8,required:"required"},
 {table:"TB_TMSP_TZGG",name:"公告类型",index:"DIC_F_IT_LX", type:"select_102",newline:true,length:3,required:"required"},
 {table:"TB_TMSP_TZGG",name:"通知时间",index:"F_DT_FBSJ", type:"date",newline:false,length:3,required:"required"},
 {table:"TB_TMSP_TZGG",name:"通知内容",index:"F_TX_NR", type:"kindeditor",newline:true,length:8,required:"required"}]', 'f_it_xl', 'desc', '1', '1', '/template/list', '/template/save', '/template/update', '{"f_it_cjr":"session.user.ID"}', TO_DATE('2015-11-02 14:25:29', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2015-11-02 14:25:29', 'YYYY-MM-DD HH24:MI:SS'), '1', '0');

-- ----------------------------
-- Table structure for TFW_OPERATION_LOG
-- ----------------------------
DROP TABLE "TFW_OPERATION_LOG";
CREATE TABLE "TFW_OPERATION_LOG" (
"ID" NUMBER NOT NULL ,
"LOGNAME" NVARCHAR2(255) NULL ,
"USERID" NVARCHAR2(255) NULL ,
"CLASSNAME" NVARCHAR2(255) NULL ,
"METHOD" NVARCHAR2(2000) NULL ,
"CREATETIME" DATE NULL ,
"SUCCEED" NVARCHAR2(255) NULL ,
"MESSAGE" NVARCHAR2(2000) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;


-- ----------------------------
-- Table structure for TFW_PARAMETER
-- ----------------------------
DROP TABLE "TFW_PARAMETER";
CREATE TABLE "TFW_PARAMETER" (
"ID" NUMBER(11) NOT NULL ,
"CODE" NVARCHAR2(255) NULL ,
"NUM" NUMBER(11) NULL ,
"NAME" NVARCHAR2(255) NULL ,
"PARA" NVARCHAR2(2000) NULL ,
"TIPS" NVARCHAR2(255) NULL ,
"STATUS" NUMBER(11) NULL ,
"VERSION" NUMBER(11) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TFW_PARAMETER
-- ----------------------------
INSERT INTO "TFW_PARAMETER" VALUES ('1', '101', '100', '是否开启记录日志', '2', '1:是  2:否', '1', '7');

-- ----------------------------
-- Table structure for TFW_RELATION
-- ----------------------------
DROP TABLE "TFW_RELATION";
CREATE TABLE "TFW_RELATION" (
"ID" NUMBER(11) NOT NULL ,
"MENUID" NUMBER(11) NULL ,
"ROLEID" NUMBER(11) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TFW_RELATION
-- ----------------------------
INSERT INTO "TFW_RELATION" VALUES ('1544', '92', '1');
INSERT INTO "TFW_RELATION" VALUES ('1545', '93', '1');
INSERT INTO "TFW_RELATION" VALUES ('1546', '94', '1');
INSERT INTO "TFW_RELATION" VALUES ('1547', '95', '1');
INSERT INTO "TFW_RELATION" VALUES ('1548', '96', '1');
INSERT INTO "TFW_RELATION" VALUES ('1549', '97', '1');
INSERT INTO "TFW_RELATION" VALUES ('1550', '109', '1');
INSERT INTO "TFW_RELATION" VALUES ('1551', '110', '1');
INSERT INTO "TFW_RELATION" VALUES ('1552', '111', '1');
INSERT INTO "TFW_RELATION" VALUES ('1553', '112', '1');
INSERT INTO "TFW_RELATION" VALUES ('1554', '113', '1');
INSERT INTO "TFW_RELATION" VALUES ('1555', '98', '1');
INSERT INTO "TFW_RELATION" VALUES ('1556', '99', '1');
INSERT INTO "TFW_RELATION" VALUES ('1557', '100', '1');
INSERT INTO "TFW_RELATION" VALUES ('1558', '101', '1');
INSERT INTO "TFW_RELATION" VALUES ('1559', '102', '1');
INSERT INTO "TFW_RELATION" VALUES ('1560', '103', '1');
INSERT INTO "TFW_RELATION" VALUES ('1561', '104', '1');
INSERT INTO "TFW_RELATION" VALUES ('1562', '105', '1');
INSERT INTO "TFW_RELATION" VALUES ('1563', '106', '1');
INSERT INTO "TFW_RELATION" VALUES ('1564', '107', '1');
INSERT INTO "TFW_RELATION" VALUES ('1565', '225', '1');
INSERT INTO "TFW_RELATION" VALUES ('1566', '1', '1');
INSERT INTO "TFW_RELATION" VALUES ('1567', '8', '1');
INSERT INTO "TFW_RELATION" VALUES ('1568', '9', '1');
INSERT INTO "TFW_RELATION" VALUES ('1569', '10', '1');
INSERT INTO "TFW_RELATION" VALUES ('1570', '11', '1');
INSERT INTO "TFW_RELATION" VALUES ('1571', '12', '1');
INSERT INTO "TFW_RELATION" VALUES ('1572', '13', '1');
INSERT INTO "TFW_RELATION" VALUES ('1573', '14', '1');
INSERT INTO "TFW_RELATION" VALUES ('1574', '15', '1');
INSERT INTO "TFW_RELATION" VALUES ('1575', '16', '1');
INSERT INTO "TFW_RELATION" VALUES ('1576', '17', '1');
INSERT INTO "TFW_RELATION" VALUES ('1577', '18', '1');
INSERT INTO "TFW_RELATION" VALUES ('1578', '19', '1');
INSERT INTO "TFW_RELATION" VALUES ('1579', '20', '1');
INSERT INTO "TFW_RELATION" VALUES ('1580', '21', '1');
INSERT INTO "TFW_RELATION" VALUES ('1581', '22', '1');
INSERT INTO "TFW_RELATION" VALUES ('1582', '23', '1');
INSERT INTO "TFW_RELATION" VALUES ('1583', '24', '1');
INSERT INTO "TFW_RELATION" VALUES ('1584', '2', '1');
INSERT INTO "TFW_RELATION" VALUES ('1585', '3', '1');
INSERT INTO "TFW_RELATION" VALUES ('1586', '4', '1');
INSERT INTO "TFW_RELATION" VALUES ('1587', '5', '1');
INSERT INTO "TFW_RELATION" VALUES ('1588', '6', '1');
INSERT INTO "TFW_RELATION" VALUES ('1589', '7', '1');
INSERT INTO "TFW_RELATION" VALUES ('1590', '25', '1');
INSERT INTO "TFW_RELATION" VALUES ('1591', '26', '1');
INSERT INTO "TFW_RELATION" VALUES ('1592', '27', '1');
INSERT INTO "TFW_RELATION" VALUES ('1593', '28', '1');
INSERT INTO "TFW_RELATION" VALUES ('1594', '29', '1');
INSERT INTO "TFW_RELATION" VALUES ('1595', '30', '1');
INSERT INTO "TFW_RELATION" VALUES ('1596', '31', '1');
INSERT INTO "TFW_RELATION" VALUES ('1597', '32', '1');
INSERT INTO "TFW_RELATION" VALUES ('1598', '33', '1');
INSERT INTO "TFW_RELATION" VALUES ('1599', '34', '1');
INSERT INTO "TFW_RELATION" VALUES ('1600', '35', '1');
INSERT INTO "TFW_RELATION" VALUES ('1601', '36', '1');
INSERT INTO "TFW_RELATION" VALUES ('1602', '37', '1');
INSERT INTO "TFW_RELATION" VALUES ('1603', '38', '1');
INSERT INTO "TFW_RELATION" VALUES ('1604', '39', '1');
INSERT INTO "TFW_RELATION" VALUES ('1605', '40', '1');
INSERT INTO "TFW_RELATION" VALUES ('1606', '41', '1');
INSERT INTO "TFW_RELATION" VALUES ('1607', '42', '1');
INSERT INTO "TFW_RELATION" VALUES ('1608', '43', '1');
INSERT INTO "TFW_RELATION" VALUES ('1609', '44', '1');
INSERT INTO "TFW_RELATION" VALUES ('1610', '45', '1');
INSERT INTO "TFW_RELATION" VALUES ('1611', '46', '1');
INSERT INTO "TFW_RELATION" VALUES ('1612', '47', '1');
INSERT INTO "TFW_RELATION" VALUES ('1613', '48', '1');
INSERT INTO "TFW_RELATION" VALUES ('1614', '49', '1');
INSERT INTO "TFW_RELATION" VALUES ('1615', '50', '1');
INSERT INTO "TFW_RELATION" VALUES ('1616', '51', '1');
INSERT INTO "TFW_RELATION" VALUES ('1617', '52', '1');
INSERT INTO "TFW_RELATION" VALUES ('1618', '53', '1');
INSERT INTO "TFW_RELATION" VALUES ('1619', '54', '1');
INSERT INTO "TFW_RELATION" VALUES ('1620', '55', '1');
INSERT INTO "TFW_RELATION" VALUES ('1621', '56', '1');
INSERT INTO "TFW_RELATION" VALUES ('1622', '57', '1');
INSERT INTO "TFW_RELATION" VALUES ('1623', '58', '1');
INSERT INTO "TFW_RELATION" VALUES ('1624', '59', '1');
INSERT INTO "TFW_RELATION" VALUES ('1625', '60', '1');
INSERT INTO "TFW_RELATION" VALUES ('1626', '61', '1');
INSERT INTO "TFW_RELATION" VALUES ('1627', '62', '1');
INSERT INTO "TFW_RELATION" VALUES ('1628', '63', '1');
INSERT INTO "TFW_RELATION" VALUES ('1629', '64', '1');
INSERT INTO "TFW_RELATION" VALUES ('1630', '65', '1');
INSERT INTO "TFW_RELATION" VALUES ('1631', '81', '1');
INSERT INTO "TFW_RELATION" VALUES ('1632', '82', '1');
INSERT INTO "TFW_RELATION" VALUES ('1633', '84', '1');
INSERT INTO "TFW_RELATION" VALUES ('1634', '85', '1');
INSERT INTO "TFW_RELATION" VALUES ('1635', '86', '1');
INSERT INTO "TFW_RELATION" VALUES ('1636', '87', '1');
INSERT INTO "TFW_RELATION" VALUES ('1637', '83', '1');
INSERT INTO "TFW_RELATION" VALUES ('1638', '88', '1');
INSERT INTO "TFW_RELATION" VALUES ('1639', '89', '1');
INSERT INTO "TFW_RELATION" VALUES ('1640', '90', '1');
INSERT INTO "TFW_RELATION" VALUES ('1641', '91', '1');
INSERT INTO "TFW_RELATION" VALUES ('1657', '81', '4');
INSERT INTO "TFW_RELATION" VALUES ('1658', '82', '4');
INSERT INTO "TFW_RELATION" VALUES ('1659', '84', '4');
INSERT INTO "TFW_RELATION" VALUES ('1660', '85', '4');
INSERT INTO "TFW_RELATION" VALUES ('1661', '86', '4');
INSERT INTO "TFW_RELATION" VALUES ('1662', '87', '4');
INSERT INTO "TFW_RELATION" VALUES ('1663', '83', '4');
INSERT INTO "TFW_RELATION" VALUES ('1664', '88', '4');
INSERT INTO "TFW_RELATION" VALUES ('1665', '89', '4');
INSERT INTO "TFW_RELATION" VALUES ('1666', '90', '4');
INSERT INTO "TFW_RELATION" VALUES ('1667', '91', '4');
INSERT INTO "TFW_RELATION" VALUES ('1668', '81', '5');
INSERT INTO "TFW_RELATION" VALUES ('1669', '82', '5');
INSERT INTO "TFW_RELATION" VALUES ('1670', '84', '5');
INSERT INTO "TFW_RELATION" VALUES ('1671', '85', '5');
INSERT INTO "TFW_RELATION" VALUES ('1672', '86', '5');
INSERT INTO "TFW_RELATION" VALUES ('1673', '87', '5');
INSERT INTO "TFW_RELATION" VALUES ('821', '73', '2');
INSERT INTO "TFW_RELATION" VALUES ('822', '74', '2');
INSERT INTO "TFW_RELATION" VALUES ('823', '75', '2');
INSERT INTO "TFW_RELATION" VALUES ('824', '76', '2');
INSERT INTO "TFW_RELATION" VALUES ('825', '77', '2');
INSERT INTO "TFW_RELATION" VALUES ('826', '78', '2');
INSERT INTO "TFW_RELATION" VALUES ('827', '79', '2');
INSERT INTO "TFW_RELATION" VALUES ('828', '80', '2');
INSERT INTO "TFW_RELATION" VALUES ('829', '81', '2');
INSERT INTO "TFW_RELATION" VALUES ('830', '82', '2');
INSERT INTO "TFW_RELATION" VALUES ('831', '83', '2');
INSERT INTO "TFW_RELATION" VALUES ('832', '84', '2');
INSERT INTO "TFW_RELATION" VALUES ('833', '85', '2');
INSERT INTO "TFW_RELATION" VALUES ('834', '86', '2');
INSERT INTO "TFW_RELATION" VALUES ('835', '87', '2');
INSERT INTO "TFW_RELATION" VALUES ('836', '88', '2');
INSERT INTO "TFW_RELATION" VALUES ('837', '89', '2');
INSERT INTO "TFW_RELATION" VALUES ('838', '90', '2');
INSERT INTO "TFW_RELATION" VALUES ('839', '91', '2');
INSERT INTO "TFW_RELATION" VALUES ('840', '92', '2');
INSERT INTO "TFW_RELATION" VALUES ('841', '93', '2');
INSERT INTO "TFW_RELATION" VALUES ('842', '94', '2');
INSERT INTO "TFW_RELATION" VALUES ('843', '95', '2');
INSERT INTO "TFW_RELATION" VALUES ('844', '96', '2');
INSERT INTO "TFW_RELATION" VALUES ('845', '97', '2');
INSERT INTO "TFW_RELATION" VALUES ('846', '98', '2');
INSERT INTO "TFW_RELATION" VALUES ('847', '99', '2');
INSERT INTO "TFW_RELATION" VALUES ('848', '100', '2');
INSERT INTO "TFW_RELATION" VALUES ('849', '101', '2');
INSERT INTO "TFW_RELATION" VALUES ('850', '102', '2');
INSERT INTO "TFW_RELATION" VALUES ('851', '1', '2');
INSERT INTO "TFW_RELATION" VALUES ('852', '8', '2');
INSERT INTO "TFW_RELATION" VALUES ('853', '9', '2');
INSERT INTO "TFW_RELATION" VALUES ('854', '10', '2');
INSERT INTO "TFW_RELATION" VALUES ('855', '11', '2');
INSERT INTO "TFW_RELATION" VALUES ('856', '12', '2');
INSERT INTO "TFW_RELATION" VALUES ('857', '13', '2');
INSERT INTO "TFW_RELATION" VALUES ('858', '14', '2');
INSERT INTO "TFW_RELATION" VALUES ('859', '15', '2');
INSERT INTO "TFW_RELATION" VALUES ('860', '16', '2');
INSERT INTO "TFW_RELATION" VALUES ('861', '17', '2');
INSERT INTO "TFW_RELATION" VALUES ('862', '18', '2');
INSERT INTO "TFW_RELATION" VALUES ('863', '19', '2');
INSERT INTO "TFW_RELATION" VALUES ('864', '20', '2');
INSERT INTO "TFW_RELATION" VALUES ('865', '21', '2');
INSERT INTO "TFW_RELATION" VALUES ('866', '22', '2');
INSERT INTO "TFW_RELATION" VALUES ('867', '23', '2');
INSERT INTO "TFW_RELATION" VALUES ('868', '24', '2');
INSERT INTO "TFW_RELATION" VALUES ('869', '2', '2');
INSERT INTO "TFW_RELATION" VALUES ('870', '3', '2');
INSERT INTO "TFW_RELATION" VALUES ('871', '4', '2');
INSERT INTO "TFW_RELATION" VALUES ('872', '5', '2');
INSERT INTO "TFW_RELATION" VALUES ('873', '6', '2');
INSERT INTO "TFW_RELATION" VALUES ('874', '7', '2');
INSERT INTO "TFW_RELATION" VALUES ('875', '25', '2');
INSERT INTO "TFW_RELATION" VALUES ('876', '26', '2');
INSERT INTO "TFW_RELATION" VALUES ('877', '27', '2');
INSERT INTO "TFW_RELATION" VALUES ('878', '28', '2');
INSERT INTO "TFW_RELATION" VALUES ('879', '29', '2');
INSERT INTO "TFW_RELATION" VALUES ('880', '30', '2');
INSERT INTO "TFW_RELATION" VALUES ('881', '31', '2');
INSERT INTO "TFW_RELATION" VALUES ('882', '32', '2');
INSERT INTO "TFW_RELATION" VALUES ('883', '33', '2');
INSERT INTO "TFW_RELATION" VALUES ('884', '34', '2');
INSERT INTO "TFW_RELATION" VALUES ('885', '35', '2');
INSERT INTO "TFW_RELATION" VALUES ('886', '36', '2');
INSERT INTO "TFW_RELATION" VALUES ('887', '37', '2');
INSERT INTO "TFW_RELATION" VALUES ('888', '38', '2');
INSERT INTO "TFW_RELATION" VALUES ('889', '39', '2');
INSERT INTO "TFW_RELATION" VALUES ('890', '40', '2');
INSERT INTO "TFW_RELATION" VALUES ('891', '41', '2');
INSERT INTO "TFW_RELATION" VALUES ('892', '42', '2');
INSERT INTO "TFW_RELATION" VALUES ('893', '43', '2');
INSERT INTO "TFW_RELATION" VALUES ('894', '44', '2');
INSERT INTO "TFW_RELATION" VALUES ('895', '45', '2');
INSERT INTO "TFW_RELATION" VALUES ('896', '46', '2');
INSERT INTO "TFW_RELATION" VALUES ('897', '47', '2');
INSERT INTO "TFW_RELATION" VALUES ('898', '48', '2');
INSERT INTO "TFW_RELATION" VALUES ('899', '49', '2');
INSERT INTO "TFW_RELATION" VALUES ('1244', '1', '3');
INSERT INTO "TFW_RELATION" VALUES ('1245', '62', '3');
INSERT INTO "TFW_RELATION" VALUES ('1246', '64', '3');
INSERT INTO "TFW_RELATION" VALUES ('1247', '72', '3');
INSERT INTO "TFW_RELATION" VALUES ('1248', '73', '3');
INSERT INTO "TFW_RELATION" VALUES ('1249', '74', '3');
INSERT INTO "TFW_RELATION" VALUES ('1250', '75', '3');
INSERT INTO "TFW_RELATION" VALUES ('1251', '76', '3');
INSERT INTO "TFW_RELATION" VALUES ('1252', '77', '3');
INSERT INTO "TFW_RELATION" VALUES ('1253', '78', '3');
INSERT INTO "TFW_RELATION" VALUES ('1254', '79', '3');
INSERT INTO "TFW_RELATION" VALUES ('1255', '80', '3');
INSERT INTO "TFW_RELATION" VALUES ('1384', '72', '6');
INSERT INTO "TFW_RELATION" VALUES ('1385', '73', '6');
INSERT INTO "TFW_RELATION" VALUES ('1386', '74', '6');
INSERT INTO "TFW_RELATION" VALUES ('1387', '75', '6');
INSERT INTO "TFW_RELATION" VALUES ('1388', '76', '6');
INSERT INTO "TFW_RELATION" VALUES ('1389', '77', '6');
INSERT INTO "TFW_RELATION" VALUES ('1390', '78', '6');
INSERT INTO "TFW_RELATION" VALUES ('1391', '79', '6');
INSERT INTO "TFW_RELATION" VALUES ('1392', '80', '6');
INSERT INTO "TFW_RELATION" VALUES ('1393', '81', '6');
INSERT INTO "TFW_RELATION" VALUES ('1394', '82', '6');
INSERT INTO "TFW_RELATION" VALUES ('1395', '84', '6');
INSERT INTO "TFW_RELATION" VALUES ('1396', '85', '6');
INSERT INTO "TFW_RELATION" VALUES ('1397', '86', '6');
INSERT INTO "TFW_RELATION" VALUES ('1398', '87', '6');
INSERT INTO "TFW_RELATION" VALUES ('1399', '83', '6');
INSERT INTO "TFW_RELATION" VALUES ('1400', '88', '6');
INSERT INTO "TFW_RELATION" VALUES ('1401', '89', '6');
INSERT INTO "TFW_RELATION" VALUES ('1402', '90', '6');
INSERT INTO "TFW_RELATION" VALUES ('1403', '91', '6');
INSERT INTO "TFW_RELATION" VALUES ('1524', '1', '25');
INSERT INTO "TFW_RELATION" VALUES ('1525', '62', '25');
INSERT INTO "TFW_RELATION" VALUES ('1526', '64', '25');
INSERT INTO "TFW_RELATION" VALUES ('1527', '72', '25');
INSERT INTO "TFW_RELATION" VALUES ('1528', '73', '25');
INSERT INTO "TFW_RELATION" VALUES ('1529', '74', '25');
INSERT INTO "TFW_RELATION" VALUES ('1530', '75', '25');
INSERT INTO "TFW_RELATION" VALUES ('1531', '76', '25');
INSERT INTO "TFW_RELATION" VALUES ('1532', '77', '25');
INSERT INTO "TFW_RELATION" VALUES ('1533', '78', '25');
INSERT INTO "TFW_RELATION" VALUES ('1534', '79', '25');
INSERT INTO "TFW_RELATION" VALUES ('1535', '80', '25');

-- ----------------------------
-- Table structure for TFW_ROLE
-- ----------------------------
DROP TABLE "TFW_ROLE";
CREATE TABLE "TFW_ROLE" (
"ID" NUMBER NOT NULL ,
"NUM" NUMBER NULL ,
"PID" NUMBER NULL ,
"NAME" NVARCHAR2(255) NULL ,
"DEPTID" NUMBER NULL ,
"TIPS" NVARCHAR2(255) NULL ,
"VERSION" NUMBER(11) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TFW_ROLE
-- ----------------------------
INSERT INTO "TFW_ROLE" VALUES ('1', '1', null, '超级管理员', '1', 'administrator', '0');
INSERT INTO "TFW_ROLE" VALUES ('2', '1', '1', '管理员', '7', 'admin', '1');
INSERT INTO "TFW_ROLE" VALUES ('3', '2', '1', '管理员1', '10', 'admin', '1');
INSERT INTO "TFW_ROLE" VALUES ('4', '2', null, '测试', '10', 'test', '0');
INSERT INTO "TFW_ROLE" VALUES ('5', '1', '4', '测试1', '3', 'test', '1');
INSERT INTO "TFW_ROLE" VALUES ('8', '1', '3', '管理员2', '6', 'user', '0');
INSERT INTO "TFW_ROLE" VALUES ('6', '2', '4', '测试2', '10', 'test', '0');

-- ----------------------------
-- Table structure for TFW_ROLE_EXT
-- ----------------------------
DROP TABLE "TFW_ROLE_EXT";
CREATE TABLE "TFW_ROLE_EXT" (
"ID" NUMBER NOT NULL ,
"USERID" NVARCHAR2(255) NULL ,
"ROLEIN" VARCHAR2(1000 BYTE) NULL ,
"ROLEOUT" VARCHAR2(1000 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TFW_ROLE_EXT
-- ----------------------------
INSERT INTO "TFW_ROLE_EXT" VALUES ('67', '1', '1,265', '0');
INSERT INTO "TFW_ROLE_EXT" VALUES ('27', '66', '1,44,49', '45');
INSERT INTO "TFW_ROLE_EXT" VALUES ('50', '74', '0', '0');
INSERT INTO "TFW_ROLE_EXT" VALUES ('48', '63', '0', '0');
INSERT INTO "TFW_ROLE_EXT" VALUES ('49', '72', '0', '0');
INSERT INTO "TFW_ROLE_EXT" VALUES ('47', '2', '0', '8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24');
INSERT INTO "TFW_ROLE_EXT" VALUES ('87', '168', '92,103,104,105,106,107', '109,110,111,112,113,114,115,116,117,118,119,120,121,122');
INSERT INTO "TFW_ROLE_EXT" VALUES ('107', '189', '108,109,110,111,112,113,114,115,116,117,118,119,120,121,122', '0');
INSERT INTO "TFW_ROLE_EXT" VALUES ('127', '21', '92,98,99,100,101,102', '0');

-- ----------------------------
-- Table structure for TFW_USER
-- ----------------------------
DROP TABLE "TFW_USER";
CREATE TABLE "TFW_USER" (
"ID" NUMBER(11) NOT NULL ,
"ACCOUNT" NVARCHAR2(45) NULL ,
"PASSWORD" NVARCHAR2(45) NULL ,
"SALT" NVARCHAR2(45) NULL ,
"NAME" NVARCHAR2(45) NULL ,
"BIRTHDAY" DATE NULL ,
"SEX" NUMBER(11) NULL ,
"EMAIL" NVARCHAR2(45) NULL ,
"PHONE" NVARCHAR2(45) NULL ,
"ROLEID" NVARCHAR2(255) NULL ,
"DEPTID" NUMBER(11) NULL ,
"STATUS" NUMBER(11) NULL ,
"CREATETIME" DATE NULL ,
"VERSION" NUMBER(11) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TFW_USER
-- ----------------------------
INSERT INTO "TFW_USER" VALUES ('1', 'admin', '4779e4a9903dfb08f9f877791c516a73', 'admin', '管理员', TO_DATE('2015-09-08 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1', 'admin@tonbusoft.com.cn', '222333', '1', '1', '1', TO_DATE('2016-01-29 08:49:53', 'YYYY-MM-DD HH24:MI:SS'), '10');
INSERT INTO "TFW_USER" VALUES ('2', 'test001', 'e334680512284cac2f57701abe03af96', 'r4i90', 'cs', TO_DATE('2016-02-19 14:00:13', 'YYYY-MM-DD HH24:MI:SS'), '1', null, null, '6', '2', '1', TO_DATE('2016-02-19 14:00:19', 'YYYY-MM-DD HH24:MI:SS'), '3');

-- ----------------------------
-- Sequence structure for SEQ_ADMIN
-- ----------------------------
DROP SEQUENCE "SEQ_ADMIN";
CREATE SEQUENCE "SEQ_ADMIN"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 100
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_ATTACH
-- ----------------------------
DROP SEQUENCE "SEQ_ATTACH";
CREATE SEQUENCE "SEQ_ATTACH"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 350
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_ATTACH_BLOB
-- ----------------------------
DROP SEQUENCE "SEQ_ATTACH_BLOB";
CREATE SEQUENCE "SEQ_ATTACH_BLOB"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 101
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_DEPT
-- ----------------------------
DROP SEQUENCE "SEQ_DEPT";
CREATE SEQUENCE "SEQ_DEPT"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 54
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_DICT
-- ----------------------------
DROP SEQUENCE "SEQ_DICT";
CREATE SEQUENCE "SEQ_DICT"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 81
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_GENERATE
-- ----------------------------
DROP SEQUENCE "SEQ_GENERATE";
CREATE SEQUENCE "SEQ_GENERATE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 5
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_LLOG
-- ----------------------------
DROP SEQUENCE "SEQ_LLOG";
CREATE SEQUENCE "SEQ_LLOG"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 1
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_MENU
-- ----------------------------
DROP SEQUENCE "SEQ_MENU";
CREATE SEQUENCE "SEQ_MENU"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 285
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_METADATA
-- ----------------------------
DROP SEQUENCE "SEQ_METADATA";
CREATE SEQUENCE "SEQ_METADATA"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 41
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_NEWS
-- ----------------------------
DROP SEQUENCE "SEQ_NEWS";
CREATE SEQUENCE "SEQ_NEWS"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 85080
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_NEWSCONTENT
-- ----------------------------
DROP SEQUENCE "SEQ_NEWSCONTENT";
CREATE SEQUENCE "SEQ_NEWSCONTENT"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 40080
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_NOTICE
-- ----------------------------
DROP SEQUENCE "SEQ_NOTICE";
CREATE SEQUENCE "SEQ_NOTICE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 1439
 CACHE 10;

-- ----------------------------
-- Sequence structure for SEQ_OLOG
-- ----------------------------
DROP SEQUENCE "SEQ_OLOG";
CREATE SEQUENCE "SEQ_OLOG"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 1
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_PARAMETER
-- ----------------------------
DROP SEQUENCE "SEQ_PARAMETER";
CREATE SEQUENCE "SEQ_PARAMETER"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 81
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_RELATION
-- ----------------------------
DROP SEQUENCE "SEQ_RELATION";
CREATE SEQUENCE "SEQ_RELATION"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 1684
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_REPORT
-- ----------------------------
DROP SEQUENCE "SEQ_REPORT";
CREATE SEQUENCE "SEQ_REPORT"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 289
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_REPORTCONTENT
-- ----------------------------
DROP SEQUENCE "SEQ_REPORTCONTENT";
CREATE SEQUENCE "SEQ_REPORTCONTENT"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 131
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_ROLE
-- ----------------------------
DROP SEQUENCE "SEQ_ROLE";
CREATE SEQUENCE "SEQ_ROLE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 45
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_ROLE_EXT
-- ----------------------------
DROP SEQUENCE "SEQ_ROLE_EXT";
CREATE SEQUENCE "SEQ_ROLE_EXT"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 147
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_USER
-- ----------------------------
DROP SEQUENCE "SEQ_USER";
CREATE SEQUENCE "SEQ_USER"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 41
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_WEB
-- ----------------------------
DROP SEQUENCE "SEQ_WEB";
CREATE SEQUENCE "SEQ_WEB"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 41
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_WEBCONTENT
-- ----------------------------
DROP SEQUENCE "SEQ_WEBCONTENT";
CREATE SEQUENCE "SEQ_WEBCONTENT"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 21
 CACHE 20;

-- ----------------------------
-- Indexes structure for table TB_TFW_GSDT
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_TFW_GSDT
-- ----------------------------
ALTER TABLE "TB_TFW_GSDT" ADD CHECK ("F_IT_XL" IS NOT NULL);
ALTER TABLE "TB_TFW_GSDT" ADD CHECK ("F_IT_XL" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_TFW_GSDT
-- ----------------------------
ALTER TABLE "TB_TFW_GSDT" ADD PRIMARY KEY ("F_IT_XL");

-- ----------------------------
-- Indexes structure for table TB_TFW_GSDTNR
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_TFW_GSDTNR
-- ----------------------------
ALTER TABLE "TB_TFW_GSDTNR" ADD CHECK ("F_IT_XL" IS NOT NULL);
ALTER TABLE "TB_TFW_GSDTNR" ADD CHECK ("F_IT_XL" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_TFW_GSDTNR
-- ----------------------------
ALTER TABLE "TB_TFW_GSDTNR" ADD PRIMARY KEY ("F_IT_XL");

-- ----------------------------
-- Indexes structure for table TB_TFW_GZBG
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_TFW_GZBG
-- ----------------------------
ALTER TABLE "TB_TFW_GZBG" ADD CHECK ("F_IT_XL" IS NOT NULL);
ALTER TABLE "TB_TFW_GZBG" ADD CHECK ("F_IT_XL" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_TFW_GZBG
-- ----------------------------
ALTER TABLE "TB_TFW_GZBG" ADD PRIMARY KEY ("F_IT_XL");

-- ----------------------------
-- Indexes structure for table TB_TFW_GZBGNR
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_TFW_GZBGNR
-- ----------------------------
ALTER TABLE "TB_TFW_GZBGNR" ADD CHECK ("F_IT_XL" IS NOT NULL);
ALTER TABLE "TB_TFW_GZBGNR" ADD CHECK ("F_IT_XL" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_TFW_GZBGNR
-- ----------------------------
ALTER TABLE "TB_TFW_GZBGNR" ADD PRIMARY KEY ("F_IT_XL");

-- ----------------------------
-- Indexes structure for table TB_TFW_TZGG
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_TFW_TZGG
-- ----------------------------
ALTER TABLE "TB_TFW_TZGG" ADD CHECK ("F_IT_XL" IS NOT NULL);
ALTER TABLE "TB_TFW_TZGG" ADD CHECK ("F_IT_XL" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_TFW_TZGG
-- ----------------------------
ALTER TABLE "TB_TFW_TZGG" ADD PRIMARY KEY ("F_IT_XL");

-- ----------------------------
-- Indexes structure for table TB_TFW_XWB
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_TFW_XWB
-- ----------------------------
ALTER TABLE "TB_TFW_XWB" ADD CHECK ("F_IT_XL" IS NOT NULL);
ALTER TABLE "TB_TFW_XWB" ADD CHECK ("F_IT_XL" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_TFW_XWB
-- ----------------------------
ALTER TABLE "TB_TFW_XWB" ADD PRIMARY KEY ("F_IT_XL");

-- ----------------------------
-- Indexes structure for table TB_TFW_XWXQB
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_TFW_XWXQB
-- ----------------------------
ALTER TABLE "TB_TFW_XWXQB" ADD CHECK ("F_IT_XL" IS NOT NULL);
ALTER TABLE "TB_TFW_XWXQB" ADD CHECK ("F_IT_XL" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_TFW_XWXQB
-- ----------------------------
ALTER TABLE "TB_TFW_XWXQB" ADD PRIMARY KEY ("F_IT_XL");

-- ----------------------------
-- Indexes structure for table TFW_ATTACH
-- ----------------------------

-- ----------------------------
-- Checks structure for table TFW_ATTACH
-- ----------------------------
ALTER TABLE "TFW_ATTACH" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_ATTACH" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_ATTACH" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_ATTACH" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TFW_ATTACH
-- ----------------------------
ALTER TABLE "TFW_ATTACH" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TFW_DEPT
-- ----------------------------

-- ----------------------------
-- Checks structure for table TFW_DEPT
-- ----------------------------
ALTER TABLE "TFW_DEPT" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_DEPT" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_DEPT" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_DEPT" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TFW_DEPT
-- ----------------------------
ALTER TABLE "TFW_DEPT" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TFW_DICT
-- ----------------------------

-- ----------------------------
-- Checks structure for table TFW_DICT
-- ----------------------------
ALTER TABLE "TFW_DICT" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_DICT" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_DICT" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_DICT" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TFW_DICT
-- ----------------------------
ALTER TABLE "TFW_DICT" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TFW_GENERATE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TFW_GENERATE
-- ----------------------------
ALTER TABLE "TFW_GENERATE" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TFW_GENERATE
-- ----------------------------
ALTER TABLE "TFW_GENERATE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TFW_LOGIN_LOG
-- ----------------------------

-- ----------------------------
-- Checks structure for table TFW_LOGIN_LOG
-- ----------------------------
ALTER TABLE "TFW_LOGIN_LOG" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_LOGIN_LOG" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_LOGIN_LOG" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_LOGIN_LOG" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TFW_LOGIN_LOG
-- ----------------------------
ALTER TABLE "TFW_LOGIN_LOG" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TFW_MENU
-- ----------------------------

-- ----------------------------
-- Checks structure for table TFW_MENU
-- ----------------------------
ALTER TABLE "TFW_MENU" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_MENU" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_MENU" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_MENU" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TFW_MENU
-- ----------------------------
ALTER TABLE "TFW_MENU" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TFW_METADATA
-- ----------------------------

-- ----------------------------
-- Checks structure for table TFW_METADATA
-- ----------------------------
ALTER TABLE "TFW_METADATA" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_METADATA" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_METADATA" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_METADATA" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TFW_METADATA
-- ----------------------------
ALTER TABLE "TFW_METADATA" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TFW_OPERATION_LOG
-- ----------------------------

-- ----------------------------
-- Checks structure for table TFW_OPERATION_LOG
-- ----------------------------
ALTER TABLE "TFW_OPERATION_LOG" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_OPERATION_LOG" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_OPERATION_LOG" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_OPERATION_LOG" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TFW_OPERATION_LOG
-- ----------------------------
ALTER TABLE "TFW_OPERATION_LOG" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TFW_PARAMETER
-- ----------------------------

-- ----------------------------
-- Checks structure for table TFW_PARAMETER
-- ----------------------------
ALTER TABLE "TFW_PARAMETER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_PARAMETER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_PARAMETER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_PARAMETER" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TFW_PARAMETER
-- ----------------------------
ALTER TABLE "TFW_PARAMETER" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TFW_RELATION
-- ----------------------------

-- ----------------------------
-- Checks structure for table TFW_RELATION
-- ----------------------------
ALTER TABLE "TFW_RELATION" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_RELATION" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_RELATION" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_RELATION" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TFW_RELATION
-- ----------------------------
ALTER TABLE "TFW_RELATION" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TFW_ROLE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TFW_ROLE
-- ----------------------------
ALTER TABLE "TFW_ROLE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_ROLE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_ROLE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_ROLE" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TFW_ROLE
-- ----------------------------
ALTER TABLE "TFW_ROLE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TFW_ROLE_EXT
-- ----------------------------

-- ----------------------------
-- Checks structure for table TFW_ROLE_EXT
-- ----------------------------
ALTER TABLE "TFW_ROLE_EXT" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_ROLE_EXT" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_ROLE_EXT" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_ROLE_EXT" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TFW_ROLE_EXT
-- ----------------------------
ALTER TABLE "TFW_ROLE_EXT" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TFW_USER
-- ----------------------------

-- ----------------------------
-- Checks structure for table TFW_USER
-- ----------------------------
ALTER TABLE "TFW_USER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TFW_USER" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TFW_USER
-- ----------------------------
ALTER TABLE "TFW_USER" ADD PRIMARY KEY ("ID");
