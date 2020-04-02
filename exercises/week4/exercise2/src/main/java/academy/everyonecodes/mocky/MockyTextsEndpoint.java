package academy.everyonecodes.mocky;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/mocky/texts")
public class MockyTextsEndpoint {

    private final RestTemplate restTemplate;
    private final String url1;
    private final String url2;

    public MockyTextsEndpoint(RestTemplate restTemplate,
                              @Value("${mocky.texts.1}") String url1,
                              @Value("${mocky.texts.2}") String url2) {
        this.restTemplate = restTemplate;
        this.url1 = url1;
        this.url2 = url2;

    }

    @GetMapping("/1")
    String getOne() {
        return restTemplate.getForObject(url1, String.class);
    }

    @GetMapping("/2")
    List<String> getTwo() {
        String[] response = restTemplate.getForObject(url2, String[].class);
        return List.of(response);
    }
}
