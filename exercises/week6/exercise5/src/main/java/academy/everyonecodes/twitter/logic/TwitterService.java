package academy.everyonecodes.twitter.logic;

import academy.everyonecodes.twitter.persistence.domain.Tweet;
import academy.everyonecodes.twitter.persistence.repository.TweetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TwitterService {

    private final TweetRepository tweetRepository;

    public TwitterService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public List<Tweet> findByTimestamp() {
        return tweetRepository.findByOrderByTimestampDesc();
    }

    public List<Tweet> findByUser(String user) {
        return tweetRepository.findByUserOrderByTimestampDesc(user);
    }

    public Tweet post(Tweet tweet) {
        tweet.setTimestamp(LocalDateTime.now());
        tweet.setComments(new ArrayList<>());
        tweetRepository.save(tweet);
        return tweet;
    }

    public void like(String id) {
        Optional<Tweet> oTweet = tweetRepository.findById(id);
        if (oTweet.isPresent()) {
            Tweet tweet = oTweet.get();
            int likes = tweet.getLikes();
            tweet.setLikes(likes + 1);
            tweetRepository.save(tweet);
        }
    }

    public void comment(String id, String comment) {
        Optional<Tweet> oTweet = tweetRepository.findById(id);
        if(oTweet.isPresent()){
            Tweet tweet = oTweet.get();
            List<String> comments = tweet.getComments();
            comments.add(comment);
            tweetRepository.save(tweet);
        }
    }

}
