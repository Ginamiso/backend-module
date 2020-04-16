package academy.everyonecodes.mongorockscissorspaper.runner;


import academy.everyonecodes.mongorockscissorspaper.logic.Game;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameRunner {

    @Bean
    ApplicationRunner appRunner(Game game) {
        return args ->
                game.play();
    }
}
