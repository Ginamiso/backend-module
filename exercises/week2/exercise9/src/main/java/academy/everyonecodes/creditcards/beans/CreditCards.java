package academy.everyonecodes.creditcards.beans;

import academy.everyonecodes.creditcards.Issuers.Issuer;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CreditCards {

    private final Set<Issuer> issuers;
    private final Luhn luhn;

    public CreditCards(Set<Issuer> issuers, Luhn luhn) {
        this.issuers = issuers;
        this.luhn = luhn;
    }

    public String inspect(String number) {
        if (!luhn.isValid(number)) {
            return "Invalid";
        }
        return issuers.stream()
                .filter(issuer -> issuer.issues(number))
                .map(Issuer::getName)
                .findFirst()
                .orElse("Not Supported");
    }
}
