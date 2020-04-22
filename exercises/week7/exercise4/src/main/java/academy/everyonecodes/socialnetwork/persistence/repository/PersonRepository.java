package academy.everyonecodes.socialnetwork.persistence.repository;

import academy.everyonecodes.socialnetwork.persistence.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
