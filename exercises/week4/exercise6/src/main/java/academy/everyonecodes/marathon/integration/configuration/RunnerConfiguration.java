package academy.everyonecodes.marathon.integration.configuration;

import academy.everyonecodes.marathon.integration.domain.Runner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;

@Configuration
public class RunnerConfiguration {


    @Bean
    Runner winner() {
        return new Runner("winner", Duration.ofSeconds(1));
    }

    @Bean
    List<Runner> runners() {
        return List.of(new Runner("winner", Duration.ofSeconds(1)),
                new Runner("second", Duration.ofSeconds(2)),
                new Runner("third", Duration.ofSeconds(3)));

    }
}
