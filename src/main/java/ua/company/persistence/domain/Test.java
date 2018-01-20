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

    /**
     * Constructor for creating new object of entity {@link Test}
     */
    public Test() {
    }

    /**
     * Receive value of filed {@link Test#testId}
     *
     * @return test Id
     */
    public int getTestId() {
        return testId;
    }

    /**
     * Define field {@link Test#testId}
     *
     * @param testId - test Id
     */
    public void setTestId(int testId) {
        this.testId = testId;
    }

    /**
     * Receive value of filed {@link Test#testName}
     *
     * @return name of test
     */
    public String getTestName() {
        return testName;
    }

    /**
     * Define field {@link Test#testName}
     *
     * @param testName - name of test
     */
    public void setTestName(String testName) {
        this.testName = testName;
    }

    /**
     * Receive value of filed {@link Test#timeLimit}
     *
     * @return limit of time per this quiz
     */
    public int getTimeLimit() {
        return timeLimit;
    }

    /**
     * Define field {@link Test#timeLimit}
     *
     * @param timeLimit - limit of time per this quiz
     */
    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    /**
     * Receive value of filed {@link Test#subjectId}
     *
     * @return id of subject
     */
    public int getSubjectId() {
        return subjectId;
    }

    /**
     * Define field {@link Test#subjectId}
     *
     * @param subjectId - subject Id
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * Compare two objects by their field {@link Test#testId}
     *
     * @param o object for comparison
     * @return true if values are equal and false vice versa
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        return testId == test.testId;

    }

    /**
     * Calculate object hash code of this class
     *
     * @return hashcode of object
     */
    @Override
    public int hashCode() {
        return (testId ^ (testId >>> 32));
    }

    /**
     * Create string representation of object
     *
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", testName='" + testName + '\'' +
                ", timeLimit=" + timeLimit +
                ", subjectId=" + subjectId +
                '}';
    }
}
