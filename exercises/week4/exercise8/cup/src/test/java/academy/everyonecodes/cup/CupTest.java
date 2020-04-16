package academy.everyonecodes.cup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CupTest {

    Cup cup;
    @BeforeEach
    void setup() {
        cup = new Cup();
    }

    @Test
    void hasCoin() {

        boolean result = cup.hasCoin();

        assertFalse(result);
    }
    @Test
    void putCoin(){
        cup.putCoin();
        boolean result = cup.hasCoin();
        assertTrue(result);
    }
    @Test
    void removeCoin(){
        cup.putCoin();
        boolean result = cup.hasCoin();
        assertTrue(result);

        cup.removeCoin();
        result = cup.hasCoin();
        assertFalse(result);
    }
}