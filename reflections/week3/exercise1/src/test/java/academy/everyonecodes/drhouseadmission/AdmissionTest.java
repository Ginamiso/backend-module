package academy.everyonecodes.drhouseadmission;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AdmissionTest {

    @Autowired
    Admission admission;

    @Test
    void admit() {
        Patient patient1 = new Patient("gina", "", "headache");
        admission.admit(patient1);
        String uuid = patient1.getUuid();

        assertEquals(36, uuid.length());
    }
}