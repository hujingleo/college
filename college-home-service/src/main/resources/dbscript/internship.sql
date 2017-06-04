-- ----------------------------
-- Table structure for `internship`
-- ----------------------------
-- DROP TABLE IF EXISTS `internship`;
CREATE TABLE `internship` (
    `id` bigint(20) NOT NULL   AUTO_INCREMENT  COMMENT 'id主键自增',  
    `img` varchar(100)    COMMENT '图片',  
    `title` varchar(50)    COMMENT '标题',  
    `content` text    COMMENT '内容',  
    `create_by` bigint(20) NOT NULL   COMMENT '创建人',  
    `update_by` bigint(20) NOT NULL   COMMENT '更新人',  
    `create_at` bigint(20) NOT NULL   COMMENT '创建时间',  
    `update_at` bigint(20) NOT NULL   COMMENT '更新时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





