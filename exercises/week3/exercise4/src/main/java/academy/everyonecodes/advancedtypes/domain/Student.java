package academy.everyonecodes.advancedtypes.domain;

import java.util.Set;

public class Student {

    private String name;
    private Set<String> languages;

    public String getName() {
        return name;
    }

    public Set<String> getLanguages() {
        return languages;
    }

    void setName(String name) {
        this.name = name;
    }

    void setLanguages(Set<String> languages) {
        this.languages = languages;
    }
}
