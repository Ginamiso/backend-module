package academy.everyonecodes.mongorockscissorspaper;


import academy.everyonecodes.mongorockscissorspaper.domain.Move;
import academy.everyonecodes.mongorockscissorspaper.logic.Judge;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JudgeTest {

    Judge judge = new Judge();

    @ParameterizedTest
    @MethodSource("parameters")
    void judge(String expected, Move move1, Move move2) {
        String result = judge.judge(move1, move2);

        assertEquals(expected, result);
    }
    static Stream<Arguments> parameters(){
        return Stream.of(
                Arguments.of("Player1 wins!", new Move("rock", "scissor"), new Move("scissor", "paper")),
                Arguments.of("Player2 wins!", new Move("paper", "rock"), new Move("scissor", "paper")),
                Arguments.of("No one wins!", new Move("rock", "scissor"),new Move("rock", "scissor")
                )
        );
    }
}