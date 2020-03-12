package academy.everyonecodes.calculator.calculation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MultiplicationTest {

    @Autowired
    Multiplication multiplication;

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(double expected, Expression input) {
        double result = multiplication.calculate(input);

        assertEquals(expected, result);
    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(0, new Expression("*", 0, 0)),
                Arguments.of(1, new Expression("*", 1, 1)),
                Arguments.of(1, new Expression("*", -1, -1))
        );
    }
}