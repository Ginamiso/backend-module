package academy.everyonecodes.couchpotato.communication.endpoint;

import academy.everyonecodes.couchpotato.logic.FilmService;
import academy.everyonecodes.couchpotato.persistence.domain.Film;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmEndpoint {

    private final FilmService filmService;

    public FilmEndpoint(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    List<Film> get() {
        return filmService.findAll();
    }

    @PostMapping
    Film post(@Valid @RequestBody Film film) {
        return filmService.save(film);

    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}
