package academy.everyonecodes.restauranttaxer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BillCalculator {

    private Set<Taxer> taxers;

    public BillCalculator(Set<Taxer> taxers) {
        this.taxers = taxers;
    }

    public double calculate(List<RestaurantDish> dishes) {
         return dishes.stream()
                .mapToDouble(dish -> taxers.stream()
                        .filter(taxer -> taxer.matches(dish))
                        .findAny().map(taxer -> taxer.tax(dish))
                        .orElseGet(dish::getPrice))
                .sum();
    }
}