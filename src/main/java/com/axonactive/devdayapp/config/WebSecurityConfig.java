package com.axonactive.devdayapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
	
    @Bean
    public PasswordEncoder md5PasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
            }
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes()).equals(encodedPassword);
            }
        };
    }
    
    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(md5PasswordEncoder());
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http
	    .csrf().disable()
	    .exceptionHandling()
	    .and()
	    .authorizeRequests()
	    .antMatchers("/user/**").permitAll()
	    .antMatchers("/v2/api-docs",
	                 "/configuration/ui",
	                 "/swagger-resources/**",
	                 "/configuration/security",
	                 "/swagger-ui.html",
	                 "/webjars/**").permitAll()
	    .anyRequest().authenticated();
    }

}	
