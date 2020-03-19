package academy.everyonecodes.advancedyml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("advanced.several")
public class SeveralValues {

    private List<Integer> naturalNumbers;
    private List<Double> decimalNumbers;
    private List<String> words;
    private List<Boolean> choices;

    public void setNaturalNumbers(List<Integer> naturalNumbers) {
        this.naturalNumbers = naturalNumbers;
    }

    public void setDecimalNumbers(List<Double> decimalNumbers) {
        this.decimalNumbers = decimalNumbers;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public void setChoices(List<Boolean> choices) {
        this.choices = choices;
    }

    public List<Integer> getNaturalNumbers() {
        return naturalNumbers;
    }

    public List<Double> getDecimalNumbers() {
        return decimalNumbers;
    }

    public List<String> getWords() {
        return words;
    }

    public List<Boolean> getChoices() {
        return choices;
    }
}
