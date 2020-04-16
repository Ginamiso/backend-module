package academy.everyonecodes.thefinalcountdown.logic;

import academy.everyonecodes.thefinalcountdown.persistence.domain.Accumulation;
import academy.everyonecodes.thefinalcountdown.persistence.repository.AccumulationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccumulationManager {

    private final AccumulationRepository accumulationRepository;

    public AccumulationManager(AccumulationRepository accumulationRepository) {
        this.accumulationRepository = accumulationRepository;

    }

    public void accumulate() {
        if (accumulationRepository.count() == 0) {
            Accumulation accumulation = new Accumulation();
            accumulationRepository.save(accumulation);
        }
        List<Accumulation> accumulations = accumulationRepository.findAll();
        Accumulation accumulation = accumulations.get(0);
        int times = accumulation.getTimes();
        accumulation.setTimes(times + 1);
        accumulationRepository.save(accumulation);
        System.out.println("Times that the countdown went off: " + accumulation.getTimes());
    }
}

