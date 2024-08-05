package com.rafaa.book_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.sound.sampled.BooleanControl;

@SpringBootApplication
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

}

record Book(String title){}

@RestController
class BookController{

	private static final Logger log = LoggerFactory.getLogger(BooleanControl.class);

	@GetMapping("books")
	public Flux<Book> getBooks() {
		return Flux.just(
				new Book("Harry Potter"),
				new Book("His Dark Materials"),
				new Book("The Hobbit"),
				new Book("The Lord of the Rings")
		).doFirst(() -> log.info("Returning list of books in the catalog"));
	}
}