drop table if exists sys_logs;
create table `sys_logs`(
  `id` bigint(20) not null auto_increment primary key,
  `username` varchar(100) default null comment '用户名',
  `operation` varchar(100) default null comment '操作',
  `method` varchar(200) default null comment '方法名',
  `params` varchar(500) default null comment '参数',
  `time` bigint(20) default null comment '执行时间(毫秒）',
  `ip` varchar(100) default null comment 'ip',
  `createdTime` datetime default null comment '创建时间'
) engine=innodb charset=utf8 comment='日志';

LOCK TABLES `sys_logs` WRITE;
insert into
sys_logs(id, username, operation, method, params, time, ip, createdTime)
values (null ,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',3,'0:0:0:0:0:0:0:1','2018-04-17 19:53:38');

insert into
sys_logs(id, username, operation, method, params, time, ip, createdTime)
values (null ,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',2,'0:0:0:0:0:0:0:1','2018-04-17 19:54:05');
insert into
sys_logs(id, username, operation, method, params, time, ip, createdTime)
values (null ,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',2,'0:0:0:0:0:0:0:1','2018-04-17 19:54:05');

insert into
sys_logs(id, username, operation, method, params, time, ip, createdTime)
values (null ,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',2,'0:0:0:0:0:0:0:1','2018-04-17 19:54:05');

insert into
sys_logs(id, username, operation, method, params, time, ip, createdTime)
values (null ,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',2,'0:0:0:0:0:0:0:1','2018-04-17 19:54:05');


UNLOCK TABLES;