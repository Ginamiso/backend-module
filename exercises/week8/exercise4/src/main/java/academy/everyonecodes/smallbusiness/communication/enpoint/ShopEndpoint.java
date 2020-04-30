package academy.everyonecodes.smallbusiness.communication.enpoint;

import academy.everyonecodes.smallbusiness.logic.ShopService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Secured("ROLE_OWNER")
@RestController
@RequestMapping("/shop")
public class ShopEndpoint {

    private final ShopService shopService;

    public ShopEndpoint(ShopService shopService) {
        this.shopService = shopService;
    }

    @PutMapping("/open")
    void open() {
        shopService.open();
    }

    @PutMapping("/close")
    void close() {
        shopService.close();
    }
}
