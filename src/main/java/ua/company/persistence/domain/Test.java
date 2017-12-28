package ua.company.persistence.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Test.java - class for describing entity Test.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 12.12.2017
 */
public class Test implements Serializable{
    private int id;
    private int timeLimit;
    private double averageScore;
    private List questionsArr;
    private List answersArr;



}
