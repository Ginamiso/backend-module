package academy.everyonecodes.rockscissorpaper.logic;

import academy.everyonecodes.rockscissorpaper.domain.Move;
import academy.everyonecodes.rockscissorpaper.player.Computer;
import academy.everyonecodes.rockscissorpaper.player.Human;
import org.springframework.stereotype.Service;

@Service
public class Game {

    private final Human player1;
    private final Computer player2;
    private final Judge judge;

    public Game(Human player1, Computer player2, Judge judge) {
        this.player1 = player1;
        this.player2 = player2;
        this.judge = judge;
    }
    public void play(){
        System.out.println("Welcome to the game!");
        boolean wantsToPlay = true;
        while(wantsToPlay){
            Move move1 = player1.play();
            Move move2 = player2.play();
            System.out.println("Player 1 chose: " + move1.getName());
            System.out.println("Player 2 chose: " + move2.getName());
            String result = judge.judge(move1, move2);
            System.out.println(result);
            wantsToPlay = player1.wantsToPlayAgain()&&player2.wantsToPlayAgain();
        }
        System.out.println("Goodbye looser!");
    }
}
