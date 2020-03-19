package academy.everyonecodes.threepwoodcinema;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TemplateMessageFinderTest {

    @Autowired
    TemplateMessageFinder finder;

    @ParameterizedTest
    @CsvSource({
            "Good day --name--!, Mr.Robot",
            "Dear --name--!, Ms.Anna",
            "My dearest --name--!, Threepwood Jim",
            "Hello --name--!, Jon"

    })
    void find(String expected, String input) {
        String result = finder.find(input);

        assertEquals(expected, result);
    }
}