package academy.everyonecodes.emergencynumbers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GeneralEmergencyTest {

    @Autowired
    GeneralEmergency generalEmergency;

    @Test
    void getName() {
        String result  = generalEmergency.getName();
        String expected = "General emergency";

        assertEquals(expected, result);
    }

    @Test
    void getNumber() {
        int expected = 112;
        int result = generalEmergency.getNumber();

        assertEquals(expected, result);
    }
}