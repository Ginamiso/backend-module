package academy.everyonecodes.mocky;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mocky/postcards")
public class MockyPostcardsEndpoint {

    private final RestTemplate restTemplate;
    private final String url1;
    private final List<String> url2;

    public MockyPostcardsEndpoint(RestTemplate restTemplate,
                                  @Value("${mocky.postcards.1}") String url1,
                                  @Value("${mocky.postcards.2}") List<String> url2) {
        this.restTemplate = restTemplate;
        this.url1 = url1;
        this.url2 = url2;
    }

    @GetMapping("/1")
    Postcard getOne() {
        return restTemplate.getForObject(url1, Postcard.class);
    }

    @GetMapping("/2")
    List<Postcard> getTwo() {
        return url2.stream()
                .map(url -> restTemplate.getForObject(url, Postcard.class))
                .collect(Collectors.toList());

    }

}
