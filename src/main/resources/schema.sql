DROP database IF EXISTS `kpacdb`;
create database 'kpacdb';
create USER 'kpacuser'@'localhost' identified by 'kpackuser';
create schema KPACDB;
grant all privileges on KPACDB.* to 'kpacuser'@'localhost';
flush privileges;
set global time_zone = '+2';

create table knowledge
(
    KNOWLEDGE_ID          int auto_increment
        primary key,
    TITLE                 varchar(250)  not null,
    KNOWLEDGE_DESCRIPTION varchar(2000) not null,
    CREATION_DATE         date          not null
);
create table package
(
    PACKAGE_ID int auto_increment
        primary key,
    TITLE      varchar(250) not null
);

create table knowledge_package
(
    KNOWLEDGE_ID int not null,
    PACKAGE_ID   int not null,
    primary key (KNOWLEDGE_ID, PACKAGE_ID),
    constraint PACKAGE_SUB_ID_FK
        foreign key (PACKAGE_ID) references package (PACKAGE_ID)
            on delete cascade
);

