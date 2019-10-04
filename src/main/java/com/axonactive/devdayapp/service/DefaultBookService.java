package com.axonactive.devdayapp.service;

import java.util.List;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.domain.BookDetail;
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
		Optional<Book> result = bookRepo.findById(bookId);
		if(result.isPresent())
			return BookUtil.toFullBookDto(result.get());
		else
			return null;
	}

	@Override
	public List<BookDto> getAll() {
		return  StreamSupport.stream(bookRepo.findAll().spliterator(),false)
			.map(book -> BookUtil.toSimpleBookDto(book))
            .collect(Collectors.toList());
	}

    @Override
    public List<BookDto> findBooksWithNameContain(String keyword) {
        List<BookDto> books = new LinkedList<>();
        for (Book book: bookRepo.findBooksWithNameContain(keyword)) {
            BookDto bookDto = BookDto.fromEntity( book );
            List<BookDetailDto> detailDtos = new LinkedList<>();
            bookDto.setDetails(detailDtos);
            books.add(bookDto);
            if (book.getDetails() == null) continue;
            for (BookDetail detail: book.getDetails()) {
                detailDtos.add( BookDetailDto.fromEntity( detail ) );
            }
        }
        return books;
    }
}

