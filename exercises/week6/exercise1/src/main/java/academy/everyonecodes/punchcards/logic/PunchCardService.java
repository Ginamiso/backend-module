package academy.everyonecodes.punchcards.logic;

import academy.everyonecodes.punchcards.persistence.domain.PunchCard;
import academy.everyonecodes.punchcards.persistence.repository.PunchCardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class PunchCardService {

    private final PunchCardRepository punchCardRepository;

    public PunchCardService(PunchCardRepository punchCardRepository) {
        this.punchCardRepository = punchCardRepository;
    }

    public void create() {
        PunchCard punchCard = new PunchCard(LocalDate.now().getDayOfWeek().toString(), LocalTime.now().toString());
        punchCardRepository.save(punchCard);
        System.out.println("Item saved: " + punchCard);

    }
}
