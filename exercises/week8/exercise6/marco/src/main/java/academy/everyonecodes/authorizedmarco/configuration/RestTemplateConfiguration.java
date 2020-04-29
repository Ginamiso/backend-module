package academy.everyonecodes.authorizedmarco.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate(@Value("${marcopolo.username}") String username,
                              @Value("${marcopolo.password}") String password) {
        return new RestTemplateBuilder()
                .basicAuthentication(username, password)
                .build();
    }
}
