package com.scl.web;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

import com.scl.schema.Cat;

@SpringBootApplication
public class SclWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SclWebApplication.class, args);
	}

	// @Bean
	// public Consumer<KStream<String, Cat>> process() {
	// return input -> input.foreach((key, value) -> System.out
	// .println("Key: " + key + " Value: " + value.toString()));
	// }

	@Bean
	public Consumer<Message<List<Cat>>> batch() {
		return message -> {
			Acknowledgment acknowledgment = message.getHeaders()
					.get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
			if (acknowledgment != null) {
				System.out.println("Acknowledgment provided");
				acknowledgment.acknowledge();
			}
		};
	}

	@Bean
	public Supplier<Cat> supplier() {
		return () -> Cat.newBuilder().setBreed("Jinash").build();
	}

}
