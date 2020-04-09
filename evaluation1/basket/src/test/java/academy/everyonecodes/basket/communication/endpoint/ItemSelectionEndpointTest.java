package academy.everyonecodes.basket.communication.endpoint;

import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.logic.SummaryCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ItemSelectionEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    SummaryCalculator summaryCalculator;

    String url = "/itemselections";

    @Test
    void post() {
        ItemSelection itemSelection = new ItemSelection("test", "test", 0.0);

        testRestTemplate.postForObject(url, itemSelection, ItemSelection.class);

        verify(summaryCalculator).process(itemSelection);
    }
}