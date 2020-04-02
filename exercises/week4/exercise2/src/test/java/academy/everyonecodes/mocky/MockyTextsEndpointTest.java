package academy.everyonecodes.mocky;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MockyTextsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RestTemplate restTemplate;

    @Value("${mocky.texts.1}")
    String url1;

    @Value("${mocky.texts.2}")
    String url2;

    String url = "/mocky/texts";

    @Test
    void getOne() {
        String expected = "test";
        Mockito.when(restTemplate.getForObject(url1, String.class))
                .thenReturn(expected);

        String response = testRestTemplate.getForObject(url +"/1", String.class);

        Assertions.assertEquals(expected, response);
        Mockito.verify(restTemplate).getForObject(url1, String.class);

    }

    @Test
    void getTwo() {
        List<String> expected = List.of("test1", "test2");
        Mockito.when(restTemplate.getForObject(url2, String[].class))
                .thenReturn(expected.toArray(String[]::new));

        String[] response = testRestTemplate.getForObject(url+"/2", String[].class);
        List<String> result = List.of(response);

        Assertions.assertEquals(expected, result);

        Mockito.verify(restTemplate).getForObject(url2, String[].class);
    }
}