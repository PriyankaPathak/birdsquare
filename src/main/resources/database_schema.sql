CREATE DATABASE birdsquare;

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

USE birdsquare;
