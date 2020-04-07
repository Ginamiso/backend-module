package academy.everyonecodes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationEndpoint {

    private final RecommendationService service;

    public RecommendationEndpoint(RecommendationService service) {
        this.service = service;
    }
    @GetMapping("/{userUuid}")
    List<Movie> get(@PathVariable String userUuid){
        return service.getMovies(userUuid);
    }
}
