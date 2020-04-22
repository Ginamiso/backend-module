package academy.everyonecodes.drhousediagnoses.logic;

import academy.everyonecodes.drhousediagnoses.domain.Patient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DrHouseTest {

    @Autowired
    DrHouse drHouse;

    @ParameterizedTest
    @CsvSource({
            "lupus, ''",
            "lupus, symptom",
            "test-diagnosis, test-symptom",
            "test-diagnosis, Test-symptom"

    })
    void diagnose(String expected, String symptoms) {
        Patient patient = new Patient("test", "test", symptoms);
        assertNull(patient.getDiagnosis());

        drHouse.diagnose(patient);

        Patient diagnosedPatient = new Patient("test", "test", symptoms, expected);
        assertNotNull(diagnosedPatient.getDiagnosis());
        assertEquals(diagnosedPatient, patient);
    }
}