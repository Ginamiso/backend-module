package academy.everyonecodes.drhouseaccountancy.communication.enpoint;

import academy.everyonecodes.drhouseaccountancy.logic.AccountantService;
import academy.everyonecodes.drhouseaccountancy.persistence.domain.Invoice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceEndpoint {

    private final AccountantService accountantService;

    public InvoiceEndpoint(AccountantService accountantService) {
        this.accountantService = accountantService;
    }
    @GetMapping
    List<Invoice> get(){
        return accountantService.getAll();
    }
    @PutMapping("/{id}/paid")
    void markAsPaid(@PathVariable Long id){
        accountantService.setToPaid(id);
    }

}
