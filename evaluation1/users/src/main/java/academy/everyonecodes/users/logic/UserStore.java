package academy.everyonecodes.users.logic;

import academy.everyonecodes.users.domain.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@ConfigurationProperties("registered")
public class UserStore {

    private List<User> users;

    public Optional<User> findByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();

    }

    void setUsers(List<User> users) {
        this.users = users;
    }
}
