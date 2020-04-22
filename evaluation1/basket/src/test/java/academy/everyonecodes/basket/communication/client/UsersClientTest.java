package academy.everyonecodes.basket.communication.client;

import academy.everyonecodes.basket.domain.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class UsersClientTest {

    @Autowired
    UsersClient usersClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${users.url}")
    String usersUrl;

    @ParameterizedTest
    @MethodSource("parameters")
    void getBy(Optional<User> oExpected, User user, String email) {
        when(restTemplate.getForObject(usersUrl + "/" + email, User.class))
                .thenReturn(user);

        Optional<User> oResult = usersClient.getBy(email);

        assertEquals(oExpected, oResult);
        verify(restTemplate).getForObject(usersUrl + "/" + email, User.class);
    }

    static Stream<Arguments> parameters() {
        User user = new User("email", "test");
        return Stream.of(
                Arguments.of(Optional.empty(), null, "test"),
                Arguments.of(Optional.of(user), user, "email"),
                Arguments.of(Optional.empty(), null, "")
        );
    }
}