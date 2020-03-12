package academy.everyonecodes.roundupcounter;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UpCounter {

    private final UpDownIndicator upDownIndicator;

    public UpCounter(UpDownIndicator upDownIndicator) {
        this.upDownIndicator = upDownIndicator;
    }
    public long count(List<Double> numbers){
        return numbers.stream()
                .map(upDownIndicator::indicate)
                .filter(result -> result.equals("UP"))
                .count();
    }
}
