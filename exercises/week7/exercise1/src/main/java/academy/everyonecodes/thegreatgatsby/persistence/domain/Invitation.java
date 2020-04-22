package academy.everyonecodes.thegreatgatsby.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Invitation {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Invitation() {
    }

    public Invitation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
