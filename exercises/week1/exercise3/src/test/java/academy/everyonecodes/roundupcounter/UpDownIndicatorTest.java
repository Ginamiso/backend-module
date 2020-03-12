package academy.everyonecodes.roundupcounter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UpDownIndicatorTest {

    @Autowired
    UpDownIndicator upDownIndicator;

    @ParameterizedTest
    @CsvSource({
            "UP, 1.7",
            "DOWN, 1.1",
            "SAME, 1.5",
            "DOWN, -4.6",
            "DOWN, 6.3",
            "SAME, -2.5",
    })
    void indicate(String expected, double input) {
        String result = upDownIndicator.indicate(input);

        assertEquals(expected, result);
    }
}