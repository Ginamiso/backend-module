package academy.everyonecodes.roundupcounter;

import org.springframework.stereotype.Service;

@Service
public class UpDownIndicator {

    private final Rounder rounder;

    public UpDownIndicator(Rounder rounder) {
        this.rounder = rounder;
    }
    public String indicate(double number){
        double roundUp = rounder.roundUp(number);
        double roundDown = rounder.roundDown(number);
        if(roundUp - number < 0.5){
            return "UP";
        }
        if(number - roundDown < 0.5){
            return "DOWN";
        }
        return "SAME";
    }
}
