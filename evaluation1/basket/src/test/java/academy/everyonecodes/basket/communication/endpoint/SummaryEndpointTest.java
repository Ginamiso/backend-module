package academy.everyonecodes.basket.communication.endpoint;

import academy.everyonecodes.basket.domain.Summary;
import academy.everyonecodes.basket.logic.Basket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class SummaryEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    Basket basket;

    String url = "/summaries";

    @Test
    void getSummaries() {
        testRestTemplate.getForObject(url, Summary[].class);

        verify(basket).getSummaries();
    }
}