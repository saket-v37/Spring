package com.springBooot.restfullWebServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfullWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfullWebServicesApplication.class, args);
	}




	// if you get error while running delete and post request(Spring basic security) TRY THIS:-
//	@Configuration
//	public static class SecurityConfig extends WebSecurityConfigurerAdapter {
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//				.csrf().disable()
//				.authorizeRequests()
//				.anyRequest().authenticated()
//				.and()
//				//.formLogin().and()
//				.httpBasic();
//		}
//	}

}
