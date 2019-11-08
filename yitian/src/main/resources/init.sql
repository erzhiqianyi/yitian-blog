-- 创建数据库
create database yitian

-- 添加数据库账号
create user 'yitian'@'localhost' identified by 'yitian';

-- 赋予数据库账号权限
grant all on yitian.* to 'yitian'@'localhost';

-- 系统配置
CREATE TABLE `system_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '配置名字',
  `code` varchar(50) NOT NULL COMMENT '配置编码',
  `value` varchar(200) NOT NULL COMMENT '配置值',
  `create_at` bigint(13) NOT NULL,
  `update_at` bigint(13) NOT NULL,
  `create_by` bigint(20) NOT NULL,
  `update_by` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统配置';

-- 管理人员
CREATE TABLE `administrator` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `nickname` varchar(50) NOT NULL COMMENT '昵称',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(500) NOT NULL COMMENT '密码',
  `create_at` bigint(13) NOT NULL,
  `update_at` bigint(13) NOT NULL,
  `create_by` bigint(20) NOT NULL,
  `update_by` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `code` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理人员';


-- 插入数据
insert into system_config ( name, code, value, create_at, update_at, create_by, update_by)
values ('博客名字','SYSTEM_SITE_NAME','二之前一的博客',1573204513496,1573204513496,1,1);

-- 查询
select id, name, code, value from system_config where code = 'SYSTEM_SITE_NAME';


