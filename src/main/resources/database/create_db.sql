drop database birdsquare;

create database birdsquare;

GRANT ALL PRIVILEGES
ON birdsquare.*
TO 'root'@'localhost'
IDENTIFIED BY 'password'
WITH GRANT OPTION;

GRANT ALL PRIVILEGES
ON birdsquare.*
TO 'root'@'%'
IDENTIFIED BY 'password'
WITH GRANT OPTION;

use birdsquare;

-- note: don't use indentations or shell script won't run
create table bird (
id int not null auto_increment,
name varchar(200) not null,
PRIMARY KEY ( id )
);

source import_all_tables.sql;