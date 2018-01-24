-- -----------------------------------------------------
-- Database QuizSystem
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS QuizSystem  CHARACTER SET utf8 COLLATE utf8_general_ci;
USE QuizSystem;

-- -----------------------------------------------------
-- Table usertype
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usertype (
  usertypeId INT NOT NULL AUTO_INCREMENT,
  usertype VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (usertypeId)) CHARACTER SET utf8;

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
FOREIGN KEY (usertypeId) REFERENCES usertype(usertypeId)) CHARACTER SET utf8;

-- -----------------------------------------------------
-- Table subject
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS subject (
  subjectId INT NOT NULL AUTO_INCREMENT,
  subjectName VARCHAR(50) NOT NULL UNIQUE,
  PRIMARY KEY (subjectId)) CHARACTER SET utf8;

-- -----------------------------------------------------
-- Table test
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS test (
  testId INT NOT NULL AUTO_INCREMENT,
  testName VARCHAR(50) NOT NULL UNIQUE,
  timeLimit INT(10) NOT NULL,
  subjectId INT(10) NOT NULL,
  PRIMARY KEY (testId),
  FOREIGN KEY (subjectId) REFERENCES subject(subjectId)) CHARACTER SET utf8;


-- -----------------------------------------------------
-- Table language
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS language(
  languageId INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  PRIMARY KEY (languageId)) CHARACTER SET utf8;


-- -----------------------------------------------------
-- Table question
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS question(
  questionId INT NOT NULL AUTO_INCREMENT,
  subjectId INT(10) NOT NULL,
  PRIMARY KEY (questionId),
  FOREIGN KEY (subjectId) REFERENCES subject(subjectId)) CHARACTER SET utf8;

-- -----------------------------------------------------
-- Table questiontranslate
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS questiontranslate(
  questiontranslateId INT NOT NULL AUTO_INCREMENT,
  questionId INT NOT NULL,
  questionText VARCHAR(200) NOT NULL UNIQUE,
  languageId INT NOT NULL,
  PRIMARY KEY (questiontranslateId),
  FOREIGN KEY (languageId) REFERENCES language(languageId),
  FOREIGN KEY (questionId) REFERENCES question(questionId)) CHARACTER SET utf8;

-- -----------------------------------------------------
-- Table answer
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS answer(
  answerId INT NOT NULL AUTO_INCREMENT,
  isRight INT(1) NOT NULL,
  questionId INT NOT NULL,
  PRIMARY KEY (answerId),
  FOREIGN KEY (questionId) REFERENCES question(questionId)) CHARACTER SET utf8;


-- -----------------------------------------------------
-- Table answertranslate
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS answertranslate(
  answertranslateId INT NOT NULL AUTO_INCREMENT,
  answerId INT NOT NULL,
  answerText VARCHAR(200) NOT NULL,
  languageId INT NOT NULL,
  PRIMARY KEY (answertranslateId),
  FOREIGN KEY (languageId) REFERENCES language(languageId),
  FOREIGN KEY (answerId) REFERENCES answer(answerId)) CHARACTER SET utf8;


-- -----------------------------------------------------
-- Table testquestion
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS testquestion (
  testquestionId INT NOT NULL AUTO_INCREMENT,
  testId INT NOT NULL,
  questionId INT NOT NULL,
  PRIMARY KEY (testquestionId),
  FOREIGN KEY (testId) REFERENCES test(testId),
  FOREIGN KEY (questionId) REFERENCES question(questionId)) CHARACTER SET utf8;

-- -----------------------------------------------------
-- Table result
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS result (
  resultId INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(50) NOT NULL,
  testName VARCHAR(50) NOT NULL,
  subjectName VARCHAR(50) NOT NULL,
  score DOUBLE NOT NULL,
  PRIMARY KEY (resultId),
  FOREIGN KEY (testName) REFERENCES test(testName),
  FOREIGN KEY (subjectName) REFERENCES subject(subjectName),
  FOREIGN KEY (login) REFERENCES user(login)) CHARACTER SET utf8;
