package academy.everyonecodes.advancedyml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SeveralValuesTest {

    @Autowired
    SeveralValues severalValues;

    @Test
    void getNumbers() {
        List<Integer> expected = List.of(3, 6, 9);
        List<Integer> result = severalValues.getNaturalNumbers();

        assertEquals(expected, result);

    }

    @Test
    void getDoubles() {
        List<Double> expected = List.of(3.14, 2.71, 3.359);
        List<Double> result = severalValues.getDecimalNumbers();
        assertEquals(expected, result);
    }

    @Test
    void getWords() {
        List<String> expected = List.of("Answer", "to", "the", "Ultimate", "Question", "of", "Life", "the", "Universe", "and", "Everything");
        List<String> result = severalValues.getWords();
        assertEquals(expected, result);
    }

    @Test
    void getChoices() {
        List<Boolean> expected = List.of(true, false, false, true);
        List<Boolean> result = severalValues.getChoices();
        assertEquals(expected, result);
    }
}