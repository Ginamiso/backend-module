package academy.everyonecodes.drhouseaccountancy.communication.enpoint;

import academy.everyonecodes.drhouseaccountancy.logic.InvoiceService;
import academy.everyonecodes.drhouseaccountancy.persistence.domain.Invoice;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@Secured("ROLE_ACCOUNTANT")
public class InvoiceEndpoint {

    private final InvoiceService invoiceService;

    public InvoiceEndpoint(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;

    }

    @GetMapping
    List<Invoice> get() {
        return invoiceService.findAll();
    }

    @PutMapping("/{id}/paid")
    void markAsPaid(@PathVariable Long id) {
        invoiceService.markAsPaid(id);
    }

}
