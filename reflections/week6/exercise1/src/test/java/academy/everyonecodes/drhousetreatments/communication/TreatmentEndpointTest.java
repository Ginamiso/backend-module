package academy.everyonecodes.drhousetreatments.communication;

import academy.everyonecodes.drhousetreatments.logic.TreatmentService;
import academy.everyonecodes.drhousetreatments.persistence.domain.Treatment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TreatmentEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    TreatmentService treatmentService;

    String url = "/treatments";

    @Test
    void getAll() {
        testRestTemplate.getForObject(url, Treatment[].class);

        verify(treatmentService).findAll();
    }

    @Test
    void getBy() {
        String uuid = "uuid";
        testRestTemplate.getForObject(url + "/" + uuid, Treatment[].class);

        verify(treatmentService).findBy(uuid);
    }
}