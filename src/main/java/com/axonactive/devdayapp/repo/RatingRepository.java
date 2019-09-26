package com.axonactive.devdayapp.repo;

import com.axonactive.devdayapp.domain.Rating;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {}

