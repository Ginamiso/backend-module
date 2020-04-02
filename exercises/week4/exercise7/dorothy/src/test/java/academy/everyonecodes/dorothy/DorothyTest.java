package academy.everyonecodes.dorothy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DorothyTest {

    @Autowired
    Dorothy dorothy;

    @MockBean
    RestTemplate restTemplate;

    @Value("${wizard.url}")
    String url;

    @Test
    void interact() {
        String homeUrl = "http://localhost:9002/home";

        Mockito.when(restTemplate.getForObject(url, String.class))
                .thenReturn(homeUrl);

        Mockito.when(restTemplate.getForObject(homeUrl, String.class))
                .thenReturn("Kansas");


        String result = dorothy.interact();
        String expected = "My home is Kansas";

        assertEquals(expected, result);

        Mockito.verify(restTemplate).getForObject(url, String.class);
        Mockito.verify(restTemplate).getForObject(homeUrl, String.class);
    }
}