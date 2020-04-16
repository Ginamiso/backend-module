package academy.everyonecodes.drhousediagnoses.logic;

import academy.everyonecodes.drhousediagnoses.domain.Patient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DiagnosisRoomTest {

    @Autowired
    DiagnosisRoom diagnosisRoom;

    @MockBean
    DrHouse drHouse;

    Patient patient = new Patient("123","patient","test");

    @Test
    void diagnose() {
        String diagnosis = "lupus";
        Patient result = diagnosisRoom.diagnose(patient);

        patient.setDiagnosis(diagnosis);

        assertEquals(diagnosis, result.getDiagnosis());
        verify(drHouse).diagnose(patient);
    }
}