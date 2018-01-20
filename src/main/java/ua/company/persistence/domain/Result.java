package ua.company.persistence.domain;

import java.io.Serializable;

/**
 * Result.java - class for describing quiz results of students.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 12.12.2017
 */
public class Result implements Serializable {
    private long id;
    private double score;
    private String login;
    private String testName;
    private String subjectName;

    /**
     * Constructor for creating new object of entity {@link Result}
     */
    public Result() {
    }

    /**
     * Receive value of filed {@link Result#id}
     *
     * @return id of result entity
     */
    public long getId() {
        return id;
    }

    /**
     * Define field {@link Result#id}
     *
     * @param id - Id of result entity
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Receive value of filed {@link Result#score}
     *
     * @return score of passed quiz
     */
    public double getScore() {
        return score;
    }

    /**
     * Define field {@link Result#score}
     *
     * @param score - score of passed quiz
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * Receive value of filed {@link Result#login}
     *
     * @return login of user that passed quiz
     */
    public String getLogin() {
        return login;
    }

    /**
     * Define field {@link Result#login}
     *
     * @param login - login of user that passed quiz
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Receive value of filed {@link Result#testName}
     *
     * @return name of test which was passed
     */
    public String getTestName() {
        return testName;
    }

    /**
     * Define field {@link Result#testName}
     *
     * @param testName - name of test which was passed
     */
    public void setTestName(String testName) {
        this.testName = testName;
    }

    /**
     * Receive value of filed {@link Result#subjectName}
     *
     * @return subject of test which was passed
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Define field {@link Result#subjectName}
     *
     * @param subjectName - subject of test which was passed
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * Compare two objects by their field {@link Result#id}
     *
     * @param o object for comparison
     * @return true if values are equal and false vice versa
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result that = (Result) o;
        return id == that.id;
    }

    /**
     * Calculate object hash code of this class
     *
     * @return hashcode of object
     */
    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    /**
     * Create string representation of object
     *
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "Perfomance{" +
                ", score=" + score +
                '}';
    }
}
