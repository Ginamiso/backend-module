package academy.everyonecodes.interactions;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uppercase")
public class UppercaseEndpoint {


    @PostMapping
    String post(@RequestBody String text){
        return text.toUpperCase();
    }
}
