package academy.everyonecodes.marathon.integration.communication.endpoint;

import academy.everyonecodes.marathon.integration.domain.TestResult;
import academy.everyonecodes.marathon.integration.logic.MarathonTester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marathon")
public class MarathonIntegrationEndpoint {

    private final MarathonTester marathonTester;

    public MarathonIntegrationEndpoint(MarathonTester marathonTester) {
        this.marathonTester = marathonTester;
    }

    @GetMapping("/integration")
    TestResult get() {
        return marathonTester.test();
    }
}
