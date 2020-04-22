package academy.everyonecodes.couchpotato.communication.endpoint;

import academy.everyonecodes.couchpotato.logic.FilmService;
import academy.everyonecodes.couchpotato.persistence.domain.Film;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class FilmEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    FilmService filmService;

    String url = "/films";

    @Test
    void get() {
        restTemplate.getForObject(url, Film[].class);

        verify(filmService).findAll();
    }

    @Test
    void post() {
        Film film = new Film("test", 1);
        restTemplate.postForObject(url, film , Film.class);

        verify(filmService).save(film);
    }
}