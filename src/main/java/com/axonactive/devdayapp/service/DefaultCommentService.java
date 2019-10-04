package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.dto.CommentDto;
import com.axonactive.devdayapp.repo.BookDetailRepository;
import com.axonactive.devdayapp.repo.BookRepository;
import com.axonactive.devdayapp.repo.CommentRepository;
import com.axonactive.devdayapp.util.BookDetailUtil;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCommentService implements CommentService {

    @Autowired
    private BookRepository bookRepo;

	@Override
	public List<CommentDto> getCommentByBookId(long bookId) {
		Optional<Book> result = bookRepo.findById(bookId);
		return StreamSupport.stream(result.get().getDetails().spliterator(),false)
				.flatMap(bookDetail -> Optional.ofNullable(BookDetailUtil.toBookDetailDto(bookDetail).getComments()).orElse( Collections.emptyList()).stream())
				.collect(Collectors.toList());
		
			
	}
}

