package academy.everyonecodes.drhouseaccountancy.logic;

import academy.everyonecodes.drhouseaccountancy.communication.dto.PatientDTO;
import academy.everyonecodes.drhouseaccountancy.persistence.domain.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientTranslator {

    public Patient translateToEntity(PatientDTO patientDTO){
        return new Patient(
                patientDTO.getUuid(),
                patientDTO.getName(),
                patientDTO.getSymptoms(),
                patientDTO.getDiagnosis(),
                patientDTO.getTreatment()
        );
    }
}
