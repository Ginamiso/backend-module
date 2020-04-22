package academy.everyonecodes.thefinalcountdown.logic;

import academy.everyonecodes.thefinalcountdown.persistence.domain.Countdown;
import academy.everyonecodes.thefinalcountdown.persistence.repository.CountdownRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CountdownManager {

    private final CountdownRepository countdownRepository;
    private final AccumulationManager accumulationManager;
    private final int start;

    public CountdownManager(CountdownRepository countdownRepository,
                            AccumulationManager accumulationManager,
                            @Value("${countdown.start}") int start) {
        this.countdownRepository = countdownRepository;
        this.accumulationManager = accumulationManager;
        this.start = start;
    }

    public void countdown() {
        if (countdownRepository.count() == 0) {
            createCountdown();
            return;
        }
        decreaseCountdown();
    }

    private void decreaseCountdown() {
        Countdown countdown = countdownRepository.findAll().get(0);
        int count = countdown.getCount();
        countdown.setCount(count - 1);
        if (countdown.getCount() == 0) {
            deleteCountdown(countdown);
            return;
        }
        countdownRepository.save(countdown);
        System.out.println("Countdown: " + countdown.getCount());
    }

    private void deleteCountdown(Countdown countdown) {
        countdownRepository.delete(countdown);
        accumulationManager.accumulate();
    }

    private void createCountdown() {
        Countdown countdown = new Countdown(start);
        countdownRepository.save(countdown);
        System.out.println("Countdown: " + countdown.getCount());
    }

}




