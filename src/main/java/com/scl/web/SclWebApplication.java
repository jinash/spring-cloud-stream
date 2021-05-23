package com.scl.web;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.scl.schema.Cat;

@SpringBootApplication
public class SclWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SclWebApplication.class, args);
	}

//	@Bean
//	public Consumer<KStream<String, Cat>> process() {
//		return input -> input.foreach((key, value) -> System.out
//				.println("Key: " + key + " Value: " + value.toString()));
//	}

	@Bean
	public Consumer<List<Cat>> batch() {
		return messages -> messages.forEach(cat -> {
			System.out.println("Cat => " + cat.toString());
		});
	}

	@Bean
	public Supplier<Cat> supplier() {
		return () -> Cat.newBuilder().setBreed("Jinash").build();
	}

}
