-- auto Generated on 2021-03-05
-- DROP TABLE IF EXISTS t_function_function_group;
CREATE TABLE t_function_function_group(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	function_id INT (11) NOT NULL DEFAULT -1 COMMENT '功能ID',
	function_group_id INT (11) NOT NULL DEFAULT -1 COMMENT '分组ID',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 't_function_function_group';
