package academy.everyonecodes.fleamarket.communication.endpoint;

import academy.everyonecodes.fleamarket.logic.FleaMarketService;
import academy.everyonecodes.fleamarket.domain.Item;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class FleaMarketEndpoint {

    private final FleaMarketService service;

    public FleaMarketEndpoint(FleaMarketService service) {
        this.service = service;
    }

    @GetMapping
    List<Item> getAll() {
        return service.findAll();
    }

    @PostMapping
    Item post(@RequestBody Item item) {
        return service.add(item);
    }

    @GetMapping("/{name}")
    List<Item> getName(@PathVariable String name) {
        return service.findBy(name);
    }
}
