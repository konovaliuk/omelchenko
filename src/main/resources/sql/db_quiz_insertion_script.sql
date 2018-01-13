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

INSERT INTO user(login, email, password, country, gender, usertypeId)
VALUES ('Stepanenko O.', 'stepanenko@gmail.com', 'Stepanenko1', 'Ukraine', 'male', 2);

INSERT INTO user(login, email, password, country, gender, usertypeId)
VALUES ('Petrenko.V', 'petrenko@gmail.com', 'Petrenko1', 'Ukraine', 'female', 2);
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
-- Table test
-- -----------------------------------------------------

INSERT INTO test(testName, timeLimit, subjectId)
VALUES ('test #1', 5, 5);

INSERT INTO test(testName, timeLimit, subjectId)
VALUES ('test #2', 5, 5);

INSERT INTO test(testName, timeLimit, subjectId)
VALUES ('test #3', 5, 5);

INSERT INTO test(testName, timeLimit, subjectId)
VALUES ('test #4', 5, 1);

INSERT INTO test(testName, timeLimit, subjectId)
VALUES ('test #5', 5, 2);

INSERT INTO test(testName, timeLimit, subjectId)
VALUES ('test #6', 5, 4);

INSERT INTO test(testName, timeLimit, subjectId)
VALUES ('test #7', 5, 5);

-- -----------------------------------------------------
-- Table language
-- -----------------------------------------------------

INSERT INTO language(name)
VALUES ('uk');

INSERT INTO language(name)
VALUES ('en');


-- -----------------------------------------------------
-- Table question
-- -----------------------------------------------------

INSERT INTO question(subjectId)
VALUES (1);

INSERT INTO question(subjectId)
VALUES (1);

INSERT INTO question(subjectId)
VALUES (1);

INSERT INTO question(subjectId)
VALUES (2);

INSERT INTO question(subjectId)
VALUES (2);

INSERT INTO question(subjectId)
VALUES (1);

INSERT INTO question(subjectId)
VALUES (2);

INSERT INTO question(subjectId)
VALUES (1);

INSERT INTO question(subjectId)
VALUES (2);

INSERT INTO question(subjectId)
VALUES (2);

INSERT INTO question(subjectId)
VALUES (4);

INSERT INTO question(subjectId)
VALUES (4);

INSERT INTO question(subjectId)
VALUES (4);

INSERT INTO question(subjectId)
VALUES (4);

INSERT INTO question(subjectId)
VALUES (4);

INSERT INTO question(subjectId)
VALUES (1);

INSERT INTO question(subjectId)
VALUES (1);

INSERT INTO question(subjectId)
VALUES (1);

INSERT INTO question(subjectId)
VALUES (1);

