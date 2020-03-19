package academy.everyonecodes.emergencynumbers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GeneralEmergency implements EmergencyNumber {

    private String name;
    private int number;

    public GeneralEmergency(@Value("${emergency.general.name}") String name,
                            @Value("${emergency.general.number}")int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumber() {
        return number;
    }
}
