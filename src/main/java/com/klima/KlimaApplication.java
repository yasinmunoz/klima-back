package com.klima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class KlimaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KlimaApplication.class, args);
	}
}
