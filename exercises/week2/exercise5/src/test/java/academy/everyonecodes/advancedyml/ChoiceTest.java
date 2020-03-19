package academy.everyonecodes.advancedyml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class ChoiceTest {

    @Autowired
    Choice choice;

    @Test
    void get() {

        boolean result = choice.get();

        assertFalse(result);
    }
}