package academy.everyonecodes.steamusers.logic;

import academy.everyonecodes.steamusers.persistence.domain.SteamUser;
import academy.everyonecodes.steamusers.persistence.repository.SteamUserRepository;
import academy.everyonecodes.steamusers.runner.EnsureAppRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class SteamUserServiceTest {

    @Autowired
    SteamUserService steamUserService;

    @MockBean
    SteamUserRepository repository;

    @MockBean
    PasswordEncoder passwordEncoder;

    @MockBean
    EnsureAppRunner runner;

    @Value("${steam-users.regular.authorities}")
    Set<String> authorities;

    String username = "username";

    @Test
    void saveFindsSteamUser() {
        SteamUser user = new SteamUser(username, "password");
        when(repository.findOneByUsername(username))
                .thenReturn(Optional.of(user));

        steamUserService.save(user);

        verify(repository).findOneByUsername(username);
        verifyNoMoreInteractions(repository);
        verifyNoInteractions(passwordEncoder);
    }

    @Test
    void saveDoesNotFindSteamUSer() {
        String password = "password";
        String encoded = "encoded";
        when(repository.findOneByUsername(username))
                .thenReturn(Optional.empty());
        when(passwordEncoder.encode(password))
                .thenReturn(encoded);

        SteamUser user = new SteamUser(username, "password");
        assertNull(user.getAuthorities());

        steamUserService.save(user);

        verify(repository).findOneByUsername(username);
        verify(passwordEncoder).encode(password);
        SteamUser expected = new SteamUser(username, encoded, authorities);
        verify(repository).save(expected);
    }
}