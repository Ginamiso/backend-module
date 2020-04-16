package academy.everyonecodes.drhousediagnoses.communication.enpoint;

import academy.everyonecodes.drhousediagnoses.domain.Patient;
import academy.everyonecodes.drhousediagnoses.logic.DiagnosisRoom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    DiagnosisRoom diagnosisRoom;

    Patient patient = new Patient("123", "patient", "test");

    String url = "/patients";


    @Test
    void post() {
        testRestTemplate.postForObject(url, patient, Patient.class);

        verify(diagnosisRoom).diagnose(patient);
    }
}