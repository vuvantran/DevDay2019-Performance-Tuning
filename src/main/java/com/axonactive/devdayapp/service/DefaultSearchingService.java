package com.axonactive.devdayapp.service;

import java.util.List;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.collect.ImmutableList;

import com.axonactive.devdayapp.util.Mapper;
import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.service.BookService;
import com.axonactive.devdayapp.service.ExternalService;
import com.axonactive.devdayapp.service.PanMacService;
import com.axonactive.devdayapp.service.OpenLibraryService;
import com.axonactive.devdayapp.service.BookMoochService;
import com.axonactive.devdayapp.service.ITBookStoreService;
import com.axonactive.devdayapp.dto.SearchingCriteria;

@Component
public class DefaultSearchingService implements SearchingService {

    private static final ImmutableList<ExternalService> EXTERNAL_SERVICE = ImmutableList.of(
            new PanMacService(),
            /new OpenLibraryService(),
            /new BookMoochService(),
            new ITBookStoreService()
    );
    
    @Autowired
    private BookService bookService;

    public List<BookDto> search(SearchingCriteria criteria) {
        String keyword = criteria.getKeyword();
        long startPot = System.currentTimeMillis();
        List<BookDto> internalBooks = bookService.findBooksWithNameContain(keyword);
        logTheTime(startPot, "internal");
        List<BookDto> output = new LinkedList<>();
        output.addAll(internalBooks);
        for (ExternalService exService: EXTERNAL_SERVICE) {
            startPot = System.currentTimeMillis();
            List<BookDto> exBooks = exService.search(keyword);
            logTheTime(startPot, exService.getClass().getCanonicalName());
            output.addAll(exBooks);
        }
        return output;
    }

    private void logTheTime(long startPot, String name) {
        System.out.println("-+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+-");
        System.out.println(">>> " + name + " take: " + (System.currentTimeMillis() - startPot));
        System.out.println("-+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+-");
    }
}

