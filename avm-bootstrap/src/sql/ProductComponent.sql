-- auto Generated on 2021-04-28
-- DROP TABLE IF EXISTS t_product_component;
CREATE TABLE t_product_component(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	product_id INT (11) NOT NULL DEFAULT -1 COMMENT 'productId',
	component_id INT (11) NOT NULL DEFAULT -1 COMMENT 'componentId',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 't_product_component';
