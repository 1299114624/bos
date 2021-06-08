-- auto Generated on 2021-05-13
-- DROP TABLE IF EXISTS t_product_function;
CREATE TABLE t_product_function(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	product_id INT (11) NOT NULL DEFAULT -1 COMMENT 'productId',
	function_id INT (11) NOT NULL DEFAULT -1 COMMENT 'functionId',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 't_product_function';
