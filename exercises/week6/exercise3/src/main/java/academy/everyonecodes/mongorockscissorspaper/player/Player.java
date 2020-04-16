package academy.everyonecodes.mongorockscissorspaper.player;


import academy.everyonecodes.mongorockscissorspaper.domain.Move;

public interface Player {

    Move play();

    boolean wantsToPlayAgain();
}
