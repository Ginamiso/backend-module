package academy.everyonecodes.mongorockscissorspaper.player;


import academy.everyonecodes.mongorockscissorspaper.domain.Move;

import java.util.List;
import java.util.Random;

public class Computer implements Player {

    private final List<Move> moves;
    private final Random random = new Random();

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
