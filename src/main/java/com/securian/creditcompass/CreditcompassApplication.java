package com.securian.creditcompass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class CreditcompassApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditcompassApplication.class, args);
	}

	@Configuration
	public class CorsConfig {

		@Bean
		public CorsFilter corsFilter() {
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			CorsConfiguration config = new CorsConfiguration();
			config.addAllowedOrigin("*"); // Replace with your frontend URL
			config.addAllowedHeader("*");
			config.addAllowedMethod("*");
			source.registerCorsConfiguration("/**", config);
			return new CorsFilter(source);
		}
	}

}
