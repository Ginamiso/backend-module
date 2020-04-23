package academy.everyonecodes.socialnetwork.persistence.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Person> friends;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, List<Person> friends) {
        this.name = name;
        this.friends = friends;
    }

    public Person(Long id, String name, List<Person> friends) {
        this.id = id;
        this.name = name;
        this.friends = friends;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, friends);
    }

}
