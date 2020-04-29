package academy.everyonecodes.drhousetreatments.communication.client;

import academy.everyonecodes.drhousetreatments.persistence.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AccountancyClientTest {

    @Autowired
    AccountancyClient accountancyClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${accountancy.url}")
    String url;

    @Test
    void post() {
        Patient patient = new Patient("uuid", "name", "symptoms", "diagnosis", "treatment");
        accountancyClient.post(patient);

        verify(restTemplate).postForObject(url, patient, Void.class);
    }
}