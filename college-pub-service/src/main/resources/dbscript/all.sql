-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
-- DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
    `id` bigint(20) NOT NULL   AUTO_INCREMENT  COMMENT 'id主键自增',  
    `rank` bigint(20) NOT NULL   COMMENT '排序',
    `img` varchar(100)    COMMENT '图片',  
    `category` bigint(2)    COMMENT '类别',  
    `status` varchar(2) NOT NULL   COMMENT '状态',  
    `title` varchar(50)    COMMENT '标题',  
    `content` text(0)    COMMENT '内容',
    `create_by` bigint(20) NOT NULL   COMMENT '创建人',  
    `update_by` bigint(20) NOT NULL   COMMENT '更新人',  
    `create_at` bigint(20) NOT NULL   COMMENT '创建时间',  
    `update_at` bigint(20) NOT NULL   COMMENT '更新时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `graduate`
-- ----------------------------
-- DROP TABLE IF EXISTS `graduate`;
CREATE TABLE `graduate` (
    `id` bigint(20) NOT NULL   AUTO_INCREMENT  COMMENT 'id主键自增',  
    `rank` bigint(20) NOT NULL   COMMENT '排序',
    `img` varchar(100)    COMMENT '图片',  
    `status` varchar(2) NOT NULL   COMMENT '状态',  
    `title` varchar(50)    COMMENT '标题',  
    `content` text(0)    COMMENT '内容',
    `create_by` bigint(20) NOT NULL   COMMENT '创建人',  
    `update_by` bigint(20) NOT NULL   COMMENT '更新人',  
    `create_at` bigint(20) NOT NULL   COMMENT '创建时间',  
    `update_at` bigint(20) NOT NULL   COMMENT '更新时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `exchange`
-- ----------------------------
-- DROP TABLE IF EXISTS `exchange`;
CREATE TABLE `exchange` (
    `id` bigint(20) NOT NULL   AUTO_INCREMENT  COMMENT 'id主键自增',  
    `img` varchar(100)    COMMENT '图片',  
    `status` varchar(2) NOT NULL   COMMENT '状态',  
    `title` varchar(50)    COMMENT '标题',  
    `content` text(0)    COMMENT '内容',
    `create_by` bigint(20) NOT NULL   COMMENT '创建人',  
    `update_by` bigint(20) NOT NULL   COMMENT '更新人',  
    `create_at` bigint(20) NOT NULL   COMMENT '创建时间',  
    `update_at` bigint(20) NOT NULL   COMMENT '更新时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
-- DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
    `id` bigint(20) NOT NULL   AUTO_INCREMENT  COMMENT 'id主键自增',  
    `img` varchar(100)    COMMENT '图片',  
    `status` varchar(2) NOT NULL   COMMENT '状态',  
    `title` varchar(50)    COMMENT '标题',  
    `content` text(0)    COMMENT '内容',
    `create_by` bigint(20) NOT NULL   COMMENT '创建人',  
    `update_by` bigint(20) NOT NULL   COMMENT '更新人',  
    `create_at` bigint(20) NOT NULL   COMMENT '创建时间',  
    `update_at` bigint(20) NOT NULL   COMMENT '更新时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `admission_employment`
-- ----------------------------
-- DROP TABLE IF EXISTS `admission_employment`;
CREATE TABLE `admission_employment` (
    `id` bigint(20) NOT NULL   AUTO_INCREMENT  COMMENT 'id主键自增',  
    `category` bigint(2)    COMMENT '类别',  
    `status` varchar(2) NOT NULL   COMMENT '状态',  
    `title` varchar(50)    COMMENT '标题',  
    `content` text(0)    COMMENT '内容',
    `create_by` bigint(20) NOT NULL   COMMENT '创建人',  
    `update_by` bigint(20) NOT NULL   COMMENT '更新人',  
    `create_at` bigint(20) NOT NULL   COMMENT '创建时间',  
    `update_at` bigint(20) NOT NULL   COMMENT '更新时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `article`
-- ----------------------------
-- DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
    `id` bigint(20) NOT NULL   AUTO_INCREMENT  COMMENT 'id主键自增',  
    `rank` bigint(20) NOT NULL   COMMENT '排序',
    `img` varchar(100)    COMMENT '图片',  
    `status` varchar(2) NOT NULL   COMMENT '状态',  
    `title` varchar(50)    COMMENT '标题',  
    `content` text(0)    COMMENT '内容',
    `create_by` bigint(20) NOT NULL   COMMENT '创建人',  
    `update_by` bigint(20) NOT NULL   COMMENT '更新人',  
    `create_at` bigint(20) NOT NULL   COMMENT '创建时间',  
    `update_at` bigint(20) NOT NULL   COMMENT '更新时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `major`
-- ----------------------------
-- DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
    `id` bigint(20) NOT NULL   AUTO_INCREMENT  COMMENT 'id主键自增',  
    `img` varchar(100)    COMMENT '图片',  
    `title` varchar(50)    COMMENT '标题',  
    `content` text(0)    COMMENT '内容',
    `create_by` bigint(20) NOT NULL   COMMENT '创建人',  
    `update_by` bigint(20) NOT NULL   COMMENT '更新人',  
    `create_at` bigint(20) NOT NULL   COMMENT '创建时间',  
    `update_at` bigint(20) NOT NULL   COMMENT '更新时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `internship`
-- ----------------------------
-- DROP TABLE IF EXISTS `internship`;
CREATE TABLE `internship` (
    `id` bigint(20) NOT NULL   AUTO_INCREMENT  COMMENT 'id主键自增',  
    `img` varchar(100)    COMMENT '图片',  
    `title` varchar(50)    COMMENT '标题',  
    `content` text(0)    COMMENT '内容',
    `create_by` bigint(20) NOT NULL   COMMENT '创建人',  
    `update_by` bigint(20) NOT NULL   COMMENT '更新人',  
    `create_at` bigint(20) NOT NULL   COMMENT '创建时间',  
    `update_at` bigint(20) NOT NULL   COMMENT '更新时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





