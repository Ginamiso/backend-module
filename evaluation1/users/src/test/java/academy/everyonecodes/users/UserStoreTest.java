package academy.everyonecodes.users;

import academy.everyonecodes.users.domain.User;
import academy.everyonecodes.users.logic.UserStore;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class UserStoreTest {

    @Autowired
    UserStore userStore;

    @ParameterizedTest
    @MethodSource("parameters")
    void findByEmail(Optional<User> expected, String input) {
        Optional<User> result = userStore.findByEmail(input);

        assertEquals(expected, result);
    }

    static Stream<Arguments> parameters() {
        User test1 = new User("test1", "test1@email", "test1");
        User test2 = new User("test2", "test2@email", "test2");
        return Stream.of(
                of(Optional.empty(), ""),
                of(Optional.of(test1), "test1@email"),
                of(Optional.of(test2), "test2@email"),
                of(Optional.of(test2), "Test2@email")
        );
    }
}