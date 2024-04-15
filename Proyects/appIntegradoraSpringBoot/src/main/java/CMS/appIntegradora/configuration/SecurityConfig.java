package CMS.appIntegradora.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final String[] pathForUsers = {"delete"};

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.
                csrf(csrf -> csrf.disable()).
                        authorizeRequests(auth -> {
                        auth.antMatchers("/").permitAll();
                        auth.antMatchers(HttpMethod.DELETE).hasRole("ROLE_ADMIN");}).
                httpBasic(Customizer.withDefaults()).
                build();
    }
    
    @Bean
    public PasswordEncoder getEncoder(){
        return new BCryptPasswordEncoder(10);
    }
    
    
}
