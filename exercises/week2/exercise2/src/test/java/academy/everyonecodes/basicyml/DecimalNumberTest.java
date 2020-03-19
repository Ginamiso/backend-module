package academy.everyonecodes.basicyml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DecimalNumberTest {

    @Autowired
    DecimalNumber decimalNumber;

    @Test
    void get() {
        double expected = 1.618;
        double result = decimalNumber.get();

        assertEquals(expected, result);
    }
}