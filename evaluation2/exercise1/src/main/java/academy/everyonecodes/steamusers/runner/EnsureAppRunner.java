package academy.everyonecodes.steamusers.runner;

import academy.everyonecodes.steamusers.persistence.domain.SteamUser;
import academy.everyonecodes.steamusers.persistence.repository.SteamUserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ConfigurationProperties("steam-users")
public class EnsureAppRunner {

    private SteamUser steamApp;

    @Bean
    ApplicationRunner ensureSteamApp(SteamUserRepository steamUserRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (steamUserRepository.existsByUsername(steamApp.getUsername())) {
                return;
            }
            String password = steamApp.getPassword();
            String encrypted = passwordEncoder.encode(password);
            steamApp.setPassword(encrypted);
            steamUserRepository.save(steamApp);
        };
    }

    void setSteamApp(SteamUser steamApp) {
        this.steamApp = steamApp;
    }
}