-- -----------------------------------------------------
-- Table questiontranslate
-- -----------------------------------------------------

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (1, '������� ��������� ����������:', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (1, 'Choose right statement:', 2);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (2, '�� ����� ������������ �� ����� java.lang.Math?', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (2, 'Is it possible to extends java.lang.Math class?', 2);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (3, '�� ����� � ����������� ���������� return ��������� ��������?', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (3, 'Is it possible to return value in constructor?', 2);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (4, '� ��� �������� ����� �������� �������� ����-����� ����?', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (4, 'In what collection can you add items of any type?', 2);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (5, '�� ���� �������� ������������� ArrayList ��� ����������� � ����������� �����?', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (5, 'Can ArrayList dynamically expand if the size is determined in the constructor?', 2);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (6, '�� �������� ����� contains � ���� Hashtable?', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (6, 'What checks method contains in Hashtable class?', 2);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (7, '������� ������� �������� ����������:', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (7, 'Choose the most appropriate statement:', 2);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (8, '�� ������ ����� insert(int offset, boolean b) ������ String?', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (8, 'What does the insert(int offset, boolean b) method from class String do?', 2);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (9, '������� ������, �� ������ ArrayList', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (9, 'Choose the methods which are available in ArraList', 2);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (10, '���� ����� �������� ���-���� ������ � ���� IdentityHashMap?', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (10, 'Which method calculates the key hash codes in the IdentityHashMap class?', 2);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (11, '���������� ����� ���� ��������� ������ wait �� sleep?', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (11, 'What type of exception is thrown by methods wait and sleep?', 2);


INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (12, '���������� ����� ���� ������ ����� read?', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (12, 'What type of exception is thrown by method read?', 2);


INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (13, '�� ��������� ���������� InterruptedException ������ yield �� notify?', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (13, 'Do methods yield �� notify throws InterruptedException?', 2);


INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (14, '�� � ���������� MyException1 checked, ���� ���� ���������� �� Exception?', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (14, 'Is MyException1 checked if it is inherited from Exception?', 2);


INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (15, '�� ����� ������ float �� ���� ArithmeticException?', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (15, 'Will division float by 0 lead to ArithmeticException?', 2);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (16, '���� ����� ��������� � �����, �� ������� ���� ���� ��������������
�� ����� ������������, ��� ��������� �� ����� ����������� ��� �������?', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (16, 'If variable is declared in method, sould this variable be initialized before using
in order compiller will not throw message about error?', 2);


INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (17, '�� ���� �������� �������� ����� ���� ����������� �� ����� ���� float?', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (17, 'Could operator >> be applied to float variable?', 2);


INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (18, '��� ����������� ������� ����� � Java?', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (18, 'What maximum length of variable in Java?', 2);


INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (19, '���� ����������� ������� ������ Clone ����� Object?', 1);

INSERT INTO questiontranslate(questionId, questionText, languageId)
VALUES (19, 'What access modifier of method Clone in Object class?', 2);


-- -----------------------------------------------------
-- Table answer
-- -----------------------------------------------------

INSERT INTO answer(isRight, questionId)
VALUES (1, 1);

INSERT INTO answer(isRight, questionId)
VALUES (0, 1);

INSERT INTO answer(isRight, questionId)
VALUES (0, 1);


INSERT INTO answer(isRight, questionId)
VALUES (0, 2);

INSERT INTO answer(isRight, questionId)
VALUES (1, 2);


INSERT INTO answer(isRight, questionId)
VALUES (1, 3);

INSERT INTO answer(isRight, questionId)
VALUES (0, 3);


INSERT INTO answer(isRight, questionId)
VALUES (0, 4);

INSERT INTO answer(isRight, questionId)
VALUES (1, 4);

INSERT INTO answer(isRight, questionId)
VALUES (0, 4);


INSERT INTO answer(isRight, questionId)
VALUES (0, 5);

INSERT INTO answer(isRight, questionId)
VALUES (1, 5);


INSERT INTO answer(isRight, questionId)
VALUES (0, 6);

INSERT INTO answer(isRight, questionId)
VALUES (0, 6);

INSERT INTO answer(isRight, questionId)
VALUES (1, 6);


INSERT INTO answer(isRight, questionId)
VALUES (1, 7);

INSERT INTO answer(isRight, questionId)
VALUES (0, 7);


INSERT INTO answer(isRight, questionId)
VALUES (0, 8);

INSERT INTO answer(isRight, questionId)
VALUES (1, 8);

INSERT INTO answer(isRight, questionId)
VALUES (0, 8);


INSERT INTO answer(isRight, questionId)
VALUES (1, 9);

INSERT INTO answer(isRight, questionId)
VALUES (1, 9);

INSERT INTO answer(isRight, questionId)
VALUES (0, 9);


INSERT INTO answer(isRight, questionId)
VALUES (1, 10);

INSERT INTO answer(isRight, questionId)
VALUES (0, 10);

INSERT INTO answer(isRight, questionId)
VALUES (0, 11);

INSERT INTO answer(isRight, questionId)
VALUES (0, 11);

INSERT INTO answer(isRight, questionId)
VALUES (1, 11);


INSERT INTO answer(isRight, questionId)
VALUES (0, 12);

INSERT INTO answer(isRight, questionId)
VALUES (1, 12);

INSERT INTO answer(isRight, questionId)
VALUES (0, 12);


INSERT INTO answer(isRight, questionId)
VALUES (1, 13);

INSERT INTO answer(isRight, questionId)
VALUES (0, 13);


INSERT INTO answer(isRight, questionId)
VALUES (0, 14);

INSERT INTO answer(isRight, questionId)
VALUES (1, 14);

INSERT INTO answer(isRight, questionId)
VALUES (0, 14);


INSERT INTO answer(isRight, questionId)
VALUES (0, 15);

INSERT INTO answer(isRight, questionId)
VALUES (1, 15);

INSERT INTO answer(isRight, questionId)
VALUES (1, 16);

INSERT INTO answer(isRight, questionId)
VALUES (0, 16);

INSERT INTO answer(isRight, questionId)
VALUES (0, 16);


INSERT INTO answer(isRight, questionId)
VALUES (0, 17);

INSERT INTO answer(isRight, questionId)
VALUES (1, 17);


INSERT INTO answer(isRight, questionId)
VALUES (0, 18);

INSERT INTO answer(isRight, questionId)
VALUES (0, 18);

INSERT INTO answer(isRight, questionId)
VALUES (0, 18);

INSERT INTO answer(isRight, questionId)
VALUES (0, 18);

INSERT INTO answer(isRight, questionId)
VALUES (1, 18);


INSERT INTO answer(isRight, questionId)
VALUES (0, 19);

INSERT INTO answer(isRight, questionId)
VALUES (0, 19);

INSERT INTO answer(isRight, questionId)
VALUES (0, 19);

INSERT INTO answer(isRight, questionId)
VALUES (1, 19);

-- -----------------------------------------------------
-- Table answertranslate
-- -----------------------------------------------------


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (1, '����� intern () � ���, ���� ����� ���� � ��� �����, ���� ���� ���� � ������� ��������� �� ��� �����.', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (1, 'When the intern method is invoked, if the pool do not contain a string equal to this String object, this String object is added to the pool and a reference to this String object is returned.', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (2, '������� true ���, � ����� ���, ���� length() ������� 0.', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (2, 'Returns true if, and only if, length() is 0.', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (3, '���� ����� � ����������� ����� �� ��������� charset ��������� �� �������������, ��������� ��������� � ����� ����� �����.', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (3, 'Encodes this String into a sequence of bytes using the platforms default charset, storing the result into a new byte array.', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (4, '���, �����.', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (4, 'Yes, it is possible', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (5, '���� java.lang.Math ���������� �� final, ����� ������������ �� ����� �������.', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (5, 'The class java.lang.Math is declared as final, that is, it can not be inherited from it.', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (6, '� ����������� � �������� return �� ����������� ��������� ��������, �� �����������.', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (6, 'In the constructor it is not allowed to specify a return value in the return statement.', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (7, '� ����������� ����� ���������� return ����� ��������� ��������.', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (7, 'In the class constructor, the return operator can return the value.', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (8, 'List<Double> b = new ArrayList()', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (8, 'List<Double> b = new ArrayList()', 2);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (9, 'a = new ArrayList<Double>()', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (9, 'a = new ArrayList<Double>()', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (10, '����� � ������� �� �����.', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (10, 'None of the options is correct.', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (11, 'ͳ.', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (11, 'No', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (12, '���', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (12, 'Yes', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (13, '�������� �������� ������� � ������ keys', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (13, 'Check the presence of values in the keys list', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (14, '�������� �������� ������� � ���� Hashtable', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (14, 'Check the presence of values in Hashtable class', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (15, '�������� �������� ������� � ������ values', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (15, 'Check the presence of values in the values list', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (16, 'WeakHashMap ������ ���� "������ ��������� �� ���� - ��������"', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (16, 'WeakHashMap contain "week reference on key - value" pairs', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (17, 'WeakHashMap ������ ���� "���� - ��������"', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (17, 'WeakHashMap contain "key-value" pairs', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (18, '�������� �������� ������������� �������� ��������� � �� �����������', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (18, 'Inserts the string representation of the boolean argument into this sequence.', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (19, '����� String � immutable �� �� ������ ����� insert()', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (19, 'The String class is immutable and does not contain method insert()', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (20, '�������� �������� ������������� char ��������� � �� �����������.', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (20, 'Inserts the string representation of the char argument into this sequence.', 2);



INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (21, 'add()', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (21, 'add()', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (22, 'remove()', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (22, 'remove()', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (23, 'push()', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (23, 'push()', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (24, 'System.identityHashCode()', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (24, 'System.identityHashCode()', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (25, 'hashCode()', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (25, 'hashCode()', 2);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (26, 'RuntimeException', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (26, 'RuntimeException', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (27, 'IOException', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (27, 'IOException', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (28, 'InterruptedException', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (28, 'InterruptedException', 2);



INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (29, 'RuntimeException', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (29, 'RuntimeException', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (30, 'IOException', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (30, 'IOException', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (31, 'InterruptedException', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (31, 'InterruptedException', 2);



INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (32, 'ͳ.', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (32, 'No', 2);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (33, '���', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (33, 'Yes', 2);



INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (34, 'ͳ.', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (34, 'No', 2);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (35, '���', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (35, 'Yes', 2);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (35, 'MyException1 �� ���� ������������ �� Exception', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (35, 'MyException1 can not be inherited from Exception', 2);



INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (36, '���', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (36, 'Yes', 2);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (37, 'ͳ.', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (37, 'No', 2);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (38, '���', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (38, 'Yes', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (39, 'ͳ', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (39, 'No', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (40, '�� ����������', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (40, 'Not necessarily', 2);



INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (41, '���', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (41, 'Yes', 2);


INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (42, 'ͳ', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (42, 'No', 2);



INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (43, '1024 MB', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (43, '1024 MB', 2);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (44, '1 GB', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (44, '1 GB', 2);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (45, '24 �������', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (45, '24 symbols', 2);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (46, '256 �������', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (46, '256 symbols', 2);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (47, '�� ��������', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (47, 'Not limited', 2);



INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (48, 'Public', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (48, 'Public', 2);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (49, 'Private', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (49, 'Private', 2);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (50, 'Private package', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (50, 'Private package', 2);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (51, 'Protected', 1);

INSERT INTO answertranslate(answerId, answerText, languageId)
VALUES (51, 'Protected', 2);
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
VALUES (3, 8);

INSERT INTO testquestion(testId, questionId)
VALUES (4, 1);

INSERT INTO testquestion(testId, questionId)
VALUES (4, 2);

INSERT INTO testquestion(testId, questionId)
VALUES (4, 3);

INSERT INTO testquestion(testId, questionId)
VALUES (4, 6);

INSERT INTO testquestion(testId, questionId)
VALUES (4, 8);


INSERT INTO testquestion(testId, questionId)
VALUES (5, 4);

INSERT INTO testquestion(testId, questionId)
VALUES (5, 5);

INSERT INTO testquestion(testId, questionId)
VALUES (5, 7);

INSERT INTO testquestion(testId, questionId)
VALUES (5, 9);

INSERT INTO testquestion(testId, questionId)
VALUES (5, 10);


INSERT INTO testquestion(testId, questionId)
VALUES (6, 11);

INSERT INTO testquestion(testId, questionId)
VALUES (6, 12);

INSERT INTO testquestion(testId, questionId)
VALUES (6, 13);

INSERT INTO testquestion(testId, questionId)
VALUES (6, 14);

INSERT INTO testquestion(testId, questionId)
VALUES (6, 15);


INSERT INTO testquestion(testId, questionId)
VALUES (7, 12);

INSERT INTO testquestion(testId, questionId)
VALUES (7, 16);

INSERT INTO testquestion(testId, questionId)
VALUES (7, 17);

INSERT INTO testquestion(testId, questionId)
VALUES (7, 18);

INSERT INTO testquestion(testId, questionId)
VALUES (7, 19);

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

INSERT INTO result (login, testName, subjectName, score)
VALUES ('admin', 'test #2', 'All subjects', 80.0);

INSERT INTO result (login, testName, subjectName, score)
VALUES ('admin', 'test #1', 'All subjects', 60.0);

INSERT INTO result (login, testName, subjectName, score)
VALUES ('admin', 'test #3', 'All subjects', 80.0);

