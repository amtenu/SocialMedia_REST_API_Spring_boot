package com.amanuel.rest.webservices.restapiwebService.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// If we use boilerPlate there is no security so we have to use chain
		// All http requests have to be autenticated
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		// If not authenticated web page is shown

		http.httpBasic(withDefaults());
		// CRSF must be used for POST and PUT http requests
		
		http.csrf().disable();

		return http.build();
	}

}
