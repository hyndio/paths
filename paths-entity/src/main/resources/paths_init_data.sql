
## 部门
INSERT INTO `org_office` VALUES(1,'1001','管理员',null,null,1);

## 人员
INSERT INTO `org_staff` VALUES (1,'110000','超级管理员',NULL,'unknow',1,NULL,NULL,NULL,1);
INSERT INTO `org_staff` VALUES (2,'110001','测试员',NULL,'unknow',1,NULL,NULL,NULL,2);

## 登录人员，密码全为1
INSERT INTO `ss3_user` VALUES(1,'sysadmin','5536484b09fdfa322c70338849bcff11',1,'no'); 
INSERT INTO `ss3_user` VALUES(2,'test','2f604010b0ac5764e59edbf08b4fc68a',1,'no');

## 岗位
INSERT INTO `org_job` VALUES (1,'110000','超级管理员',1,NULL,1,NULL,1);
INSERT INTO `org_job` VALUES (2,'110001','测试员',1,NULL,1,NULL,2);

## 关联表: 人员与岗位
INSERT INTO `org_staffjob` VALUES(1, 1);
INSERT INTO `org_staffjob` VALUES(2, 2);

## 角色
INSERT INTO `ss3_role` VALUES (1,'超级管理员',1);
INSERT INTO `ss3_role` VALUES (2,'测试员',2);

## 关联表: 岗位与角色
INSERT INTO `ss3_job_role` VALUES(1, 1, 1);
INSERT INTO `ss3_job_role` VALUES(2, 2, 2);

## 权限
INSERT INTO `ss3_authority` VALUES(1,'ROLE_SYSADMIN','超级管理员',1);
INSERT INTO `ss3_authority` VALUES(2,'ROLE_TEST','测试员',2);

## 关联表: 角色与权限
INSERT INTO `ss3_role_auth` VALUES(1, 1, 1);
INSERT INTO `ss3_role_auth` VALUES(2, 2, 2);

## 资源
INSERT INTO `ss3_resource` VALUES(1,'用户管理','/secure/extreme/index.jsp',null,1);
INSERT INTO `ss3_resource` VALUES(2,'权限管理','/secure/index.jsp',null,2);

## 关联表: 权限与资源
INSERT INTO `ss3_auth_reso` VALUES(1, 1, 1);
INSERT INTO `ss3_auth_reso` VALUES(2, 1, 2);
INSERT INTO `ss3_auth_reso` VALUES(3, 2, 2);