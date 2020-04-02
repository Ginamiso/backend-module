package everyonecodes.academy.loremipsum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/loremipsum")
public class LoremIpsumEndpoint {

    private final RestTemplate restTemplate;
    private final String url = "https://loripsum.net/api";


    public LoremIpsumEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    String getLoremIpsum() {
        return restTemplate.getForObject(url, String.class);
    }
}


