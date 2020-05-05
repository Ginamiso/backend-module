package academy.everyonecodes.drivers.logic;

import academy.everyonecodes.drivers.persistence.domain.Driver;
import academy.everyonecodes.drivers.persistence.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {

    private final DriverRepository driverRepository;
    private final PasswordEncoder passwordEncoder;
    private final String role;

    public DriverService(DriverRepository driverRepository,
                         PasswordEncoder passwordEncoder,
                         @Value("${driver.role}") String role) {
        this.driverRepository = driverRepository;
        this.passwordEncoder = passwordEncoder;
        this.role = role;
    }

    public Driver save(Driver driver) {
        Optional<Driver> oDriver = driverRepository.findOneByUsername(driver.getUsername());
        if (oDriver.isPresent()) {
            return oDriver.get();
        }
        driver.getAuthorities().add(role);
        String encoded = passwordEncoder.encode(driver.getPassword());
        driver.setPassword(encoded);
        return driverRepository.save(driver);
    }

    public Optional<Driver> findDriver(String id) {
        return driverRepository.findById(id);
    }

    public void tagAsAvailable(String id) {
        Optional<Driver> oDriver = driverRepository.findById(id);
        if (oDriver.isEmpty()) {
            return;
        }
        Driver driver = oDriver.get();
        driver.setAvailable(true);
        driverRepository.save(driver);
    }

    public void tagAsNotAvailable(String id) {
        Optional<Driver> oDriver = driverRepository.findById(id);
        if (oDriver.isEmpty()) {
            return;
        }
        Driver driver = oDriver.get();
        driver.setAvailable(false);
        driverRepository.save(driver);
    }
}
