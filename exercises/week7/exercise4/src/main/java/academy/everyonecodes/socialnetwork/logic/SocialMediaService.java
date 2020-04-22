package academy.everyonecodes.socialnetwork.logic;

import academy.everyonecodes.socialnetwork.communication.dto.PersonDTO;
import academy.everyonecodes.socialnetwork.persistence.domain.Person;
import academy.everyonecodes.socialnetwork.persistence.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SocialMediaService {

    private final PersonRepository personRepository;
    private final PersonTranslator translator;

    public SocialMediaService(PersonRepository personRepository, PersonTranslator translator) {
        this.personRepository = personRepository;
        this.translator = translator;
    }

    public PersonDTO post(PersonDTO personDTO) {
        Person person = translator.translateToPerson(personDTO);
        personRepository.save(person);
        return translator.translateToDTO(person);
    }

    public List<PersonDTO> getAll() {
        List<Person> persons = personRepository.findAll();
        return persons.stream()
                .map(translator::translateToDTO)
                .collect(Collectors.toList());
    }

    public void connect(Long id1, Long id2) {
        if (id1.equals(id2)) {
            return;
        }
        Optional<Person> oPerson1 = personRepository.findById(id1);
        Optional<Person> oPerson2 = personRepository.findById(id2);
        if (oPerson1.isEmpty() && oPerson2.isEmpty()) {
            return;
        }
        makeFriends(oPerson1.get(), oPerson2.get());
        makeFriends(oPerson2.get(), oPerson1.get());
    }

    private void makeFriends(Person person1, Person person2) {
        if (!person1.getFriends().contains(person2)) {
            person1.getFriends().add(person2);
            personRepository.save(person1);
        }
    }

    public void unfriend(Long id1, Long id2) {
        Optional<Person> oPerson1 = personRepository.findById(id1);
        Optional<Person> oPerson2 = personRepository.findById(id2);
        if (oPerson1.isEmpty() && oPerson2.isEmpty()) {
            return;
        }
        Person person1 = oPerson1.get();
        Person person2 = oPerson2.get();
        noMoreFriends(person1, person2);
        noMoreFriends(person2, person1);
    }

    private void noMoreFriends(Person person1, Person person2) {
        person1.getFriends().remove(person2);
        personRepository.save(person1);

    }
}
