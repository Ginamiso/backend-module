package academy.everyonecodes.socialnetwork.logic;

import academy.everyonecodes.socialnetwork.communication.dto.PersonDTO;
import academy.everyonecodes.socialnetwork.persistence.domain.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class PersonTranslator {

    public PersonDTO translateToDTO(Person person) {
        return new PersonDTO(
                person.getId(),
                person.getName(),
                person.getFriends()
                        .stream()
                        .map(Person::getName)
                        .collect(Collectors.toList()));

    }

    public Person translateToPerson(PersonDTO personDTO) {
        return new Person(personDTO.getName(), new ArrayList<>());
    }
}
