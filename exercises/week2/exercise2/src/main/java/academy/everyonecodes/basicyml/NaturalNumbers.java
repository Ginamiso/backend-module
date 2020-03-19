package academy.everyonecodes.basicyml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NaturalNumbers {

    private int naturalNumber;

    public NaturalNumbers(@Value("${basic.naturalnumber}")int naturalNumber) {
        this.naturalNumber = naturalNumber;
    }
    public int get(){
        return naturalNumber;
    }
}
