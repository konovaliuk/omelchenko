package ua.company.persistence.domain;

import java.io.Serializable;

/**
 * Language.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class Language implements Serializable{
    private int languageId;
    private String name;

    /**
     * Constructor for creating new object of entity {@link Language}
     */
    public Language() {
    }

    /**
     * Receive value of filed {@link Language#languageId}
     *
     * @return language Id
     */
    public int getLanguageId() {
        return languageId;
    }

    /**
     * Define field {@link Language#languageId}
     *
     * @param languageId - language Id
     */
    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    /**
     * Receive value of filed {@link Language#name}
     *
     * @return name of language
     */
    public String getName() {
        return name;
    }

    /**
     * Define field {@link Language#name}
     *
     * @param name - name of language
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Compare two objects by their field {@link Language#languageId}
     *
     * @param o object for comparison
     * @return true if values are equal and false vice versa
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Language language = (Language) o;

        return languageId == language.languageId;

    }

    /**
     * Calculate object hash code of this class
     *
     * @return hashcode of object
     */
    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * Create string representation of object
     *
     * @return string representation of object
     */
    @Override
    public int hashCode() {
        return (languageId ^ (languageId >>> 32));
    }
}
