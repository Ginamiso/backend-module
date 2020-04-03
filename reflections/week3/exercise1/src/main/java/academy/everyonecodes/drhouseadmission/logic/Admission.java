package academy.everyonecodes.drhouseadmission.logic;

import academy.everyonecodes.drhouseadmission.communication.client.DiagnosesClient;
import academy.everyonecodes.drhouseadmission.domain.Patient;
import org.springframework.stereotype.Service;

@Service
public class Admission {

    private final UUIDProvider provider;
    private final DiagnosesClient diagnosesClient;

    public Admission(UUIDProvider provider, DiagnosesClient diagnosesClient) {
        this.provider = provider;
        this.diagnosesClient = diagnosesClient;
    }
    public Patient admit(Patient patient){
        provider.provideUUID(patient);
        diagnosesClient.send(patient);
        return patient;
    }
}
