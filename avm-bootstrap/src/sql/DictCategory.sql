-- auto Generated on 2021-02-22
-- DROP TABLE IF EXISTS t_dict_category;
CREATE TABLE t_dict_category(
  id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  category_code VARCHAR (50) NOT NULL DEFAULT '' COMMENT '编码',
  category_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT '名称',
  sort_no INT (11) NOT NULL DEFAULT -1 COMMENT '排序',
  `status` INT (11) NOT NULL DEFAULT -1 COMMENT '状态 0停用   1启用',
  remark VARCHAR (50) NOT NULL DEFAULT '' COMMENT '字典描述',
  maintain_type INT (11) NOT NULL DEFAULT -1 COMMENT '字典维护方式：0 不在界面维护  1 在界面维护',
  add_time DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'addTime',
  add_user VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'addUser',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
  update_user VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'updateUser',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 't_dict_category';
