package com.example.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("valijon").password("{noop}root").roles("admin")
                .and()
                .withUser("jahongir").password("{noop}1234").roles("user")
                .and()
                .withUser("alijon").password("{noop}alijon1234").roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // starting implementation
                .antMatchers("/init").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();

        http.csrf().disable();
    }
}