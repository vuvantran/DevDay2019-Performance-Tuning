package com.axonactive.devdayapp;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.axonactive.devdayapp.service.BookService;
import com.axonactive.devdayapp.service.CommentService;
import com.axonactive.devdayapp.service.SearchingService;


@RestController
@EnableAutoConfiguration
@ComponentScan
public class EntryPoint {

    private static final String API_ROOT = "/library-core/api/books";
    @Autowired
    private BookService bookService;

    @Autowired
    private SearchingService searchingService;
    
    @Autowired
    private CommentService commentService;

	@RequestMapping(path = API_ROOT, method = RequestMethod.GET)

	public List<BookDto> getBooks() {
		return bookService.getAll();
	}

	@RequestMapping(path = API_ROOT + "/{bookId}", method = RequestMethod.GET)
	public BookDto getBookById(@PathVariable("bookId") Long bookId) {
		return bookService.findById(bookId);

	}

	@RequestMapping(path = API_ROOT + "/{bookId}/comments", method = RequestMethod.GET)
	public List<CommentDto> getCommentByBookId(@PathVariable("bookId") Long bookId) {
        
        return commentService.getCommentByBookId(bookId);
	}

	@RequestMapping(path = API_ROOT + "/search", method = RequestMethod.POST)
	public List<BookDto> searchBook(@RequestBody SearchingCriteria criteria) {
        return searchingService.search(criteria);
	}

	public static void main(String[] args) {
		SpringApplication.run(EntryPoint.class, args);
	}

}

