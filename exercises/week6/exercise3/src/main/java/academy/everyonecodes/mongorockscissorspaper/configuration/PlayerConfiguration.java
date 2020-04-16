package academy.everyonecodes.mongorockscissorspaper.configuration;


import academy.everyonecodes.mongorockscissorspaper.domain.Move;
import academy.everyonecodes.mongorockscissorspaper.logic.GameResultManager;
import academy.everyonecodes.mongorockscissorspaper.player.Computer;
import academy.everyonecodes.mongorockscissorspaper.player.Human;
import academy.everyonecodes.mongorockscissorspaper.util.MoveUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfiguration {

    @Bean
    Human player1(MoveUtils utils) {
        return new Human(utils);
    }

    @Bean
    Computer player2(List<Move> moves) {
        return new Computer(moves);
    }
}
