package academy.everyonecodessteampurchases.communication.endpoint;

import academy.everyonecodessteampurchases.domain.Purchase;
import academy.everyonecodessteampurchases.logic.PurchaseService;
import academy.everyonecodessteampurchases.persistence.domain.Game;
import academy.everyonecodessteampurchases.persistence.domain.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PurchaseEndpoint {

    private final PurchaseService purchaseService;

    public PurchaseEndpoint(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping("/purchases")
    @Secured("ROLE_APP")
    Purchase post(@RequestBody Purchase purchase) {
        return purchaseService.save(purchase);
    }

    @GetMapping("/users")
    @Secured("ROLE_ADMIN")
    List<User> getAllUsers() {
        return purchaseService.getAllUsers();
    }

    @GetMapping("/games")
    List<Game> getAllGames() {
        return purchaseService.getAllGames();
    }
}
