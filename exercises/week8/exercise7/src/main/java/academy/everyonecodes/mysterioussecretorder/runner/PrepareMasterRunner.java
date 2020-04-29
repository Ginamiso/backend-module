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
    ApplicationRunner prepareMaster(UserRepository userRepository, PasswordEncoder passwordEncoder){
        return args -> {
            if(!userRepository.existsByUsername("eugenia")){
                String encodedPassword = passwordEncoder.encode("eugenia");
                User master = new User("eugenia", encodedPassword, Set.of("ROLE_MASTER"));
                userRepository.save(master);
            }
        };
    }
}
