package com.example.lab3.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
@Configuration
public class CustomWebSecurityConfigurerAdapter  extends WebSecurityConfigurerAdapter {
    private UserDetailsServiceClass userDetailsService;

    public CustomWebSecurityConfigurerAdapter(UserDetailsServiceClass userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    protected void configure(HttpSecurity http) {
        try {
            http.authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/dashboard").hasAnyRole("ADMIN", "USER")
                    .antMatchers(HttpMethod.GET, "/dashboard/{id}").hasAnyRole("ADMIN", "USER")
                    .antMatchers(HttpMethod.POST, "/dashboard").hasRole("ADMIN")
                    .antMatchers(HttpMethod.DELETE, "/dashboard/{id}").hasRole("ADMIN")
                    .and().httpBasic()
                    .and().cors().disable()
                    .csrf().disable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        try {
            auth.userDetailsService(userDetailsService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}
