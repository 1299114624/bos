-- auto Generated on 2021-06-18
-- DROP TABLE IF EXISTS t_resource;
CREATE TABLE t_resource(

	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	res_code VARCHAR (50) NOT NULL DEFAULT '' COMMENT '资源编码',
	parent_id INT (11) NOT NULL DEFAULT -1 COMMENT '父资源id',
	app_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT '应用名称',
	menu_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT '功能名称',
	disabled INT (11) NOT NULL DEFAULT -1 COMMENT '是否禁用',
	ismenu INT (11) NOT NULL DEFAULT -1 COMMENT '是否菜单',
	menu_type VARCHAR (50) NOT NULL DEFAULT '' COMMENT '类型',
	menu_url VARCHAR (50) NOT NULL DEFAULT '' COMMENT '地址',
	orderby INT (11) NOT NULL DEFAULT -1 COMMENT '排序',
description VARCHAR (50) NOT NULL DEFAULT '' COMMENT '描述',
		add_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'addTime',
	add_user VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'addUser',
	update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
	update_user VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'updateUser',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 't_resource';
