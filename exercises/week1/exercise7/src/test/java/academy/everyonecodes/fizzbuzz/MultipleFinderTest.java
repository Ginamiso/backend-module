package academy.everyonecodes.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MultipleFinderTest {

    MultipleFinder finder = new MultipleFinder(3);

    @ParameterizedTest
    @CsvSource({
            "true, 6",
            "false, 2",
            "true, 9"
    })
    void isMultiple(boolean expected, int input) {
        boolean result = finder.isMultiple(input);

        assertEquals(expected, result);
    }
}