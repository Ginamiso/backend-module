package academy.everyonecodes.creditcards.beans;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CreditCardsTest {

    @Autowired
    CreditCards creditCards;

    @ParameterizedTest
    @CsvSource({
            "Invalid, 373747858595",
            "Not Supported, 30569309025904",
            "American Express, 378282246310005",
            "Discover, 6011111111111117",
            "Visa, 4012888888881881",
            "MasterCard, 5555555555554444"
    })
    void inspect(String expected, String input) {
        String result = creditCards.inspect(input);
    }
}