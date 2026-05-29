package com.ws101.colitoy_delarosa_a.EcommerceApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ws101.colitoy_delarosa_a.EcommerceApi.repository")
public class EcommerceApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApiApplication.class, args);
	}
}