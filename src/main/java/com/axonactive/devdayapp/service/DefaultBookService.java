package com.axonactive.devdayapp.service;

import java.util.List;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.domain.BookDetail;
import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.repo.BookRepository;
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
		Optional<Book> result = bookRepo.findById(bookId);
		
		if(result.isPresent())
			return Mapper.map(result.get(),  BookDto.class);
		else
			return null;
	}

	@Override
	public List<BookDto> getAll() {
		// TODO Auto-generated method stub
		return  StreamSupport.stream(bookRepo.findAll().spliterator(),false)
			.map(book -> Mapper.map(book, BookDto.class))
            .collect(Collectors.toList());
	}

    public List<BookDto> findBooksWithNameContain(String keyword) {
        List<BookDto> books = new LinkedList<>();
        for (Book book: bookRepo.findBooksWithNameContain(keyword)) {
            BookDto bookDto = BookDto.fromEntity( book );
            List<BookDetailDto> detailDtos = new LinkedList<>();
            if (book.getDetails() == null) continue;
            for (BookDetail detail: book.getDetails()) {
                detailDtos.add( BookDetailDto.fromEntity( detail ) );
            }
            bookDto.setDetails(detailDtos);
            books.add(bookDto);
        }
        return books;
    }
}

