package com.axonactive.devdayapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.dto.CommentDto;
import com.axonactive.devdayapp.dto.SearchingCriteria;
import com.axonactive.devdayapp.service.SearchingService;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class EntryPoint {

    private static final String API_ROOT = "/library-core/api/books";

    @Autowired
    private SearchingService searchingService;

	@RequestMapping(path = API_ROOT, method = RequestMethod.GET)
	public List<BookDto> getBooks() {
        BookDto book = new BookDto();
        book.setId(123l);
        book.setName("Used to be king");
        book.setAuthor("Thomas Hamstor");
        List<BookDto> books = new ArrayList<>();
        books.add(book);
		return books;
	}

	@RequestMapping(path = API_ROOT + "/{bookId}", method = RequestMethod.GET)
	public BookDto getBookById(@PathVariable("bookId") Long bookId) {
        BookDto book = new BookDto();
        book.setId(bookId);
        book.setName("Used to be king");
        book.setAuthor("Thomas Hamstor");
		return book;
	}

	@RequestMapping(path = API_ROOT + "/{bookId}/comments", method = RequestMethod.GET)
	public List<CommentDto> getCommentByBookId(@PathVariable("bookId") Long bookId) {
        CommentDto comment = new CommentDto();
        comment.setId(195l);
        comment.setContent("Good book!");
        List<CommentDto> comments = new ArrayList<>(0);
        comments.add(comment);
        return comments;
	}

	@RequestMapping(path = API_ROOT + "/search", method = RequestMethod.POST)
	public List<BookDto> searchBook(@RequestBody SearchingCriteria criteria) {
        return searchingService.search(criteria);
	}

	public static void main(String[] args) {
		SpringApplication.run(EntryPoint.class, args);
	}
}

