package academy.everyonecodes.trickster.communication.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class CupsClient {

    private final RestTemplate restTemplate;
    private final List<String> cupsUrls;

    public CupsClient(RestTemplate restTemplate,
                      @Value("${cups.url}") List<String> cupsUrls) {
        this.restTemplate = restTemplate;
        this.cupsUrls = cupsUrls;
    }

    public Boolean hasCoin(int number) {
        String url = cupsUrls.get(number);
        return restTemplate.getForObject(url, Boolean.class);
    }

    public void putCoin(int number) {
        String url = cupsUrls.get(number);
        restTemplate.put(url, true);
    }
    public void deleteCoin(int number){
        String url = cupsUrls.get(number);
        restTemplate.delete(url);
    }
    public int getCups(){
        return cupsUrls.size();
    }
}
