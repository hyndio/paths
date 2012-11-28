
drop table if exists ss_user;
create table ss_user (
	username varchar(255) not null,
	password varchar(255) not null,
	enabled bool,
	primary key (username)
);