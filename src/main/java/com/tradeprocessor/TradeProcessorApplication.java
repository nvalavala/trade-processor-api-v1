package com.tradeprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { KafkaAutoConfiguration.class, SecurityAutoConfiguration.class })
public class TradeProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeProcessorApplication.class, args);
	}

}
