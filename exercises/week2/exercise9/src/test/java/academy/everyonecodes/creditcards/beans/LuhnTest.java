package academy.everyonecodes.creditcards.beans;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LuhnTest {

    @Autowired
    Luhn luhn;

    @ParameterizedTest
    @CsvSource({
            "true, 378282246310005",
            "true, 371449635398431",
            "true, 5555555555554444",
            "true, 5105105105105100",
            "true, 4111111111111111",
            "true, 4012888888881881",
            "true, 4373631987146720",
            "true, 4485832439079635",
            "true, 4929284097886035491",
            "true, 5416395829812727",
            "true, 2720997950404063",
            "true, 2720994996921655",
            "false, 37828224631000"
    })
    void isValid(boolean expected, String input) {
        boolean result = luhn.isValid(input);

        assertEquals(expected, result);
    }

}
