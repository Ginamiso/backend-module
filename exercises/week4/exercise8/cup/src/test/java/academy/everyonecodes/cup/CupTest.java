package academy.everyonecodes.cup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CupTest {

    Cup cup = new Cup();

    @Test
    void hasCoin() {

        boolean result = cup.hasCoin();

        assertFalse(result);
    }
}