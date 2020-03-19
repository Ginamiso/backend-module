package academy.everyonecodes.rockscissorpaper.configuration;

import academy.everyonecodes.rockscissorpaper.serviceAndDataClasses.Move;
import academy.everyonecodes.rockscissorpaper.serviceAndDataClasses.Computer;
import academy.everyonecodes.rockscissorpaper.serviceAndDataClasses.Human;
import academy.everyonecodes.rockscissorpaper.beans.MoveUtils;
import academy.everyonecodes.rockscissorpaper.serviceAndDataClasses.Player;
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
