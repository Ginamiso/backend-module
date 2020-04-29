package academy.everyonecodes.complexformula;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class FormulaClientTest {

    @Autowired
    FormulaClient formulaClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${formula.url}")
    String url;

    @Test
    void post() {
        Integer number = 22;

        formulaClient.post(number);

        Mockito.verify(restTemplate).postForObject(url, number, Integer.class);
    }
}