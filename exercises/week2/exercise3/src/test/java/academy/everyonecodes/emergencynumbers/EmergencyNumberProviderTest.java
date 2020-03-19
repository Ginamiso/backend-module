package academy.everyonecodes.emergencynumbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EmergencyNumberProviderTest {

    @Autowired
    EmergencyNumberProvider provider;

    @ParameterizedTest
    @CsvSource({
            "122, Fire brigade",
            "133, Police",
            "112, ''",
            "112, Ambulance"
    })
    void provide(int expected, String input) {
        int result = provider.provide(input);

        assertEquals(expected, result);
    }
}