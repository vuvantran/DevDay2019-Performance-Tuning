package com.axonactive.devdayapp.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.service.BookService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
@Component
public class BookDataFetcher implements DataFetcher<BookDto>{
	@Autowired
    private BookService bookService;

	@Override
	public BookDto get(DataFetchingEnvironment environment) {
		long bookId = environment.getArgument("id");
		return bookService.findById(bookId);
	}

}
