package academy.everyonecodes.marathon.integration.logic;

import academy.everyonecodes.marathon.integration.communication.client.MarathonClient;
import academy.everyonecodes.marathon.integration.domain.Runner;
import academy.everyonecodes.marathon.integration.domain.TestResult;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
public class MarathonTester {

    private final MarathonClient marathonClient;
    private final Runner winner;
    private final List<Runner> runners;

    public MarathonTester(MarathonClient marathonClient, Runner winner, List<Runner> runners) {
        this.marathonClient = marathonClient;
        this.winner = winner;
        this.runners = runners;
    }

    public TestResult test() {
        Optional<Runner> oWinner = marathonClient.getWinner();
        if (oWinner.isPresent()) {
            return new TestResult("Error", "No winner should have been received in the first call");
        }
        runners.forEach(marathonClient::post);
        Optional<Runner> oWinnerWins =marathonClient.getWinner();
        if (oWinnerWins.isPresent() && !oWinnerWins.get().equals(winner)) {
            return new TestResult("Error", "Incorrect winner received");
        }
        return new TestResult("Success", "The test runs correctly");
    }
}

