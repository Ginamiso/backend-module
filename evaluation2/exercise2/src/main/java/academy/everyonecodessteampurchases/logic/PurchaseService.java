package academy.everyonecodessteampurchases.logic;

import academy.everyonecodessteampurchases.domain.Purchase;
import academy.everyonecodessteampurchases.persistence.domain.Game;
import academy.everyonecodessteampurchases.persistence.domain.User;
import academy.everyonecodessteampurchases.persistence.repository.GameRepository;
import academy.everyonecodessteampurchases.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;

    public PurchaseService(GameRepository gameRepository, UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
    }

    public Purchase save(Purchase purchase) {
        Game game = findOrCreateGame(purchase);
        User user = getUser(purchase);
        user.getGames().add(game);
        userRepository.save(user);
        return purchase;
    }

    private Game findOrCreateGame(Purchase purchase) {
        return gameRepository.findByUuid(purchase.getUuid())
                .orElseGet(() -> createNewGame(purchase));
    }

    private Game createNewGame(Purchase purchase) {
        Game game = new Game(
                purchase.getGameName(),
                purchase.getUuid(),
                purchase.getPrice());
        gameRepository.save(game);
        return game;
    }

    private User getUser(Purchase purchase) {
        return userRepository.findByUsername(purchase.getUsername())
                .orElse(new User(purchase.getUsername()));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
}
