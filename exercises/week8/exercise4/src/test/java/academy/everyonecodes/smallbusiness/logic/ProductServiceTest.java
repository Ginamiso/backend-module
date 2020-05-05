package academy.everyonecodes.smallbusiness.logic;

import academy.everyonecodes.smallbusiness.persistence.domain.Product;
import academy.everyonecodes.smallbusiness.persistence.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @MockBean
    ProductRepository repository;

    @MockBean
    ShopService shopService;

    @Test
    void save() {
        Product product = new Product("test", 0.0, true);
        productService.save(product);

        verify(repository).save(product);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void findByIsPremiumOpen(boolean isPremium) {
        when(shopService.isOpen())
                .thenReturn(true);

        productService.findByIsPremium(isPremium);

        verify(shopService).isOpen();
        verify(repository).findByIsPremium(isPremium);

    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void findByIsPremiumClosed(boolean isPremium) {

        productService.findByIsPremium(isPremium);

        verify(shopService).isOpen();
        verifyNoInteractions(repository);
    }
}