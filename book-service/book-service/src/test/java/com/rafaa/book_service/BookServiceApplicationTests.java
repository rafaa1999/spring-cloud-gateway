package com.rafaa.book_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookServiceApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void when_get_requests_then_return_books(){
		webTestClient
				.get()
				.uri("/books")
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(Book.class)
				.contains(
						new Book("Harry Potter"),
						new Book("His Dark Materials"),
						new Book("The Hobbit"),
						new Book("The Lord of the Rings")
				);
	}

}
