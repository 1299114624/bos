-- auto Generated on 2021-02-27
-- DROP TABLE IF EXISTS t_company;
CREATE TABLE t_company(
  id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  company_name VARCHAR (255) NOT NULL DEFAULT '' COMMENT 'companyName',
  english_company_name VARCHAR (255) NOT NULL DEFAULT '' COMMENT 'englishCompanyName',
  simple_company_name VARCHAR (255) NOT NULL DEFAULT '' COMMENT 'simpleCompanyName',
  description VARCHAR (255) NOT NULL DEFAULT '' COMMENT 'description',
  del_status INT (11) NOT NULL DEFAULT 0 COMMENT 'delStatus',
  update_user VARCHAR (255) NOT NULL DEFAULT '' COMMENT 'updateUser',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
  add_user VARCHAR (255) NOT NULL DEFAULT '' COMMENT 'addUser',
  add_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'addTime',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 't_company';
