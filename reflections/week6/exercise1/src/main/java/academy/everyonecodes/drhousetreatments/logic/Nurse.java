package academy.everyonecodes.drhousetreatments.logic;

import academy.everyonecodes.drhousetreatments.persistence.domain.Patient;
import academy.everyonecodes.drhousetreatments.persistence.domain.Treatment;
import academy.everyonecodes.drhousetreatments.persistence.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Nurse {

    private final TreatmentRepository repository;
    private final String treatment;

    public Nurse(TreatmentRepository repository,
                 @Value("${nurse.treatment}") String treatment) {
        this.repository = repository;
        this.treatment = treatment;
    }

    public Patient treat(Patient patient) {
        patient.setTreatment(treatment);
        repository.save(new Treatment(
                patient.getUuid(),
                patient.getName(),
                patient.getSymptoms(),
                patient.getDiagnosis(),
                patient.getTreatment()));
        return patient;
    }
}
