package academy.everyonecodes.drhousetreatments.communication.endpoint;

import academy.everyonecodes.drhousetreatments.logic.TreatmentService;
import academy.everyonecodes.drhousetreatments.persistence.domain.Treatment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/treatments")
public class TreatmentEndpoint {

    private final TreatmentService treatmentService;

    public TreatmentEndpoint(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }
    @GetMapping
    List<Treatment> getAll(){
        return treatmentService.findAll();
    }
    @GetMapping("/{uuid}")
    List<Treatment> getBy(@PathVariable String uuid){
        return treatmentService.findBy(uuid);
    }

}

