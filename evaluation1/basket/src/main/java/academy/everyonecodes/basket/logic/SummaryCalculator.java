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
        String userEmail = itemSelection.getUserEmail();
        String itemName = itemSelection.getItemName();
        double itemPrice = itemSelection.getItemPrice();
        double deliveryCost = 2.50;
        Optional<User> oUser = usersClient.getBy(userEmail);
        if (oUser.isPresent() && oUser.get().getAccountType().equalsIgnoreCase("premium")) {
            deliveryCost = 0;
        }
        double totalPrice = itemPrice + deliveryCost;
        Summary summary = new Summary(
                userEmail,
                itemName,
                itemPrice,
                deliveryCost,
                totalPrice);
        basket.add(summary);
    }
}
