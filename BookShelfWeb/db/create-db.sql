drop database if exists bookShelf;
create database bookShelf;
use bookShelf;

create table book(
isbn int unsigned not null,
name varchar(100) not null,
price double not null,
author varchar(32) not null,
primary key(isbn));

