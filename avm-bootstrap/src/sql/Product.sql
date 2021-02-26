-- auto Generated on 2021-02-24
-- DROP TABLE IF EXISTS t_product;
CREATE TABLE t_product(
  id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  simple_english_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'simpleEnglishName',
  full_english_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'fullEnglishName',
  full_chinese_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'fullChineseName',
  group_member_names VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'groupMemberNames',
  product_desc VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'productDesc',
  add_user VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'addUser',
  add_time DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'addTime',
  update_user VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'updateUser',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
  del_status VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'delStatus',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 't_product';
