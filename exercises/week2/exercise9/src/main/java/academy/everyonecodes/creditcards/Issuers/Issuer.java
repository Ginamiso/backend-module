package academy.everyonecodes.creditcards.Issuers;

import java.util.Set;

public class Issuer {

    private String name;
    private Set<String> startsWith;
    private Set<Integer> lengths;

    public Issuer(String name, Set<String> startsWith, Set<Integer> lengths) {
        this.name = name;
        this.startsWith = startsWith;
        this.lengths = lengths;
    }

    public Issuer() {
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    void setStartsWith(Set<String> startsWith) {
        this.startsWith = startsWith;
    }

    void setLengths(Set<Integer> lengths) {
        this.lengths = lengths;
    }

    public boolean issues(String number) {
        return lengths.contains(number.length()) &&
                startsWith.stream()
                        .anyMatch(number::startsWith);
    }
}
