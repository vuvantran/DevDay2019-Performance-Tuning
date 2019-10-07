package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.domain.BookDetail;
import com.axonactive.devdayapp.dto.BookDetailDto;
import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.repo.BookRepository;
import com.axonactive.devdayapp.util.BookUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class DefaultBookService implements BookService {
    private static final Logger log = LogManager.getLogger(DefaultBookService.class);
    
    @Autowired
    private BookRepository bookRepo;

    @Override
	public BookDto findById(long bookId) {
        log.info("find book has Id = " + bookId);
		Optional<Book> result = bookRepo.findById(bookId);
		if(result.isPresent())
			return BookUtil.toFullBookDto(result.get());
		else
			return null;
	}

	@Override
	public List<BookDto> getAll() {
        log.info("get all books");
		return  StreamSupport.stream(bookRepo.findAll().spliterator(),false)
			.map(book -> BookUtil.toSimpleBookDto(book))
            .collect(Collectors.toList());
	}

    @Override
    public List<BookDto> findBooksWithNameContain(String keyword) {
        log.info(String.format("find all books contain keyword '%s'.", keyword));
        List<BookDto> books = new LinkedList<>();
        for (Book book: bookRepo.findBooksWithNameContain("%".concat(keyword).concat("%"))) {
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

