package academy.everyonecodes.cup;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CupEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    Cup cup;

    String url = "/cup";

    @Test
    void checkCup() {
        testRestTemplate.getForObject(url, Boolean.class);

        Mockito.verify(cup).hasCoin();
    }

    @Test
    void putCoin() {

        testRestTemplate.put(url, Boolean.class);

        Mockito.verify(cup).putCoin();

    }

    @Test
    void removeCoin() {
        testRestTemplate.delete(url);
        Mockito.verify(cup).removeCoin();
    }
}