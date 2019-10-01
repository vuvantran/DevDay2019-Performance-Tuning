package com.axonactive.devdayapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axonactive.devdayapp.domain.SimpleBook;
import com.axonactive.devdayapp.repo.SimpleBookRepository;

@Service
public class DefaultBookService implements BookService {

    @Autowired
    private SimpleBookRepository bookRepo;
    @Override
	public SimpleBook findById(long bookId) {
		// TODO Auto-generated method stub
		Optional<SimpleBook> result = bookRepo.findById(bookId);
		if(result.isPresent())
			return result.get();
		else
			return null;
	}

	@Override
	public List<SimpleBook> getAll() {
		// TODO Auto-generated method stub
		return (List<SimpleBook>) bookRepo.findAll();
	}
}

