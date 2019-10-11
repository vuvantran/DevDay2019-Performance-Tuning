package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.repo.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultRatingService implements RatingService {

    @Autowired
    private RatingRepository ratingRepo;
}

