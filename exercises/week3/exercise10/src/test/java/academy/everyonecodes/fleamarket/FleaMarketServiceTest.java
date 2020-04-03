package academy.everyonecodes.fleamarket;

import academy.everyonecodes.fleamarket.domain.Item;
import academy.everyonecodes.fleamarket.logic.FleaMarketService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FleaMarketServiceTest {

    FleaMarketService service = new FleaMarketService();

    @Test
    void add() {
        Item item = new Item("Chair", 20.9);
        service.add(item);
        List<Item> expected = List.of(new Item("Chair", 20.9));
        List<Item> result = service.findAll();

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findBy(List<Item> expected, String input) {
        service.add(new Item("Chair", 2.20));
        service.add(new Item("Chair", 3.20));
        service.add(new Item("Table", 2.20));
        service.add(new Item("Table", 3.20));

        List<Item> result = service.findBy(input);

        assertEquals(expected, result);
    }
    static Stream<Arguments> parameters(){
        return  Stream.of(
                Arguments.of(List.of(
                        new Item("Chair", 2.20),
                        new Item("Chair", 3.20)), "Chair"),
                Arguments.of(List.of(
                        new Item("Table", 2.20),
                        new Item("Table", 3.20)), "Table"),
                Arguments.of(List.of(), "")
        );
    }
}