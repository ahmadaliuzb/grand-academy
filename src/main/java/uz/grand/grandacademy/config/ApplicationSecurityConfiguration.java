package uz.grand.grandacademy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration {

    private static final String USERS_ENDPOINT = "/home/**";
    private static final String LOGIN_ENDPOINT = "/login/**";
    private static final String REGISTER_ENDPOINT = "/register/**";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .antMatchers(USERS_ENDPOINT,
                                LOGIN_ENDPOINT,
                                REGISTER_ENDPOINT,
                                "/resources/**",
                                "/static/**",
                                "/*.js",
                                "/*.css",
                                "/img/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers(LOGIN_ENDPOINT, REGISTER_ENDPOINT, USERS_ENDPOINT,
//                        "/js/**",
//                        "/css/**",
//                        "/img/**","").permitAll()
//                .anyRequest().authenticated();
//
//    }


}
