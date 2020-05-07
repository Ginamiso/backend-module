package academy.everyonecodes.steamusers.communication.endpoint;

import academy.everyonecodes.steamusers.logic.SteamUserService;
import academy.everyonecodes.steamusers.persistence.domain.SteamUser;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Secured("ROLE_APP")
public class AppEndpoint {

    private final SteamUserService service;

    public AppEndpoint(SteamUserService service) {
        this.service = service;
    }

    @PostMapping
    SteamUser post(@RequestBody SteamUser steamUser) {
        return service.save(steamUser);
    }
}
