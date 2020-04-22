package academy.everyonecodes.couchpotato.logic;

import academy.everyonecodes.couchpotato.persistence.domain.Film;
import academy.everyonecodes.couchpotato.persistence.repository.FilmRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class FilmServiceTest {

    @Autowired
    FilmService filmService;

    @MockBean
    FilmRepository repository;

    @Test
    void findAll() {
        filmService.findAll();

        verify(repository).findAll();
    }

    @Test
    void save() {
        Film film = new Film("test", 1);
        filmService.save(film);

        verify(repository).save(film);
    }
}