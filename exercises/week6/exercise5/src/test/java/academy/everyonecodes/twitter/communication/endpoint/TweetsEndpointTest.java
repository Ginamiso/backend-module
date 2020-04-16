package academy.everyonecodes.twitter.communication.endpoint;

import academy.everyonecodes.twitter.logic.TwitterService;
import academy.everyonecodes.twitter.persistence.domain.Tweet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TweetsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    TwitterService twitterService;

    String url = "/tweets";
    String id = "id";

    @Test
    void getByTimestamp() {
        testRestTemplate.getForObject(url, Tweet[].class);

        verify(twitterService).findByTimestamp();
    }

    @Test
    void findBy() {
        String user = "user";
        testRestTemplate.getForObject(url +"/user/"+user, Tweet[].class);

        verify(twitterService).findByUser(user);
    }

    @Test
    void post() {
        Tweet tweet = new Tweet("user", "text", 0, new ArrayList<>(), LocalDateTime.now());
        testRestTemplate.postForObject(url, tweet, Tweet.class);

        verify(twitterService).post(tweet);
    }

    @Test
    void like() {
        testRestTemplate.put(url+"/"+id+"/likes", Void.class);

        verify(twitterService).like(id);
    }

    @Test
    void comment() {
        String comment = "comment";
        testRestTemplate.put(url+"/"+id+"/comments",comment);

        verify(twitterService).comment(id, comment);
    }
}