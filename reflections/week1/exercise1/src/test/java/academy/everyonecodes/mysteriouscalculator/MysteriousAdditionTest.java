package academy.everyonecodes.mysteriouscalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MysteriousAdditionTest {

    @ParameterizedTest
    @MethodSource("parameters")
    void apply(int expected, MysteriousAddition addition, int input) {
        int result = addition.apply(input);

        assertEquals(expected, result);
    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(2, new MysteriousAddition(1), 1),
                Arguments.of(0, new MysteriousAddition(0), 0),
                Arguments.of(-2, new MysteriousAddition(-1), -1)
        );
    }
}