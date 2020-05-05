package academy.everyonecodes.rides.logic;

import academy.everyonecodes.rides.persistence.domain.Driver;
import academy.everyonecodes.rides.persistence.domain.Ride;
import academy.everyonecodes.rides.persistence.repository.DriverRepository;
import academy.everyonecodes.rides.persistence.repository.RideRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class UberServiceTest {

    @Autowired
    UberService uberService;

    @MockBean
    DriverRepository driverRepository;

    @MockBean
    RideRepository rideRepository;

    @Test
    void save() {
        Driver driver = new Driver("username", "car");
        driverRepository.save(driver);

        verify(driverRepository).save(driver);
    }

    @Test
    void findAll() {
        uberService.findAll();

        verify(driverRepository).findAll();
    }

    @Test
    void connectDoesNotFindDriver() {
        Long id = 1L;
        Ride ride = new Ride("customer", 0.0, 0.0);
        when(driverRepository.findById(id))
                .thenReturn(Optional.empty());

        uberService.connect(ride, id);
        verify(driverRepository).findById(id);
        verifyNoInteractions(rideRepository);
        verifyNoMoreInteractions(driverRepository);
    }

    @Test
    void connectFindsDriver() {
        Long id = 1L;
        Driver driver = new Driver(id, "username", "car", new ArrayList<>());
        Ride ride = new Ride("customer", 0.0, 0.0);
        when(driverRepository.findById(id))
                .thenReturn(Optional.of(driver));

        assertTrue(driver.getRides().isEmpty());

        uberService.connect(ride, id);

        assertEquals(1, driver.getRides().size());
        verify(rideRepository).save(ride);
        Driver expected = new Driver(id, "username", "car", List.of(ride));
        verify(driverRepository).save(expected);
    }
}