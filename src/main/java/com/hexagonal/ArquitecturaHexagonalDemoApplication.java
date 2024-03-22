package com.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ArquitecturaHexagonalDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArquitecturaHexagonalDemoApplication.class, args);
	}

}
