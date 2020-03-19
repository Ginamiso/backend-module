package academy.everyonecodes.rockscissorpaper.beans;

import academy.everyonecodes.rockscissorpaper.serviceAndDataClasses.Move;
import org.springframework.stereotype.Service;

@Service
public class Judge {

    public String judge(Move move1, Move move2) {
        if (move1.getDefeats().equals(move2.getName())) {
            return "You win!";
        }
        if (move2.getDefeats().equals(move1.getName())) {
            return "You lose!";
        }
        return "No one wins!";

    }
}
