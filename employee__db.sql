create database employee_db;
use employee_db;

create table employees(
id int primary key auto_increment,
name varchar(50) Not null,
department varchar(100),
salary double
);
