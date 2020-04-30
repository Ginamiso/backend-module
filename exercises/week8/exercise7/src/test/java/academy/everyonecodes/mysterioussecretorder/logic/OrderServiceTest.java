package academy.everyonecodes.mysterioussecretorder.logic;

import academy.everyonecodes.mysterioussecretorder.persistence.domain.User;
import academy.everyonecodes.mysterioussecretorder.persistence.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cglib.core.WeakCacheKey;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @MockBean
    UserRepository userRepository;

    @MockBean
    PasswordEncoder passwordEncoder;

    @Test
    void save() {
        String password = "tets";
        String encoded = "test&";
        User user = new User("user", password, Set.of("ROLE"));
        when(passwordEncoder.encode(password))
                .thenReturn(encoded);

        orderService.save(user);

        verify(passwordEncoder).encode(password);
        verify(userRepository).save(new User("user", encoded, Set.of("ROLE")));
    }

    @Test
    void findAll() {
        orderService.findAll();

        verify(userRepository).findAll();
    }

    @Test
    void findApprentices() {
        orderService.findApprentices();

        verify(userRepository).findByAuthorities("ROLE_APPRENTICE");
    }
}