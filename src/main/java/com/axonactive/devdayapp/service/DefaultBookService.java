package com.axonactive.devdayapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.repo.BookRepository;


@Service
public class DefaultBookService implements BookService {

    @Autowired
    private BookRepository bookRepo;
    @Override
	public Book findById(long bookId) {
		// TODO Auto-generated method stub
		Optional<Book> result = bookRepo.findById(bookId);
		if(result.isPresent())
			return result.get();
		else
			return null;
	}

	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return (List<Book>) bookRepo.findAll();
	}
}

