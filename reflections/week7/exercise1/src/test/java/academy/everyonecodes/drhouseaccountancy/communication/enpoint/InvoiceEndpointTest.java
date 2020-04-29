package academy.everyonecodes.drhouseaccountancy.communication.enpoint;

import academy.everyonecodes.drhouseaccountancy.logic.InvoiceService;
import academy.everyonecodes.drhouseaccountancy.persistence.domain.Invoice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class InvoiceEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    InvoiceService invoiceService;

    String url = "/invoices";

    @Test
    void get() {
        testRestTemplate.getForObject(url, Invoice[].class);

        verify(invoiceService).findAll();
    }

    @Test
    void markAsPaid() {
        long id = 1L;
        testRestTemplate.put(url +"/"+id +"/paid", null);

        verify(invoiceService).markAsPaid(id);
    }
}