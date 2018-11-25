drop table if exists sys_category;
create table `sys_category`(
  `id` bigint(20) not null auto_increment primary key comment '分类ID',
  `category` varchar(200) not null comment '分类名',
  `note` varchar(200) not null comment '分类描述',
  `parentId` bigint(20) default null comment '父级分类id',
  `createdTime` datetime default null comment '创建时间',
  `updatedTime` datetime default null comment '更改时间',
  `createdUser` varchar(200) default null comment '创建用户',
  `updatedUser` varchar(200) default null comment '修改用户'
)engine=innodb charset = utf8 comment '分类表';

insert into sys_category(id, category, note, parentId, createdTime, updatedTime, createdUser, updatedUser)
VALUES (1, 'shuma', '数码', null, now(), now(), 'admin', 'admin');
insert into sys_category(id, category, note, parentId, createdTime, updatedTime, createdUser, updatedUser)
VALUES (2, 'phone', '手机', 1, now(), now(), 'admin', 'admin');
insert into sys_category(id, category, note, parentId, createdTime, updatedTime, createdUser, updatedUser)
VALUES (3, 'apple-phone', '苹果手机', 2, now(), now(), 'admin', 'admin');
insert into sys_category(id, category, note, parentId, createdTime, updatedTime, createdUser, updatedUser)
VALUES (4, 'computer', '电脑', 1, now(), now(), 'admin', 'admin');
insert into sys_category(id, category, note, parentId, createdTime, updatedTime, createdUser, updatedUser)
VALUES (5, 'camara', '相机', 1, now(), now(), 'admin', 'admin');
