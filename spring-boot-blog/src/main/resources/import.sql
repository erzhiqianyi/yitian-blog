--创建数据库
create database blog;

-- 添加数据库账号
create user 'blog'@'localhost' identified by 'blog';

-- 赋予数据库账号权限
grant all on blog.* to 'blog'@'localhost';

-- 添加用户表
CREATE TABLE `user`
(
    `id`         int(11) PRIMARY KEY auto_increment,
    `username`   varchar(50)                  NOT NULL COMMENT '用户名',
    `email`      varchar(50)                  NOT NULL COMMENT '邮箱',
    `password`   varchar(300)                  NOT NULL COMMENT '密码',
    `create_at`  BIGINT(13)                    NOT NULL,
    `update_at`  BIGINT(13)                    NOT NULL,
    `create_by`  INT(11)                       NOT NULL,
    `update_by`  INT(11)                       NOT NULL,
    index(email),
    index(username)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- 插入数据
insert into user ( username, email, password, create_at, update_at, create_by, update_by)
 values ('admin','admin@admin.com','123456','1563094556746','1563094556746','0','0');

-- 查询
select id, username, email, password, create_at, update_at, create_by, update_by, index from "user" where id = '';

-- 用户表添加 status 字段
ALTER  TABLE user  ADD status varchar(20) NOT NULL COMMENT '用户状态'
