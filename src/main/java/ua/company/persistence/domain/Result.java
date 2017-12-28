package ua.company.persistence.domain;

import java.io.Serializable;

/**
 * Perfomance.java - class for describing testing results of students.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 12.12.2017
 */
public class Result implements Serializable {
    private long id;
    private double score;

    public Result() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result that = (Result) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Perfomance{" +
                ", score=" + score +
                '}';
    }
}
