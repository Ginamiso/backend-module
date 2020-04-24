package academy.everyonecodes.drhouseaccountancy.logic;

import academy.everyonecodes.drhouseaccountancy.communication.dto.PatientDTO;
import academy.everyonecodes.drhouseaccountancy.persistence.domain.Invoice;
import academy.everyonecodes.drhouseaccountancy.persistence.domain.Patient;
import academy.everyonecodes.drhouseaccountancy.persistence.repository.InvoiceRepository;
import academy.everyonecodes.drhouseaccountancy.persistence.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountantService {

    private final PatientRepository patientRepository;
    private final InvoiceRepository invoiceRepository;
    private final PatientTranslator translator;
    private final double cost;

    public AccountantService(PatientRepository patientRepository, InvoiceRepository invoiceRepository, PatientTranslator translator,
                             @Value("${treatment.cost}") double cost) {
        this.patientRepository = patientRepository;
        this.invoiceRepository = invoiceRepository;
        this.translator = translator;
        this.cost = cost;
    }
    public PatientDTO invoice(PatientDTO patientDTO){
        Patient patient = translator.translateToEntity(patientDTO);
        boolean existsByUuid = patientRepository.existsByUuid(patient.getUuid());
        if(!existsByUuid){
            patientRepository.save(patient);
        }
        Optional<Patient> oPatient = patientRepository.findByUuid(patient.getUuid());
        patient = oPatient.get();
        Invoice invoice = new Invoice(cost, patient);
        invoiceRepository.save(invoice);
        return patientDTO;
    }
    public List<Invoice> getAll(){
        return invoiceRepository.findAll();
    }
    public void setToPaid(Long id){
        Optional<Invoice> oInvoice = invoiceRepository.findById(id);
        if(oInvoice.isEmpty()){
            return;
        }
        Invoice invoice = oInvoice.get();
        invoice.setPaid(true);
        invoiceRepository.save(invoice);
    }
}
