package academy.everyonecodes.drhouseadmission;

import academy.everyonecodes.drhouseadmission.domain.Patient;
import academy.everyonecodes.drhouseadmission.logic.Admission;
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
        Patient patient1 = new Patient("gina", "headache");
        Patient admitted = admission.admit(patient1);
        String uuid = admitted.getUuid();

        assertEquals(36, uuid.length());
    }
}