
# 删除表
drop table if exists sec_user_role;
drop table if exists sec_role_auth;
drop table if exists sec_auth_reso;
drop table if exists sec_authority;
drop table if exists sec_resource;
drop table if exists sec_user;
drop table if exists sec_role;
drop table if exists sec_user_role;

# 权限表 
create table sec_authority (
     id_ int not null AUTO_INCREMENT,
     name_ varchar(100) not null,
     desc_ varchar(256),
     enabled_ smallint not null,
     issys_ varchar(10) not null,
     module_ varchar(5), #所属的子系统，比如平台里面包括10个系统。
     primary key (id_)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 资源表
create table sec_resource (
       id_ int not null AUTO_INCREMENT,
       name_ varchar(256),
       desc_ varchar(256),
       type_ varchar(40),
       string_ varchar(256),
       priority smallint,
       enabled_ smallint not null,
       issys_ varchar(10) not null,
       module_ varchar(5), 
       PRIMARY key(id_)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 权限资源表
create table sec_auth_reso (
       auth_ int not null,
       reso_ int not null,
       enabled_ smallint not null,
       primary key (auth_, reso_),
       key (auth_),
       key (reso_)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
      
# 角色表
create table sec_role (
       id_ int not null AUTO_INCREMENT,
       name_ varchar(256) not null,
       desc_ varchar(256),
       enabled_ smallint not null,
       issys_ varchar(10) not null,
       module_ varchar(5), 
       primary key (id_)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 角色权限表
create table sec_role_auth (
       role_ int not null,
       auth_ int not null,
       enabled_ smallint not null,
       primary key (role_, auth_),
       key (role_),
       key (auth_)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
      
# 用户表
create table sec_user (
       id_ int not null AUTO_INCREMENT,
       account_ varchar(100) not null,
       name_ varchar(50) not null,
       password_ varchar(256),
       desc_ varchar(256),
       enabled_ smallint not null,
       issys_ varchar(10) not null,
       dept_ int,
       duty_ varchar(256),
       subsystem_ varchar(30),
       primary key (id_)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 用户角色表
create table sec_user_role (
       user_ int not null,
       role_ int not null,
       enabled_ smallint not null,
       PRIMARY key (user_, role_),
       key (user_),
       key (role_)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 添加约束
alter table sec_auth_reso 
      add CONSTRAINT sec_fkauth_reso FOREIGN key (auth_ ) 
      REFERENCES sec_authority(id_)
      on DELETE CASCADE;
alter table sec_auth_reso
      add CONSTRAINT sec_auth_fkreso FOREIGN key (reso_)
      REFERENCES sec_resource(id_)
      on DELETE CASCADE;
alter table sec_role_auth
      add CONSTRAINT sec_fkrole_auth FOREIGN key (role_)
      REFERENCES sec_role (id_)
      on delete CASCADE;
alter table sec_role_auth
      add CONSTRAINT sec_role_fkauth FOREIGN key (auth_)
      REFERENCES sec_authority(id_)
      on delete CASCADE;
alter table sec_user_role
      add CONSTRAINT sec_fkuser_role FOREIGN key (user_)
      REFERENCES sec_user(id_)
      on delete CASCADE;
alter table sec_user_role
      add CONSTRAINT sec_user_fkrole FOREIGN key (role_)
      REFERENCES sec_role(id_)
      on delete CASCADE;