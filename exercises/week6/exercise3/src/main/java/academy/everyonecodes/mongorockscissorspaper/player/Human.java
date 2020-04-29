package academy.everyonecodes.mongorockscissorspaper.player;


import academy.everyonecodes.mongorockscissorspaper.util.MoveUtils;
import academy.everyonecodes.mongorockscissorspaper.domain.Move;

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
            System.out.print("Choose a move (" + moveUtils.getNames() + "): ");
            String move = scanner.nextLine();
            oMove = moveUtils.getOne(move);
        }
        return oMove.get();
    }

    @Override
    public boolean wantsToPlayAgain() {
        System.out.println("Do you want to play again? yes/no");
        String answer = scanner.nextLine();
        return answer.equals("yes") || answer.equals("y");
    }
}

