package com.axonactive.devdayapp.service;

import java.util.List;

import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.domain.SimpleBook;

public interface BookService {
	public SimpleBook findById(long bookId);
	public List<SimpleBook> getAll();
}

