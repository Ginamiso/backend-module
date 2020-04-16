package academy.everyonecodes.mongorockscissorspaper.repository;

import academy.everyonecodes.mongorockscissorspaper.domain.GameResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameResultRepository extends MongoRepository<GameResult, String> {

}
