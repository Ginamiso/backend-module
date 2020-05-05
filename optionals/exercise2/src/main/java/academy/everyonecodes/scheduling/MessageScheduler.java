package academy.everyonecodes.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableAsync
public class MessageScheduler {

    private final SchedulingService service;

    public MessageScheduler(SchedulingService service) {
        this.service = service;
    }
    @Async
    @Scheduled(fixedDelayString = "${async1.delay")
    public void printMessage(){
        service.readMessage();
    }
    @Async
    @Scheduled(fixedRateString = "${asynch2.rate}")
    public void printSecondMessage(){
        service.readSecondMessage();
    }
    @Async
    @Scheduled(cron = "${asynch3.cron}")
    public void printThirdMessage(){
        service.readThirdMessage();
    }


}
