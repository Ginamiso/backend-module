package academy.everyonecodes.mongorockscissorspaper.logic;


import academy.everyonecodes.mongorockscissorspaper.domain.GameResult;
import academy.everyonecodes.mongorockscissorspaper.domain.Move;
import academy.everyonecodes.mongorockscissorspaper.player.Computer;
import academy.everyonecodes.mongorockscissorspaper.player.Human;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

@Service
public class Game {

    private final Human player1;
    private final Computer player2;
    private final Judge judge;
    private final GameResultManager gameResultManager;

    public Game(Human player1, Computer player2, Judge judge, GameResultManager gameResultManager) {
        this.player1 = player1;
        this.player2 = player2;
        this.judge = judge;
        this.gameResultManager = gameResultManager;
    }

    public void play() {
        boolean wantsToPlay = true;

        while (wantsToPlay) {
            System.out.println("Game statistics: " + createStatistics());
            Move move1 = player1.play();
            Move move2 = player2.play();
            System.out.println("Player 1 chose: " + move1.getName());
            System.out.println("Player 2 chose: " + move2.getName());
            String result = judge.judge(move1, move2);
            gameResultManager.saveResult(result);
            System.out.println(result);
            wantsToPlay = player1.wantsToPlayAgain() && player2.wantsToPlayAgain();
        }
        gameResultManager.deleteAll();
    }

    private String createStatistics() {
        List<GameResult> all = gameResultManager.findAll();
        return all.stream()
                .collect(groupingBy(GameResult::getResult, counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> e.getKey() + ": " + e.getValue())
                .collect(joining(", "));
//        long player1 = all.stream()
//                .filter(gameResult -> gameResult.getResult().equals("Player 1 wins"))
//                .count();
//        long player2 = all.stream()
//                .filter(gameResult -> gameResult.getResult().equals("Player 2 wins"))
//                .count();
//        long nobody = all.stream()
//                .filter(gameResult -> gameResult.getResult().equals("Nobody wins"))
//                .count();
//        if (player1 != 0) {
//            result = result + "Player 1 wins: " + player1 + ", ";
//        }
//        if (player2 != 0) {
//            result = result + "Player 2 wins: " + player2 + ", ";
//        }
//        if (nobody != 0) {
//            result = result + "Nobody wins: " + nobody;
//        }
//        return result;
    }
}

