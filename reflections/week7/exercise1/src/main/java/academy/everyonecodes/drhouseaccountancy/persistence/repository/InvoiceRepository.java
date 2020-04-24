package academy.everyonecodes.drhouseaccountancy.persistence.repository;

import academy.everyonecodes.drhouseaccountancy.persistence.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
