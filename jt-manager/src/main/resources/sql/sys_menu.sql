drop table if exists sys_category;
create table `sys_category`(
  `id` bigint(20) not null auto_increment primary key comment '菜单ID',
  `menu` varchar(200) not null comment '菜单名称',
  `url` varchar(200) not null comment '菜单url',
  `icon` varchar(200) not null comment '菜单图标',
  `status` tinyint(2) default 1 comment '菜单状态',
  `hidden` tinyint(1) default 0 comment '是否隐藏',
  `parentId` bigint(20) default null comment '父级菜单id',
  `createdTime` datetime default null comment '创建时间',
  `updatedTime` datetime default null comment '更改时间',
  `createdUser` varchar(200) default null comment '创建用户',
  `updatedUser` varchar(200) default null comment '修改用户'
)engine=innodb charset = utf8 comment '分类表';

