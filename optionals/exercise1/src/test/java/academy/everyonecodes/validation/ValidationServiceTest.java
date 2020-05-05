package academy.everyonecodes.validation;

import academy.everyonecodes.validation.methodLevel.ValidationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ValidationService.class)
class ValidationServiceTest {

    @Autowired
    MockMvc mvc;

    ValidationService service = new ValidationService();

    @Test
    void textHasLessThan3Characters() throws Exception {
        assertThrows(ConstraintViolationException.class, () -> {
            service.validate("a");
        });
    }
    @Test
    void textHasMoreThan3Character(){
        service.validate("aaaaa");

    }
}