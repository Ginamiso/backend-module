package academy.everyonecodes.rockscissorpaper.player;

import academy.everyonecodes.rockscissorpaper.domain.Move;
import academy.everyonecodes.rockscissorpaper.player.Player;
import academy.everyonecodes.rockscissorpaper.util.MoveUtils;

import java.util.Optional;
import java.util.Scanner;

public class Human implements Player {

    private final MoveUtils moveUtils;
    private final Scanner scanner = new Scanner(System.in);

    public Human(MoveUtils moveUtils) {
        this.moveUtils = moveUtils;
    }

    @Override
    public Move play() {

        Optional<Move> oMove = Optional.empty();//Assume they make typo in the beginning
        while (oMove.isEmpty()) {
            System.out.print("Choose from these moves: " + moveUtils.getNames());
            String move = scanner.nextLine();
            oMove = moveUtils.getOne(move);
        }
        return oMove.get();
    }

    @Override
    public boolean wantsToPlayAgain() {
        System.out.println("Do you want to play again? yes/no");
        String answer = scanner.nextLine();
        if (answer.equals("yes") || answer.equals("y")) {
            return true;
        }
        return false;
    }
}
