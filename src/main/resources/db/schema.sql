DROP database IF EXISTS `kpacdb`;
create database 'kpacdb';
create USER 'kpacuser'@'localhost' identified by 'kpackuser';
create schema KPACDB;
grant all privileges on KPACDB.* to 'kpacuser'@'localhost';
flush privileges;
set global time_zone = '+2';

CREATE TABLE KNOWLEDGE
(
    KNOWLEDGE_ID          INT           NOT NULL AUTO_INCREMENT,
    TITLE                VARCHAR(250)  NOT NULL,
    KNOWLEDGE_DESCRIPTION VARCHAR(2000) NOT NULL,
    CREATION_DATE         DATE          NOT NULL,
    PRIMARY KEY (KNOWLEDGE_ID)
);
CREATE TABLE PACKAGE
(
    PACKAGE_ID INT          NOT NULL AUTO_INCREMENT,
    TITLE     VARCHAR(250) NOT NULL,
    PRIMARY KEY (PACKAGE_ID)
);
CREATE TABLE KNOWLEDGE_PACKAGE
(
    KNOWLEDGE_ID INT,
    PACKAGE_ID   INT,
    PRIMARY KEY (KNOWLEDGE_ID, PACKAGE_ID),

    CONSTRAINT KNOWLEDGE_SUB_ID_FK
        FOREIGN KEY (KNOWLEDGE_ID)
            REFERENCES KNOWLEDGE (KNOWLEDGE_ID),

    CONSTRAINT PACKAGE_SUB_ID_FK
        FOREIGN KEY (PACKAGE_ID)
            REFERENCES PACKAGE (PACKAGE_ID)
);

