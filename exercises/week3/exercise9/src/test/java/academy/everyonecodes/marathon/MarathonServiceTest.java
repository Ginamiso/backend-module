package academy.everyonecodes.marathon;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarathonServiceTest {

    MarathonService marathonService = new MarathonService();

    @Test
    void add() {
        Runner runner = new Runner("gina", Duration.parse("PT1H1M34S"));
        marathonService.add(runner);
        Set<Runner> expected = Set.of(new Runner("gina", Duration.parse("PT1H1M34S")));
        Set<Runner> result = marathonService.getRunners();

        assertEquals(expected, result);
    }

    @Test
    void findWinner() {
        Runner expected = new Runner("gina", Duration.parse("PT1H1M34S"));
        Runner looser = new Runner("martin", Duration.parse("PT1H1M34S"));
        marathonService.add(expected);
        marathonService.add(looser);
        Optional<Runner> winner = marathonService.findWinner();

        assertEquals(Optional.of(expected), winner);
    }

    @Test
    void noWinner() {
        Optional<Runner> result = marathonService.findWinner();
        assertEquals(Optional.empty(), result);
    }

}