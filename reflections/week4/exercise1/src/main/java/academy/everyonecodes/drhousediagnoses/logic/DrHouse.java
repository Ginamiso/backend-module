package academy.everyonecodes.drhousediagnoses.logic;

import academy.everyonecodes.drhousediagnoses.domain.Diagnosis;
import academy.everyonecodes.drhousediagnoses.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrHouse {

    private final List<Diagnosis> diagnoses;

    public DrHouse(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }
    public void diagnose(Patient patient){
        String result =  diagnoses.stream()
                .filter(diagnosis -> diagnosis.getSymptoms().contains(patient.getSymptoms()))
                .map(Diagnosis::getName)
                .findFirst()
                .orElse("lupus");
        patient.setDiagnosis(result);
    }
}
