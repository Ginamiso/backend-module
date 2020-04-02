package academy.everyonecodes.home;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class HomeEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void getHome() {
        String url = "/home";
        restTemplate.getForObject(url, String.class);
    }
}