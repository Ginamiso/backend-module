package academy.everyonecodes.drhouseaccountancy.communication.enpoint;

import academy.everyonecodes.drhouseaccountancy.communication.dto.PatientDTO;
import academy.everyonecodes.drhouseaccountancy.logic.AccountantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    AccountantService accountantService;

    String url = "/patients";

    @Test
    void post() {
        PatientDTO patientDTO = new PatientDTO("uuid", "name", "symptoms", "diagnosis", "treatment");
        testRestTemplate.postForObject(url, patientDTO, PatientDTO.class);

        verify(accountantService).invoice(patientDTO);
    }
}