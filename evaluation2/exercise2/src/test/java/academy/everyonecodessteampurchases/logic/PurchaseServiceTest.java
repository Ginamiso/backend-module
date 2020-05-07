package academy.everyonecodessteampurchases.logic;

import academy.everyonecodessteampurchases.domain.Purchase;
import academy.everyonecodessteampurchases.persistence.domain.Game;
import academy.everyonecodessteampurchases.persistence.domain.User;
import academy.everyonecodessteampurchases.persistence.repository.GameRepository;
import academy.everyonecodessteampurchases.persistence.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class PurchaseServiceTest {

    @Autowired
    PurchaseService purchaseService;

    @MockBean
    UserRepository userRepository;

    @MockBean
    GameRepository gameRepository;

    String uuid = "uuid";
    String username = "username";
    String gameName = "gameName";

    static Stream<Arguments> parameters() {
        Game game = new Game("gameName", "uuid", 0);
        User user = new User("username");
        return Stream.of(
                Arguments.of(Optional.of(user), Optional.of(game)),
                Arguments.of(Optional.empty(), Optional.of(game))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void saveDoesNotCreateNewGame(Optional<User> oUser, Optional<Game> oGame) {
        Purchase purchase = new Purchase(username, gameName, uuid, 0);
        Game game = new Game(gameName, uuid, 0);
        when(gameRepository.findByUuid(uuid))
                .thenReturn(oGame);
        when(userRepository.findByUsername(username))
                .thenReturn(oUser);

        purchaseService.save(purchase);

        verify(gameRepository).findByUuid(uuid);
        verify(userRepository).findByUsername(username);
        verifyNoMoreInteractions(gameRepository);
        User expected = new User(username, Set.of(game));
        verify(userRepository).save(expected);
    }

    static Stream<Arguments> parameters2() {
        User user = new User("username");
        return Stream.of(
                Arguments.of(Optional.of(user), Optional.empty()),
                Arguments.of(Optional.empty(), Optional.empty())
        );
    }

    @ParameterizedTest
    @MethodSource("parameters2")
    void SaveCreatesNewGame(Optional<User> oUser, Optional<Game> oGame) {
        Purchase purchase = new Purchase(username, gameName, uuid, 0);
        Game game = new Game(gameName, uuid, 0);
        when(gameRepository.findByUuid(uuid))
                .thenReturn(oGame);
        when(userRepository.findByUsername(username))
                .thenReturn(oUser);

        purchaseService.save(purchase);

        verify(gameRepository).findByUuid(uuid);
        verify(userRepository).findByUsername(username);
        verify(gameRepository).save(game);
        User expected = new User(username, Set.of(game));
        verify(userRepository).save(expected);
    }

    @Test
    void getAllUsers() {
        purchaseService.getAllUsers();

        verify(userRepository).findAll();
    }

    @Test
    void getAllGames() {
        purchaseService.getAllGames();

        verify(gameRepository).findAll();
    }
}