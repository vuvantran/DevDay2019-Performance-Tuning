package com.axonactive.devdayapp.service;

public interface BookDetailService {

    boolean rateABook(Long userId, Long bookDetailId, Integer point);

    boolean unrateABook(Long userId, Long bookDetailId);

}

