package academy.everyonecodes.mocky;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MockyPostcardsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RestTemplate restTemplate;

    @Value("${mocky.postcards.1}")
    String url1;

    @Value("${mocky.postcards.2}")
    List<String> url2;

    String url = "/mocky/postcards";

    Postcard expectedPostcard1 = new Postcard("Silvia", "Anne",
            "My trip is awesome so far! I'm looking forward to tell you all about it!");

    Postcard expectedPostcard2 = new Postcard("Tom", "Ryan",
            "You have to visit this place, mate! It's great!");


    @Test
    void getOne() {

        Mockito.when(restTemplate.getForObject(url1, Postcard.class))
                .thenReturn(expectedPostcard1);

        Postcard response = testRestTemplate.getForObject(url + "/1", Postcard.class);

        assertEquals(expectedPostcard1, response);

        Mockito.verify(restTemplate).getForObject(url1, Postcard.class);
    }

    @Test
    void getTwo() {
        Mockito.when(restTemplate.getForObject(url2.get(0), Postcard.class))
                .thenReturn(expectedPostcard1);
        Mockito.when(restTemplate.getForObject(url2.get(1), Postcard.class))
                .thenReturn(expectedPostcard2);

        Postcard[] response = testRestTemplate.getForObject(url + "/2", Postcard[].class);
        List<Postcard> result = List.of(response);
        List<Postcard> expected = List.of(expectedPostcard1, expectedPostcard2);

        assertEquals(expected, result);

        //Mockito.verify(restTemplate).getForObject(url2, Postcard[].class);
    }
}