package ua.company.service.service;

import ua.company.persistence.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/**
 * AuthService.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public interface AuthService {
    User registration(String login, String email, String password, String country, String gender);
    User login(String login, String password);
    boolean getAccess(String login, String password);
    Test generateTest(Subject subject);
    HashMap<QuestionTranslate,List<AnswerTranslate>> getQuestionAndAnswer(Test test, Locale locale);
    List findWrongAnswers(HashMap<QuestionTranslate, List<AnswerTranslate>> showQuiz, String[] userAnswers);
    double getScore();
    void writeResult(User user, Test test, double score);
    boolean getUserTypeId(String login);
    TreeMap getResults();
    Subject getSubject(int subjectId);
    void writeTest (List<List<String>> questionsArr, List<String> subjectsArr, List<List<String>> answersEngArr,
                    List<List<String>> answersUkrArr, List<List<String>> isRightArr);
}
