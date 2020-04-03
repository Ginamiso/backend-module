package academy.everyonecodes.polo;

import org.springframework.stereotype.Service;

@Service
public class Polo {

    public String answer(String message) {
        return message.equals("Marco") ? "Polo" : "What?";
    }
}