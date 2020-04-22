package academy.everyonecodes.drhousediagnoses.communication.client;

import academy.everyonecodes.drhousediagnoses.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TreatmentsClientTest {

    @Autowired
    TreatmentsClient treatmentsClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${treatments.url}")
    String url;

    @Test
    void post() {
        Patient patient = new Patient("test", "test", "test", "test");
        treatmentsClient.post(patient);

        verify(restTemplate).postForObject(url, patient, Void.class);
    }
}