package academy.everyonecodes.drhouseadmission;

import academy.everyonecodes.drhouseadmission.communication.client.DiagnosesClient;
import academy.everyonecodes.drhouseadmission.domain.Patient;
import academy.everyonecodes.drhouseadmission.logic.Admission;
import academy.everyonecodes.drhouseadmission.logic.UUIDProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AdmissionTest {

    @Autowired
    Admission admission;

    @MockBean
    UUIDProvider uuidProvider;

    @MockBean
    DiagnosesClient diagnosesClient;
    Patient patient = new Patient(null, "gina", "headache");
    


    @Test
    void admit() {


        Patient result = admission.admit(patient);
        String uuid = result.getUuid();

        assertEquals(36, uuid.length());
        verify(uuidProvider).provideUUID(patient);
        verify(diagnosesClient).send(patient);
    }
}