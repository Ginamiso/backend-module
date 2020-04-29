package academy.everyonecodes.phonebook.communication.enpoint;

import academy.everyonecodes.phonebook.persistence.domain.Contact;
import academy.everyonecodes.phonebook.logic.PhoneBookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactsEndpoint {

    private final PhoneBookService service;

    public ContactsEndpoint(PhoneBookService service) {
        this.service = service;
    }
    @GetMapping
    List<Contact> getAll(){
        return service.findAll();
    }
    @GetMapping("/postalcodes/{postalCode}")
    List<Contact> findBy(@PathVariable String postalCode){
        return service.findBy(postalCode);
    }
    @PostMapping
    Contact post(@Valid @RequestBody Contact contact){
        return service.save(contact);
    }
    @DeleteMapping
    void delete(){
        service.delete();
    }
}
