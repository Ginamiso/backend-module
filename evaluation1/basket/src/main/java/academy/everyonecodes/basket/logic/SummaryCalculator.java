package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.communication.client.UsersClient;
import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.domain.Summary;
import academy.everyonecodes.basket.domain.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SummaryCalculator {

    private final UsersClient usersClient;
    private final Basket basket;

    public SummaryCalculator(UsersClient usersClient, Basket basket) {
        this.usersClient = usersClient;
        this.basket = basket;
    }

    public void process(ItemSelection itemSelection) {
        double deliveryCost = 2.50;
        Optional<User> oUser = usersClient.getBy(itemSelection.getUserEmail());
        if (oUser.isPresent() && oUser.get().getAccountType().equals("premium")) {
            deliveryCost = 0;
        }
        double totalPrice = itemSelection.getItemPrice() + deliveryCost;
        Summary summary = new Summary(
                itemSelection.getUserEmail(),
                itemSelection.getItemName(),
                itemSelection.getItemPrice(),
                deliveryCost,
                totalPrice);
        basket.add(summary);
    }
}
