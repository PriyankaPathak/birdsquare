drop database birdsquare;

create database birdsquare;

use birdsquare;

-- note: don't use indentations or shell script won't run
create table bird (
id int not null auto_increment,
name varchar(200) not null,
PRIMARY KEY ( id )
);

create table checkin (
id int not null auto_increment,
birdname varchar(200) not null,
birdname varchar(200) not null,
PRIMARY KEY ( id )
);

source import_all_tables.sql