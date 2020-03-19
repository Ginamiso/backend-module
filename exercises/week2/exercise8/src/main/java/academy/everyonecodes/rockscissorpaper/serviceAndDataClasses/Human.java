package academy.everyonecodes.rockscissorpaper.serviceAndDataClasses;

import academy.everyonecodes.rockscissorpaper.beans.MoveUtils;

import java.util.Optional;
import java.util.Scanner;

public class Human implements Player {

    private final MoveUtils moveUtils;
    private Scanner scanner = new Scanner(System.in);

    public Human(MoveUtils moveUtils) {
        this.moveUtils = moveUtils;
    }

    @Override
    public Move play() {

        Optional<Move> oMove = Optional.empty();
        while (oMove.isEmpty()) {
            System.out.println("Choose from these moves: " + moveUtils.getNames());
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
