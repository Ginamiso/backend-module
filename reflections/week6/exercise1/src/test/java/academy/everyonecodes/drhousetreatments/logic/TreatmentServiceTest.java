package academy.everyonecodes.drhousetreatments.logic;

import academy.everyonecodes.drhousetreatments.persistence.repository.TreatmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TreatmentServiceTest {

    @Autowired
    TreatmentService service;

    @MockBean
    TreatmentRepository repository;

    @Test
    void findAll() {
        service.findAll();

        verify(repository).findAll();
    }

    @Test
    void findBy() {
        String uuid = "uuid";
        service.findBy(uuid);

        verify(repository).findByUuid(uuid);
    }
}