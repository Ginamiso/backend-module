package academy.everyonecodes.creditcards.Issuers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IssuerTest {

    Issuer issuer = new Issuer();

    @ParameterizedTest
    @MethodSource("parameters")
    void issues(boolean expected, Issuer issuer, String input) {
        boolean result = issuer.issues(input);

        assertEquals(expected, result);
    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(true, new Issuer("Mc", Set.of("34"), Set.of(4)), "3444"),
                Arguments.of(false, new Issuer("Mc", Set.of("34"), Set.of(4)), "344"),
                Arguments.of(true, new Issuer("Mc", Set.of("56"), Set.of(5)), "56777")
        );
    }
}