-- auto Generated on 2021-03-15
-- DROP TABLE IF EXISTS t_function_component;
CREATE TABLE t_function_component(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	function_id INT (11) NOT NULL DEFAULT -1 COMMENT 'componentEnglishName',
	component_id INT (11) NOT NULL DEFAULT -1 COMMENT 'componentName',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 't_function_component';
