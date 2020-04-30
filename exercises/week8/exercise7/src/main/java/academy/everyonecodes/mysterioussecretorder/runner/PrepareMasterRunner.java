package academy.everyonecodes.mysterioussecretorder.runner;

import academy.everyonecodes.mysterioussecretorder.persistence.domain.User;
import academy.everyonecodes.mysterioussecretorder.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class PrepareMasterRunner {

    @Bean
    ApplicationRunner prepareMaster(UserRepository userRepository, PasswordEncoder passwordEncoder,
                                    @Value("${master.username}") String username,
                                    @Value("${master.password}") String password,
                                    @Value("${master.authorities}") Set<String> authorities) {
        return args -> {
            if (!userRepository.existsByUsername(username)) {
                String encodedPassword = passwordEncoder.encode(password);
                User master = new User(username, encodedPassword, authorities);
                userRepository.save(master);
            }
        };
    }
}
