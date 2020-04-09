package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.domain.Summary;

import java.util.List;

public class Basket {

    private final List<Summary> summaries;

    public Basket(List<Summary> summaries) {
        this.summaries = summaries;

    }

    public void add(Summary summary) {
        summaries.add(summary);
    }

    public List<Summary> getSummaries() {
        return summaries;
    }
}
