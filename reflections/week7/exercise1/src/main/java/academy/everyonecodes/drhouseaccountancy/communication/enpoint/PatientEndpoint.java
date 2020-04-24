package academy.everyonecodes.drhouseaccountancy.communication.enpoint;

import academy.everyonecodes.drhouseaccountancy.communication.dto.PatientDTO;
import academy.everyonecodes.drhouseaccountancy.logic.AccountantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {

    private final AccountantService accountantService;

    public PatientEndpoint(AccountantService accountantService) {
        this.accountantService = accountantService;
    }
    @PostMapping
    PatientDTO post(@RequestBody PatientDTO patientDTO){
        return accountantService.invoice(patientDTO);
    }
}
