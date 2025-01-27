package academy.everyonecodes;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TailoredRecommendationsClientTest {

    @Autowired
    TailoredRecommendationsClient client;

    @MockBean
    RestTemplate restTemplate;

    @Value("${tailored.url}")
    String url;

    @Test
    void get() {
        String userUuid = "123";

        Mockito.when(restTemplate.getForObject(url+"/"+userUuid, Movie[].class))
                .thenReturn(new Movie[]{});

        client.get(userUuid);

        Mockito.verify(restTemplate).getForObject(url +"/"+userUuid, Movie[].class);
    }
}