package academy.everyonecodes.thefinalcountdown.persistence.repository;

import academy.everyonecodes.thefinalcountdown.persistence.domain.Countdown;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountdownRepository extends MongoRepository<Countdown, String> {
}
