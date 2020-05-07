package academy.everyonecodes.steamusers.communication.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Secured("ROLE_USER")
public class LoginEndpoint {

    private final String message;

    public LoginEndpoint(@Value("${steam-users.regular.message}") String message) {
        this.message = message;
    }

    @PostMapping
    String getMessage() {
        return message;
    }
}
