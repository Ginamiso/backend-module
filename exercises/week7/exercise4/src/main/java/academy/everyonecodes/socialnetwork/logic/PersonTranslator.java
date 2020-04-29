package academy.everyonecodes.socialnetwork.logic;

import academy.everyonecodes.socialnetwork.communication.dto.PersonDTO;
import academy.everyonecodes.socialnetwork.persistence.domain.Person;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

@Service
public class PersonTranslator {

    public PersonDTO translateToDTO(Person person) {
        return new PersonDTO(
                person.getId(),
                person.getName(),
                person.getFriends()
                        .stream()
                        .map(Person::getName)
                        .collect(toList()));

    }

    public Person translateToPerson(PersonDTO personDTO) {
        return new Person(personDTO.getName());
    }
}
