package academy.everyonecodes.mysterioussecretorder.logic;

import academy.everyonecodes.mysterioussecretorder.persistence.domain.User;
import academy.everyonecodes.mysterioussecretorder.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final String apprentices;

    public OrderService(UserRepository repository, PasswordEncoder encoder,
                        @Value("${apprentices}") String apprentices) {
        this.repository = repository;
        this.encoder = encoder;
        this.apprentices = apprentices;
    }
    public void save(User user){
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);
        repository.save(user);
    }
    public List<User> findAll(){
        return repository.findAll();
    }
    public List<User> findApprentices(){
        return repository.findByAuthorities(apprentices);
    }
    public Optional<User> findByUsername(String username){
        return repository.findOneByUsername(username);
    }
}
