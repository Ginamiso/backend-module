package academy.everyonecodes.punchcards;

import academy.everyonecodes.punchcards.logic.PunchCardService;
import academy.everyonecodes.punchcards.persistence.domain.PunchCard;
import academy.everyonecodes.punchcards.persistence.repository.PunchCardRepository;
import academy.everyonecodes.punchcards.runner.PunchCardRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
class PunchCardServiceTest {

    @Autowired
    PunchCardService punchCardService;

    @MockBean
    PunchCardRepository repository;

    @MockBean
    PunchCardRunner punchCardRunner;

    @Test
    void create() {
        punchCardService.create();

        verify(repository).save(any(PunchCard.class));
    }
}