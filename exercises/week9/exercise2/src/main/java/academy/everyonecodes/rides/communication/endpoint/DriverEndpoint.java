package academy.everyonecodes.rides.communication.endpoint;

import academy.everyonecodes.rides.logic.UberService;
import academy.everyonecodes.rides.persistence.domain.Driver;
import academy.everyonecodes.rides.persistence.domain.Ride;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverEndpoint {

    private final UberService uberService;

    public DriverEndpoint(UberService uberService) {
        this.uberService = uberService;
    }

    @PostMapping
    @Secured("ROLE_ADMIN")
    Driver postDriver(@RequestBody Driver driver) {
        return uberService.save(driver);
    }

    @GetMapping
    @Secured("ROLE_ADMIN")
    List<Driver> get() {
        return uberService.findAll();
    }

    @PostMapping("/{id}/rides")
    @Secured("ROLE_APP")
    Ride postRide(@RequestBody Ride ride, @PathVariable Long id) {
        uberService.connect(ride, id);
        return ride;
    }
}
