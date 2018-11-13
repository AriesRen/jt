drop database if exists jt_sys;
create database jt_sys;
use jt_sys;
create table `sys_roles`(
  `id` bigint(20) not null auto_increment primary key,
  `name` varchar(100) default null comment '角色名称',
  `note` varchar(500) default null  comment '备注',
  `createTime` datetime default null comment '创建时间',
  `updateTime` datetime default null comment '更改时间',
  `createUser` varchar(200) default null comment '创建用户',
  `updateUser` varchar(200) default null comment '修改用户'
) engine=innodb charset=utf8 comment='角色';

insert into sys_roles(name, note, createTime, updateTime) values ("role_user", "用户角色", now(), now());
insert into sys_roles(name, note, createTime, updateTime) values ("role_admin", "管理员角色", now(), now());