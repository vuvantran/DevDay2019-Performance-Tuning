package com.axonactive.devdayapp.repo;

import com.axonactive.devdayapp.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {}

