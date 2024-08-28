package com.graymatter.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	UserDetailsService service;
//	
//	@Bean
//	public AuthenticationProvider authProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(service);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return provider;
//	}
	
//	public void myConfiguration(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//		.authorizeHttpRequests().requestMatchers("/login")
//		.permitAll()
//		.anyRequest()
//		.authenticated();
//		.and()
//		.formLogin().loginPage("/login").permitAll();
//	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.anyRequest().authenticated()
		.and()
		.oauth2Login();
		
		return http.build();
	}
	
}
