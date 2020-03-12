package academy.everyonecodes.calculator.calculation;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class Calculator {
    private final ExpressionParser parser;
    private final Set<Calculation> calculations;

    public Calculator(ExpressionParser parser, Set<Calculation> calculations) {
        this.parser = parser;
        this.calculations = calculations;
    }

    public double calculate(String text) {
        Expression expression = parser.parse(text);
        return calculations.stream()
                .filter(calculation -> calculation.matches(expression))
                .map(calculation -> calculation.calculate(expression))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}


