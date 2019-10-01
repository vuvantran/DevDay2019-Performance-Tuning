package com.axonactive.devdayapp;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.domain.Comment;
import com.axonactive.devdayapp.service.BookService;

@RestController
@EnableAutoConfiguration
@ComponentScan
//@ComponentScan (basePackages = "com.axonactive.devdayapp")
//@EnableJpaRepositories(basePackages ="com.axonactive.devdayapp.repo")
//@EntityScan(basePackages = "com.axonactive.devdayapp.domain" )
public class EntryPoint {

    private static final String API_ROOT = "/library-core/api/books";
    @Autowired
    private BookService bookService;

	@RequestMapping(path = API_ROOT, method = RequestMethod.GET)
	public List<Book> getBooks() {
		return bookService.getAll();
	}

	@RequestMapping(path = API_ROOT + "/{bookId}", method = RequestMethod.GET)
	public Book getBookById(@PathVariable("bookId") Long bookId) {
        return bookService.findById(bookId);
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

