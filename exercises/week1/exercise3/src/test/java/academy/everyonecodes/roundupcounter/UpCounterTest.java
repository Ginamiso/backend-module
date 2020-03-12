package academy.everyonecodes.roundupcounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
class UpCounterTest {

    @Autowired
    UpCounter upCounter;

    @ParameterizedTest
    @MethodSource("parameters")
    void count(long expected, List<Double> input) {
        long result = upCounter.count(input);

        Assertions.assertEquals(expected, result);
    }
    static Stream<Arguments> parameters(){
        return Stream.of(
                Arguments.of(0, List.of()),
                Arguments.of(1, List.of(1.7,1.1)),
                Arguments.of(2, List.of(1.7,2.7))
        );
    }
}