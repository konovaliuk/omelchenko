package ua.company.service.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.company.persistence.domain.*;
import ua.company.persistence.idao.*;
import ua.company.service.exception.NoSuchUserException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;


/**
 * AuthServiceImplTest.java - class for testing service layer
 *
 * @author Ruslan Omelchenko
 * @version 1.0 21.01.2018
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthServiceImplTest {

    private static final String TEST_LOGIN = "test";
    private static final String TEST_EMAIL = "test@test.com";
    private static final String TEST_PASSWORD = "Testtest1";
    private static final String TEST_COUNTRY= "Ukraine";
    private static final String TEST_GENDER = "mail";
    private static final Integer TEST_ID = 1;

    @Mock
    private IUser mockIUser;

    @Mock
    private ITest mockITest;

    @Mock
    private ILanguage mockILanguage;

    @Mock
    private ITestQuestion mockITestQuestion;

    @Mock
    private IAnswer mockIAnswer;

    @Mock
    private IAnswerTranslate mockIAnswerTranslate;

    @Mock
    private IResult mockIResult;

    @Mock
    private IUserType mockIUserType;

    @Mock
    private ISubject mockISubject;

    @Test
    public void positiveRegistrationScenario() {
        User user = new User();
        when(mockIUser.insertUser(TEST_LOGIN, TEST_EMAIL, TEST_PASSWORD, TEST_COUNTRY, TEST_GENDER,
                TEST_ID)).thenReturn(user);
    }

    @Test
    public void positiveLoginScenario() throws NoSuchUserException {
        User user = new User();
        when(mockIUser.getUserByLoginAndPass(TEST_LOGIN, TEST_PASSWORD)).thenReturn(user);
    }

    @Test
    public void positiveGetAccessScenario() {
        User user = new User();
        when(mockIUser.getUserByLoginAndPass(TEST_LOGIN, TEST_PASSWORD)).thenReturn(user);
    }


    @Test
    public void positiveGenerateTestScenario() {
        ua.company.persistence.domain.Test test = new ua.company.persistence.domain.Test();
        when(mockITest.getTestById(TEST_ID)).thenReturn(test);
        when(mockITest.getTestBySubjectId(TEST_ID, TEST_ID)).thenReturn(test);
        when(mockITest.getTestQuantity()).thenReturn(TEST_ID);
        when(mockITest.getTestQuantity(TEST_ID)).thenReturn(TEST_ID);
    }

    @Test
    public void positiveGetQuestionAndAnswerScenario() {
        List <QuestionTranslate> questionsTranslate = new ArrayList<>();
        List <AnswerTranslate> answerTranslate = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();
        when(mockILanguage.getIdByName(anyString())).thenReturn(TEST_ID);
        when(mockITestQuestion.getQuestionByTestId(TEST_ID, TEST_ID)).thenReturn(questionsTranslate);
        when(mockIAnswer.getAnswerByQuestionId(TEST_ID)).thenReturn(answers);
        when(mockIAnswerTranslate.getAnswerTranslateByAnswerIdAndLanguageId(answers, TEST_ID)).
                thenReturn(answerTranslate);
    }

    @Test
    public void positiveFindWrongAnswersScenario() {
        Answer answer = new Answer();
        when(mockIAnswer.getAnswerById(TEST_ID)).thenReturn(answer);
    }

    @Test
    public void positiveWriteResultScenario() {
        User user = new User();
        ua.company.persistence.domain.Test test = new ua.company.persistence.domain.Test();
        double score=100;
        when(mockIResult.insertResult(user, test, score)).thenReturn(true);
        user = null;
        assertEquals(mockIResult.insertResult(user, test, score), false);
    }

    @Test
    public void positiveGetUserTypeIdScenario() {
        when(mockIUser.getUserTypeIdByLogin(TEST_LOGIN)).thenReturn(TEST_ID);
    }

    @Test
    public void positiveGetResultsScenario() {
        List<Result> results = new ArrayList<>();
        when(mockIResult.getResults()).thenReturn(results);

    }

    @Test
    public void positiveGetSubjectScenario() {
        Subject subject = new Subject();
        when(mockISubject.getSubjectById(TEST_ID)).thenReturn(subject);
    }
}
