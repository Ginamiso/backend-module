package academy.everyonecodes.rockscissorpaper.serviceAndDataClasses;

import java.util.List;
import java.util.Random;

public class Computer implements Player {

    private List<Move> moves;
    private Random random = new Random();

    public Computer(List<Move> moves) {
        this.moves = moves;
    }

    @Override
    public Move play() {
        int randomInt = random.nextInt(moves.size());
        return moves.get(randomInt);
    }

    @Override
    public boolean wantsToPlayAgain() {
        return true;
    }
}
