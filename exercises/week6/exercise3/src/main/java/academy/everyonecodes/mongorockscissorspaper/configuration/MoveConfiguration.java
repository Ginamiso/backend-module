package academy.everyonecodes.mongorockscissorspaper.configuration;


import academy.everyonecodes.mongorockscissorspaper.domain.Move;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("game")
public class MoveConfiguration {

    private List<Move> moves;

    @Bean
    public List<Move> provideMoves(){
        return moves;
    }

    void setMoves(List<Move> moves) {
        this.moves = moves;
    }
}
