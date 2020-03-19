package academy.everyonecodes.basicproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NaturalNumber {

    private int naturalNumber;

    public NaturalNumber(@Value("${basic.naturalnumber}") int naturalNumber) {
        this.naturalNumber = naturalNumber;
    }
    public int get(){
        return naturalNumber;
    }
}
