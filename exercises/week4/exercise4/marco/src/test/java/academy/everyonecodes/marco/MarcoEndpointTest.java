package academy.everyonecodes.marco;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MarcoEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    PoloClient poloClient;

    String url = "/marco";

    @Test
    void getMessage() {
        String message = "marco";
        when(poloClient.post(message)).thenReturn("polo");

        String response = restTemplate.getForObject(url + "/" + message, String.class);

        assertEquals("polo", response);

        verify(poloClient).post(message);
    }
}