package academy.everyonecodes.securedpolo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PoloServiceTest {

    @Autowired
    PoloService poloService;

    @ParameterizedTest
    @CsvSource({
            "Polo, Marco",
            "What?, something",
            "What?, ''"
    })
    void answer(String expected, String input) {
        String result = poloService.answer(input);

        assertEquals(expected, result);


    }
}