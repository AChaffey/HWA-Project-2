package com.qa.project2.config;


	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;

	@Configuration
	public class AppConfig {
		
		@Bean
		public String hello() {
			return "Hello";
		}
		
	}

