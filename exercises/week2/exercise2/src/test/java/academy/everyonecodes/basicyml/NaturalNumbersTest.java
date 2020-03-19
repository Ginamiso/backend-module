package academy.everyonecodes.basicyml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NaturalNumbersTest {

    @Autowired
    NaturalNumbers naturalNumbers;

    @Test
    void get() {
        int expected= 369;
        int result = naturalNumbers.get();

        assertEquals(expected, result);
    }
}