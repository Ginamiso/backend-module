package academy.everyonecodes.fleamarket;

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
        return service.getAll();
    }

    @PostMapping
    Item post(@RequestBody Item item) {
        service.add(item);
        return item;
    }

    @GetMapping("/{name}")
    List<Item> getName(@PathVariable String name) {
        return service.findBy(name);
    }
}
