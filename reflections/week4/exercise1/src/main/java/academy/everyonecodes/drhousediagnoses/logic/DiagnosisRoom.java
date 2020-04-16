package academy.everyonecodes.drhousediagnoses.logic;

import academy.everyonecodes.drhousediagnoses.domain.Patient;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisRoom {

    private final DrHouse drHouse;

    public DiagnosisRoom(DrHouse drHouse) {
        this.drHouse = drHouse;
    }

    public Patient diagnose(Patient patient) {
        drHouse.diagnose(patient);
        String message = "Patient with symptoms: "
                + patient.getSymptoms()
                + "; diagnose with: "
                + patient.getDiagnosis();
        System.out.println(message);
        return patient;
    }
}
