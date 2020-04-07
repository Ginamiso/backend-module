package academy.everyonecodes.tailoredrecommendations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TailoredRecommendationsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    TailoredRecommendationsStore store;

    String url = "/tailoredrecommendations";

    @Test
    void get() {
        String userUuid =  "1";
        testRestTemplate.getForObject(url + "/"+userUuid, Movie[].class);

        verify(store).getForUser(userUuid);
    }

    @Test
    void postOne() {
        TailoredRecommendation recommendation = new TailoredRecommendation("1", new Movie("test3", "test3"));
        testRestTemplate.postForObject(url,recommendation, TailoredRecommendation.class);

        verify(store).post(recommendation);
    }
}