package academy.everyonecodes.calculator.calculation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CalculatorTest {

    @Autowired
    Calculator calculator;

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(double expected, String input){
        double result = calculator.calculate(input);

        assertEquals(expected, result);

    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(2.0, "1 + 1"),
                Arguments.of(0.0, "1 - 1"),
                Arguments.of(1.0, "1 * 1"),
                Arguments.of("Infinity", "1.0 / 0.0")
        );
    }

    @Test
    void testExpectedException() throws IllegalArgumentException {
        String input = "1 $ 1";
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculate(input));
    }
}