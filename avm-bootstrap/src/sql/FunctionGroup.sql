
-- auto Generated on 2021-03-02
-- DROP TABLE IF EXISTS t_function_group;
CREATE TABLE t_function_group(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	group_name VARCHAR (255) NOT NULL DEFAULT '' COMMENT '分组名称',
	group_code VARCHAR (255) NOT NULL DEFAULT '' COMMENT '分组编号',
	parent_code VARCHAR (255) NOT NULL DEFAULT '' COMMENT 'parentCode',
	group_desc VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'groupDesc',
	group_type INT (11) NOT NULL DEFAULT -1 COMMENT 'groupType',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 't_function_group';
