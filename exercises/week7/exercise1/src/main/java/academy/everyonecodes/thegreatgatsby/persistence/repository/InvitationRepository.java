package academy.everyonecodes.thegreatgatsby.persistence.repository;

import academy.everyonecodes.thegreatgatsby.persistence.domain.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
}
