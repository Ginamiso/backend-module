package academy.everyonecodes.validation.methodLevel;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ValidationService {

    public String validate(@Length(min = 3) String text) {
        return text;
    }
}
