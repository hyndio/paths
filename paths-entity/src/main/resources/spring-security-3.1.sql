# spring security 3.1 schema
drop table if exists users;
create table users (
       username varchar(50) not null primary key,
       password varchar(50) not null,
       enabled boolean not null
);

drop table if exists authorities;
create table authorities (
       username varchar(50) not null,
       authority varchar(50) not null,
       constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

/*密码是字符串admin加密后的结果*/
INSERT INTO users(username,PASSWORD,enabled)
       VALUES('admin','21232f297a57a5a743894a0e4a801fc3',1);
/*密码是字符串user 加密后的结果 */
INSERT INTO users(username,PASSWORD,enabled)
       VALUES('user','ee11cbb19052e40b07aac0ca060c23ee',1);
       
INSERT INTO authorities VALUES('admin','ROLE_ADMIN');
INSERT INTO authorities VALUES('user','ROLE_USER');
