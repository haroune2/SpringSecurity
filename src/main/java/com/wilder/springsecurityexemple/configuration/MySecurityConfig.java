package com.wilder.springsecurityexemple.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
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
}
