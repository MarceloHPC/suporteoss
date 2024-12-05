package com.av2.suporteos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.av2")
@EntityScan(basePackages = {"com.av2","com.av2.enums"})
@EnableJpaRepositories(basePackages = "com.av2.repositories")
@SpringBootApplication
public class SuporteosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuporteosApplication.class, args);
	}

}
