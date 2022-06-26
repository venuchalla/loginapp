package com.example.loginapp.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;


@Configuration
public class InMemoryAuthenticationProvider {
    private final Logger logger = LoggerFactory.getLogger(InMemoryAuthenticationProvider.class);

   /* BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    @Bean
    public UserDetailsManager user() {
        logger.info("buliding in memory users");
        PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserBuilder userBuilder = User.builder().passwordEncoder(passwordEncoder::encode);
                //.builder().passwordEncoder(getEncoder()::encode);
        UserDetails user = userBuilder
                .username("user")
                .password("user")
                .roles("user")
                .build();
        logger.info("User password:{}", user.getPassword());
        UserDetails admin = userBuilder
                .username("admin")
                .password("admin")
                .roles("user", "admin")
                .build();
        logger.info("admin password:{}", admin.getPassword());
        return new InMemoryUserDetailsManager(user, admin);
    }
/*
    public DaoAuthenticationProvider getInMeMoryAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(getEncoder());
        daoAuthenticationProvider.setUserDetailsService(user());
        return daoAuthenticationProvider;
    }*/
}
