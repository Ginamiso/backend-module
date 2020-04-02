package academy.everyonecodes.marco;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class PoloClientTest {

    @Autowired
    PoloClient poloClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${polo.url}")
    String url;

    @Test
    void getMessage() {
        String message = "Marco";

        poloClient.post(message);

        Mockito.verify(restTemplate).postForObject(url + "/" + message, message, String.class);

    }
}