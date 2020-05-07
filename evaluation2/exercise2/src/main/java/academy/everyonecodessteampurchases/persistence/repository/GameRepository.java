package academy.everyonecodessteampurchases.persistence.repository;

import academy.everyonecodessteampurchases.persistence.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findByUuid(String uuid);
}
