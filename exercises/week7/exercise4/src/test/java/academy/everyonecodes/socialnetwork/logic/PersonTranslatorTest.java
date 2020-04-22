package academy.everyonecodes.socialnetwork.logic;

import academy.everyonecodes.socialnetwork.communication.dto.PersonDTO;
import academy.everyonecodes.socialnetwork.persistence.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTranslatorTest {

    PersonTranslator translator = new PersonTranslator();

    @Test
    void translateToDTO() {
        Person person = new Person(1L, "name", List.of(new Person("name")));
        PersonDTO expected = new PersonDTO(1L, "name", List.of("name"));

        PersonDTO result = translator.translateToDTO(person);

        assertEquals(expected, result);
    }
}