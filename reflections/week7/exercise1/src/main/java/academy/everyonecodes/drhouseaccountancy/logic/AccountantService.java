package academy.everyonecodes.drhouseaccountancy.logic;

import academy.everyonecodes.drhouseaccountancy.communication.dto.PatientDTO;
import academy.everyonecodes.drhouseaccountancy.persistence.domain.Invoice;
import academy.everyonecodes.drhouseaccountancy.persistence.domain.Patient;
import academy.everyonecodes.drhouseaccountancy.persistence.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AccountantService {

    private final PatientRepository patientRepository;
    private final InvoiceService invoiceService;
    private final double cost;

    public AccountantService(PatientRepository patientRepository, InvoiceService invoiceService,
                             @Value("${treatment.cost}") double cost) {
        this.patientRepository = patientRepository;
        this.invoiceService = invoiceService;
        this.cost = cost;
    }

    public PatientDTO invoice(PatientDTO patientDTO) {
        Patient patient = findOrCreateNew(patientDTO);
        Invoice invoice = new Invoice(cost, patient);
        invoiceService.save(invoice);
        return patientDTO;
    }

    private Patient findOrCreateNew(PatientDTO patientDTO) {
        return patientRepository.findByUuid(patientDTO.getUuid())
                .orElseGet(() -> createNew(patientDTO));
    }

    private Patient createNew(PatientDTO patientDTO) {
        Patient patient = new Patient(patientDTO.getUuid(),
                patientDTO.getName(),
                patientDTO.getSymptoms(),
                patientDTO.getDiagnosis(),
                patientDTO.getTreatment()
        );
        return patientRepository.save(patient);
    }
}
