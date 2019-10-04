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
import com.axonactive.devdayapp.dto.SearchingCriteria;

@Component
public class DefaultSearchingService implements SearchingService {

    private static final ImmutableList<ExternalService> EXTERNAL_SERVICE = ImmutableList.of(
            new PanMacService(),
            new OpenLibraryService()
    );
    
    @Autowired
    private BookService bookService;

    public List<BookDto> search(SearchingCriteria criteria) {
        String keyword = criteria.getKeyword();
        List<BookDto> internalBooks = bookService.findBooksWithNameContain(keyword);
        List<BookDto> output = new LinkedList<>();
        output.addAll(internalBooks);
        for (ExternalService exService: EXTERNAL_SERVICE) {
            List<BookDto> exBooks = exService.search(keyword);
            output.addAll(exBooks);
        }
        return output;
    }
}

