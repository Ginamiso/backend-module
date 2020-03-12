package academy.everyonecodes.calculator.calculation;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressionParser {

    public Expression parse(String text) {

        List<String> parsedText = List.of(text.split(" "));
        String symbol = parsedText.get(1);
        double term1 = Double.parseDouble(parsedText.get(0));
        double term2 = Double.parseDouble(parsedText.get(2));
        Expression expression = new Expression(symbol, term1, term2);
        return expression;
    }

}
