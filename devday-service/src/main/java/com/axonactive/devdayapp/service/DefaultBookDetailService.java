package com.axonactive.devdayapp.service;

import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axonactive.devdayapp.domain.BookDetail;
import com.axonactive.devdayapp.domain.Rating;
import com.axonactive.devdayapp.domain.User;
import com.axonactive.devdayapp.logger.Log;
import com.axonactive.devdayapp.repo.BookDetailRepository;
import com.axonactive.devdayapp.repo.RatingRepository;
import com.axonactive.devdayapp.repo.UserRepository;
import com.axonactive.devdayapp.util.Constants;

@Service
public class DefaultBookDetailService implements BookDetailService {
    private static @Log Logger log;
    @Autowired
    private BookDetailRepository bookDetailRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RatingRepository ratingRepo;

    @Override
    public boolean rateABook(Long userId, Long bookDetailId, Integer point) {
        long startTime = System.currentTimeMillis();
        if (point == null || userId == null || bookDetailId == null) {
            return false;
        }
        if (point < 1 || point > 5) {
            return false;
        }
        Rating oldRating = ratingRepo.findRatingByUserIdAndBookDetailId(userId, bookDetailId);
        if (oldRating != null) {
            oldRating.setValue(point);
            ratingRepo.save(oldRating);
            return true;
        }
        Optional<User> user = userRepo.findById(userId);
        if ( ! user.isPresent()) {
            return false;
        }
        Optional<BookDetail> book = bookDetailRepo.findById(bookDetailId);
        if ( ! book.isPresent()) {
            return false;
        }
        Rating rating = new Rating();
        rating.setUser(user.get());
        rating.setBookDetail(book.get());
        rating.setValue(point);
        ratingRepo.save(rating);
        log.info(Constants.INFO_LOG_MSG, getClass().getName(),
                "rateABook", 
                System.currentTimeMillis() - startTime,
                String.format("userId=%s, bookDetailId=%s, point=%s", userId, bookDetailId, point));
        return true;
    }

    @Override
    public boolean unrateABook(Long userId, Long bookDetailId) {
        long startTime = System.currentTimeMillis();
        Rating oldRating = ratingRepo.findRatingByUserIdAndBookDetailId(userId, bookDetailId);
        if (oldRating == null) {
            return false;
        }
        ratingRepo.delete(oldRating);
        log.info(Constants.INFO_LOG_MSG, getClass().getName(),
                "rateABook", 
                System.currentTimeMillis() - startTime,
                String.format("userId=%s, bookDetailId=%s", userId, bookDetailId));
        return true;
    }
}

