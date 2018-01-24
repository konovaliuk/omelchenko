

# Quiz system

System of students' fast quiz. Student can registered by e-mail, he has his perfomance and after complete test he receives e-mail about test result. There is a catalog by subjects available in the system. Authorized student can pass tests. 	After finish test form with errors of student will be shown. All data about perfomance and passed courses are displayed on the page of administrator as summary table by all Students.

# Prerequisits

The application requires:
* Java 8 or higher version
* Apache Maven 4.0.0
* MySql 5.5.23
* Apache Tomcat 7.0.82
* phpMyAdmin 4.7.7
* Denwer 3
    
# Installation

## Clone this repository
$ git clone https://github.com/rosrossito/QuizSystem.git

## Go into the repository
$ cd .../QuizSystem

## Build war-archive with the application:
$ mvn clean package

# How to run

* Run Denwer local server
* Run phpMyAdmin and execute sql scripts db_quiz_creation_script.sql and then db_quiz_insertion.sql from the
directory "src/resources/sql" of the project.
* Run Apache Tomcat server
* Run browser and type in address bar http://localhost:8080/Testing/index.jsp

# Authors

Ruslan Omelchenko - https://github.com/rosrossito/QuizSystem.
