package academy.everyonecodes.mocky;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MockyPostcardsEndpointIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    String url = "/mocky/postcards";

    Postcard expectedPostcard1 = new Postcard("Silvia", "Anne",
            "My trip is awesome so far! I'm looking forward to tell you all about it!");

    Postcard expectedPostcard2 = new Postcard("Tom", "Ryan",
            "You have to visit this place, mate! It's great!");


    @Test
    void getOne() {
        Postcard response = testRestTemplate.getForObject(url + "/1", Postcard.class);

        assertEquals(expectedPostcard1, response);
    }

    @Test
    void getTwo() {
        Postcard[] response = testRestTemplate.getForObject(url + "/", Postcard[].class);
        List<Postcard> result = List.of(response);

        List<Postcard> expected = List.of(expectedPostcard1, expectedPostcard2);

        assertEquals(expected, result);
    }
}