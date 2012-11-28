# Host: localhost  (Version: 5.5.28)
# Date: 2012-11-27 17:27:59
# Generator: MySQL-Front 5.3  (Build 1.18)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

#
# Source for table "org_office"
#

DROP TABLE IF EXISTS `org_office`;
CREATE TABLE `org_office` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机构（部门）标识',
  `code` varchar(45) DEFAULT NULL COMMENT '机构（单位）编码',
  `name` varchar(256) NOT NULL COMMENT '机构（部门）名称',
  `parent` int(11) DEFAULT NULL COMMENT '上级机构（部门）',
  `duty` text COMMENT '机构（部门）职责',
  `order` int(10) unsigned zerofill NOT NULL COMMENT '排序',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构（部门）表';

#
# Data for table "org_office"
#


#
# Source for table "org_job"
#

DROP TABLE IF EXISTS `org_job`;
CREATE TABLE `org_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `name` varchar(256) NOT NULL,
  `office` int(11) DEFAULT NULL COMMENT '所属机构（部门）',
  `parent` int(11) DEFAULT NULL COMMENT '上级岗位',
  `level` tinyint(4) DEFAULT NULL COMMENT '级别',
  `duty` text COMMENT '岗位职责',
  `order` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `org_job_fk_1_idx` (`office`),
  CONSTRAINT `org_job_fk_1` FOREIGN KEY (`office`) REFERENCES `org_office` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位表';

#
# Data for table "org_job"
#


#
# Source for table "org_officesupervisor"
#

DROP TABLE IF EXISTS `org_officesupervisor`;
CREATE TABLE `org_officesupervisor` (
  `office` int(11) NOT NULL,
  `job` int(11) DEFAULT NULL,
  PRIMARY KEY (`office`),
  KEY `org_officesupervisor_idx` (`office`),
  KEY `org_officesupervisor_fk2_idx` (`job`),
  CONSTRAINT `org_officesupervisor_fk1` FOREIGN KEY (`office`) REFERENCES `org_office` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `org_officesupervisor_fk2` FOREIGN KEY (`job`) REFERENCES `org_job` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门主管';

#
# Data for table "org_officesupervisor"
#


#
# Source for table "org_role"
#

DROP TABLE IF EXISTS `org_role`;
CREATE TABLE `org_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL COMMENT '角色名称',
  `order` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

#
# Data for table "org_role"
#


#
# Source for table "org_jobrole"
#

DROP TABLE IF EXISTS `org_jobrole`;
CREATE TABLE `org_jobrole` (
  `job` int(11) NOT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`job`),
  KEY `org_jobrole_fk1_idx` (`job`),
  KEY `org_jobrole_fk2_idx` (`role`),
  KEY `org_jobrole_fk2_idx1` (`role`),
  CONSTRAINT `org_jobrole_fk2` FOREIGN KEY (`role`) REFERENCES `org_role` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `org_jobrole_fk1` FOREIGN KEY (`job`) REFERENCES `org_job` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位与角色关联';

#
# Data for table "org_jobrole"
#


#
# Source for table "org_staff"
#

