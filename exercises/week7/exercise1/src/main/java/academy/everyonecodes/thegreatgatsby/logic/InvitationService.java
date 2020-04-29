package academy.everyonecodes.thegreatgatsby.logic;

import academy.everyonecodes.thegreatgatsby.persistence.repository.InvitationRepository;
import academy.everyonecodes.thegreatgatsby.persistence.domain.Invitation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class InvitationService {

    private final InvitationRepository repository;
    private final String menu;
    private final String invite;
    private final String show;
    private final String conclude;
    private final Scanner scanner = new Scanner(System.in);

    public InvitationService(InvitationRepository repository,
                             @Value("${gatsby.menu}") String menu,
                             @Value("${gatsby.invite}") String invite,
                             @Value("${gatsby.show}") String show,
                             @Value("${gatsby.conclude}") String conclude) {
        this.repository = repository;
        this.menu = menu;
        this.invite = invite;
        this.show = show;
        this.conclude = conclude;
    }

    public void party() {
        boolean isPartyOn = true;
        while (isPartyOn) {
            System.out.print(menu);
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                invite();
            }
            if (choice == 2) {
                showInvitations();
            }
            if (choice == 3) {
                isPartyConcluded();
            }
            if (choice == 4) {
                isPartyOn = false;
            }
        }
    }


    private void isPartyConcluded() {
        System.out.println(conclude);
        String answer = scanner.nextLine();
        if (answer.equals("y")) {
            System.out.println("- The current party was concluded.");
            repository.deleteAll();
        } else {
            System.out.println("- The current party is still ongoing.");
        }
    }

    private void showInvitations() {
        System.out.println(show);
        List<Invitation> all = repository.findAll();
        if (all.isEmpty()) {
            System.out.println("No invitations yet");
        }
        all.forEach(invitation -> System.out.println(invitation.getName()));
        System.out.println("> Press any key to continue.");
    }

    private void invite() {
        System.out.println(invite);
        String name = scanner.nextLine();
        Invitation invitation = new Invitation(name);
        repository.save(invitation);
        System.out.println("- " + name + " was added to the list.");
    }
}
