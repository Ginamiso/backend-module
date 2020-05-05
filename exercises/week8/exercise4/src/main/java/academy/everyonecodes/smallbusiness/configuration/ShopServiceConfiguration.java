package academy.everyonecodes.smallbusiness.configuration;

import academy.everyonecodes.smallbusiness.logic.ShopService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopServiceConfiguration {

    @Bean
    ShopService shopService(){
        return new ShopService(false);
    }
}
