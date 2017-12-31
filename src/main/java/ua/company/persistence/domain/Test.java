package ua.company.persistence.domain;

import java.io.Serializable;

/**
 * Test.java - class for describing entity Test.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 12.12.2017
 */
public class Test implements Serializable{
    private int testId;
    private String testName;
    private int timeLimit;
    private int subjectId;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}
