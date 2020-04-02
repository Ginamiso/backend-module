package academy.everyonecodes.polo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PoloEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @SpyBean
    Polo polo;

    String url = "/polo";

    @Test
    void post() {
        String message = "Marco";

        restTemplate.postForObject(url, message, String.class);

        Mockito.verify(polo).answer(message);
    }
}