package academy.everyonecodes.drhousetreatments.communication.client;

import academy.everyonecodes.drhousetreatments.persistence.domain.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class AccountancyClient {

    private final RestTemplate restTemplate;
    private final String url;

    public AccountancyClient(RestTemplate restTemplate,
                             @Value("${accountancy.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }
    public void post(Patient patient){
        restTemplate.postForObject(url, patient, Void.class);
    }
}
