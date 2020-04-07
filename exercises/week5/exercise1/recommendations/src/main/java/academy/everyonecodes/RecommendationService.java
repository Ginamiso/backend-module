package academy.everyonecodes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    private final TailoredRecommendationsClient tailoredClient;
    private final HotRightNowClient hotRightNowClient;

    public RecommendationService(TailoredRecommendationsClient tailoredClient, HotRightNowClient hotRightNowClient) {
        this.tailoredClient = tailoredClient;
        this.hotRightNowClient = hotRightNowClient;
    }

    public List<Movie> getMovies(String userUuid) {
        List<Movie> tailored = tailoredClient.get(userUuid);
        if (tailored.isEmpty()) {
            return hotRightNowClient.get();
        }
        return tailored;
    }
}
