package com.cognizant.spring_learn.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for testing purpose
            .authorizeRequests()
            .antMatchers("/authenticate").permitAll() // Allow access to /authenticate without login
            .anyRequest().authenticated() // All other requests need authentication
            .and()
            .httpBasic(); // Use Basic Authentication (user:pwd)
    }
}
