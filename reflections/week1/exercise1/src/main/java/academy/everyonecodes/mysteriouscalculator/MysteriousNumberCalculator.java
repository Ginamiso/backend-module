package academy.everyonecodes.mysteriouscalculator;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MysteriousNumberCalculator {

    private final Set<MysteriousAddition> additions;
    private final MysteriousNumberFormatter formatter;

    public MysteriousNumberCalculator(Set<MysteriousAddition> additions, MysteriousNumberFormatter formatter) {
        this.additions = additions;
        this.formatter = formatter;
    }

    public String calculate(int number) {
        return additions.stream()
                .map(addition -> addition.apply(number))
                .map(formatter::format)
                .collect(Collectors.joining(", "));

    }
}
