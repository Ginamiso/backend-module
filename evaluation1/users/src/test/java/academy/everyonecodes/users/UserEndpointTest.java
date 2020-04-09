package academy.everyonecodes.users;

import academy.everyonecodes.users.domain.User;
import academy.everyonecodes.users.logic.UserStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    UserStore userStore;

    @Test
    void getBy() {
        String url = "/users";
        String email = "email";

        restTemplate.getForObject(url + "/" + email, User.class);

        verify(userStore).findByEmail(email);
    }
}