package academy.everyonecodes.drhousetreatments.logic;

import academy.everyonecodes.drhousetreatments.persistence.domain.Treatment;
import academy.everyonecodes.drhousetreatments.persistence.repository.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {

    private final TreatmentRepository repository;

    public TreatmentService(TreatmentRepository repository) {
        this.repository = repository;
    }

    public List<Treatment> findAll(){
        return repository.findAll();
    }
    public List<Treatment> findBy(String uuid){
        return repository.findByUuid(uuid);
    }
}
