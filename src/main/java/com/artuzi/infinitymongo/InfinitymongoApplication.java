package com.artuzi.infinitymongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.artuzi.infinitymongo.config.MongoDbConfig;

@Import(MongoDbConfig.class)
@SpringBootApplication
public class InfinitymongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfinitymongoApplication.class, args);
	}

}
