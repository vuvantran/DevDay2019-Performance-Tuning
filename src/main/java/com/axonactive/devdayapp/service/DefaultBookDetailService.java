package com.axonactive.devdayapp.service;

import java.util.Optional;

import com.axonactive.devdayapp.repo.BookDetailRepository;
import com.axonactive.devdayapp.repo.UserRepository;
import com.axonactive.devdayapp.repo.RatingRepository;
import com.axonactive.devdayapp.dto.UserDto;
import com.axonactive.devdayapp.domain.BookDetail;
import com.axonactive.devdayapp.domain.Rating;
import com.axonactive.devdayapp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultBookDetailService implements BookDetailService {

    @Autowired
    private BookDetailRepository bookDetailRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RatingRepository ratingRepo;

    @Override
    public boolean rateABook(Long userId, Long bookDetailId, Integer point) {
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
        return true;
    }

    @Override
    public boolean unrateABook(Long userId, Long bookDetailId) {
        Rating oldRating = ratingRepo.findRatingByUserIdAndBookDetailId(userId, bookDetailId);
        if (oldRating == null) {
            return false;
        }
        ratingRepo.delete(oldRating);
        return true;
    }
}

