package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.repo.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultTagService implements TagService {

    @Autowired
    private TagRepository tagRepo;
}

