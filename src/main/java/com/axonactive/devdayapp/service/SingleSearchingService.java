package com.axonactive.devdayapp.service;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.dto.SearchingCriteria;
import com.google.common.collect.ImmutableList;
@Component
public class SingleSearchingService implements SearchingService {
	private static final Logger log = LogManager.getLogger(SingleSearchingService.class);
	private static final ImmutableList<ExternalService> EXTERNAL_SERVICE = ImmutableList.of(
            new PanMacService(),
            new OpenLibraryService(),
            new BookMoochService(),
            new ITBookStoreService()
    );
	@Autowired
    private BookService bookService;
	@Override
	public List<BookDto> search(SearchingCriteria criteria) {
		log.info(String.format("Source (%s):  find all books contain keyword '%s' .",criteria.getBookSource(), criteria.getKeyword()));
		List<BookDto> output = new LinkedList<>();
		String keyword = criteria.getKeyword();
        //log.info("Search for books contain keyword: " + keyword);
        
        switch (criteria.getBookSource()) {
		case AAHCM:
		case AADN:
		case AACT:
		case AAYG:
			
			output.addAll(bookService.findBooksWithNameAndSource(keyword,criteria.getBookSource()));
			
			break;
		case PANMAC:
		case BOOK_MOOCH:
		case IT_BOOK_STORE:
		case OPEN_LIBRARY:
			for (ExternalService exService: EXTERNAL_SERVICE) {
				 
				if(exService.getClass().getCanonicalName().toUpperCase().indexOf(criteria.getBookSource().name().toUpperCase()) >= 0) {
					List<BookDto> exBooks = exService.search(keyword);
		            
		            log.info("Found {} books in {} service", exBooks.size(), exService.getClass().getCanonicalName());
		            output.addAll(exBooks);
				}
	        }
            break;
		default:
			break;
		}

        log.info("Total found {} books ", output.size());
        return output;
	}
	
}
