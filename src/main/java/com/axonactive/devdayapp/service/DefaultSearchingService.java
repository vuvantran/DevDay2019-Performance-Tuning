package com.axonactive.devdayapp.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.axonactive.devdayapp.util.Mapper;
import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.service.BookService;
import com.axonactive.devdayapp.dto.SearchingCriteria;

@Component
public class DefaultSearchingService implements SearchingService {
    
    @Autowired
    private BookService bookService;

    public List<BookDto> search(SearchingCriteria criteria) {
        return bookService.findBooksWithNameContain(criteria.getKeyword());
    }
}