DROP TABLE IF EXISTS `org_staff`;
CREATE TABLE `org_staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '人员标识',
  `code` varchar(45) DEFAULT NULL COMMENT '人员公司编码',
  `name` varchar(256) NOT NULL COMMENT '姓名',
  `diff` varchar(50) DEFAULT NULL COMMENT '名字后缀，用来区分同名的人',
  `gender` varchar(6) NOT NULL DEFAULT 'unknow' COMMENT '性别，男male, 女female, 未知unknow',
  `office` int(11) NOT NULL COMMENT '所属机构（部门）',
  `officeRoom` varchar(256) DEFAULT NULL COMMENT '办公室门牌号',
  `officeCall` varchar(20) DEFAULT NULL COMMENT '办公室电话号码',
  `mobilePhone` varchar(20) DEFAULT NULL COMMENT '移动电话号码',
  `order` int(10) unsigned zerofill NOT NULL COMMENT '排序',
  PRIMARY KEY (`office`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `org_staff_fk_2_idx` (`id`),
  CONSTRAINT `org_staff_fk_2` FOREIGN KEY (`office`) REFERENCES `org_office` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员基础信息';

#
# Data for table "org_staff"
#


#
# Source for table "org_staffjob"
#

DROP TABLE IF EXISTS `org_staffjob`;
CREATE TABLE `org_staffjob` (
  `staff` int(11) NOT NULL,
  `job` int(11) DEFAULT NULL,
  PRIMARY KEY (`staff`),
  KEY `org_staffjob_fk1_idx` (`staff`),
  KEY `org_staffjob_fk2_idx` (`job`),
  CONSTRAINT `org_staffjob_fk1` FOREIGN KEY (`staff`) REFERENCES `org_staff` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `org_staffjob_fk2` FOREIGN KEY (`job`) REFERENCES `org_job` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员岗位表';

#
# Data for table "org_staffjob"
#


#
# Source for table "org_staffparttime"
#

DROP TABLE IF EXISTS `org_staffparttime`;
CREATE TABLE `org_staffparttime` (
  `staff` int(11) NOT NULL,
  `job` int(11) NOT NULL,
  PRIMARY KEY (`staff`,`job`),
  KEY `org_staffparttime_fk1_idx` (`staff`),
  KEY `org_staffparttime_fk2_idx` (`job`),
  CONSTRAINT `org_staffparttime_fk1` FOREIGN KEY (`staff`) REFERENCES `org_staff` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `org_staffparttime_fk2` FOREIGN KEY (`job`) REFERENCES `org_job` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员兼职';

#
# Data for table "org_staffparttime"
#


#
# Source for table "org_title"
#

DROP TABLE IF EXISTS `org_title`;
CREATE TABLE `org_title` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位的敬称';

#
# Data for table "org_title"
#


#
# Source for table "org_jobtitle"
#

DROP TABLE IF EXISTS `org_jobtitle`;
CREATE TABLE `org_jobtitle` (
  `job` int(11) NOT NULL,
  `title` int(11) DEFAULT NULL,
  PRIMARY KEY (`job`),
  KEY `org_jobtitle_fk1_idx` (`job`),
  KEY `org_jobtitle_fk2_idx` (`title`),
  CONSTRAINT `org_jobtitle_fk1` FOREIGN KEY (`job`) REFERENCES `org_job` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `org_jobtitle_fk2` FOREIGN KEY (`title`) REFERENCES `org_title` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位与敬称';

#
# Data for table "org_jobtitle"
#


#
# Source for table "ss3_authority"
#

DROP TABLE IF EXISTS `ss3_authority`;
CREATE TABLE `ss3_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL COMMENT 'spring security的编码，\\"ROLE_\\"开头',
  `name` varchar(256) NOT NULL COMMENT '权限名',
  `order` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

#
# Data for table "ss3_authority"
#


#
# Source for table "ss3_resource"
#

DROP TABLE IF EXISTS `ss3_resource`;
CREATE TABLE `ss3_resource` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL COMMENT '资源名',
  `uri` varchar(256) DEFAULT NULL COMMENT '定位符',
  `order` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表';

#
# Data for table "ss3_resource"
#


#
# Source for table "ss3_auth_reso"
#

DROP TABLE IF EXISTS `ss3_auth_reso`;
CREATE TABLE `ss3_auth_reso` (
  `authority` int(11) NOT NULL,
  `resource` int(11) NOT NULL,
  PRIMARY KEY (`authority`,`resource`),
  KEY `ss3_auth_reso_fk1_idx` (`authority`),
  KEY `ss3_auth_reso_fk2_idx` (`resource`),
  CONSTRAINT `ss3_auth_reso_fk1` FOREIGN KEY (`authority`) REFERENCES `ss3_authority` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ss3_auth_reso_fk2` FOREIGN KEY (`resource`) REFERENCES `ss3_resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限与资源关系';

#
# Data for table "ss3_auth_reso"
#


#
# Source for table "ss3_role_auth"
#

DROP TABLE IF EXISTS `ss3_role_auth`;
CREATE TABLE `ss3_role_auth` (
  `role` int(11) NOT NULL,
  `authority` int(11) NOT NULL,
  PRIMARY KEY (`role`,`authority`),
  KEY `ss3_role_auth_fk1_idx` (`role`),
  KEY `ss3_role_auth_fk2_idx` (`authority`),
  CONSTRAINT `ss3_role_auth_fk1` FOREIGN KEY (`role`) REFERENCES `org_role` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `ss3_role_auth_fk2` FOREIGN KEY (`authority`) REFERENCES `ss3_authority` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与权限';

#
# Data for table "ss3_role_auth"
#


#
# Source for table "ss3_user"
#

DROP TABLE IF EXISTS `ss3_user`;
CREATE TABLE `ss3_user` (
  `staff` int(11) NOT NULL COMMENT '人员标识',
  `username` varchar(50) NOT NULL COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT '登录密码',
  `enabled` tinyint(4) NOT NULL DEFAULT '1' COMMENT '账号是否可用，1可用，0停用',
  `online` varchar(5) NOT NULL COMMENT '是否在线, yes, no',
  PRIMARY KEY (`staff`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `ss3_user_fk_1_idx` (`staff`),
  CONSTRAINT `ss3_user_fk_1` FOREIGN KEY (`staff`) REFERENCES `org_staff` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录信息表';

#
# Data for table "ss3_user"
#


/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
