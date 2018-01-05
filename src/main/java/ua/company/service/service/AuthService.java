package ua.company.service.service;

import ua.company.persistence.domain.Answer;
import ua.company.persistence.domain.Question;
import ua.company.persistence.domain.Test;
import ua.company.persistence.domain.User;

import java.util.HashMap;
import java.util.List;

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
    Test generateTest();
    HashMap<Question,List<Answer>> getQuestionAndAnswer(Test test);
    List findWrongAnswers(HashMap<Question, List<Answer>> quiz, String[] userAnswers);
    double getScore();
    void writeResult(User user, Test test, double score);
    boolean getUserTypeId(String login);
    HashMap getResults();
}
