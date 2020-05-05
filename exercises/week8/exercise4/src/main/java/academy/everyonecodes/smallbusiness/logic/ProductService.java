package academy.everyonecodes.smallbusiness.logic;

import academy.everyonecodes.smallbusiness.persistence.domain.Product;
import academy.everyonecodes.smallbusiness.persistence.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ShopService shopService;


    public ProductService(ProductRepository repository, ShopService shopService) {
        this.repository = repository;
        this.shopService = shopService;

    }

    public void save(Product product) {
        repository.save(product);
    }

    public List<Product> findByIsPremium(boolean isPremium) {
        return (shopService.isOpen()) ? repository.findByIsPremium(isPremium) : new ArrayList<>();

    }
}
