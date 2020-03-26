package academy.everyonecodes.developerskills;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DeveloperServiceTest {

    @Autowired
    DeveloperService developerService;

    @Test
    void findAll() {
        List<Developer> expected = List.of(
                new Developer("one", Set.of("1", "2", "3")),
                new Developer("two", Set.of("4", "3")),
                new Developer("three", Set.of("6", "2", "3")));
        List<Developer> result = developerService.findAll();

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findBy(List<Developer> expected, String input) {
        List<Developer> result = developerService.findBy(input);

        assertEquals(expected, result);
    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(
                        new Developer("one", Set.of("1", "2", "3"))), "1 2 3"),
                Arguments.of(List.of(new Developer("two", Set.of("4", "3"))), "4"),
                Arguments.of(List.of(), "7"),
                Arguments.of(List.of(new Developer("one", Set.of("1", "2", "3")),
                        new Developer("two", Set.of("4", "3")),
                        new Developer("three", Set.of("6", "2", "3"))), "3"),
                Arguments.of(List.of(new Developer("one", Set.of("1", "2", "3")),
                        new Developer("three", Set.of("6", "2", "3"))), "2 3")
        );
    }
}