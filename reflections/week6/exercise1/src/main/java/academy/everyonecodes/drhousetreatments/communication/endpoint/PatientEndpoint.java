package academy.everyonecodes.drhousetreatments.communication.endpoint;

import academy.everyonecodes.drhousetreatments.logic.Nurse;
import academy.everyonecodes.drhousetreatments.persistence.domain.Patient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class
PatientEndpoint {

    private final Nurse nurse;

    public PatientEndpoint(Nurse nurse) {
        this.nurse = nurse;
    }
    @PostMapping
    Patient post(@RequestBody Patient patient){
        return nurse.treat(patient);
    }
}
