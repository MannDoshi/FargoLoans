package com.wellsfargo.training.fargoloans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class FargoloansApplication {

	public static void main(String[] args) {
		SpringApplication.run(FargoloansApplication.class, args);
	}

}
