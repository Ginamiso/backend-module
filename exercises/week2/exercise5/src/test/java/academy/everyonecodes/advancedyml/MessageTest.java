package academy.everyonecodes.advancedyml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MessageTest {

    @Autowired
    Message message;

    @Test
    void get() {
        String expected = "My brain is only a receiver, in the Universe there is a core from which we obtain knowledge, strength and inspiration. - Nikola Tesla";
        String result = message.get();

        assertEquals(expected, result);
    }
}