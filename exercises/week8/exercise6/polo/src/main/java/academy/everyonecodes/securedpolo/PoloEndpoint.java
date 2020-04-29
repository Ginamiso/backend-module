package academy.everyonecodes.securedpolo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/polo")
public class PoloEndpoint {

    private final PoloService poloService;

    public PoloEndpoint(PoloService poloService) {
        this.poloService = poloService;
    }
    @PostMapping
    String getAnswer(@RequestBody String message){
        return poloService.answer(message);
    }
}
