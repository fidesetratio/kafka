package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class SpringBootKafkaMultiApplication {
	

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaMultiApplication.class, args);
	}
		

}
