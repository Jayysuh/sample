package com.GLAB309_8_2.studentlogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*
@Configuration
    - Allows Spring to scan the class and inject as a bean. Each bean
    is managed by the spring container.
@EnableWebSecurity
    - Enables Spring Security’s web security
    support and provide Spring MVC integration.
@Bean
    -To make each method work like a bean, define the @Bean
    annotation before that particular method. One or more @Bean
    methods may be processed by the Spring container to generate
    bean definitions and service requests for those beans at runtime
 */
@Configuration
@EnableWebSecurity
public class SpringSecurity {

    /*
    - The security configuration uses the bcryptPasswordEncoder to
encrypt student passwords.
- The passwordEncoder object is injected into the
StudentServiceImpl class and used in the saveStudent() method.
    - First, the password is validated by the dto.
    - Second, the password is encrypted by invoking the encode()
    method.
    - Lastly, the encrypted password is set in the Student object.
● Spring Security maintains a filter chain internally where each filter has a
particular responsibility to grant or deny access to endpoints. Filters can be
added or removed from the configuration depending on which services are
required.
● The ordering of the filters is important as there are dependencies between
them.
● The filterChain() method accepts an HttpSecurity object, which acts as the
builder to configure security at the web level. The method intercepts
requests to ensure that students have proper authorization.
     */

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authz) -> authz
                                .requestMatchers("/register/**").permitAll()
                                .requestMatchers("/index").permitAll()
                                .requestMatchers("/students").hasRole("ADMIN")
                                // .and()
                )
                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/students")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll());
        return http.build();
    }
}
/*
-http.csrf().disable()
    Spring Security has built-in CSRF protection against common
    security attacks, such as malicious code that submits a form on
    behalf of another user, normally the victim of the attack. CSRF is
    disabled because Thymeleaf renders the path relative.
- .authorizeHttpRequests()
    Authorization section - returns an object in which you can specify
    URL paths,patterns, and security requirements/rules for those paths.
- .requestMatchers("/register/**").permitAll()
- .requestMatchers("/index").permitAll()
    requests for /register/** and /index - all requests accessing either
    endpoint are granted the permitAll authorization for any student.
- .requestMatchers("/students").hasRole("ADMIN")
    Request for the /students endpoint is accessible to students
    granted with the role authority “ROLE_ADMIN.”
- .and()
    Method that begins a new section of configuration.
- .formLogin(
form -> form
    Method starts the configuration for the custom login page.
- .loginPage("/login")
    Method argument points to the custom login page. If student
    is not authenticated, spring redirects students to the login page.
- .loginProcessingUrl("/login")
    Method listens for a direct request to the /login page.
- .defaultSuccessUrl("/students")
    Method redirects student to /students page after successful login
- .logout(
logout -> logout
    Method logs out student, and by default, redirects student to
    the login page.
- return http.build();
    Method returns a SecurityFilterChain object configured with:
        ● A required specific security condition(s) that are met before allowing
        a request to be served.
        ● A custom login page.
        ● Student log out enabled.
        ● CSRF Disabled.
 */
