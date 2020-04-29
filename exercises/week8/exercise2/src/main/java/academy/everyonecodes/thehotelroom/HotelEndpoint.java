package academy.everyonecodes.thehotelroom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HotelEndpoint {

    private final String everyone;
    private final String madameD;

    public HotelEndpoint(
            @Value("${messages.everyone}") String everyone,
            @Value("${messages.madameD}") String madameD) {
        this.everyone = everyone;
        this.madameD = madameD;
    }

    @GetMapping
    String get() {
        return everyone;
    }

    @GetMapping("/room")
    String getRoom() {
        return madameD;
    }

}
