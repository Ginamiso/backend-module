package academy.everyonecodes.authorizedmarco.communication.enpoint;

import academy.everyonecodes.authorizedmarco.communication.client.PoloClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MarcoEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    PoloClient poloClient;

    String url = "/marco";

    @Test
    void get() {
        String message = "message";
        testRestTemplate.getForObject(url+"/"+message, String.class);

        verify(poloClient).post(message);
    }
}