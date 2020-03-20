package academy.everyonecodes.secret.agent.handshakes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PriceToHandshakesTranslator {

    private final int minPrice;
    private final int maxPrice;
    private final HandshakeNumberToMoveTranslator translator;

    public PriceToHandshakesTranslator(@Value("${secretagent.minPrice}") int minPrice,
                                       @Value("${secretagent.maxPrice}") int maxPrice,
                                       HandshakeNumberToMoveTranslator translator) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.translator = translator;
    }

    public List<String> translate(int price) {
        if (price >= minPrice && price <= maxPrice) {
            String numberToString = String.valueOf(price);
            List<String> numberToList = List.of(numberToString.split(""));
            return numberToList.stream()
                    .map(Integer::parseInt)
                    .map(translator::translate)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
