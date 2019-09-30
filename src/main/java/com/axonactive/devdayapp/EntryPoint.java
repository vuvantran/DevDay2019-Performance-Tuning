package com.axonactive.devdayapp;

import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.domain.Comment;
import java.util.List;
import java.util.ArrayList;
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

    private static final String API_ROOT = "/library-core/api/books";

	@RequestMapping(path = API_ROOT, method = RequestMethod.GET)
	public List<Book> getBooks() {
        Book book = new Book();
        book.setId(123l);
        book.setName("Used to be king");
        book.setAuthor("Thomas Hamstor");
        List<Book> books = new ArrayList<>();
        books.add(book);
		return books;
	}

	@RequestMapping(path = API_ROOT + "/{bookId}", method = RequestMethod.GET)
	public Book getBookById(@PathVariable("bookId") Long bookId) {
        Book book = new Book();
        book.setId(bookId);
        book.setName("Used to be king");
        book.setAuthor("Thomas Hamstor");
		return book;
	}

	@RequestMapping(path = API_ROOT + "/{bookId}/comments", method = RequestMethod.GET)
	public List<Comment> getCommentByBookId(@PathVariable("bookId") Long bookId) {
        Comment comment = new Comment();
        comment.setId(195l);
        comment.setContent("Good book!");
        List<Comment> comments = new ArrayList<>(0);
        comments.add(comment);
        return comments;
	}

	@RequestMapping(path = API_ROOT + "/search", method = RequestMethod.POST)
	public List<Book> searchBook() {
        Book book = new Book();
        book.setId(123l);
        book.setName("Used to be king");
        book.setAuthor("Thomas Hamstor");
        List<Book> books = new ArrayList<>();
        books.add(book);
		return books;
	}

	public static void main(String[] args) {
		SpringApplication.run(EntryPoint.class, args);
	}

}

