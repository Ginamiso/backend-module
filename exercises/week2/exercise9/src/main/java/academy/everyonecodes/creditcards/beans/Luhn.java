package academy.everyonecodes.creditcards.beans;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class Luhn {

    public boolean isValid(String CCNumber) {
        List<Integer> digits = Stream.of(CCNumber.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        Collections.reverse(digits);
        int sum = 0;
        boolean isEven = false;
        for (Integer number : digits) {
            if (isEven) {
                number = number * 2;
            }
            if (number > 9) {
                number = number - 9;
            }
            sum = sum + number;
            isEven = !isEven;
        }
        return sum % 10 == 0;
    }
}
