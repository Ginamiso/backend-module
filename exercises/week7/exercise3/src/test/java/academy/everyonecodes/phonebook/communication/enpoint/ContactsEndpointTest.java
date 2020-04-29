package academy.everyonecodes.phonebook.communication.enpoint;

import academy.everyonecodes.phonebook.persistence.domain.Address;
import academy.everyonecodes.phonebook.persistence.domain.Contact;
import academy.everyonecodes.phonebook.logic.PhoneBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ContactsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    PhoneBookService service;

    String url="/contacts";

    @Test
    void getAll() {
        testRestTemplate.getForObject(url, Contact[].class);

        verify(service).findAll();
    }

    @Test
    void findBy() {
        String postalCode = "test";
        testRestTemplate.getForObject(url +"/postalcodes/"+postalCode, Contact[].class);

        verify(service).findBy(postalCode);
    }

    @Test
    void post() {
        Contact contact = new Contact("test", new Address("test", "test"));
        testRestTemplate.postForObject(url, contact, Contact.class);

        verify(service).save(contact);
    }

    @Test
    void delete() {
        testRestTemplate.delete(url);

        verify(service).delete();
    }
}