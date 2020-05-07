package academy.everyonecodes.steamusers.persistence.repository;

import academy.everyonecodes.steamusers.persistence.domain.SteamUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SteamUserRepository extends MongoRepository<SteamUser, String> {

    boolean existsByUsername(String username);

    Optional<SteamUser> findOneByUsername(String username);
}
