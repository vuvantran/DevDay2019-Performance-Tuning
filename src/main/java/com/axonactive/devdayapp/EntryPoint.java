package com.axonactive.devdayapp;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.*;

import com.axonactive.devdayapp.domain.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@RestController
@EnableAutoConfiguration
@ComponentScan (basePackages = "com.axonactive.devdayapp")
@EnableJpaRepositories(basePackages ="com.axonactive.devdayapp.repo")
@EntityScan(basePackages = "com.axonactive.devdayapp.domain" )
public class EntryPoint {

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(EntryPoint.class, args);
	}
	@RequestMapping("/api/books/{id}")
	Book getSingleBook(@PathVariable final  long id) {
		Book b = new Book();
		b.setAuthor("Ian");
		b.setId(id);
		b.setName("Rusian in summer");
		b.setSerialNumber("1247465094357-85");
		return b;
	}
}

