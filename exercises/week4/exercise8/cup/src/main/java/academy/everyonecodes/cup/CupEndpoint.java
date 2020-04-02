package academy.everyonecodes.cup;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cup")
public class CupEndpoint {

    private final Cup cup;

    public CupEndpoint(Cup cup) {
        this.cup = cup;
    }
    @GetMapping
    boolean checkCup(){
        return cup.hasCoin();
    }
    @PutMapping
    void putCoin(){
        cup.putCoin();
    }
    @DeleteMapping
    void removeCoin(){
        cup.removeCoin();
    }
}
