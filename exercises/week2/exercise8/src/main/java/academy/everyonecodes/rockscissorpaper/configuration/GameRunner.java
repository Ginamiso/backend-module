package academy.everyonecodes.rockscissorpaper.configuration;

import academy.everyonecodes.rockscissorpaper.beans.Game;
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
