package academy.everyonecodes.trickster.communication.client;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class CupsClientTest {

    @Autowired
    CupsClient cupsClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${cups.url}")
    List<String> cupsUrls;

    int cup= 0;

    @Test
    void hasCoin() {

        cupsClient.hasCoin(cup);

        Mockito.verify(restTemplate).getForObject(cupsUrls.get(cup), Boolean.class);
    }

    @Test
    void putCoin() {

        cupsClient.putCoin(cup);

        Mockito.verify(restTemplate).put(cupsUrls.get(cup), true);
    }

    @Test
    void deleteCoin() {
        cupsClient.deleteCoin(cup);

        Mockito.verify(restTemplate).delete(cupsUrls.get(cup));
    }

    @Test
    void getCups() {
        int result = cupsClient.getCups();

        assertEquals(3, result);
    }
}