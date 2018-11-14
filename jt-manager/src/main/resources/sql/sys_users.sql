drop table if exists sys_users;
create table `sys_users`(
  `id` bigint(20) not null auto_increment primary key,
  `username` varchar(100) default null comment '用户名',
  `password` varchar(32) default null comment '密码',
  `salt` varchar(32) default null comment '盐',
  `email` varchar(32) default null comment '邮箱',
  `phone` varchar(32) default null comment '电话',
  `status` int default 0 comment '用户状态',
  `createdTime` datetime default null comment '创建时间',
  `createdUser` varchar(100) default null comment '创建用户',
  `updatedTime` datetime default null comment '更新时间',
  `updatedUser` varchar(100) default null comment '更新用户'
) engine=innodb charset=utf8 comment='用户信息';

insert into sys_users(username, password, salt, email, phone, status, createdTime, createdUser, updatedTime, updatedUser)
values ("admin", "admin", "salt", "admin@admin.com", "123456789", 1, now(),"admin", now(), "admin");

insert into sys_users(username, password, salt, email, phone, status, createdTime, createdUser, updatedTime, updatedUser)
values ("admin", "admin", "salt", "admin@admin.com", "123456789", 1, now(),"admin", now(), "admin");

insert into sys_users(username, password, salt, email, phone, status, createdTime, createdUser, updatedTime, updatedUser)
values ("admin", "admin", "salt", "admin@admin.com", "123456789", 1, now(),"admin", now(), "admin");
