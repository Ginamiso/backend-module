package academy.everyonecodes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class HotRightNowClient{

    private final RestTemplate restTemplate;
    private final String url;

    public HotRightNowClient(RestTemplate restTemplate,
                             @Value("${hotrightnow.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }
    public List<Movie> get() {
        Movie[] response = restTemplate.getForObject(url, Movie[].class);
        return List.of(response);

    }
}
