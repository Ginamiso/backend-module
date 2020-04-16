package academy.everyonecodes.mongorockscissorspaper.logic;


import academy.everyonecodes.mongorockscissorspaper.domain.Move;
import org.springframework.stereotype.Service;

@Service
public class Judge {

    public String judge(Move move1, Move move2) {
        if (move1.getDefeats().equals(move2.getName())) {
            return "Player 1 wins";
        }
        if (move2.getDefeats().equals(move1.getName())) {
            return "Player 2 wins";
        }
        return "Nobody wins";

    }
}
