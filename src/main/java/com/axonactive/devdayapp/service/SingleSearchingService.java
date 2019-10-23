package com.axonactive.devdayapp.service;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.dto.SearchingCriteria;
import com.axonactive.devdayapp.enums.BookSource;
import com.google.common.collect.ImmutableList;
@Component
public class SingleSearchingService implements SearchingService {
	private static final Logger log = LogManager.getLogger(SingleSearchingService.class);
	
	@Autowired
    private BookService bookService;
	@Override
	public List<BookDto> search(SearchingCriteria criteria) {
		log.info(String.format("Source (%s):  find all books contain keyword '%s' .",criteria.getBookSource(), criteria.getKeyword()));
		List<BookDto> output = new LinkedList<>();
		String keyword = criteria.getKeyword();
        //log.info("Search for books contain keyword: " + keyword);
		
		if (criteria.getBookSource().equals(BookSource.AAHCM)||criteria.getBookSource().equals(BookSource.AADN)
        		|| criteria.getBookSource().equals(BookSource.AACT)||criteria.getBookSource().equals(BookSource.AAYG)) {
		
			
			output.addAll(bookService.findBooksWithNameAndSource(keyword,criteria.getBookSource()));
			
        } else {
        	ExternalService exService = null;
        	if(criteria.getBookSource().equals(BookSource.PANMAC)){
        		exService = new PanMacService();
        	}else if(criteria.getBookSource().equals(BookSource.BOOK_MOOCH)) {
        		exService = new BookMoochService();
        	}else if(criteria.getBookSource().equals(BookSource.IT_BOOK_STORE)) {
        		exService = new ITBookStoreService();
        	}else if(criteria.getBookSource().equals(BookSource.OPEN_LIBRARY)) {
        		exService = new OpenLibraryService();
        	}else {
        		log.info("Cannot search from {} source", criteria.getBookSource().getClass().getCanonicalName());
        	}
        	if(null != exService) {
	        	List<BookDto> exBooks = exService.search(keyword);
	            
	            log.info("Found {} books in {} service", exBooks.size(), exService.getClass().getCanonicalName());
	            output.addAll(exBooks);
        	}
        }
        
        log.info("Total found {} books ", output.size());
        return output;
	}
	
}
