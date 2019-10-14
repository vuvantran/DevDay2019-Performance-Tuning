package com.axonactive.devdayapp;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.dto.CommentDto;
import com.axonactive.devdayapp.dto.SearchingCriteria;
import com.axonactive.devdayapp.service.BookDetailService;
import com.axonactive.devdayapp.service.BookService;
import com.axonactive.devdayapp.service.CommentService;
import com.axonactive.devdayapp.service.SearchingService;


@RestController
@EnableAutoConfiguration
@ComponentScan
public class EntryPoint {
	private static final Logger log = LogManager.getLogger(EntryPoint.class);
    private static final String API_ROOT = "/library-core/api";

    @Autowired
    private BookService bookService;

    @Autowired
    private SearchingService searchingService;
    
    @Autowired
    private CommentService commentService;

    @Autowired
    private BookDetailService bookDetailService;

	@RequestMapping(path = API_ROOT, method = RequestMethod.GET)

	public List<BookDto> getBooks() {
		log.info("Get all books.");
		return bookService.getAll();
	}

	@RequestMapping(path = API_ROOT + "/books/{bookId}", method = RequestMethod.GET)
	public BookDto getBookById(@PathVariable("bookId") Long bookId) {
		log.info(String.format("Finding book with bookId=%s", bookId));
		return bookService.findById(bookId);

	}

	@RequestMapping(path = API_ROOT + "/books/{bookId}/comments", method = RequestMethod.GET)
	public List<CommentDto> getCommentByBookId(@PathVariable("bookId") Long bookId) {
        log.info(String.format("Searching for comments of bookId=%s", 1, bookId));
        return commentService.getCommentByBookId(bookId);
	}

	@RequestMapping(path = API_ROOT + "/books/search", method = RequestMethod.POST)
	public List<BookDto> searchBook(@RequestBody SearchingCriteria criteria) {
		log.info(String.format("Searching for books with criteria '%s'", criteria));
        return searchingService.search(criteria);
	}

	@RequestMapping(path = API_ROOT + "/book-details/{bookDetailId}/ratings", method = RequestMethod.POST)
	public boolean rateABook(
            @RequestHeader(value="Authorization") Long userId,
            @PathVariable("bookDetailId") Long bookDetailId,
            @RequestBody Integer point
    ) {
        log.info("User {} do rate {} star for the book detail with id {}", userId, point, bookDetailId);
        return bookDetailService.rateABook(userId, bookDetailId, point);
	}

	@RequestMapping(path = API_ROOT + "/book-details/{bookDetailId}/ratings", method = RequestMethod.DELETE)
	public boolean unrateABook(
            @RequestHeader(value="Authorization") Long userId,
            @PathVariable("bookDetailId") Long bookDetailId
    ) {
        log.info("User {} do unrate the book detail with id {}", userId, bookDetailId);
        return bookDetailService.unrateABook(userId, bookDetailId);
	}

	public static void main(String[] args) {
		SpringApplication.run(EntryPoint.class, args);
	}

}

