package academy.everyonecodes.trickster.logic;

import academy.everyonecodes.trickster.communication.client.CupsClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TricksterTest {

    @Autowired
    Trickster trickster;

    @MockBean
    CupsClient cupsClient;

    @MockBean
    Random random;

    int cup = 0;

    @Test
    void play() {

        Mockito.when(cupsClient.getCups()).thenReturn(3);
        Mockito.when(random.nextInt(3)).thenReturn(cup);
        String result = trickster.play();
        String expected = "The cups have been shuffled!";
        assertEquals(expected, result);

        Mockito.verify(random).nextInt(3);
        Mockito.verify(cupsClient).getCups();
        Mockito.verify(cupsClient).deleteCoin(cup);
        Mockito.verify(cupsClient).putCoin(cup);
    }

    @Test
    void hasCoin() {
        Mockito.when(cupsClient.hasCoin(cup))
                .thenReturn(true);

        boolean result = trickster.hasCoin(cup);

        assertTrue(result);

        Mockito.verify(cupsClient).hasCoin(cup);
    }
}