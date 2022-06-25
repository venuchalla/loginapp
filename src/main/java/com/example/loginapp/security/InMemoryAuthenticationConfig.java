package com.example.loginapp.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class InMemoryAuthenticationConfig extends WebSecurityConfigurerAdapter {
    private static Logger logger = LoggerFactory.getLogger(InMemoryAuthenticationConfig.class);
    // Adding the roles
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .roles("admin")
                .and()
                .withUser("user")
                .password("user")
                .roles("user");
    }

    // Configuring the api
    // according to the roles.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasAnyRole("admin","user")
                .and()
                .formLogin();
    }

    // Function to encode the password
    // assign to the particular roles.
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
