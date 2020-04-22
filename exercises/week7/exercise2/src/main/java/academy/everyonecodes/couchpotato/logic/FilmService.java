package academy.everyonecodes.couchpotato.logic;

import academy.everyonecodes.couchpotato.persistence.domain.Film;
import academy.everyonecodes.couchpotato.persistence.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private final FilmRepository repository;

    public FilmService(FilmRepository repository) {
        this.repository = repository;
    }

    public List<Film> findAll() {
        return repository.findAll();
    }

    public Film save(Film film) {
        return repository.save(film);
    }

}


