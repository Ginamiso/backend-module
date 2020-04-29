package academy.everyonecodes.mysterioussecretorder.communication.endpoint;

import academy.everyonecodes.mysterioussecretorder.logic.OrderService;
import academy.everyonecodes.mysterioussecretorder.persistence.domain.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MembersEndpoint {

    private final OrderService orderService;

    public MembersEndpoint(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @Secured("ROLE_MASTER")
    User post(@RequestBody User user) {
        orderService.save(user);
        return user;
    }

    @GetMapping
    @Secured("ROLE_MASTER")
    List<User> get() {
        return orderService.findAll();
    }

    @GetMapping("/apprentices")
    @Secured({"ROLE_APPRENTICE", "ROLE_MASTER"})
    List<User> getApprentices() {
        return orderService.findApprentices();
    }

}
