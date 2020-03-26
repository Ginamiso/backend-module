package academy.everyonecodes.marathon;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MarathonService {

    private Set<Runner> runners = new HashSet<>();

    public void add(Runner runner){
        runners.add(runner);
    }
    public Optional<Runner> findWinner(){
        return runners.stream()
                .sorted(Comparator.comparing(Runner::getDuration))
                .findFirst();
    }
    Set<Runner> getRunners(){
        return runners;
    }
}
