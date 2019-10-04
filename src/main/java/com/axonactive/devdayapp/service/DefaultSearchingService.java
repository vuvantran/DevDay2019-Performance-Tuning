package com.axonactive.devdayapp.service;

import java.util.LinkedList;
import java.util.List;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.dto.SearchingCriteria;
import com.google.common.collect.ImmutableList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultSearchingService implements SearchingService {
    private static final Logger log = LogManager.getLogger(DefaultSearchingService.class);

    private static final ImmutableList<ExternalService> EXTERNAL_SERVICE = ImmutableList.of(
            new PanMacService(),
            new OpenLibraryService()
    );
    
    @Autowired
    private BookService bookService;

    public List<BookDto> search(SearchingCriteria criteria) {
        log.info("Search for books contain keyword: " + criteria.getKeyword());
        String keyword = criteria.getKeyword(); 
        List<BookDto> internalBooks = bookService.findBooksWithNameContain(keyword);
        log.info(String.format("Found %s books in our DB", internalBooks.size()));
        List<BookDto> output = new LinkedList<>();
        output.addAll(internalBooks);
        for (ExternalService exService: EXTERNAL_SERVICE) {
            List<BookDto> exBooks = exService.search(keyword);
            log.info(String.format("Found %s books in %s service", exBooks.size()));
            output.addAll(exBooks);
        }
        log.info(String.format("Total found %s books in our DB and external services", output.size()));
        return output;
    }
}

