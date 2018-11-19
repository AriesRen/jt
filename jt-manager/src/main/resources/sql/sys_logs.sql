drop table if exists sys_logs;
create table `sys_logs`(
  `id` bigint(20) not null auto_increment primary key,
  `username` varchar(100) default null comment '用户名',
  `operation` varchar(100) default null comment '操作',
  `method` varchar(200) default null comment '方法名',
  `params` varchar(500) default null comment '参数',
  `time` bigint(20) default null comment '执行时间(毫秒）',
  `ip` varchar(100) default null comment 'ip',
  `createdTime` datetime default null comment '创建时间',
  `updatedTime` datetime default null comment '更改时间',
  `createdUser` varchar(200) default null comment '创建用户',
  `updatedUser` varchar(200) default null comment '修改用户'
) engine=innodb charset=utf8 comment='日志';

insert into
sys_logs(id, username, operation, method, params, time, ip, createdTime, updatedTime, createdUser, updatedUser)
values (null ,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',3,'0:0:0:0:0:0:0:1','2018-04-17 19:53:38', now(), 'renhj', 'admin');

insert into
sys_logs(id, username, operation, method, params, time, ip, createdTime, updatedTime, createdUser, updatedUser)
values (null ,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',2,'0:0:0:0:0:0:0:1','2018-04-17 19:54:05', now(), 'renhj', 'admin');
insert into
sys_logs(id, username, operation, method, params, time, ip, createdTime, updatedTime, createdUser, updatedUser)
values (null ,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',2,'0:0:0:0:0:0:0:1','2018-04-17 19:54:05', now(), 'renhj', 'admin');

insert into
sys_logs(id, username, operation, method, params, time, ip, createdTime, updatedTime, createdUser, updatedUser)
values (null ,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',2,'0:0:0:0:0:0:0:1','2018-04-17 19:54:05', now(), 'renhj', 'admin');

insert into
sys_logs(id, username, operation, method, params, time, ip, createdTime, updatedTime, createdUser, updatedUser)
values (null ,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',2,'0:0:0:0:0:0:0:1','2018-04-17 19:54:05', now(), 'renhj', 'admin');





delimiter //
drop procedure p;
create procedure p()
  begin
    declare i int default 1;

    while i<=10000 do
      insert into
      sys_logs(id, username, operation, method, params, time, ip, createdTime)
      values (null ,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',3,'0:0:0:0:0:0:0:1','2018-04-17 19:53:38');
      set i = i + 1;
    end while;
  end;
//

call p();
delimiter ;
drop procedure p;