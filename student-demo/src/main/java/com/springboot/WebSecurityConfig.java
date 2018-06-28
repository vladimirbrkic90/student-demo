package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        http
            .authorizeRequests()
            		.antMatchers("/").permitAll()
                .antMatchers("/resources/**", "/students", "/students/**", "/v2/api-docs", "/configuration/ui",
                				"/swagger-resources", "/configuration/security", "/webjars/**", "/swagger-resources/configuration/ui",
                				"/swagge‌​r-ui.html", "/swagger-resources/configuration/security").permitAll()
                .antMatchers("/student/showFormForAdd").hasRole("ADMIN")
                .antMatchers("/student/save*").hasRole("ADMIN")
                .antMatchers("/student/delete").hasRole("ADMIN")
                .antMatchers("/student/list").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/student/login")
                	.defaultSuccessUrl("/student/list")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
            .logout()
                .permitAll()
                	
                .and()
                .csrf().disable();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    		
        auth.
        		inMemoryAuthentication()
       		.withUser("John").password("{noop}123").roles("USER", "ADMIN")
       		.and()
       		.withUser("user").password("{noop}123").roles("USER")
       		.and()
       		.withUser("admin").password("{noop}123").roles("USER", "ADMIN");
        			
    }
    
   
}
