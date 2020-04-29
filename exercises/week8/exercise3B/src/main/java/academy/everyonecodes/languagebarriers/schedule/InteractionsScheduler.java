package academy.everyonecodes.languagebarriers.schedule;

import academy.everyonecodes.languagebarriers.logic.InteractionsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class InteractionsScheduler {

    private final InteractionsService interactionsService;
    private final int amount;

    public InteractionsScheduler(InteractionsService interactionsService,
                                 @Value("${interactions.amount}") int amount) {
        this.interactionsService = interactionsService;
        this.amount = amount;
    }
    @Scheduled(fixedDelayString = "${interactions.delay}")
    public void addInteractions(){
        interactionsService.increaseAmount(amount);
    }
}
