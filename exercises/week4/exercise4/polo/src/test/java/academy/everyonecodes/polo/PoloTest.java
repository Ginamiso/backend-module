package academy.everyonecodes.polo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PoloTest {

    Polo polo = new Polo();

    @ParameterizedTest
    @CsvSource({
            "Polo, Marco",
            "What?, marco",
            "What?, ''",
            "What?, ciao"
    })
    void answer(String expected, String input) {
        String result = polo.answer(input);

        assertEquals(expected, result);
    }
}