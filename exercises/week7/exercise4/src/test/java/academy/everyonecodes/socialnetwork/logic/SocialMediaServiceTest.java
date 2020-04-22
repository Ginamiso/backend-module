package academy.everyonecodes.socialnetwork.logic;

import academy.everyonecodes.socialnetwork.communication.dto.PersonDTO;
import academy.everyonecodes.socialnetwork.persistence.domain.Person;
import academy.everyonecodes.socialnetwork.persistence.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class SocialMediaServiceTest {

    @Autowired
    SocialMediaService service;

    @MockBean
    PersonRepository repository;

    @SpyBean
    PersonTranslator translator;

    Person savedPerson = new Person(1L, "name", new ArrayList<>());
    PersonDTO expectedDTO = new PersonDTO(1L, "name", new ArrayList<>());

    Long id1 = 1L;
    Long id2 = 2L;
    Person person1 = new Person(id1, "test1", new ArrayList<>());
    Person person2 = new Person(id2, "test2", new ArrayList<>());

    @Test
    void post() {
        PersonDTO personDTO = new PersonDTO("name");
        Person person = new Person("name", new ArrayList<>());

        service.post(personDTO);

        verify(repository).save(person);
        verify(translator).translateToPerson(personDTO);
    }

    @Test
    void getAll() {
        List<Person> persons = List.of(savedPerson);
        List<PersonDTO> expected = List.of(expectedDTO);
        when(repository.findAll())
                .thenReturn(persons);

        List<PersonDTO> result = service.getAll();

        assertEquals(expected, result);

        verify(repository).findAll();
        verify(translator,times(persons.size())).translateToDTO(savedPerson);

    }

    @Test
    void connectFindsPerson() {
        assertTrue(person1.getFriends().isEmpty());
        assertTrue((person2.getFriends().isEmpty()));

        when(repository.findById(id1))
                .thenReturn(Optional.of(person1));
        when(repository.findById(id2))
                .thenReturn(Optional.of(person2));

        service.connect(id1, id2);

        assertEquals(person2, person1.getFriends().get(0));
        assertEquals(person1, person2.getFriends().get(0));
        verify(repository).findById(id1);
        verify(repository).findById(id2);
        verify(repository).save(person1);
        verify(repository).save(person2);
    }
    @Test
    void connectDoesNotFindAnyPerson(){
        when(repository.findById(id1))
                .thenReturn(Optional.empty());
        when(repository.findById(id2))
                .thenReturn(Optional.empty());
        service.connect(id1, id2);

        verify(repository).findById(id1);
        verify(repository).findById(id2);
        verify(repository, never()).save(person1);
    }

    @Test
    void unfriendFindsPerson() {
        Person person1 = new Person(id1, "test1", new ArrayList<>());
        Person person2 = new Person(id2, "test2", new ArrayList<>());
        person1.getFriends().add(person2);
        person2.getFriends().add(person1);

        when(repository.findById(id1))
                .thenReturn(Optional.of(person1));
        when(repository.findById(id2))
                .thenReturn(Optional.of(person2));

        service.unfriend(id1, id2);

        assertTrue(person1.getFriends().isEmpty());
        assertTrue(person2.getFriends().isEmpty());

        verify(repository).findById(id1);
        verify(repository).findById(id2);
        verify(repository).save(person1);
        verify(repository).save(person2);

    }
    @Test
    void unfriendDoesNotFindAnyPerson(){
        when(repository.findById(id1))
                .thenReturn(Optional.empty());
        when(repository.findById(id2))
                .thenReturn(Optional.empty());

        service.unfriend(id1, id2);

        verify(repository).findById(id1);
        verify(repository).findById(id2);
        verify(repository, never()).save(person1);
    }
}