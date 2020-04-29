package academy.everyonecodes.drhousetreatments.logic;

import academy.everyonecodes.drhousetreatments.communication.client.AccountancyClient;
import academy.everyonecodes.drhousetreatments.persistence.domain.Patient;
import academy.everyonecodes.drhousetreatments.persistence.domain.Treatment;
import academy.everyonecodes.drhousetreatments.persistence.repository.TreatmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class NurseTest {

    @Autowired
    Nurse nurse;

    @MockBean
    TreatmentRepository repository;

    @MockBean
    AccountancyClient accountancyClient;

    @Value("${nurse.treatment}")
    String bed;

    @Test
    void treat() {
        Patient patient = new Patient("uuid", "name", "test", "test");
        assertNull(patient.getTreatment());

        nurse.treat(patient);

        assertNotNull(patient.getTreatment());
        assertEquals(bed, patient.getTreatment());

        Treatment treatment = new Treatment("uuid", "name", "test", "test", bed);
        verify(repository).save(treatment);
        verify(accountancyClient).post(patient);
    }
}