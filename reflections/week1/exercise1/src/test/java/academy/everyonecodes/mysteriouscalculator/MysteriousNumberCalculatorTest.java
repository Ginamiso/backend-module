package academy.everyonecodes.mysteriouscalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MysteriousNumberCalculatorTest {

    @Autowired
    MysteriousNumberCalculator mysteriousNumberCalculator;

    @ParameterizedTest
    @CsvSource({
            "'The mysterious number is 6, The mysterious number is 7', 5",
            "'The mysterious number is 8, The mysterious number is 9', 7",
            "'The mysterious number is 1, The mysterious number is 2', 0"
    })
    void calculate(String expected, int input) {
        String result = mysteriousNumberCalculator.calculate(input);

        assertEquals(expected, result);
    }
}