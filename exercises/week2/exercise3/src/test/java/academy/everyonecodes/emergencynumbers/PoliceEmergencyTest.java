package academy.everyonecodes.emergencynumbers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PoliceEmergencyTest {

    @Autowired
    PoliceEmergency policeEmergency;

    @Test
    void getName() {
        String expected= "Police";
        String result = policeEmergency.getName();

        assertEquals(expected, result);
    }

    @Test
    void getNumber() {
        int expected = 133;
        int result = policeEmergency.getNumber();

        assertEquals(expected, result);
    }
}