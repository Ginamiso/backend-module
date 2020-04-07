package academy.everyonecodes.tailoredrecommendations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@ConfigurationProperties("tailored")
public class TailoredRecommendationsStore {

    private List<TailoredRecommendation> recommendations;

    void setRecommendations(List<TailoredRecommendation> recommendations) {
        this.recommendations = recommendations;
    }

    List<TailoredRecommendation> get() {
        return recommendations;
    }

    public List<Movie> getForUser(String userUuid) {
        return recommendations.stream()
                .filter(tailoredRecommendation -> tailoredRecommendation.getUserUuid().equalsIgnoreCase(userUuid))
                .map(TailoredRecommendation::getMovie)
                .collect(toList());
    }

    public TailoredRecommendation post(TailoredRecommendation recommendation) {
        recommendations.add(recommendation);
        return recommendation;
    }
}
