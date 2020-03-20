package academy.everyonecodes.secret.agent.handshakes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PriceToHandshakesTranslatorTest {

    @Autowired
    PriceToHandshakesTranslator translator;

    @ParameterizedTest
    @MethodSource("parameters")
    void translate(List<String> expected, int input) {
        List<String> result = translator.translate(input);

        assertEquals(expected, result);
    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(), 0),
                Arguments.of(List.of(), 1000),
                Arguments.of(List.of(), 10),
                Arguments.of(List.of("thumb"), 12),
                Arguments.of(List.of("thumb", "little"), 23),
                Arguments.of(List.of("thumb", "little"), 273)
        );
    }
}
