# Host: localhost  (Version: 5.1.38-community)
# Date: 2012-11-16 10:49:25
# Generator: MySQL-Front 5.3  (Build 1.18)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

#
# Source for table "sec_authority"
#

DROP TABLE IF EXISTS `sec_authority`;
CREATE TABLE `sec_authority` (
  `id_` int(11) NOT NULL AUTO_INCREMENT,
  `name_` varchar(100) NOT NULL,
  `desc_` varchar(256) DEFAULT NULL,
  `enabled_` smallint(6) NOT NULL,
  `issys_` varchar(10) NOT NULL,
  `module_` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sec_authority"
#

/* 根据权限名查找对应的所有资源名
select r.string_ from sec_auth_reso j
left join sec_resource r on j.reso_ = r.id_
left join sec_authority a on j.auth_=a.id_
where a.name_='';
*/
/* 根据用户名查找所对应的所有权限名 
select * from sec_user_role ur 
left join sec_user u on ur.user_=u.id_
left join sec_role_auth ra on ur.role_=ra.role_
left join sec_auth a on ra.auth_=a.id_
where u.account_='';
*/


#
# Source for table "sec_resource"
#

DROP TABLE IF EXISTS `sec_resource`;
CREATE TABLE `sec_resource` (
  `id_` int(11) NOT NULL AUTO_INCREMENT,
  `name_` varchar(256) DEFAULT NULL,
  `desc_` varchar(256) DEFAULT NULL,
  `type_` varchar(40) DEFAULT NULL,
  `string_` varchar(256) DEFAULT NULL,
  `priority` smallint(6) DEFAULT NULL,
  `enabled_` smallint(6) NOT NULL,
  `issys_` varchar(10) NOT NULL,
  `module_` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sec_resource"
#


#
# Source for table "sec_auth_reso"
#

DROP TABLE IF EXISTS `sec_auth_reso`;
CREATE TABLE `sec_auth_reso` (
  `auth_` int(11) NOT NULL,
  `reso_` int(11) NOT NULL,
  `enabled_` smallint(6) NOT NULL,
  PRIMARY KEY (`auth_`,`reso_`),
  KEY `auth_` (`auth_`),
  KEY `reso_` (`reso_`),
  CONSTRAINT `sec_auth_fkreso` FOREIGN KEY (`reso_`) REFERENCES `sec_resource` (`id_`) ON DELETE CASCADE,
  CONSTRAINT `sec_fkauth_reso` FOREIGN KEY (`auth_`) REFERENCES `sec_authority` (`id_`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sec_auth_reso"
#


#
# Source for table "sec_role"
#

DROP TABLE IF EXISTS `sec_role`;
CREATE TABLE `sec_role` (
  `id_` int(11) NOT NULL AUTO_INCREMENT,
  `name_` varchar(256) NOT NULL,
  `desc_` varchar(256) DEFAULT NULL,
  `enabled_` smallint(6) NOT NULL,
  `issys_` varchar(10) NOT NULL,
  `module_` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sec_role"
#


#
# Source for table "sec_role_auth"
#

DROP TABLE IF EXISTS `sec_role_auth`;
CREATE TABLE `sec_role_auth` (
  `role_` int(11) NOT NULL,
  `auth_` int(11) NOT NULL,
  `enabled_` smallint(6) NOT NULL,
  PRIMARY KEY (`role_`,`auth_`),
  KEY `role_` (`role_`),
  KEY `auth_` (`auth_`),
  CONSTRAINT `sec_role_fkauth` FOREIGN KEY (`auth_`) REFERENCES `sec_authority` (`id_`) ON DELETE CASCADE,
  CONSTRAINT `sec_fkrole_auth` FOREIGN KEY (`role_`) REFERENCES `sec_role` (`id_`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sec_role_auth"
#


#
# Source for table "sec_user"
#

DROP TABLE IF EXISTS `sec_user`;
CREATE TABLE `sec_user` (
  `id_` int(11) NOT NULL AUTO_INCREMENT,
  `account_` varchar(100) NOT NULL,
  `name_` varchar(50) NOT NULL,
  `password_` varchar(256) DEFAULT NULL,
  `desc_` varchar(256) DEFAULT NULL,
  `enabled_` smallint(6) NOT NULL,
  `issys_` varchar(10) NOT NULL,
  `dept_` int(11) DEFAULT NULL,
  `duty_` varchar(256) DEFAULT NULL,
  `subsystem_` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sec_user"
#


#
# Source for table "sec_user_role"
#

DROP TABLE IF EXISTS `sec_user_role`;
CREATE TABLE `sec_user_role` (
  `user_` int(11) NOT NULL,
  `role_` int(11) NOT NULL,
  `enabled_` smallint(6) NOT NULL,
  PRIMARY KEY (`user_`,`role_`),
  KEY `user_` (`user_`),
  KEY `role_` (`role_`),
  CONSTRAINT `sec_user_fkrole` FOREIGN KEY (`role_`) REFERENCES `sec_role` (`id_`) ON DELETE CASCADE,
  CONSTRAINT `sec_fkuser_role` FOREIGN KEY (`user_`) REFERENCES `sec_user` (`id_`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sec_user_role"
#


#
# Source for table "t_account"
#

DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `cashBalance` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "t_account"
#

INSERT INTO `t_account` VALUES (1,500,'John Smith'),(2,1000,'Bernard Dupont'),(3,1500,'Bart Simpson');

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
