package academy.everyonecodes.drhouseaccountancy.logic;

import academy.everyonecodes.drhouseaccountancy.communication.dto.PatientDTO;
import academy.everyonecodes.drhouseaccountancy.persistence.domain.Invoice;
import academy.everyonecodes.drhouseaccountancy.persistence.domain.Patient;
import academy.everyonecodes.drhouseaccountancy.persistence.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AccountantServiceTest {

    @Autowired
    AccountantService accountantService;

    @MockBean
    InvoiceService invoiceService;

    @MockBean
    PatientRepository patientRepository;

    @Value("${treatment.cost}")
    double cost;

    String uuid = "uuid";
    PatientDTO patientDTO = new PatientDTO(uuid, "name", "symptoms", "diagnosis", "treatment");
    Patient patient = new Patient(uuid, "name", "symptoms", "diagnosis", "treatment");
    @Test
    void invoiceDoesNotFindPatient() {
        Invoice invoice = new Invoice(cost, patient);
        when(patientRepository.findByUuid(uuid))
                .thenReturn(Optional.empty());
        when(patientRepository.save(patient))
                .thenReturn(patient);

        accountantService.invoice(patientDTO);

        verify(patientRepository).findByUuid(uuid);
        verify(patientRepository).save(patient);
        verify(invoiceService).save(invoice);
    }
    @Test
    void invoiceFindsPatient(){
        Invoice invoice = new Invoice(cost, patient);
        when(patientRepository.findByUuid(uuid))
                .thenReturn(Optional.of(patient));

        accountantService.invoice(patientDTO);

         verify(patientRepository).findByUuid(uuid);
         verifyNoMoreInteractions(patientRepository);
         verify(invoiceService).save(invoice);
    }


}