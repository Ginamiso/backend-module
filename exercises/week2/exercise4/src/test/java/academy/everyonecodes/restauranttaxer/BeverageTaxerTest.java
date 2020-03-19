package academy.everyonecodes.restauranttaxer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BeverageTaxerTest {

    @Autowired
    BeverageTaxer beverageTaxer;

    @ParameterizedTest
    @MethodSource("parametersMatches")
    void matches(boolean expected, RestaurantDish input) {
        boolean result = beverageTaxer.matches(input);

        assertEquals(expected, result);
    }

    static Stream<Arguments> parametersMatches() {
        return Stream.of(
                Arguments.of(true, new RestaurantDish("soda", 3)),
                Arguments.of(true, new RestaurantDish("orange juice", 4)),
                Arguments.of(true, new RestaurantDish("milkshake", 6)),
                Arguments.of(false, new RestaurantDish("tiramisu", 1))
        );
    }

    @ParameterizedTest
    @MethodSource("parametersTax")
    void tax(double expected, RestaurantDish input) {
        double result = beverageTaxer.tax(input);

        assertEquals(expected, result);
    }

    static Stream<Arguments> parametersTax() {
        return Stream.of(
                Arguments.of(2.4, new RestaurantDish("soda", 2)),
                Arguments.of(4.8, new RestaurantDish("orange juice", 4)),
                Arguments.of(8.4, new RestaurantDish("milkshake", 7))

        );
    }
}