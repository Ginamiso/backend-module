package academy.everyonecodes.basket.communication.client;

import academy.everyonecodes.basket.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    void getBy() {
        User user = new User("test", "test");
        String email = "email";

        when(restTemplate.getForObject(usersUrl+"/"+email, User.class))
                .thenReturn(user);

        Optional<User> oResult = usersClient.getBy(email);
        Optional<User> oExpected = Optional.of(user);
        assertEquals(oExpected, oResult);
        verify(restTemplate).getForObject(usersUrl+"/"+email, User.class);
    }
}