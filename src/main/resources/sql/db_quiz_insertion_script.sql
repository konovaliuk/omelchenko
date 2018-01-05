-- -----------------------------------------------------
-- Database QuizSystem
-- -----------------------------------------------------

USE QuizSystem;

-- -----------------------------------------------------
-- Table usertype
-- -----------------------------------------------------

INSERT INTO usertype(usertype) VALUES('admin'), ('student');

-- -----------------------------------------------------
-- Table user
-- -----------------------------------------------------

INSERT INTO user(login, email, password, country, gender, usertypeId)
VALUES ('admin', 'ruslan.omelchenko.irtcits@gmail.com', 'Rosronaldo1', 'Ukraine', 'male', 1);

INSERT INTO user(login, email, password, country, gender, usertypeId)
VALUES ('einstein', 'albert.einstein@gmail.com', 'Quantum1', 'Germany', 'male', 2);

INSERT INTO user(login, email, password, country, gender, usertypeId)
VALUES ('geits', 'bill.gates@gmail.com', 'Microsoft1', 'USA', 'male', 2);

INSERT INTO user(login, email, password, country, gender, usertypeId)
VALUES ('lovelace', 'ada.lovelace@gmail.com', 'Firstprogram1', 'Great Britain', 'female', 2);

-- -----------------------------------------------------
-- Table subject
-- -----------------------------------------------------

INSERT INTO subject (subjectName)
VALUES ('Classes, methods, types');

INSERT INTO subject (subjectName)
VALUES ('Collections');

INSERT INTO subject (subjectName)
VALUES ('Nested/Inner classes');

INSERT INTO subject (subjectName)
VALUES ('Exceptions');

INSERT INTO subject (subjectName)
VALUES ('All subjects');
-- -----------------------------------------------------
-- Table question
-- -----------------------------------------------------

INSERT INTO question(questionText, subjectId)
VALUES ('���� ���������� ��������� � ������, ������ �� ��� ���� �������������������
�� ������ �������������, ����� ���������� �� ����� ��������� �� ������?', 1);

INSERT INTO question(questionText, subjectId)
VALUES ('����� �� �������� ����������� ������ ���� �������� � ���������� ���� float?', 1);

INSERT INTO question(questionText, subjectId)
VALUES ('���������� ������ ���� ����������� ������ wait � sleep?', 4);

INSERT INTO question(questionText, subjectId)
VALUES ('����� ������������ ����� ����� ���������� ��������� � Java?', 1);

INSERT INTO question(questionText, subjectId)
VALUES ('����� ����������� ����������� ������ Clone ������ Object?', 1);

INSERT INTO question(questionText, subjectId)
VALUES ('����� �� ������ ������ ������� �����������?', 1);

INSERT INTO question(questionText, subjectId)
VALUES ('����� �������� �� ��������� ��������� ���� ���� boolean?', 1);

-- -----------------------------------------------------
-- Table answer
-- -----------------------------------------------------

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('��', 1, 1);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('���', 0, 1);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('�� �����������', 0, 1);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('��', 0, 2);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('���', 1, 2);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('RuntimeException', 0, 3);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('IOException', 0, 3);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('InterruptedException', 1, 3);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('1024 MB', 0, 4);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('1 GB', 0, 4);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('24 �������', 0, 4);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('256 ��������', 0, 4);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('�� ����������', 1, 4);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('Public', 0, 5);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('Private', 0, 5);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('Private package', 0, 5);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('Protected', 1, 5);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('��', 0, 6);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('���', 1, 6);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('��� �������, ���� �� �������� ������ ���� int.', 0, 6);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('0', 0, 7);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('null', 0, 7);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('false', 1, 7);

INSERT INTO answer(answerText, isRight, questionId)
VALUES ('true', 0, 7);

-- -----------------------------------------------------
-- Table test
-- -----------------------------------------------------

INSERT INTO test(testName, timeLimit, subjectId)
VALUES ('test #1', 5, 5);

INSERT INTO test(testName, timeLimit, subjectId)
VALUES ('test #2', 5, 5);

INSERT INTO test(testName, timeLimit, subjectId)
VALUES ('test #3', 5, 5);

-- -----------------------------------------------------
-- Table testquestion
-- -----------------------------------------------------

INSERT INTO testquestion(testId, questionId)
VALUES (1, 1);

INSERT INTO testquestion(testId, questionId)
VALUES (1, 2);

INSERT INTO testquestion(testId, questionId)
VALUES (1, 3);

INSERT INTO testquestion(testId, questionId)
VALUES (1, 4);

INSERT INTO testquestion(testId, questionId)
VALUES (1, 5);

INSERT INTO testquestion(testId, questionId)
VALUES (2, 2);

INSERT INTO testquestion(testId, questionId)
VALUES (2, 3);

INSERT INTO testquestion(testId, questionId)
VALUES (2, 5);

INSERT INTO testquestion(testId, questionId)
VALUES (2, 6);

INSERT INTO testquestion(testId, questionId)
VALUES (2, 7);

INSERT INTO testquestion(testId, questionId)
VALUES (3, 3);

INSERT INTO testquestion(testId, questionId)
VALUES (3, 4);

INSERT INTO testquestion(testId, questionId)
VALUES (3, 5);

INSERT INTO testquestion(testId, questionId)
VALUES (3, 6);

INSERT INTO testquestion(testId, questionId)
VALUES (3, 7);

-- -----------------------------------------------------
-- Table result
-- -----------------------------------------------------

INSERT INTO result (login, testName, subjectName, score)
VALUES ('einstein', 'test #1', 'All subjects',100.0);

INSERT INTO result (login, testName, subjectName, score)
VALUES ('geits', 'test #2', 'All subjects', 90.0);

INSERT INTO result (login, testName, subjectName, score)
VALUES ('geits', 'test #1', 'All subjects', 70.0);

INSERT INTO result (login, testName, subjectName, score)
VALUES ('lovelace', 'test #1', 'All subjects', 70.0);

INSERT INTO result (login, testName, subjectName, score)
VALUES ('geits', 'test #1', 'All subjects', 70.0);

INSERT INTO result (login, testName, subjectName, score)
VALUES ('lovelace', 'test #3', 'All subjects', 80.0);

INSERT INTO result (login, testName, subjectName, score)
VALUES ('einstein', 'test #3', 'All subjects', 90.0);

INSERT INTO result (login, testName, subjectName, score)
VALUES ('einstein', 'test #1', 'All subjects', 80.0);

INSERT INTO result (login, testName, subjectName, score)
VALUES ('geits', 'test #2', 'All subjects', 100.0);

INSERT INTO result (login, testName, subjectName, score)
VALUES ('geits', 'test #2', 'All subjects', 80.0);
