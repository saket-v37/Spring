package com.oliverWood.springRestApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}
}




/*
 All Examples:-put below code inside SpringRestApplication.
 1.

 	@GetMapping
	public List<String> ShowMsg(){
		return List.of("Hello", "Spring");
	}

	2.
		@GetMapping
	public List<students> ShowMsg(){
		return List.of(new students(1L,"Sam",23,LocalDate.of(2000, Month.DECEMBER,5),"samNortan@gmail.com"));
	}


 */