
-- auto Generated on 2021-02-25
-- DROP TABLE IF EXISTS t_component;
CREATE TABLE t_component(
  id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  component_english_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'componentEnglishName',
  component_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'componentName',
  component_code VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'componentCode',
  component_type INT (11) NOT NULL DEFAULT 0 COMMENT 'componentType',
  description VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'description',
  language_type VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'languageType',
  chargeman VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'chargeman',
  del_status INT (11) NOT NULL DEFAULT 0 COMMENT 'delStatus',
  update_user VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'updateUser',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
  add_user VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'addUser',
  add_time DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'addTime',
  design_svn_address VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'designSvnAddress',
  require_svn_address VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'requireSvnAddress',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 't_component';
