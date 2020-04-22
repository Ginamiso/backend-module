package academy.everyonecodes.thegreatgatsby;

import academy.everyonecodes.thegreatgatsby.logic.InvitationService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PartyRunner {

    @Bean
    ApplicationRunner appRunner(InvitationService service) {
        return args -> {
            service.party();
        };
    }
}
