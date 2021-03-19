-- auto Generated on 2021-03-03
-- DROP TABLE IF EXISTS t_company_product;
CREATE TABLE t_company_product(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	company_id INT (11) NOT NULL DEFAULT -1 COMMENT 'companyId',
	product_id INT (11) NOT NULL DEFAULT -1 COMMENT 'productId',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 't_company_product';
