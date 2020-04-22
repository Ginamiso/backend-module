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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TwitterServiceTest {

    @Autowired
    TwitterService twitterService;

    @MockBean
    TweetRepository tweetRepository;

    Tweet tweet = new Tweet("user", "text", 0, new ArrayList<>(), LocalDateTime.now());
    String id = "id";
    String comment = "comment";

    @Test
    void findByTimestamp() {
        twitterService.findByTimestamp();

        verify(tweetRepository).findByOrderByTimestampDesc();
    }

    @Test
    void findByUser() {
        String user = "user";

        twitterService.findByUser(user);

        verify(tweetRepository).findByUserOrderByTimestampDesc(user);
    }

    @Test
    void post() {
        Tweet tweet = new Tweet("test", "test");
        assertNull(tweet.getComments());
        assertNull(tweet.getTimestamp());

        twitterService.post(tweet);

        assertNotNull(tweet.getComments());
        assertTrue(tweet.getComments().isEmpty());
        assertNotNull(tweet.getTimestamp());
        verify(tweetRepository).save(tweet);
    }

    @Test
    void likeFindsTweet() {
        assertEquals(0, tweet.getLikes());
        when(tweetRepository.findById(id))
                .thenReturn(Optional.of(tweet));

        twitterService.like(id);

        assertEquals(1, tweet.getLikes());
        verify(tweetRepository).findById(id);
        verify(tweetRepository).save(tweet);

    }
    @Test
    void likeFindsNoTweet(){
        when(tweetRepository.findById(id))
                .thenReturn(Optional.empty());

        twitterService.like(id);

        verify(tweetRepository).findById(id);
        verify(tweetRepository, never()).save(any(Tweet.class));
    }

    @Test
    void commentFindsTweet() {
        assertNotNull(tweet.getComments());
        assertTrue(tweet.getComments().isEmpty());
        when(tweetRepository.findById(id))
                .thenReturn(Optional.of(tweet));

        twitterService.comment(id, comment);

        assertEquals(1, tweet.getComments().size());
        assertEquals(comment, tweet.getComments().get(0));
        verify(tweetRepository).findById(id);
        verify(tweetRepository).save(tweet);
    }
    @Test
    void commentFindsNoTweet(){
        when(tweetRepository.findById(id))
                .thenReturn(Optional.empty());

        twitterService.comment(id, comment);

        verify(tweetRepository).findById(id);
        verify(tweetRepository, never()).save(any(Tweet.class));

    }
}