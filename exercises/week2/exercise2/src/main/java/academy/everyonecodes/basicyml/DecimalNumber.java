package academy.everyonecodes.basicyml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DecimalNumber {

    private double decimalNumber;

    public DecimalNumber(@Value("${basic.decimalnumber}") double decimalNumber) {
        this.decimalNumber = decimalNumber;
    }
    public double get(){
        return decimalNumber;
    }
}
