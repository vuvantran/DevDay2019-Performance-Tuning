package com.axonactive.devdayapp.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.dto.CommentDto;
import com.axonactive.devdayapp.dto.SearchingCriteria;
import com.axonactive.devdayapp.service.BookService;
import com.axonactive.devdayapp.service.CommentService;
import com.axonactive.devdayapp.service.SearchingService;


@RestController
@RequestMapping("/library-core/api/books")
public class LibraryResource {
	
	private static final Logger log = LogManager.getLogger(LibraryResource.class);
	
    @Autowired
    private BookService bookService;

    @Autowired
    private SearchingService searchingService;
    
    @Autowired
    private CommentService commentService;

	@GetMapping
	public List<BookDto> getBooks() {
		log.info("Get all books.");
		return bookService.getAll();
	}

	@GetMapping("/{bookId}")
	public BookDto getBookById(@PathVariable("bookId") Long bookId) {
		log.info(String.format("Finding book with bookId=%s", bookId));
		return bookService.findById(bookId);

	}

	@GetMapping("/{bookId}/comments")
	public List<CommentDto> getCommentByBookId(@PathVariable("bookId") Long bookId) {
        log.info(String.format("Searching for comments of bookId=%s", 1, bookId));
        return commentService.getCommentByBookId(bookId);
	}

	@PostMapping("/search")
	public List<BookDto> searchBook(@RequestBody SearchingCriteria criteria) {
		log.info(String.format("Searching for books with criteria '%s'", criteria));
        return searchingService.search(criteria);
	}
}

