package org.test.countrybrowser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.test.countrybrowser.config.CountryAppConfiguration;

@SpringBootApplication
public class CountrybrowserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountrybrowserApplication.class, args);
	}

}
