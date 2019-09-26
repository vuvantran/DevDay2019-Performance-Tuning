package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCommentService implements CommentService {

    @Autowired
    private CommentRepository commentRepo;
}

