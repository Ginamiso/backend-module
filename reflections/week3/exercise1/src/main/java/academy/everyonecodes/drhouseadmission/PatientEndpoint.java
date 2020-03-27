package academy.everyonecodes.drhouseadmission;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {

    private final Admission admission;

    public PatientEndpoint(Admission admission) {
        this.admission = admission;
    }
    @PostMapping
    Patient post(Patient patient){
        admission.admit(patient);
        return patient;
    }
}
