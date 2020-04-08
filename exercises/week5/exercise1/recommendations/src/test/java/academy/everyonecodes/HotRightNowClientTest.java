package academy.everyonecodes;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class HotRightNowClientTest {

    @Autowired
    HotRightNowClient client;

    @MockBean
    RestTemplate restTemplate;

    @Value("${hotrightnow.url}")
    String url;

    @Test
    void get() {
        Mockito.when(restTemplate.getForObject(url, Movie[].class))
                .thenReturn(new Movie[]{});

        client.get();

        Mockito.verify(restTemplate).getForObject(url, Movie[].class);
    }
}