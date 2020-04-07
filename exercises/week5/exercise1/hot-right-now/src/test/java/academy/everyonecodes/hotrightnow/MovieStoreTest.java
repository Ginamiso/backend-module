package academy.everyonecodes.hotrightnow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class MovieStoreTest {

    @Autowired
    MovieStore movieStore;

    @Test
    void getMovies() {
        List<Movie> result = movieStore.getMovies();
        List<Movie> expected = List.of(
                new Movie("test1", "test1"));

        assertEquals(expected, result);
    }
}