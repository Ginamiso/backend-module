package academy.everyonecodes.rockscissorpaper.player;

import academy.everyonecodes.rockscissorpaper.domain.Move;
import academy.everyonecodes.rockscissorpaper.player.Player;

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
