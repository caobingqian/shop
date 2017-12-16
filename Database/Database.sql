CREATE DATABASE /*!32312 IF NOT EXISTS*/`w10021YSSPWZ` /*!40100 DEFAULT CHARACTER SET utf8  COLLATE utf8_general_ci */; 


use `w10021YSSPWZ`;
INSERT  INTO t_role(`name`,`descp`) VALUES ('系统管理员','超级管理员权限');
INSERT  INTO t_user(`username`,`password`,`role`) VALUES ('admin','admin',1);
insert  into `t_role`(`name`,`descp`) values ('会员','会员权限');
