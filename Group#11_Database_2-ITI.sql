CREATE DATABASE Bookstore;
USE Bookstore;

CREATE TABLE book (
book_id int(11) not null auto_increment primary key,
title varchar(128) not null,
author varchar(45) not null,
price float not null,
UNIQUE KEY `book_id_UNIQUE` (`book_id`),
UNIQUE KEY `title_UNIQUE` (`title`))
ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE VAL(
book_id int(11) not null auto_increment primary key,
title varchar(128) not null,
author varchar(45) not null,
stat varchar(10) not null,
#price float not null,
UNIQUE KEY `book_id_UNIQUE` (`book_id`),
UNIQUE KEY `title_UNIQUE` (`title`))
ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
#ALTER TABLE [your table name here] AUTO_INCREMENT = 1


CREATE TABLE MAN(
book_id int(11) not null auto_increment primary key,
title varchar(128) not null,
author varchar(45) not null,
stat varchar(10) not null,
#price float not null,
UNIQUE KEY `book_id_UNIQUE` (`book_id`),
UNIQUE KEY `title_UNIQUE` (`title`))
ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

create table ACCOUNTS(
acctype varchar(20) not null, 
accname varchar(128) not null primary key,
accpass varchar(45) not null,
UNIQUE KEY `accname_UNIQUE` (`accname`));

insert into accounts values
("yowyow", "ewan", "12345");

insert into accounts values
	("admin", "Suisei", "12345"),
    ("guest", "Mio", "54321");

INSERT INTO val VALUES 
		(3, "susies", "Bruce Eckel", "Borrowed"),
        (4, "towa", "Joshua Bloch", "Available"),
        (6, "coco", "Kathy Sierra & Bert Bales", "Borrowed");
        
INSERT INTO MAN VALUES
(3, "Thinking in Java", "Bruce Eckel", "Available"),
        (4, "Effective Java", "Joshua Bloch", "Available"),
        (6, "Head First Java", "Kathy Sierra & Bert Bales", "Available");
      
describe man;

drop table accounts;

drop table man;

select * from man;

