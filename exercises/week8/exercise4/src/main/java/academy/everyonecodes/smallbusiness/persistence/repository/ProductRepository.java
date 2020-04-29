package academy.everyonecodes.smallbusiness.persistence.repository;

import academy.everyonecodes.smallbusiness.persistence.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByIsPremium(boolean isPremium);

}
