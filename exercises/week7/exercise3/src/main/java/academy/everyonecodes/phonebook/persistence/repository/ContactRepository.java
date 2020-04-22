package academy.everyonecodes.phonebook.persistence.repository;

import academy.everyonecodes.phonebook.persistence.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByAddressPostalCode(String postalCode);

}
