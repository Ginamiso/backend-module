package academy.everyonecodes.musicstation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MusicStationTest {

    @Autowired
    MusicStation musicStation;

    @Test
    void findAll() {
        List<Song> expected = List.of(
                new Song("one", "1"),
                new Song("two", "1"),
                new Song("three", "2"));
        List<Song> result = musicStation.findAll();

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findBy(List<Song> expected, String input) {
        List<Song> result = musicStation.findBy(input);

        assertEquals(expected, result);
    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(new Song("one", "1"), new Song("two", "1")), "1"),
                Arguments.of(List.of(new Song("three", "2")), "2"),
                Arguments.of(List.of(), "")
        );
    }
}