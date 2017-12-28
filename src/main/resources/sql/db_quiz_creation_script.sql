-- -----------------------------------------------------
-- Database QuizSystem
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS QuizSystem DEFAULT CHARACTER SET utf8;
USE QuizSystem;

-- -----------------------------------------------------
-- Table usertype
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usertype (
  usertypeId INT NOT NULL AUTO_INCREMENT,
  usertype VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (usertypeId));

-- -----------------------------------------------------
-- Table user
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS user(
userId INT NOT NULL AUTO_INCREMENT,
login VARCHAR(50) NOT NULL UNIQUE,
email VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL,
country VARCHAR(50) NOT NULL,
gender VARCHAR(10) NOT NULL,
usertypeId INT NOT NULL,
PRIMARY KEY (userId),
FOREIGN KEY (usertypeId) REFERENCES usertype(usertypeId));
