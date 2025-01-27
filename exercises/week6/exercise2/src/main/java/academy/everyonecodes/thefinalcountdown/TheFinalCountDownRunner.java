package academy.everyonecodes.thefinalcountdown;

import academy.everyonecodes.thefinalcountdown.logic.CountdownManager;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TheFinalCountDownRunner {


    @Bean
    ApplicationRunner runCountdown(CountdownManager countdownManager){
        return args ->
                countdownManager.countdown();
    }
}
