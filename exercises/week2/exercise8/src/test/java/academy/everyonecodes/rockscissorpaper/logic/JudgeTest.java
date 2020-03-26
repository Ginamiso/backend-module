package academy.everyonecodes.rockscissorpaper.logic;

import academy.everyonecodes.rockscissorpaper.domain.Move;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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
                Arguments.of("You win!", new Move("rock", "scissor"), new Move("scissor", "paper")),
                Arguments.of("You lose!", new Move("paper", "rock"), new Move("scissor", "paper")),
                Arguments.of("No one wins!", new Move("rock", "scissor"),new Move("rock", "scissor")
                )
        );
    }
}