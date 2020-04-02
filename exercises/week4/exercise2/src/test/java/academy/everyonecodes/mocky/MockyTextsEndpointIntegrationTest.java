package academy.everyonecodes.mocky;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MockyTextsEndpointIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    String url = "/mocky/texts";

    @Test
    void getOne() {
        String response = testRestTemplate.getForObject(url+"/1", String.class);
        String expected = "Yay, it worked! This message comes from an external API in the cloud :)";

        Assertions.assertEquals(expected, response);
    }

    @Test
    void getTwo() {
        String[] response = testRestTemplate.getForObject(url + "/2", String[].class);
        List<String> result = List.of(response);

        List<String> expected = List.of(
                "You are doing an amazing job!",
                "Keep on going, you're learning fast");

        Assertions.assertEquals(expected, result);
    }
}