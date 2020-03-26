package academy.everyonecodes.advancedtypes.domain;

import java.util.Set;

public class CommunityEvent {

    private String name;
    private String location;
    private Set<Student> students;

    void setName(String name) {
        this.name = name;
    }

    void setLocation(String location) {
        this.location = location;
    }

    void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Set<Student> getStudents() {
        return students;
    }
}
