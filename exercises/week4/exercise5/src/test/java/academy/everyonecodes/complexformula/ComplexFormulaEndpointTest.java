package academy.everyonecodes.complexformula;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ComplexFormulaEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    ComplexFormula complexFormula;

    @Test
    void get() {
        int number = 22;
        String url = "/complexformula";

        restTemplate.getForObject(url+"/"+ number, Integer.class);

        Mockito.verify(complexFormula).calculate(number);
    }
}