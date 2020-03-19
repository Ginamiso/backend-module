package academy.everyonecodes.emergencynumbers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class FireEmergencyTest {

    @Autowired
    FireEmergency fireEmergency;

    @Test
    void getName() {
        String expected = "Fire brigade";
        String result = fireEmergency.getName();

        assertEquals(expected, result);
    }

    @Test
    void getNumber() {
        int expected = 122;
        int result = fireEmergency.getNumber();

        assertEquals(expected, result);
    }
}