package academy.everyonecodes.marco;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marco")
public class MarcoEndpoint {

    private final PoloClient poloClient;

    public MarcoEndpoint(PoloClient poloClient) {
        this.poloClient = poloClient;
    }

    @GetMapping("/{message}")
    String getMessage(@PathVariable String message) {
        return poloClient.post(message);
    }
}
