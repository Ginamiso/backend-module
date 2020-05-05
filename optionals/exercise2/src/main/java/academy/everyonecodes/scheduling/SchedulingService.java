package academy.everyonecodes.scheduling;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SchedulingService {

    private final String message1;
    private final String message2;
    private final String message3;

    public SchedulingService(
            @Value("${asynch1.message1}") String message1,
            @Value("${asynch2.message2}")String message2,
            @Value("${asynch3.message3}")String message3) {
        this.message1 = message1;
        this.message2 = message2;
        this.message3 = message3;
    }

    public String readMessage(){
        return message1;
    }
    public String readSecondMessage(){
        return message2;
    }
    public String readThirdMessage(){
        return message3;
    }
}
