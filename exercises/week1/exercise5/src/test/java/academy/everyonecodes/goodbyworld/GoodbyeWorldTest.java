package academy.everyonecodes.goodbyworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GoodbyeWorldTest {

    @Autowired
    GoodbyeWorld goodbyeWorld;

    @Test
    void get() {
        String expected = "Goodbye World";
        String result = goodbyeWorld.get();

        assertEquals(expected, result);

    }
}