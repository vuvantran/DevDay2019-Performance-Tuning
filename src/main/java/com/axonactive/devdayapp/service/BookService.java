package com.axonactive.devdayapp.service;

import java.util.List;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.enums.BookSource;

public interface BookService {

    List<BookDto> findBooksWithNameContain(String keyword);
    public BookDto findById(long bookId);
    public List<BookDto> getAll();
    List<BookDto> findBooksWithNameAndSource(String keyword,BookSource source);
}

