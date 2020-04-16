package academy.everyonecodes.twitter.logic;

import academy.everyonecodes.twitter.persistence.domain.Tweet;
import academy.everyonecodes.twitter.persistence.repository.TweetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TwitterServiceTest {

    @Autowired
    TwitterService twitterService;

    @MockBean
    TweetRepository tweetRepository;

    Tweet tweet = new Tweet("user", "text", 0, new ArrayList<>(), LocalDateTime.now());
    String id = "id";

    @Test
    void findByTimestamp() {
        twitterService.findByTimestamp();

        verify(tweetRepository).findByOrderByTimestampDesc();
    }

    @Test
    void findByUser() {
        String user = "user";

        List<Tweet> result = twitterService.findByUser(user);

        verify(tweetRepository).findByUserOrderByTimestampDesc(user);
    }

    @Test
    void post() {
        twitterService.post(tweet);

        verify(tweetRepository).save(tweet);
    }

    @Test
    void like() {
        when(tweetRepository.findById(id))
                .thenReturn(Optional.of(tweet));
        when(tweetRepository.save(tweet))
                .thenReturn(tweet);

        twitterService.like(id);

        assertEquals(1, tweet.getLikes());
        verify(tweetRepository).findById(id);
        verify(tweetRepository).save(tweet);

    }

    @Test
    void comment() {
        String comment = "comment";

        when(tweetRepository.findById(id))
                .thenReturn(Optional.of(tweet));
        when(tweetRepository.save(tweet))
                .thenReturn(tweet);

        twitterService.comment(id, comment);
        assertEquals(1, tweet.getComments().size());

        verify(tweetRepository).findById(id);
        verify(tweetRepository).save(tweet);
    }
}