package academy.everyonecodes.restauranttaxer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FoodstuffTaxerTest {

    @Autowired
    FoodstuffTaxer taxer;

    @ParameterizedTest
    @MethodSource("parametersMatches")
    void matches(boolean expected, RestaurantDish input) {
        boolean result = taxer.matches(input);

        assertEquals(expected, result);
    }

    static Stream<Arguments> parametersMatches() {
        return Stream.of(
                Arguments.of(true, new RestaurantDish("potato soup", 3)),
                Arguments.of(true, new RestaurantDish("caesar salad", 4)),
                Arguments.of(true, new RestaurantDish("tiramisu", 6)),
                Arguments.of(false, new RestaurantDish("soda", 1))
        );
    }

    @ParameterizedTest
    @MethodSource("parametersTax")
    void tax(double expected, RestaurantDish input) {
        double result = taxer.tax(input);

        assertEquals(expected, result);
    }

    static Stream<Arguments> parametersTax() {
        return Stream.of(
                Arguments.of(0, new RestaurantDish("potato soup", 0)),
                Arguments.of(4.4, new RestaurantDish("caesar salad", 4)),
                Arguments.of(1.1, new RestaurantDish("tiramisu", 1))
        );
    }
}