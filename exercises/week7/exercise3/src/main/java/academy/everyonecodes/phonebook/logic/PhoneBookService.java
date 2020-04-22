package academy.everyonecodes.phonebook.logic;

import academy.everyonecodes.phonebook.persistence.domain.Address;
import academy.everyonecodes.phonebook.persistence.domain.Contact;
import academy.everyonecodes.phonebook.persistence.repository.AddressRepository;
import academy.everyonecodes.phonebook.persistence.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneBookService {

    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;

    public PhoneBookService(ContactRepository contactRepository, AddressRepository addressRepository) {
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
    }
    public Contact save(Contact contact){
        addressRepository.save(contact.getAddress());
        return contactRepository.save(contact);
    }
    public List<Contact> findAll(){
        return contactRepository.findAll();
    }
    public List<Contact> findBy(String postalCode){
        return contactRepository.findByAddressPostalCode(postalCode);
    }
    public void delete(){
        contactRepository.deleteAll();
    }

}
