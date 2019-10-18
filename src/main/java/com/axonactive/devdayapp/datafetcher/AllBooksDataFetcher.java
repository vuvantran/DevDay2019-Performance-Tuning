package com.axonactive.devdayapp.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.service.BookService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllBooksDataFetcher implements DataFetcher<List<BookDto>> {

	@Autowired
    private BookService bookService;


    @Override
    public List<BookDto> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return bookService.getAll();
    }
}