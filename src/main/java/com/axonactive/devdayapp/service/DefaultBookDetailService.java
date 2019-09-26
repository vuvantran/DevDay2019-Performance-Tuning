package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.repo.BookDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultBookDetailService implements BookDetailService {

    @Autowired
    private BookDetailRepository bookDetailRepo;
}

