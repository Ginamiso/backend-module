package academy.everyonecodes.smallbusiness.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShopServiceTest {

    @Test
    void isOpen() {
        ShopService shopService = new ShopService(false);

        assertFalse(shopService.isOpen());
    }

    @Test
    void open() {
        ShopService shopService = new ShopService(false);

        shopService.open();

        assertTrue(shopService.isOpen());
    }

    @Test
    void close() {
        ShopService shopService = new ShopService(true);

        shopService.close();

        assertFalse(shopService.isOpen());

    }
}