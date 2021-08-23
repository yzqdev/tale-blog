/*
 Navicat Premium Data Transfer

 Source Server         : tencent
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : 81.69.227.146:3306
 Source Schema         : tale

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 23/08/2021 22:25:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_attach
-- ----------------------------
DROP TABLE IF EXISTS `t_attach`;
CREATE TABLE `t_attach`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ftype` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `fkey` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author_id` int NOT NULL,
  `created` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_attach
-- ----------------------------

-- ----------------------------
-- Table structure for t_comments
-- ----------------------------
DROP TABLE IF EXISTS `t_comments`;
CREATE TABLE `t_comments`  (
  `coid` int NOT NULL AUTO_INCREMENT,
  `cid` int NOT NULL DEFAULT 0,
  `created` int NOT NULL,
  `author` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author_id` int NULL DEFAULT 0,
  `owner_id` int NULL DEFAULT 0,
  `mail` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `agent` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `parent` int NULL DEFAULT 0,
  PRIMARY KEY (`coid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_comments
-- ----------------------------

-- ----------------------------
-- Table structure for t_contents
-- ----------------------------
DROP TABLE IF EXISTS `t_contents`;
CREATE TABLE `t_contents`  (
  `cid` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `slug` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `thumb_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created` int NOT NULL,
  `modified` int NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `author_id` int NOT NULL,
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `fmt_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'markdown',
  `tags` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `categories` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `hits` int NULL DEFAULT 0,
  `comments_num` int NULL DEFAULT 0,
  `allow_comment` int NULL DEFAULT 1,
  `allow_ping` int NULL DEFAULT NULL,
  `allow_feed` int NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE,
  UNIQUE INDEX `cid`(`cid`) USING BTREE,
  UNIQUE INDEX `slug`(`slug`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_contents
-- ----------------------------
INSERT INTO `t_contents` VALUES (1, '关于', 'about', NULL, 1487853610, 1487872488, '### Hello World\r\n\r\n这是我的关于页面\r\n\r\n### 当然还有其他\r\n\r\n具体你来写点什么吧', 1, 'page', 'publish', 'markdown', NULL, NULL, 0, 0, 1, 1, 1);
INSERT INTO `t_contents` VALUES (2, '第一篇文章', NULL, NULL, 1487861184, 1487872798, '## Hello  World.\r\n\r\n> 第一篇文章总得写点儿什么?...\r\n\r\n----------\r\n\r\n\r\n<!--more-->\r\n\r\n```java\r\npublic static void main(String[] args){\r\n    System.out.println(\"Hello Tale.\");\r\n}\r\n```', 1, 'post', 'publish', 'markdown', '', '默认分类', 10, 0, 1, 1, 1);
INSERT INTO `t_contents` VALUES (3, '友情链接', 'links', NULL, 1505643727, 1505643888, '## 友情链接\r\n\r\n- :lock: [王爵的技术博客]()\r\n- :lock: [cyang.tech]()\r\n- :lock: [Bakumon\'s Blog]()\r\n\r\n## 链接须知\r\n\r\n> 请确定贵站可以稳定运营\r\n> 原创博客优先，技术类博客优先，设计、视觉类博客优先\r\n> 经常过来访问和评论，眼熟的\r\n\r\n备注：默认申请友情链接均为内页（当前页面）\r\n\r\n## 基本信息\r\n\r\n                网站名称：Tale博客\r\n                网站地址：https://tale.biezhi.me\r\n\r\n请在当页通过评论来申请友链，其他地方不予回复\r\n\r\n暂时先这样，同时欢迎互换友链，这个页面留言即可。 ^_^\r\n\r\n还有，我会不定时对无法访问的网址进行清理，请保证自己的链接长期有效。', 1, 'page', 'publish', 'markdown', NULL, NULL, 0, 0, 1, 1, NULL);

-- ----------------------------
-- Table structure for t_logs
-- ----------------------------
DROP TABLE IF EXISTS `t_logs`;
CREATE TABLE `t_logs`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `action` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `data` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `author_id` int NOT NULL,
  `ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created` timestamp NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_logs
-- ----------------------------
INSERT INTO `t_logs` VALUES (2, '初始化站点', NULL, 8, '', '2021-08-23 11:24:26');
INSERT INTO `t_logs` VALUES (3, '初始化站点', NULL, 9, '', '2021-08-23 11:39:03');
INSERT INTO `t_logs` VALUES (4, '初始化站点', NULL, 10, '', '2021-08-23 11:48:52');
INSERT INTO `t_logs` VALUES (5, '初始化站点', NULL, 11, '', '2021-08-23 12:12:02');
INSERT INTO `t_logs` VALUES (6, '初始化站点', NULL, 12, '', '2021-08-23 12:17:23');
INSERT INTO `t_logs` VALUES (7, '初始化站点', NULL, 13, '', '2021-08-23 12:20:22');

-- ----------------------------
-- Table structure for t_metas
-- ----------------------------
DROP TABLE IF EXISTS `t_metas`;
CREATE TABLE `t_metas`  (
  `mid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `slug` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sort` int NULL DEFAULT 0,
  `parent` int NULL DEFAULT 0,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_metas
-- ----------------------------
INSERT INTO `t_metas` VALUES (1, '默认分类', NULL, 'category', NULL, 0, 0);

-- ----------------------------
-- Table structure for t_options
-- ----------------------------
DROP TABLE IF EXISTS `t_options`;
CREATE TABLE `t_options`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `value` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_options
-- ----------------------------
INSERT INTO `t_options` VALUES (1, 'allow_comment_audit', 'true', '评论需要审核');
INSERT INTO `t_options` VALUES (2, 'allow_install', 'false', '是否允许重新安装博客');
INSERT INTO `t_options` VALUES (3, 'site_description', '博客系统,Blade框架,Tale', NULL);
INSERT INTO `t_options` VALUES (4, 'site_keywords', '博客系统,Blade框架,Tale', NULL);
INSERT INTO `t_options` VALUES (5, 'site_theme', 'default', NULL);
INSERT INTO `t_options` VALUES (6, 'site_title', 'yzq的网站', '');
INSERT INTO `t_options` VALUES (7, 'social_github', '', NULL);
INSERT INTO `t_options` VALUES (8, 'social_twitter', '', NULL);
INSERT INTO `t_options` VALUES (9, 'social_weibo', '', NULL);
INSERT INTO `t_options` VALUES (10, 'social_zhihu', '', NULL);
INSERT INTO `t_options` VALUES (11, 'site_url', 'http://localhost:8500', NULL);

-- ----------------------------
-- Table structure for t_relationships
-- ----------------------------
DROP TABLE IF EXISTS `t_relationships`;
CREATE TABLE `t_relationships`  (
  `cid` int NOT NULL,
  `mid` int NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_relationships
-- ----------------------------
INSERT INTO `t_relationships` VALUES (2, 1);

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users`  (
  `uid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `home_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `screen_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created` timestamp NOT NULL,
  `activated` int NULL DEFAULT NULL,
  `logged` timestamp NULL DEFAULT NULL,
  `group_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `uid`(`uid`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES (1, 'yzqdev', 'b097d32da251b7864b31ecc888c525e6', '1@qq.com', NULL, 'yzqdev', '2021-08-23 12:20:22', NULL, '2021-08-23 21:46:55', NULL);

SET FOREIGN_KEY_CHECKS = 1;
