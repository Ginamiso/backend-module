package academy.everyonecodes.drhousediagnoses.logic;

import academy.everyonecodes.drhousediagnoses.communication.client.TreatmentsClient;
import academy.everyonecodes.drhousediagnoses.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DiagnosisRoomTest {

    @Autowired
    DiagnosisRoom diagnosisRoom;

    @MockBean
    DrHouse drHouse;

    @MockBean
    TreatmentsClient treatmentsClient;

    Patient patient = new Patient("123","patient","test");

    @Test
    void diagnose() {
        diagnosisRoom.diagnose(patient);

        verify(drHouse).diagnose(patient);
        verify(treatmentsClient).post(patient);
    }
}