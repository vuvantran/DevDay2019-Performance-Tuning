package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.logger.Log;
import com.axonactive.devdayapp.repo.RatingRepository;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultRatingService implements RatingService {
    private static @Log Logger log;
    @Autowired
    private RatingRepository ratingRepo;
}

