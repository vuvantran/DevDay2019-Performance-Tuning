package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultBookService implements BookService {

    @Autowired
    private BookRepository bookRepo;
}

