

# Quiz system

System of students' fast quiz. Student can registered by e-mail, he has his perfomance and after complete test he receives e-mail about test result. There is a catalog by subjects available in the system. Authorized student can pass tests. 	After finish test form with errors of student will be shown. All data about perfomance and passed courses are displayed on the page of administrator as summary table by all Students. (Variant #12).

# Prerequisits

The application requires:
    JDK 1.8
    Maven 4.0.0 
    MySql 5.5.23
    Apache Tomcat 7.0.82
    phpMyAdmin 4.7.7
    Denwer
    
# Installation

Build war-archive with the application:
mvn clean package

# How to run

To clone and run this application, you'll need Git installed on your computer. 
From your command line:

## Clone this repository
$ git clone https://github.com/rosrossito/QuizSystem.git

## Go into the repository
$ cd .../QuizSystem

## Install dependencies
$ mvn clean package

## Run the app
Run Denwer
Run phpMyAdmin and execute sql scripts
Run Apache Tomcat
Run browser and type in address bar http://localhost:8080/Testing/index.jsp

# Authors

Ruslan Omelchenko - https://github.com/rosrossito/QuizSystem.
