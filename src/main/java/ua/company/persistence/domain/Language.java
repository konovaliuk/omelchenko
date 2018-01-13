package ua.company.persistence.domain;

/**
 * Language.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class Language {
    private int languageId;
    private String name;

    public Language() {
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
