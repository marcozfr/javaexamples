package com.example.authserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AuthServiceConfiguration {

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public TokenStore getTokenStore(){
        return new InMemoryTokenStore();
    }

    @Bean
    public AuthenticationManager getAuthenticationManager(){
        return new OAuth2AuthenticationManager();
    }

    @Bean
    public UserDetailsService getUserDetailsService(){
        UserDetails marcofUser = User.withUsername("marcof")
                .passwordEncoder(getPasswordEncoder()::encode)
                .password("m@rcof").roles("USER")
                .build();

        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        userDetailsManager.createUser(marcofUser);

        return userDetailsManager;
    }
}
