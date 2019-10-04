package com.axonactive.devdayapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.repo.BookRepository;
import com.axonactive.devdayapp.util.BookUtil;
import com.axonactive.devdayapp.util.Mapper;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.dto.BookDetailDto;


@Service
public class DefaultBookService implements BookService {

    @Autowired
    private BookRepository bookRepo;
    @Override
    public BookDto findById(long bookId) {
		// TODO Auto-generated method stub
		Book result = bookRepo.getBookById(bookId);
		
		if(result != null)
			return BookUtil.toFullBookDto(result);
		else
			return null;
	}

	@Override
	public List<BookDto> getAll() {
		// TODO Auto-generated method stub
		return  StreamSupport.stream(bookRepo.findAll().spliterator(),false)
			.map(book -> BookUtil.toSimpleBookDto(book))
            .collect(Collectors.toList());
	}

    public List<BookDto> findBooksWithNameContain(String keyword) {
        return bookRepo.findBooksWithNameContain(keyword).stream()
                    .map(book -> Mapper.map(book, BookDto.class))
                    .peek(book -> {
                        for (BookDetailDto detail: book.getDetails()) {
                            detail.setBook(null);
                        }
                    })
                    .collect(Collectors.toList());
    }
}

