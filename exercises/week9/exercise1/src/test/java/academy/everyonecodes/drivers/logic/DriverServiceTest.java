package academy.everyonecodes.drivers.logic;

import academy.everyonecodes.drivers.persistence.domain.Driver;
import academy.everyonecodes.drivers.persistence.repository.DriverRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DriverServiceTest {

    @Autowired
    DriverService driverService;

    @MockBean
    DriverRepository driverRepository;

    @MockBean
    PasswordEncoder passwordEncoder;

    @Value("${driver.role}")
    String role;

    String id = "id";
    String username = "username";
    String password = "password";
    String encrypted = "encrypted";

    @Test
    void saveDoesNotFindDriver() {
        Driver driver = new Driver(username, password, "car");
        when(driverRepository.findOneByUsername(username))
                .thenReturn(Optional.empty());
        when(passwordEncoder.encode(password))
                .thenReturn(encrypted);

        assertTrue(driver.getAuthorities().isEmpty());

        driverService.save(driver);

        assertEquals(1, driver.getAuthorities().size());
        assertTrue(driver.getAuthorities().contains(role));

        verify(driverRepository).findOneByUsername(username);
        Driver expected = new Driver(username, encrypted, Set.of(role), "car", false);
        verify(driverRepository).save(expected);

    }

    @Test
    void saveFindsDriver() {
        Driver driver = new Driver(username, password, "car");
        Driver savedDriver = new Driver(username, encrypted, Set.of(role), "car", false);
        when(driverRepository.findOneByUsername(username))
                .thenReturn(Optional.of(savedDriver));

        driverService.save(driver);

        verify(driverRepository).findOneByUsername(username);
        verifyNoInteractions(passwordEncoder);
        verifyNoMoreInteractions(driverRepository);
    }

    @Test
    void findDriver() {
        driverService.findDriver(id);

        verify(driverRepository).findById(id);
    }

    @Test
    void tagAsAvailableDoesNotFindDriver() {
        when(driverRepository.findById(id))
                .thenReturn(Optional.empty());

        driverService.tagAsAvailable(id);

        verify(driverRepository).findById(id);
        verifyNoMoreInteractions(driverRepository);
    }

    @Test
    void tagAsAvailableFindsDriver() {
        Driver driver = new Driver("username", "password", Set.of(role), "car", false);
        when(driverRepository.findById(id))
                .thenReturn(Optional.of(driver));

        assertFalse(driver.isAvailable());

        driverService.tagAsAvailable(id);

        assertTrue(driver.isAvailable());

        verify(driverRepository).findById(id);
        Driver expected = new Driver("username", "password", Set.of(role), "car", true);
        verify(driverRepository).save(expected);
    }

    @Test
    void tagAsUnavailableDoesNotFindDriver() {
        when(driverRepository.findById(id))
                .thenReturn(Optional.empty());

        driverService.tagAsNotAvailable(id);

        verify(driverRepository).findById(id);
        verifyNoMoreInteractions(driverRepository);
    }

    @Test
    void tagAsUnavailableFindsDriver() {
        Driver driver = new Driver("username", "password", Set.of(role), "car", true);
        when(driverRepository.findById(id))
                .thenReturn(Optional.of(driver));

        assertTrue(driver.isAvailable());

        driverService.tagAsNotAvailable(id);

        assertFalse(driver.isAvailable());

        verify(driverRepository).findById(id);
        Driver expected = new Driver("username", "password", Set.of(role), "car", false);
        verify(driverRepository).save(expected);
    }
}