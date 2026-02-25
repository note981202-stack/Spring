package com.example.demo.demo02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {
	
	@Bean
	public Chef chef() {
		return new Chef();
	}

	@Bean
	public Restaurant restaurant(Chef chef) {
		return new Restaurant(chef);
	}
	
}
