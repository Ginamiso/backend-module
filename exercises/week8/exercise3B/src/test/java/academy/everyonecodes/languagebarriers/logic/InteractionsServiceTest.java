package academy.everyonecodes.languagebarriers.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InteractionsServiceTest {

    InteractionsService service;

    @BeforeEach
    void setup() {
        service = new InteractionsService();
    }

    @Test
    void getInteractions() {
        int result = service.getInteractions();

        assertEquals(0, result);

    }

    @Test
    void increaseInteractions() {
        int initial = service.getInteractions();
        assertEquals(0, initial);

        service.increaseInteractions();

        int result = service.getInteractions();
        assertEquals(1, result);
    }

    @Test
    void increaseAmount() {
        int initial = service.getInteractions();
        assertEquals(0, initial);

        service.increaseAmount(1);

        int result = service.getInteractions();
        assertEquals(1, result);
    }
}