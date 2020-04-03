package academy.everyonecodes.marathon.integration.communication.endpoint;

import academy.everyonecodes.marathon.integration.domain.TestResult;
import academy.everyonecodes.marathon.integration.logic.MarathonTester;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MarathonIntegrationEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    MarathonTester tester;

    String url = "/marathon/integration";

    @Test
    void get() {

        restTemplate.getForObject(url, TestResult.class);

        Mockito.verify(tester).test();
    }
}