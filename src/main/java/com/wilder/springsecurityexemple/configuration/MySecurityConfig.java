package com.wilder.springsecurityexemple.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> {
			try {
				authz
				
						.anyRequest().authenticated()
						.and().formLogin()
						.and().httpBasic();
			} catch (Exception e) {

				e.printStackTrace();
			}
		});
		return http.build();
	}

	// User bean
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		UserDetails user = User
				.withUsername("user")
				.password(encoder.encode("password"))
				.roles("USER")
				.build();

		// Admin
		UserDetails admin = User
				.withUsername("admin")
				.password(encoder.encode("12345678"))
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(List.of(user, admin));
	}
}
