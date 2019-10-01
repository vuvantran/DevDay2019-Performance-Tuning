package com.axonactive.devdayapp.service;

import java.util.List;

import com.axonactive.devdayapp.domain.Book;


public interface BookService {
	public Book findById(long bookId);
	public List<Book> getAll();
}

