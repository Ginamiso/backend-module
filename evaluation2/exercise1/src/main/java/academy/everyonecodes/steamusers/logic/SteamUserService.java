package academy.everyonecodes.steamusers.logic;

import academy.everyonecodes.steamusers.persistence.domain.SteamUser;
import academy.everyonecodes.steamusers.persistence.repository.SteamUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class SteamUserService {

    private final SteamUserRepository repository;
    private final PasswordEncoder encoder;
    private final Set<String> authorities;

    public SteamUserService(SteamUserRepository repository,
                            PasswordEncoder encoder, @Value("${steam-users.regular.authorities}") Set<String> authorities) {
        this.repository = repository;
        this.encoder = encoder;
        this.authorities = authorities;
    }

    public SteamUser save(SteamUser steamUser) {
        Optional<SteamUser> oSteamUser = repository.findOneByUsername(steamUser.getUsername());
        if (oSteamUser.isPresent()) {
            return oSteamUser.get();
        }
        steamUser.setAuthorities(authorities);
        String password = steamUser.getPassword();
        String encoded = encoder.encode(password);
        steamUser.setPassword(encoded);
        return repository.save(steamUser);
    }
}
