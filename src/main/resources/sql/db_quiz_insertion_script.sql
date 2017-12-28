USE QuizSystem;
INSERT INTO usertype(usertype) VALUES('admin'), ('student');

INSERT INTO user(login, email, password, country, gender, usertypeId)
VALUES ('admin', 'ruslan.omelchenko.irtcits@gmail.com', 'rosronaldo', 'Ukraine', 'male', 1);

INSERT INTO user(login, email, password, country, gender, usertypeId)
VALUES ('einstein', 'albert.einstein@gmail.com', 'quantum', 'Germany', 'male', 2);

INSERT INTO user(login, email, password, country, gender, usertypeId)
VALUES ('geits', 'bill.gates@gmail.com', 'microsoft', 'USA', 'male', 2);

INSERT INTO user(login, email, password, country, gender, usertypeId)
VALUES ('lovelace', 'ada.lovelace@gmail.com', 'firstprogram', 'Great Britain', 'female', 2);


