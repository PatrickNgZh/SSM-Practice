CREATE DATABASE db_mybatis;

USE db_mybatis;

CREATE TABLE tb_customer (
  id       INT(32) PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50),
  jobs     VARCHAR(50),
  phone    VARCHAR(16)
);

