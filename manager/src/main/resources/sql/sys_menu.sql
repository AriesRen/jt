drop table if exists sys_menu;
create table `sys_menu`(
  `id` bigint(20) not null auto_increment primary key comment '菜单ID',
  `menu` varchar(200) not null comment '菜单名称',
  `url` varchar(200) not null comment '菜单url',
  `icon` varchar(200) not null comment '菜单图标',
  `status` tinyint(2) default 1 comment '菜单状态',
  `permission` varchar(100) default  null comment '授权标识',
  `hidden` tinyint(2) default 0 comment '是否隐藏',
  `type` tinyint(2) default 1 comment '菜单类型',
  `note` varchar(200) default null  comment '菜单描述',
  `sort` int default null comment '菜单排序',
  `parentId` bigint(20) default null comment '父级菜单id',
  `createdTime` datetime default null comment '创建时间',
  `updatedTime` datetime default null comment '更改时间',
  `createdUser` varchar(200) default null comment '创建用户',
  `updatedUser` varchar(200) default null comment '修改用户'
)engine=innodb charset = utf8 comment '菜单表';

insert into sys_menu(id, menu, url, icon, status, hidden, parentId, createdTime, updatedTime, createdUser, updatedUser, type, note,sort, permission)
VALUES (1, '系统管理', '/system', 'setting', 1,0,null,now(), now(),'admin','admin','1','系统管理',2, 'sys:all');

insert into sys_menu(id, menu, url, icon, status, hidden, parentId, createdTime, updatedTime, createdUser, updatedUser,type, note,sort, permission)
VALUES (2, '日志管理', '/logsUI', 'logs', 1,0,1,now(), now(),'admin','admin','1','日志管理',2, 'sys:all');

insert into sys_menu(id, menu, url, icon, status, hidden, parentId, createdTime, updatedTime, createdUser, updatedUser,type, note,sort, permission)
VALUES (3, '用户管理', '/userUI', 'user', 1,0,1,now(), now(),'admin','admin','1','用户管理',1, 'sys:all');

insert into sys_menu(id, menu, url, icon, status, hidden, parentId, createdTime, updatedTime, createdUser, updatedUser,type, note,sort, permission)
VALUES (4, '系统设置', '/setting', 'setting', 1,0,1,now(), now(),'admin','admin','1','系统设置',1, 'sys:all');

insert into sys_menu(id, menu, url, icon, status, hidden, parentId, createdTime, updatedTime, createdUser, updatedUser,type, note,sort, permission)
VALUES (5, '个人中心', '/me', 'user', 1,0,null,now(), now(),'admin','admin','1','个人中心',1, 'sys:all');



