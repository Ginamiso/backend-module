package academy.everyonecodes.smallbusiness.communication.enpoint;

import academy.everyonecodes.smallbusiness.logic.ProductService;
import academy.everyonecodes.smallbusiness.persistence.domain.Product;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsEndpoint {

    private final ProductService productService;

    public ProductsEndpoint(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    @Secured("ROLE_OWNER")
    Product post(@RequestBody Product product){
        productService.save(product);
        return product;
    }
    @GetMapping
    List<Product> getNotPremium(){
        return productService.getNormalProducts();
    }
    @GetMapping("/premium")
    @Secured({"ROLE_PREMIUM", "ROLE_OWNER"})
    List<Product> getPremium(){
        return productService.getPremium();
    }

}
