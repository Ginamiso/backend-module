package academy.everyonecodes.threepwoodcinema;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TemplateEngineTest {
    @Autowired
    TemplateEngine templateEngine;

    @ParameterizedTest
    @CsvSource({
            "Good day Mr.Robot!, Mr.Robot",
            "Dear Ms.Anna!, Ms.Anna",
            "My dearest Threepwood Jim!, Threepwood Jim",
            "Hello Jon!, Jon"
    })
    void customise(String expected, String input) {
        String result = templateEngine.customise(input);

        assertEquals(expected, result);
    }
}