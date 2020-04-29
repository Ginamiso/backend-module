package academy.everyonecodes.socialnetwork.logic;

import academy.everyonecodes.socialnetwork.communication.dto.PersonDTO;
import academy.everyonecodes.socialnetwork.persistence.domain.Person;
import academy.everyonecodes.socialnetwork.persistence.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class SocialMediaServiceTest {

    @Autowired
    SocialMediaService service;

    @MockBean
    PersonRepository repository;

    @MockBean
    PersonTranslator translator;

    Long id1 = 1L;
    Long id2 = 2L;

    Person person1 = new Person(id1,"name1", new ArrayList<>());
    Person person2 = new Person(id2,"name2", new ArrayList<>());

    @Test
    void post() {
        PersonDTO personDTO = new PersonDTO("name");
        when(translator.translateToPerson(personDTO))
                .thenReturn(person1);

        service.post(personDTO);

        verify(translator).translateToPerson(personDTO);
        verify(repository).save(person1);
        verify(translator).translateToDTO(person1);
    }

    @Test
    void getAll() {
        List<Person> persons = List.of(person1, person2);
        when(repository.findAll())
                .thenReturn(persons);

        service.getAll();

        verify(repository).findAll();
        verify(translator, times(persons.size())).translateToDTO(any(Person.class));
    }

    @Test
    void friendFindsBothPersons() {
        when(repository.findById(id1))
                .thenReturn(Optional.of(person1));
        when(repository.findById(id2))
                .thenReturn(Optional.of(person2));

        service.connect(id1, id2);

        verify(repository).findById(id1);
        verify(repository).findById(id2);
        verify(repository).save(new Person(id1,"name1", List.of(person2)));
        verify(repository).save(new Person(id2,"name2", List.of(person1)));
    }

    @Test
    void unfriendFindsBothPersons() {
        Person personFriends1 = new Person(id1, "name1", new ArrayList<>(List.of(person2)));
        Person personFriends2 = new Person(id2, "name2", new ArrayList<>(List.of(person1)));

        when(repository.findById(id1))
                .thenReturn(Optional.of(personFriends1));
        when(repository.findById(id2))
                .thenReturn(Optional.of(personFriends2));

        service.unfriend(id1, id2);

        verify(repository).findById(id1);
        verify(repository).findById(id2);
        verify(repository).save(person1);
        verify(repository).save(person2);

    }

    @ParameterizedTest
    @MethodSource("parameters")
    void friendDoesNotFindPersons(Optional<Person> oPerson1, Optional<Person> oPerson2) {
        when(repository.findById(id1))
                .thenReturn(oPerson1);
        when(repository.findById(id2))
                .thenReturn(oPerson2);
        service.connect(id1, id2);

        verify(repository).findById(id1);
        verify(repository).findById(id2);
        verifyNoMoreInteractions(repository);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void unfriendDoesNotFindPersons(Optional<Person> oPerson1, Optional<Person> oPerson2) {
        when(repository.findById(id1))
                .thenReturn(oPerson1);
        when(repository.findById(id2))
                .thenReturn(oPerson2);

        service.unfriend(id1, id2);

        verify(repository).findById(id1);
        verify(repository).findById(id2);
        verifyNoMoreInteractions(repository);
    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(Optional.empty(), Optional.empty()),
                Arguments.of(Optional.empty(), Optional.of(new Person("name"))),
                Arguments.of(Optional.of(new Person("name")), Optional.empty())
        );
    }
}