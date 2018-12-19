drop table if exists sys_users_roles;
create table `sys_users_roles`(
  `user_id` bigint(20) not null,
  `role_id` bigint(20) not null
) engine=innodb charset=utf8 comment='用户角色信息中间表';

insert into sys_users_roles(user_id, role_id) values (1, 1),(1,2);
insert into sys_users_roles(user_id, role_id) values (6, 1);

