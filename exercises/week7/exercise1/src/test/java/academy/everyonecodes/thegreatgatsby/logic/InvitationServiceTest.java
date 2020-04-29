package academy.everyonecodes.thegreatgatsby.logic;

import academy.everyonecodes.thegreatgatsby.persistence.domain.Invitation;
import academy.everyonecodes.thegreatgatsby.persistence.repository.InvitationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Scanner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class InvitationServiceTest {

    @Autowired
    InvitationService invitationService;

    @MockBean
    InvitationRepository repository;

    @MockBean
    Scanner scanner;
    @Value("${gatsby.menu}")
    String menu;
    @Value("${gatsby.invite}")
    String invite;
    @Value("${gatsby.show}")
    String show;
    @Value("${gatsby.conclude}")
    String conclude;

    @Test
    void partyInvite() {
        String name = "giulia";
        when(scanner.nextInt()).thenReturn(1);
        when(scanner.nextLine()).thenReturn(name);
        Invitation invitation = new Invitation(name);

        invitationService.party();

        verify(repository).save(invitation);
        verify(scanner).nextLine();
        verify(scanner).nextInt();
    }
}