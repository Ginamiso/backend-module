package academy.everyonecodes.complexformula;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplexFormula {

    private final FormulaClient formulaClient;

    public ComplexFormula(FormulaClient formulaClient) {
        this.formulaClient = formulaClient;
    }
    public int calculate(int number) {
        List<String> digits = List.of(String.valueOf(number).split(""));
        String result = digits.stream()
                .map(Integer::valueOf)
                .map(formulaClient::post)
                .map(String::valueOf)
                .collect(Collectors.joining());
        return Integer.parseInt(result);
    }
}

