package com.bootcamp.movementbootcoinservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;

@EnableReactiveMongoAuditing
@SpringBootApplication
public class MovementbootcoinServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovementbootcoinServiceApplication.class, args);
	}

}
