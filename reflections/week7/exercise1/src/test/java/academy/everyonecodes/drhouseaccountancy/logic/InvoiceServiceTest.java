package academy.everyonecodes.drhouseaccountancy.logic;

import academy.everyonecodes.drhouseaccountancy.persistence.domain.Invoice;
import academy.everyonecodes.drhouseaccountancy.persistence.domain.Patient;
import academy.everyonecodes.drhouseaccountancy.persistence.repository.InvoiceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class InvoiceServiceTest {

    @Autowired
    InvoiceService invoiceService;

    @MockBean
    InvoiceRepository invoiceRepository;

    Invoice invoice = new Invoice(0, false,  new Patient());
    Long id = 1L;

    @Test
    void findAll() {
        invoiceService.findAll();

        verify(invoiceRepository).findAll();
    }

    @Test
    void save() {
        invoiceService.save(invoice);

        verify(invoiceRepository).save(invoice);
    }

    @Test
    void markAsPaidDoesNotFindInvoice() {
        when(invoiceRepository.findById(id))
                .thenReturn(Optional.empty());

        invoiceService.markAsPaid(id);

        verify(invoiceRepository).findById(id);
        verifyNoMoreInteractions(invoiceRepository);
    }

    @Test
    void markAsPaidFindsInvoice() {
        when(invoiceRepository.findById(id))
                .thenReturn(Optional.of(invoice));

        assertFalse(invoice.isPaid());

        invoiceService.markAsPaid(id);

        assertTrue(invoice.isPaid());

        verify(invoiceRepository).findById(id);
        Invoice expected = new Invoice(0, true, new Patient());
        verify(invoiceRepository).save(expected);

    }
}