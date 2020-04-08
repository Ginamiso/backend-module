package academy.everyonecodes.tailoredrecommendations;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tailoredrecommendations")
public class TailoredRecommendationsEndpoint {

    private final TailoredRecommendationsStore store;

    public TailoredRecommendationsEndpoint(TailoredRecommendationsStore store) {
        this.store = store;
    }
    @GetMapping("/{userUuid}")
    List<Movie> get(@PathVariable String userUuid){
        return store.getForUser(userUuid);
    }
    @PostMapping
    TailoredRecommendation postOne(@RequestBody TailoredRecommendation tailoredRecommendation){
        store.post(tailoredRecommendation);
        return tailoredRecommendation;
    }
}
