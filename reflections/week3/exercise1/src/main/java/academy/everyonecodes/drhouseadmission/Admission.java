package academy.everyonecodes.drhouseadmission;

import org.springframework.stereotype.Service;

@Service
public class Admission {

    private final UUIDProvider provider;

    public Admission(UUIDProvider provider) {
        this.provider = provider;
    }
    public Patient admit(Patient patient){
        provider.provideUUID(patient);
        return patient;
    }
}
