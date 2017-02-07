# 数据库 
#创建数据库
DROP DATABASE IF EXISTS manhelp_db;
CREATE DATABASE manhelp_db;

#使用数据库 
use manhelp_db;
#创建管理表 
CREATE TABLE manager_tb(
manager_id int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
manager_phone varchar(255) COMMENT '电话',
manager_password varchar(255) COMMENT '密码',
PRIMARY KEY (manager_id)
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='管理表';

#创建新闻表 
CREATE TABLE news_tb(
news_id int(11) NOT NULL AUTO_INCREMENT COMMENT '新闻id',
type varchar(255) COMMENT '类别',
title varchar(255) COMMENT '标题',
time timestamp COMMENT '时间',
fixed_recommend tinyint(4) COMMENT '是否置顶 默认否',
is_recommend tinyint(4) COMMENT '是否推荐 默认否',
img_address varchar(255) COMMENT '图片地址',
content longtext COMMENT '文章内容',
PRIMARY KEY (news_id)
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='新闻表';

#创建新闻图片表 
CREATE TABLE img_tb(
img_id int(11) NOT NULL AUTO_INCREMENT COMMENT '新闻图片id',
img_address varchar(255) COMMENT '新闻图地址',
news_id int(11) COMMENT '新闻id,外键',
PRIMARY KEY (img_id),
CONSTRAINT FK_NEWS_IMG FOREIGN KEY (news_id) REFERENCES news_tb (news_id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品图片表';

#创建广告位表
CREATE TABLE adsense_tb(
adsense_id int(11) NOT NULL AUTO_INCREMENT COMMENT '广告位id',
type tinyint(11) COMMENT '广告位类型',
content longtext COMMENT '广告位代码',
PRIMARY KEY (adsense_id)
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='广告位表';