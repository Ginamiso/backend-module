package academy.everyonecodes.tailoredrecommendations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;
import static org.springframework.test.annotation.DirtiesContext.MethodMode.AFTER_METHOD;

@SpringBootTest(webEnvironment = NONE)
class TailoredRecommendationsStoreTest {

    @Autowired
    TailoredRecommendationsStore store;

    @ParameterizedTest
    @MethodSource("parameters")
    void getForUser(List<Movie> expected, String input) {
        List<Movie> result = store.getForUser(input);

        assertEquals(expected, result);
    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(new Movie("test1", "test1")), "1"),
                Arguments.of(List.of(new Movie("test2", "test2")), "2"),
                Arguments.of(List.of(), "0")
        );
    }

    @DirtiesContext
    @Test
    void post() {

        TailoredRecommendation recommendation = new TailoredRecommendation("1", new Movie("test3", "test3"));
        store.post(recommendation);

        List<TailoredRecommendation> result = store.get();
        List<TailoredRecommendation> expected = List.of(
                new TailoredRecommendation("1", new Movie("test1", "test1")),
                new TailoredRecommendation("2", new Movie("test2", "test2")),
                new TailoredRecommendation("1", new Movie("test3", "test3")));


        assertEquals(expected, result);
        assertEquals(expected.size(), result.size());
    }

    @Test
    void getAll() {
        List<TailoredRecommendation> result = store.get();
        List<TailoredRecommendation> expected = List.of(
                new TailoredRecommendation("1", new Movie("test1", "test1")),
                new TailoredRecommendation("2", new Movie("test2", "test2"))
        );
        assertEquals(expected, result);

    }
}