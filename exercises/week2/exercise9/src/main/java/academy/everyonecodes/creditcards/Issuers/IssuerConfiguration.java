package academy.everyonecodes.creditcards.Issuers;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("creditcards")
public class IssuerConfiguration {

    private List<Issuer> issuers;

    @Bean
    public List<Issuer> provideIssuers(){
        return issuers;
    }

    void setIssuers(List<Issuer> issuers) {
        this.issuers = issuers;
    }
}
