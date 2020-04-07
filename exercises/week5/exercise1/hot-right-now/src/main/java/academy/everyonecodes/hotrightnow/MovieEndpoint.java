package academy.everyonecodes.hotrightnow;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieEndpoint {

    private final MovieStore movieStore;

    public MovieEndpoint(MovieStore movieStore) {
        this.movieStore = movieStore;
    }
    @GetMapping
    List<Movie> getAll(){
        return movieStore.getMovies();
    }
}
