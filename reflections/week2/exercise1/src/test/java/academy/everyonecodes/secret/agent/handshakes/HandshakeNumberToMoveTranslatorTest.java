package academy.everyonecodes.secret.agent.handshakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.Stream;

@SpringBootTest
class HandshakeNumberToMoveTranslatorTest {

    @Autowired
    HandshakeNumberToMoveTranslator translator;

    @ParameterizedTest
    @MethodSource("parameters")
    void translate(Optional<String> expected, int input) {
        Optional<String> result = translator.translate(input);

        Assertions.assertEquals(expected, result);

    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(Optional.of("thumb"), 2),
                Arguments.of(Optional.of("little"), 3),
                Arguments.of(Optional.of("tickles"), 5),
                Arguments.of(Optional.of("bro"), 6),
                Arguments.of(Optional.of("thousand"), 9),
                Arguments.of(Optional.empty(), 1),
                Arguments.of(Optional.empty(), 0)

                );
    }
}