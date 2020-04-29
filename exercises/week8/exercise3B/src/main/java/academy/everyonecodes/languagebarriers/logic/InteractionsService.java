package academy.everyonecodes.languagebarriers.logic;

import org.springframework.stereotype.Service;

@Service
public class InteractionsService {

    private int numberOfInteractions;

    public int getInteractions() {
        return numberOfInteractions;
    }

    public void increaseInteractions() {
        numberOfInteractions++;
    }

    public void increaseAmount(int amount) {
        numberOfInteractions += amount;
    }
}
