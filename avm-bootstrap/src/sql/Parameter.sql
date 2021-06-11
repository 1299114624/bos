-- auto Generated on 2021-06-10
-- DROP TABLE IF EXISTS t_sys_parameter;
CREATE TABLE t_sys_parameter(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	para_type VARCHAR (50) NOT NULL DEFAULT '' COMMENT '类别',
	para_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT '名称',
	para_value VARCHAR (50) NOT NULL DEFAULT '' COMMENT '值',
	`status` INT (11) NOT NULL DEFAULT -1 COMMENT '状态（1启用 2禁用）',
	para_desc VARCHAR (50) NOT NULL DEFAULT '' COMMENT '描述',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 't_sys_parameter';
