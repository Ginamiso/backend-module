package academy.everyonecodes.marathon.integration.communication.client;

import academy.everyonecodes.marathon.integration.domain.Runner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class MarathonClientTest {

    @Autowired
    MarathonClient client;

    @MockBean
    RestTemplate restTemplate;

    @Value("${marathon.url}")
    String url;

    @Test
    void getWinner() {
        client.getWinner();

        Mockito.verify(restTemplate).getForObject(url+"/winner", Runner.class);
    }

    @Test
    void post() {
        Runner runner = new Runner("runner", Duration.ofSeconds(1));
        client.post(runner);

        Mockito.verify(restTemplate).postForObject(url, runner, Runner.class);
    }
}