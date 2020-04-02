package academy.everyonecodes.trickster.logic;

import academy.everyonecodes.trickster.communication.client.CupsClient;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Trickster {

    private final CupsClient cupsClient;
    private final Random random;

    public Trickster(CupsClient cupsClient, Random random) {
        this.cupsClient = cupsClient;
        this.random = random;
    }

    public String play() {
        int numberOfCups = cupsClient.getCups();
        for (int i = 0; i < numberOfCups; i++) {
          cupsClient.deleteCoin(i);
        }
        int randomCup = random.nextInt(numberOfCups);
        cupsClient.putCoin(randomCup);
        return "The cups have been shuffled!";
    }

    public boolean hasCoin(int number) {
        return cupsClient.hasCoin(number);
    }
}
