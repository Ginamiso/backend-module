package academy.everyonecodes.basket.communication.client;

import academy.everyonecodes.basket.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Controller
public class UsersClient {

    private final RestTemplate restTemplate;
    private final String usersUrl;

    public UsersClient(RestTemplate restTemplate,
                       @Value("${users.url}") String usersUrl) {
        this.restTemplate = restTemplate;
        this.usersUrl = usersUrl;
    }

    public Optional<User> getBy(String email) {
        String emailUrl = usersUrl + "/" + email;
        User user = restTemplate.getForObject(emailUrl, User.class);
        return Optional.ofNullable(user);
    }
}
