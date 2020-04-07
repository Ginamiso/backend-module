package academy.everyonecodes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class RecommendationServiceTest {

    @Autowired
    RecommendationService service;

    @MockBean
    TailoredRecommendationsClient tailoredClient;

    @MockBean
    HotRightNowClient hotRightNowClient;

    List<Movie> movies = List.of(new Movie("test", "test"));
    String userUuid = "123";

    @Test
    void getTailored() {
        when(tailoredClient.get(userUuid))
                .thenReturn(movies);

        List<Movie> result = service.getMovies(userUuid);

        assertEquals(movies, result);

        verify(tailoredClient).get(userUuid);
        verify(hotRightNowClient, never()).get();
    }

    @Test
    void getHot() {
        when(tailoredClient.get(userUuid))
                .thenReturn(List.of());
        when(hotRightNowClient.get())
                .thenReturn(movies);

        List<Movie> result = service.getMovies(userUuid);

        assertEquals(movies, result);

        verify(tailoredClient).get(userUuid);
        verify(hotRightNowClient).get();
    }
}