package academy.everyonecodes.smallbusiness.communication.enpoint;

import academy.everyonecodes.smallbusiness.logic.ShopService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopEndpoint {

    private final ShopService shopService;

    public ShopEndpoint(ShopService shopService) {
        this.shopService = shopService;
    }

    @PutMapping("/open")
    @Secured("ROLE_OWNER")
    void open() {
        shopService.open();
    }

    @PutMapping("/close")
    @Secured("ROLE_OWNER")
    void close() {
        shopService.close();
    }
}
