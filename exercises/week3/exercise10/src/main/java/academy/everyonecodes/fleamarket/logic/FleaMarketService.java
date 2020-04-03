package academy.everyonecodes.fleamarket.logic;

import academy.everyonecodes.fleamarket.domain.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class FleaMarketService {

    private final List<Item> items = new ArrayList<>();

    public Item add(Item item) {
        items.add(item);
        return item;
    }

    public List<Item> findBy(String name) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .collect(toList());
    }

    public List<Item> findAll() {
        return items;
    }
}
