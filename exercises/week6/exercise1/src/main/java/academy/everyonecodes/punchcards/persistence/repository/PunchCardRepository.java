package academy.everyonecodes.punchcards.persistence.repository;

import academy.everyonecodes.punchcards.persistence.domain.PunchCard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PunchCardRepository extends MongoRepository<PunchCard, String> {
}
