package academy.everyonecodes.calculator.calculation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ExpressionParserTest {

    @Autowired
    ExpressionParser parser;

    @ParameterizedTest
    @MethodSource("parameters")
    void parse(Expression expected, String input) {
        Expression result = parser.parse(input);

        assertEquals(expected, result);
    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new Expression("+", 1, 1), "1 + 1"),
                Arguments.of(new Expression("-", 1, 1), "1 - 1"),
                Arguments.of(new Expression("/", 1,1), "1 / 1"),
                Arguments.of(new Expression("*", 1, 1), "1 * 1")
        );
    }
}