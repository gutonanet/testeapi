package com.augusto.lemes.teste.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.User;
/**
 * 
 * @author Augusto Lemes
 * @since 28/11/2018
 * 
 * Serviço de autenticação dos serviços REST.
 * Foi feito um BASIC AUTHENTICATION, porém esse serviço deve ser associado
 * a uma autenticação oAuth2 ou similar.
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	  @Autowired
	    private AuthenticationEntryPoint authEntryPoint;
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable();
	 
	        // All requests send to the Web Server request must be authenticated
	        http.authorizeRequests().anyRequest().authenticated();
	 
	        // Use AuthenticationEntryPoint to authenticate user/password
	        http.httpBasic().authenticationEntryPoint(authEntryPoint);
	    }
	 
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        return bCryptPasswordEncoder;
	    }
	 
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

	    	//Serviço deve ser associado a autenticação segura
	        String password = "123";
	        String encrytedPassword = this.passwordEncoder().encode(password);
	        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> //
	        mngConfig = auth.inMemoryAuthentication();
	        UserDetails u1 = User.withUsername("admin").password(encrytedPassword).roles("USER").build();
	        UserDetails u2 = User.withUsername("usuario").password(encrytedPassword).roles("USER").build();
	        mngConfig.withUser(u1);
	        mngConfig.withUser(u2);
	 
	    }
}
