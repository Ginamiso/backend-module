package academy.everyonecodes.thefinalcountdown.persistence.repository;

import academy.everyonecodes.thefinalcountdown.persistence.domain.Accumulation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccumulationRepository extends MongoRepository<Accumulation, String> {
}
