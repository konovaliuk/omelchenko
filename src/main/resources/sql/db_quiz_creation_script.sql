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

-- -----------------------------------------------------
-- Table subject
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS subject (
  subjectId INT NOT NULL AUTO_INCREMENT,
  subjectName VARCHAR(50) NOT NULL UNIQUE,
  PRIMARY KEY (subjectId));

-- -----------------------------------------------------
-- Table question
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS question(
  questionId INT NOT NULL AUTO_INCREMENT,
  questionText VARCHAR(200) NOT NULL UNIQUE,
  subjectId INT(10) NOT NULL,
  PRIMARY KEY (questionId),
  FOREIGN KEY (subjectId) REFERENCES subject(subjectId));

-- -----------------------------------------------------
-- Table answer
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS answer(
  answerId INT NOT NULL AUTO_INCREMENT,
  answerText VARCHAR(200) NOT NULL,
  isRight INT(1) NOT NULL,
  questionId INT NOT NULL,
  PRIMARY KEY (answerId),
  FOREIGN KEY (questionId) REFERENCES question(questionId));

-- -----------------------------------------------------
-- Table test
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS test (
  testId INT NOT NULL AUTO_INCREMENT,
  testName VARCHAR(50) NOT NULL UNIQUE,
  timeLimit INT(10) NOT NULL,
  subjectId INT(10) NOT NULL,
  PRIMARY KEY (testId),
  FOREIGN KEY (subjectId) REFERENCES subject(subjectId));

-- -----------------------------------------------------
-- Table testquestion
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS testquestion (
  testquestionId INT NOT NULL AUTO_INCREMENT,
  testId INT NOT NULL,
  questionId INT NOT NULL,
  PRIMARY KEY (testquestionId),
  FOREIGN KEY (testId) REFERENCES test(testId),
  FOREIGN KEY (questionId) REFERENCES question(questionId));

-- -----------------------------------------------------
-- Table result
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS result (
  resultId INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(50) NOT NULL,
  testName VARCHAR(50) NOT NULL,
  subjectName VARCHAR(50) NOT NULL UNIQUE,
  score DOUBLE NOT NULL,
  PRIMARY KEY (resultId),
  FOREIGN KEY (testName) REFERENCES test(testName),
  FOREIGN KEY (subjectName) REFERENCES subject(subjectName),
  FOREIGN KEY (login) REFERENCES user(login));
