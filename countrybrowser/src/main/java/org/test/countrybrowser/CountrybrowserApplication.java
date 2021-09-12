package org.test.countrybrowser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CountrybrowserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountrybrowserApplication.class, args);
	}

}
