package academy.everyonecodes.drhouseaccountancy.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@ConfigurationProperties("credentials")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private List<Accountant> accountants;

    void setAccountants(List<Accountant> accountants) {
        this.accountants = accountants;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(POST, "/patients").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        List<UserDetails> users = accountants.stream()
                .map(user -> User.withUsername(user.getUsername())
                        .password(encoder.encode(user.getPassword()))
                        .authorities(user.getAuthorities())
                        .build())
                .collect(toList());
        return new InMemoryUserDetailsManager(users);
    }
}
