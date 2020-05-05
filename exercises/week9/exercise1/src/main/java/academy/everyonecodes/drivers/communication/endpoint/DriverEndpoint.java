package academy.everyonecodes.drivers.communication.endpoint;

import academy.everyonecodes.drivers.logic.DriverService;
import academy.everyonecodes.drivers.persistence.domain.Driver;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriverEndpoint {

    private final DriverService driverService;

    public DriverEndpoint(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    Driver post(@RequestBody Driver driver) {
        return driverService.save(driver);
    }

    @GetMapping("/{id}")
    @Secured("ROLE_DRIVER")
    Driver getOne(@PathVariable String id) {
        return driverService.findDriver(id)
                .orElse(null);
    }

    @PutMapping("/{id}/available")
    @Secured("ROLE_DRIVER")
    void available(@PathVariable String id) {
        driverService.tagAsAvailable(id);
    }

    @PutMapping("/{id}/unavailable")
    @Secured("ROLE_DRIVER")
    void unavailable(@PathVariable String id) {
        driverService.tagAsNotAvailable(id);
    }
}
