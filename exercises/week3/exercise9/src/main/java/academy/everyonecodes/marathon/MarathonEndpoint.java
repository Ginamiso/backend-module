package academy.everyonecodes.marathon;

import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/runners")
public class MarathonEndpoint {

    private final MarathonService marathonService;

    public MarathonEndpoint(MarathonService marathonService) {
        this.marathonService = marathonService;
    }

    @PostMapping
    Runner post(@RequestBody Runner runner) {
        marathonService.add(runner);
        return runner;
    }

    @GetMapping("/winner")
    Runner getWinner() {
        return marathonService.findWinner().orElse(null);
    }

    @GetMapping
    Set<Runner> getAll() {
        return marathonService.getRunners();
    }
}
