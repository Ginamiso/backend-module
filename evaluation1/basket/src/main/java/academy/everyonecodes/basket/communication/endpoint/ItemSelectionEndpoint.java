package academy.everyonecodes.basket.communication.endpoint;

import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.logic.SummaryCalculator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemselections")
public class ItemSelectionEndpoint {

    private final SummaryCalculator summaryCalculator;

    public ItemSelectionEndpoint(SummaryCalculator summaryCalculator) {
        this.summaryCalculator = summaryCalculator;
    }

    @PostMapping
    ItemSelection post(@RequestBody ItemSelection itemSelection) {
        summaryCalculator.process(itemSelection);
        return itemSelection;
    }
}
