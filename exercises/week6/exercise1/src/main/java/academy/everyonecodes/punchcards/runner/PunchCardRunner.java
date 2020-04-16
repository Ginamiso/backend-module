package academy.everyonecodes.punchcards.runner;

import academy.everyonecodes.punchcards.logic.PunchCardService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PunchCardRunner {

    @Bean
    ApplicationRunner runPunchCard(PunchCardService punchCardService) {
        return args -> {
            punchCardService.create();
        };
    }

}
