package academy.everyonecodes.mysteriouscalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MysteriousNumberFormatterTest {

    @Autowired
    MysteriousNumberFormatter formatter;

    @ParameterizedTest
    @CsvSource({
            "'The mysterious number is 0', 0",
            "'The mysterious number is 5', 5",
            "'The mysterious number is -2', -2"
    })
    void format(String expected, int input) {
        String result = formatter.format(input);

        assertEquals(expected, result);
    }
}