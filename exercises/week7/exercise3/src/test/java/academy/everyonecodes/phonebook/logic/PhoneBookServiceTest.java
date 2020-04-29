package academy.everyonecodes.phonebook.logic;

import academy.everyonecodes.phonebook.persistence.domain.Address;
import academy.everyonecodes.phonebook.persistence.domain.Contact;
import academy.everyonecodes.phonebook.persistence.repository.AddressRepository;
import academy.everyonecodes.phonebook.persistence.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class PhoneBookServiceTest {

    @Autowired
    PhoneBookService service;

    @MockBean
    ContactRepository contactRepository;

    @MockBean
    AddressRepository addressRepository;

    @Test
    void save() {
        Contact contact = new Contact("test", new Address("test", "test"));

        service.save(contact);

        verify(addressRepository).save(contact.getAddress());
        verify(contactRepository).save(contact);
    }

    @Test
    void findAll() {
        service.findAll();

        verify(contactRepository).findAll();
    }

    @Test
    void findBy() {
        String postalCode ="test";
        service.findBy(postalCode);

        verify(contactRepository).findByAddressPostalCode(postalCode);
    }

    @Test
    void delete() {
        service.delete();

        verify(contactRepository).deleteAll();
    }
}