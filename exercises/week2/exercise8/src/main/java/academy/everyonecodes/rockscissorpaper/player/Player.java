package academy.everyonecodes.rockscissorpaper.player;

import academy.everyonecodes.rockscissorpaper.domain.Move;

public interface Player {

    Move play();

    boolean wantsToPlayAgain();
}
