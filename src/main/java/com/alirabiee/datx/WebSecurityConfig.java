package com.alirabiee.datx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Profile( value = { "development", "production" } )
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers( "/", "/home" ).permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage( "/login" ).failureUrl( "/login?error" )
            .permitAll()
            .and()
            .logout()
            .permitAll()
            .and()
            .exceptionHandling().accessDeniedPage( "/403" )
            .and()
            .csrf();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
        auth.jdbcAuthentication()
            .dataSource( dataSource )
            .usersByUsernameQuery( "select username, password, enabled from user where username=?" )
            .authoritiesByUsernameQuery( "select username, role from user_role where username = ?" );
    }
}