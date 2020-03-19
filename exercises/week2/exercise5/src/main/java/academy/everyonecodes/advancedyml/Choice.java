package academy.everyonecodes.advancedyml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("advanced")
public class Choice {

    private boolean choice;

    public boolean get() {
        return choice;
    }

    public void setChoice(boolean choice) {
        this.choice = choice;
    }
}
