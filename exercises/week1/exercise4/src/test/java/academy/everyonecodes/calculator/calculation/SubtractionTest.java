package academy.everyonecodes.calculator.calculation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SubtractionTest {

    @Autowired
    Subtraction subtraction;

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(double expected, Expression input) {
        double result = subtraction.calculate(input);

        assertEquals(expected, result);
    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(0, new Expression("-", 1, 1)),
                Arguments.of(0, new Expression("-", -1, -1)),
                Arguments.of(2, new Expression("-", 4, 2))
        );
    }
}