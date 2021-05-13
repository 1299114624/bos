-- auto Generated on 2021-05-11
-- DROP TABLE IF EXISTS t_component_company;
CREATE TABLE t_component_company(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	component_id INT (11) NOT NULL DEFAULT -1 COMMENT 'componentId',
	company_id INT (11) NOT NULL DEFAULT -1 COMMENT 'companyId',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 't_component_company';
