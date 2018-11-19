drop table if exists sys_items;
create table sys_items(
  `id` bigint(20) not null auto_increment primary key COMMENT '主键',
  `cid` bigint(20) NOT NULL COMMENT '商品分类ID',
  `brand` varchar(50) DEFAULT NULL COMMENT '品牌',
  `model` varchar(50) DEFAULT NULL COMMENT '型号',
  `title` varchar(100) DEFAULT NULL COMMENT '名称',
  `sellPoint` varchar(500) default null comment '商品卖点信息',
  `price` bigint(20) DEFAULT NULL COMMENT '价格*100',
  `num` bigint(20) DEFAULT NULL COMMENT '库存数量',
  `barcode` varchar(100) default null unique comment '条形码',
  `image` varchar(200) DEFAULT 0 COMMENT '商品图片信息',
  `status` tinyint(4) DEFAULT '2' COMMENT '商品状态 1正常 2下架 3删除',
  `createdTime` datetime default null comment '创建时间',
  `createdUser` varchar(100) default null comment '创建用户',
  `updatedTime` datetime default null comment '更新时间',
  `updatedUser` varchar(100) default null comment '更新用户'
)engine=innodb charset=utf8 comment='商品表';

INSERT INTO `sys_items` VALUES (536563,163,'联想','小新13','联想(Lenovo)小新Air13 Pro 13.3英寸14.8mm超轻薄笔记本电脑','清仓！仅北京，武汉仓有货！',12600,99999,'','http://139.129.241.42/images/portal/air13/little4.jpg',1,'2015-03-08 21:33:18','admin','2015-04-11 20:38:38','admin'),
                               (635906,163,'联想','310经典版','联想（Lenovo）小新310经典版','清仓！仅北京，武汉仓有货！',4199,99999,NULL,'http://139.129.241.42/images/portal/310/collect.jpg',1,'2017-01-10 17:55:34','admin','2015-03-08 21:33:18','admin'),
                               (635907,163,'联想','310旗舰版','联想（Lenovo）小新310经典版','清仓！仅北京，武汉仓有货！',4191,9999,NULL,'http://139.129.241.42/images/portal/310/collect.jpg',1,'2017-01-11 13:10:04','admin','2017-01-11 13:09:32','admin'),
                               (635908,163,'联想','310经典版','联想（Lenovo）小新310经典版','清仓！仅北京，武汉仓有货！',5592,9999,NULL,'http://139.129.241.42/images/portal/310/collect.jpg',1,'2017-01-11 13:10:07','admin','2017-01-11 13:09:32','admin'),
                               (635909,163,'联想','310低配版','联想（Lenovo）小新310经典版','清仓！仅北京，武汉仓有货！',2299,9999,NULL,'http://139.129.241.42/images/portal/310/collect.jpg',1,'2017-01-11 13:10:09','admin','2017-01-11 13:09:32','admin'),
                               (635910,163,'联想','310打折版','联想（Lenovo）小新310经典版','清仓！仅北京，武汉仓有货！',4,9999,NULL,'http://139.129.241.42/images/portal/310/collect.jpg',1,'2017-01-11 13:10:11','admin','2017-01-11 13:09:32','admin'),
                               (635911,163,'联想','310学习版','联想（Lenovo）小新310经典版','清仓！仅北京，武汉仓有货！',1999,9999,NULL,'http://139.129.241.42/images/portal/310/collect.jpg',1,'2017-01-11 13:10:13','admin','2017-01-11 13:09:32','admin'),
                               (635912,163,'联想','310DOTA2版','联想（Lenovo）小新310经典版','清仓！仅北京，武汉仓有货！',9999,9999,NULL,'http://139.129.241.42/images/portal/310/collect.jpg',1,'2017-01-11 13:10:16','admin','2017-01-11 13:09:32','admin'),
                               (635913,163,'联想','310英雄联盟版','联想（Lenovo）小新310经典版','清仓！仅北京，武汉仓有货！',11111,9999,NULL,'http://139.129.241.42/images/portal/310/collect.jpg',1,'2017-01-11 13:10:18','admin','2017-01-11 13:09:32','admin'),
                               (635914,163,'联想','310魔兽世界版','联想（Lenovo）小新310经典版','清仓！仅北京，武汉仓有货！',12345,9999,NULL,'http://139.129.241.42/images/portal/310/collect.jpg',1,'2017-01-11 13:10:22','admin','2017-01-11 13:09:32','admin'),
                               (679532,238,'deli','25K商务记事本','得力（deli）22215 皮面本PU材质25K商务记事本可插笔 斜绑带笔记本','仅上海，广州，沈阳仓有货！预购从速！',19,99999,NULL,'http://139.129.241.42/images/portal/book/little1.png',1,'2017-03-14 08:46:27','admin','2015-03-08 21:32:31','admin'),
                               (679533,925,'乐尚','男女商务休闲旅行书包','法国LEXON乐上15英寸双肩电脑包男女商务休闲旅行书包LNE6025G06T','少量库存，抢完即止！',180,99999,NULL,'http://139.129.241.42/images/portal/bag/little4.png',1,'2015-03-08 21:31:36','admin','2015-03-08 21:31:36','admin'),
                               (691300,238,'齐心','A5优品商务笔记本','齐心（COMIX）C5902 A5优品商务笔记本子记事本日记本122张','下单即送10400毫安移动电源！再赠手机魔法盒！',22,99999,NULL,'http://139.129.241.42/images/portal/qixin/little4.jpg',1,'2015-03-08 21:29:27','admin','2015-03-08 21:29:27','admin'),
                               (738388,163,'联想','310经典版','联想（Lenovo）小新310经典版','经典回顾！超值价格值得拥有。',4199,99999,NULL,'http://139.129.241.42/images/portal/310/collect.jpg',1,'2017-01-10 17:55:38','admin','2015-03-08 21:28:16','admin'),
                               (741524,163,'戴尔','Pro-R2505TSS','戴尔(DELL)魔方15MF Pro-R2505TSS灵越','下单赠12000毫安移动电源',4999,99999,NULL,'http://139.129.241.42/images/portal/dell2505/little2.jpg',1,'2015-03-08 21:28:30','admin','2015-03-08 21:28:30','admin'),
                               (816448,163,'联想','ThinkPad New S2','联想ThinkPad New S2（20GUA005CD）','经典回顾！超值特惠！',6888,99999,NULL,'http://139.129.241.42/images/portal/bag/little4.png',1,'2015-03-08 21:28:44','admin','2015-03-08 21:28:44','admin'),
                               (816753,163,'戴尔','XPS13-9360','戴尔(DELL)XPS13-9360-R1609 13.3','仅上海，广州，沈阳仓有货！预购从速！',4600,99999,NULL,'http://139.129.241.42/images/portal/xps/little4.jpg',1,'2015-03-08 21:27:39','admin','2015-03-08 21:27:39','admin'),
                               (830972,238,'广博','牛皮纸记事本','广博(GuangBo)10本装40张A5牛皮纸记事本子日记本办公软抄本GBR0731','经典回顾！超值特惠！',49,99999,NULL,'http://139.129.241.42/images/portal/gb/little4.jpg',1,'2015-03-08 21:28:30','admin','2015-03-08 21:28:30','admin'),
                               (832739,236,'三木','票据网格拉链袋','三木(SUNWOOD) C4523 票据网格拉链袋/文件袋 12个装 颜色随机','经典回顾！超值特惠！',28,99999,NULL,'http://139.129.241.42/images/portal/lld/little4.jpg',1,'2015-03-08 21:28:44','admin','2015-03-08 21:28:44','admin'),
                               (844022,241,'施耐德','圆珠笔','施耐德（Schneider） K15 经典款圆珠笔 (5支混色装)','经典回顾！超值特惠！',29,99999,NULL,'http://139.129.241.42/images/portal/pen/little4.jpg',1,'2015-03-08 21:28:01','admin','2015-03-08 21:28:01','admin')
























