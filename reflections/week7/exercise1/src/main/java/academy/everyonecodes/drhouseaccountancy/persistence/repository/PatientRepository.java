package academy.everyonecodes.drhouseaccountancy.persistence.repository;

import academy.everyonecodes.drhouseaccountancy.persistence.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByUuid(String uuid);
}
