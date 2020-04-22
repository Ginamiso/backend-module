package academy.everyonecodes.drhousediagnoses.logic;

import academy.everyonecodes.drhousediagnoses.communication.client.TreatmentsClient;
import academy.everyonecodes.drhousediagnoses.domain.Patient;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisRoom {

    private final DrHouse drHouse;
    private final TreatmentsClient treatmentsClient;

    public DiagnosisRoom(DrHouse drHouse, TreatmentsClient treatmentsClient) {
        this.drHouse = drHouse;
        this.treatmentsClient = treatmentsClient;
    }

    public Patient diagnose(Patient patient) {
        drHouse.diagnose(patient);
        treatmentsClient.post(patient);
        return patient;
    }
}
