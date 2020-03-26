package academy.everyonecodes.rockscissorpaper.configuration;

import academy.everyonecodes.rockscissorpaper.domain.Move;
import academy.everyonecodes.rockscissorpaper.player.Computer;
import academy.everyonecodes.rockscissorpaper.player.Human;
import academy.everyonecodes.rockscissorpaper.util.MoveUtils;
import academy.everyonecodes.rockscissorpaper.player.Player;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfiguration {

    @Bean
    Player player1(MoveUtils utils) {
        return new Human(utils);
    }

    @Bean
    Player player2(List<Move> moves) {
        return new Computer(moves);
    }
}
