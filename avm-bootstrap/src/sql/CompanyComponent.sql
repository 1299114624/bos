-- auto Generated on 2021-04-26
-- DROP TABLE IF EXISTS t_company_component;
CREATE TABLE t_company_component(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	company_id INT (11) NOT NULL DEFAULT -1 COMMENT 'companyId',
	product_id INT (11) NOT NULL DEFAULT -1 COMMENT 'productId',
	component_id INT (11) NOT NULL DEFAULT -1 COMMENT 'componentId',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 't_company_component';
