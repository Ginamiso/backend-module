package academy.everyonecodes.emergencynumbers;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class EmergencyNumberProvider {

    private final Set<EmergencyNumber> numbers;
    private final GeneralEmergency generalEmergency;


    public EmergencyNumberProvider(Set<EmergencyNumber> numbers, GeneralEmergency generalEmergency) {
        this.numbers = numbers;
        this.generalEmergency = generalEmergency;
    }

    public int provide(String name) {
        return numbers.stream()
                .filter(emergencyNumber -> emergencyNumber.getName().equals(name))
                .map(EmergencyNumber::getNumber)
                .findFirst()
                .orElse(generalEmergency.getNumber());

    }
}

