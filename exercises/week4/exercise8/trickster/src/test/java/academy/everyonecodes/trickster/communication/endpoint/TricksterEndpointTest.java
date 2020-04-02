package academy.everyonecodes.trickster.communication.endpoint;

import academy.everyonecodes.trickster.logic.Trickster;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TricksterEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    Trickster trickster;


    @Test
    void getToPlay() {
        String url = "/play";

        testRestTemplate.getForObject(url, String.class);

        Mockito.verify(trickster).play();
    }

    @Test
    void getCup() {
        String url = "/choose/";

        testRestTemplate.getForObject(url+0, Boolean.class);

        Mockito.verify(trickster).hasCoin(0);
    }
}