package academy.everyonecodes.securedpolo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PoloService {

    private final String marco;
    private final String rightAnswer;
    private final String what;

    public PoloService(@Value("${polo.marco}") String marco,
                       @Value("${polo.rightAnswer}") String rightAnswer,
                       @Value("${polo.what}") String what) {
        this.marco = marco;
        this.rightAnswer = rightAnswer;
        this.what = what;
    }

    public String answer(String question) {
        return question.equals(marco) ? rightAnswer : what;
    }
}
