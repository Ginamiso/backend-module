package academy.everyonecodes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Controller
public class TailoredRecommendationsClient {

    private final RestTemplate restTemplate;
    private final String url;

    public TailoredRecommendationsClient(RestTemplate restTemplate,
                                         @Value("${tailored.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public List<Movie> get(String userUuid) {
        Movie[] response = restTemplate.getForObject(url + "/" + userUuid, Movie[].class);
        return List.of(Objects.requireNonNull(response));
    }
}
