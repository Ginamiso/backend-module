package academy.everyonecodes.twitter.communication.endpoint;

import academy.everyonecodes.twitter.logic.TwitterService;
import academy.everyonecodes.twitter.persistence.domain.Tweet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetsEndpoint {

    private final TwitterService twitterService;

    public TweetsEndpoint(TwitterService twitterService) {
        this.twitterService = twitterService;
    }
    @GetMapping
    List<Tweet> getByTimestamp(){
        return twitterService.findByTimestamp();
    }
    @GetMapping("/user/{user}")
    List<Tweet> findBy(@PathVariable String user){
        return twitterService.findByUser(user);
    }
    @PostMapping
    Tweet post(@RequestBody Tweet tweet){
        return twitterService.post(tweet);
    }
    @PutMapping("/{id}/likes")
    void like(@PathVariable String id){
        twitterService.like(id);
    }
    @PutMapping("/{id}/comments")
    void comment(@PathVariable String id, @RequestBody String comment){
        twitterService.comment(id, comment);
    }
}
