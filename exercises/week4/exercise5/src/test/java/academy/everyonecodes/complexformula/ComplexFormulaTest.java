package academy.everyonecodes.complexformula;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ComplexFormulaTest {

    @Autowired
    ComplexFormula complexFormula;

    @MockBean
    FormulaClient formulaClient;


    @Test
    void calculate() {
        int number = 2;
        when(formulaClient.post(number))
                .thenReturn(4);

        int result = complexFormula.calculate(number);

        assertEquals(4, result);

        verify(formulaClient).post(number);

    }
}